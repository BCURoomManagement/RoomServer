package com.example.servlet.managementTerminal;

import com.example.dao.managementTerminal.ApprovalDao;
import com.example.dao.managementTerminal.QueryStatusDao;
import com.example.entity.userTerminal.ClassTime;
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

@WebServlet("/StatusByDataServlet")
public class StatusByDataServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    private List<ClassTime> list = new ArrayList<ClassTime>();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF8");
        PrintWriter out = response.getWriter();
        String data = new String(request.getParameter("data").getBytes("iso8859-1"),"UTF-8");
        list = new QueryStatusDao().getStatusByData(data);
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
