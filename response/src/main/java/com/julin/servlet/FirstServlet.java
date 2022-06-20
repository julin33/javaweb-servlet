package com.julin.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;

public class FirstServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = "C:\\Users\\julin\\IdeaProjects\\javaweb-servlet\\response\\target\\response\\WEB-INF\\classes\\纸片人.jpg";//获取下载文件的路径
        System.out.println("要下载文件的路径" + path);
        String fileName = path.substring(path.lastIndexOf("\\") + 1);// 下载文件的名字
        //想办法让浏览器支持（Content-Disposition）下载我们需要的东西
        resp.setHeader("Content-Disposition","attachment;filename=" + URLEncoder.encode(fileName,"utf-8"));
        FileInputStream in = new FileInputStream(path);//获取文件的输入流
        //创建缓冲区
        int len = 0;
        byte[] buffer = new byte[1024];
        //获取OutputStream对象
        OutputStream out = resp.getOutputStream();
        //将FileInputStream流写入到buffer缓冲区
        while ((len=in.read(buffer))>0) {
            out.write(buffer,0,len);
        }

        out.close();
        in.close();


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
