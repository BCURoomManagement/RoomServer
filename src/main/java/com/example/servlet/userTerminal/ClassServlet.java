package com.example.servlet.userTerminal;

import com.example.dao.userTerminal.RecordDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/ClassServlet")
public class ClassServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF8");
        PrintWriter out = response.getWriter();

        String roomid = new String(request.getParameter("roomid").getBytes("iso8859-1"), "UTF-8");
        String data = new String(request.getParameter("data").getBytes("iso8859-1"), "UTF-8");

        out.print(new RecordDao().gettime2(roomid,data));
        out.flush();
        out.close();
    }
}
