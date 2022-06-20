package com.julin.servlet;

import com.julin.pojo.Person;
import org.apache.jasper.runtime.HttpJspBase;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

public class SessionDemo01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       //解决乱码问题
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setHeader("Content-type","text/html;charset=utf-8");
        //得到session
        HttpSession session = req.getSession();
        //给Session存入数据
        session.setAttribute("name",new Person("julin",24));
        //获取session的id
        String id = session.getId();
        //判断session是不是新创建
        if (session.isNew()) {
            resp.getWriter().write("session新创建成功,ID:" + id);
        }else {
            resp.getWriter().write("session已经在服务器中存在了,ID:" + id);
        }

        //session创建的时候做了什么事
//        Cookie cookie = new Cookie("JSESSIONID",id);
//        resp.addCookie(cookie);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
