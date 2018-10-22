package com.example.servlet;

import com.example.dao.ClassTimeDao;
import com.example.dao.RecordDao;
import com.example.dao.SubmitDao;
import com.example.entity.Record;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/SubmitServlet")
public class SubmitServlet extends HttpServlet {
    public SubmitServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
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
        String time = new String(request.getParameter("timestamp").getBytes("iso8859-1"),"UTF-8");
        String username = new String(request.getParameter("username").getBytes("iso8859-1"),"UTF-8");
        String use = new String(request.getParameter("use").getBytes("iso8859-1"),"UTF-8");
        String phone = new String(request.getParameter("phone").getBytes("iso8859-1"),"UTF-8");
        String ftime =new String(request.getParameter("ftime").getBytes("iso8859-1"),"UTF-8");
        String ltime =new String(request.getParameter("ltime").getBytes("iso8859-1"),"UTF-8");
//        String [] b = new String [] {"1","1","0","0","0","0","0","0","0","0","0","0","0","0"};

        String b1 = aa.substring(2,aa.length());
        String [] bb = b1.split(",");
        int [] c = new ClassTimeDao().stt(bb);
        for (int i = 0 ; i < bb.length;i++){
            System.out.println(bb[i]);
        }
        System.out.println(new RecordDao().chack(new RecordDao().gettime(roomid,data),bb));
        if (new RecordDao().chack(new RecordDao().gettime(roomid,data),bb)){

            b = new SubmitDao().upad(roomid,data,c);
            if(b==true){
                a = new RecordDao().instertSubmit(username,phone,use,data,bb,roomid,"no",time,ftime,ltime);
                if (a != false) {
                    out.print("true");
                } else {
                    out.print("false");
                }
            }
            else{
                out.print("false");
            }

        }
        else {
            out.print("false");
        }
        out.flush();
        out.close();
    }
}
