package com.example.servlet;

import com.example.dao.RecordDao;
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
        boolean a;
        String [] b = new String [] {"1","1","0","0","0","0","0","0","0","0","0","0","0","0"};
        System.out.println(new RecordDao().chack(new RecordDao().gettime("112","20181018"),b));
        if (new RecordDao().chack(new RecordDao().gettime("112","20181018"),b)){
            a = new RecordDao().instertSubmit("ad","ss","20181019",b,"www","no","20181019");
            System.out.println(a);
            if (a != false) {
                out.print("true");
            } else {
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
