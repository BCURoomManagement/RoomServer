package com.example.servlet.userTerminal;

import com.example.dao.userTerminal.CanleDao;
import com.example.dao.userTerminal.ClassTimeDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/CanleServlet")
public class CanleServlet extends HttpServlet {
    public CanleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF8");
        PrintWriter out = response.getWriter();

        String roomid = new String(request.getParameter("roomid").getBytes("iso8859-1"), "UTF-8");
        String data = new String(request.getParameter("Daydata").getBytes("iso8859-1"), "UTF-8");
        String aa = new String(request.getParameter("time").getBytes("iso8859-1"), "UTF-8");
        String submission = new String(request.getParameter("submission").getBytes("iso8859-1"), "UTF-8");
        String username = new String(request.getParameter("username").getBytes("iso8859-1"), "UTF-8");

//        int [] a=new int[]{0,0,0,1,1,0,0,0,0,0,0,0,0,0,0};
//
//        String b = "20181018";
        String b1 = aa.substring(1, aa.length() - 1);
        String[] bb = b1.split(",");

        int[] a = new ClassTimeDao().stt(bb);
        for (int i=0;i<a.length;i++){
            System.out.println(a[i]+"aa");
        }
//        String c = "112";

//        boolean t;
        new CanleDao().Canle(roomid, data, a);
        new CanleDao().dels(username,submission);
//        if (list != null) {
//            JSONArray ja = JSONArray.fromObject(list);
//            out.print(ja);
//        } else {
//            out.print("0");
//        }
        out.flush();
        out.close();
    }
}
