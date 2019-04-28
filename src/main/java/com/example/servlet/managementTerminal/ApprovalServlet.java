package com.example.servlet.managementTerminal;

import com.example.dao.managementTerminal.ApprovalDao;
import com.example.dao.userTerminal.CanleDao;
import com.example.dao.userTerminal.ClassTimeDao;
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
        boolean a;
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF8");
        PrintWriter out = response.getWriter();
        String pass = new String(request.getParameter("pass").getBytes("iso8859-1"),"UTF-8");
        String username = new String(request.getParameter("username").getBytes("iso8859-1"),"UTF-8");
        String time = new String(request.getParameter("time").getBytes("iso8859-1"),"UTF-8");
        String noinf = new String(request.getParameter("noinf").getBytes("iso8859-1"),"UTF-8");
        if (pass.equals("nopass")){
            a=new ApprovalDao().approval(time,username,pass,noinf);
            List<Record> list =  new ApprovalDao().selBre(username,time);

            String aa = "{"+"0"+","+list.get(0).getOne()+","+list.get(0).getTwo()+","+list.get(0).getThree()+","+list.get(0).getFour()+","+list.get(0).getFive()+","+list.get(0).getSix()+","+list.get(0).getSeven()+","+list.get(0).getEight()+","+list.get(0).getNine()+","+list.get(0).getTen()+","+list.get(0).getTone()+","+list.get(0).getTtwo()+","+list.get(0).getTthree()+","+list.get(0).getTfour()+"}";
            String b1 = aa.substring(1, aa.length() - 1);
            String[] bb = b1.split(",");

            int[] a1 = new ClassTimeDao().stt(bb);
            System.out.println(aa);
            new CanleDao().Canle(list.get(0).getRoomid(), list.get(0).getData(), a1);
        }
        else{
            a=new ApprovalDao().approval(time,username,pass,noinf);
        }
        out.print(a);
        out.flush();
        out.close();
    }
}
