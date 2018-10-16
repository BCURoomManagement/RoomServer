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

@WebServlet("/RecordServlet")
public class RecordServlet extends HttpServlet {
    public RecordServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    private List<Record> list = new ArrayList<Record>();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF8");
        PrintWriter out = response.getWriter();
        String uname = new String(request.getParameter("username").getBytes("iso8859-1"),"UTF-8");
        list = new RecordDao().getRecord(uname);
        System.out.println(list);
        if (list != null) {
            JSONArray ja = JSONArray.fromObject(list);
            out.print(ja);
        } else {
            out.print("0");
        }
        out.flush();
        out.close();
    }
}
