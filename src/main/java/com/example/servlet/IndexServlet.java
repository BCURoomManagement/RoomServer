package com.example.servlet;

import com.example.dao.IndexDao;
import com.example.entity.Index;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/IndexServlet")
public class IndexServlet extends HttpServlet {
    public IndexServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    private List<Index> list = new ArrayList<Index>();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF8");
        PrintWriter out = response.getWriter();
        String te = new String(request.getParameter("te").getBytes("iso8859-1"),"UTF-8");
        list = new IndexDao().getOneRoom(te);
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
