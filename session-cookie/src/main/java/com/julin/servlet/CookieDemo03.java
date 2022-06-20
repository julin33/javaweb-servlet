package com.julin.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

//中文传输cookie
public class CookieDemo03 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setHeader("Content-type","text/html;charset=utf-8");

        PrintWriter out = resp.getWriter();

        boolean flag = true;
        Cookie[] cookies = req.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("name")) {
                //获取cookie中的值
                System.out.println(cookie.getValue());
                out.write(cookie.getValue());
                flag = false;
            }
        }
        if (flag) {
            out.write("这是你第一次访问本站");
        }

        Cookie cookie = new Cookie("name","菊林");
        resp.addCookie(cookie);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       doGet(req, resp);
    }
}
