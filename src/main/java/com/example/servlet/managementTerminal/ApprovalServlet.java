package com.example.servlet.managementTerminal;

import com.example.dao.managementTerminal.ApprovalDao;
import com.example.entity.userTerminal.Record;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/ApprovalServlet")
public class ApprovalServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF8");
        PrintWriter out = response.getWriter();
        String pass = new String(request.getParameter("pass").getBytes("iso8859-1"),"UTF-8");
        String username = new String(request.getParameter("username").getBytes("iso8859-1"),"UTF-8");
        String time = new String(request.getParameter("time").getBytes("iso8859-1"),"UTF-8");

        out.print(new ApprovalDao().approval(time,username,pass));
        out.flush();
        out.close();
    }
}
