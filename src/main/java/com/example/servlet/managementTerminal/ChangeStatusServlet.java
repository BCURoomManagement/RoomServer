package com.example.servlet.managementTerminal;

import com.example.dao.managementTerminal.ChangeStatusDao;
import com.example.dao.userTerminal.ClassTimeDao;
import com.example.dao.userTerminal.RecordDao;
import com.example.dao.userTerminal.SubmitDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/ChangeStatusServlet")
public class ChangeStatusServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF8");
        PrintWriter out = response.getWriter();
        boolean a,b;
        String roomid = new String(request.getParameter("sroomid").getBytes("iso8859-1"),"UTF-8");
        String data = new String(request.getParameter("sDaydata").getBytes("iso8859-1"),"UTF-8");
        String aa = new String(request.getParameter("sClasstime").getBytes("iso8859-1"),"UTF-8");
//        String [] b = new String [] {"1","1","0","0","0","0","0","0","0","0","0","0","0","0"};

        String b1 = aa.substring(2,aa.length());
        String [] bb = b1.split(",");
        int [] c = new ClassTimeDao().stt(bb);
        b = new ChangeStatusDao().ChangeStatus(roomid,data,c);
        out.print(b);
        out.flush();
        out.close();

    }
}
