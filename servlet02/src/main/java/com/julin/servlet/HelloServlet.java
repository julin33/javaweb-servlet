package com.julin.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        this.getInitParameter(); 初始化参数
//        this.getServletConfig();  servlet配置
//        this.getServletContext(); servlet 上下文
        ServletContext context = this.getServletContext();
        String userName = "julin"; //数据
        context.setAttribute("userName",userName);//讲一个数据保存在ServletContext中，名为userName,值为userName



    }
}
