package com.julin.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

//保存用户上一次访问时间
public class CookieDemo01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //服务器，告诉你你来的时间，把这个时间封装成一个信件
        //解决中文乱码

        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setHeader("Content-type","text/html;charset=utf-8");

        PrintWriter out = resp.getWriter();

        //Cookie,服务器端从客户端获取
        Cookie[] cookies = req.getCookies();//这里是数组，说明cookie可能是多个
        //判断cookie是否存在
        boolean flag = true;
        //如果存在怎么办
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("lastLoginTime")) {
                //获取cookie中的值

                long lastLoginTime = Long.parseLong(cookie.getValue());
                Date date = new Date(lastLoginTime);
                out.write("你上一次访问本站的时间是: " + date.toLocaleString());
                flag = false;
            }
        }
        if (flag) {
            out.write("这是你第一次访问本站");
        }


        //服务器给客户端响应一个cookie

        Cookie cookie = new Cookie("lastLoginTime",System.currentTimeMillis() + "");
        cookie.setMaxAge(60*60*24);

        resp.addCookie(cookie);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
