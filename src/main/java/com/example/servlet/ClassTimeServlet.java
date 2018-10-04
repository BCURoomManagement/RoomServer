package com.example.servlet;

import com.example.dao.ClassTimeDao;
import com.example.dao.IndexDao;
import com.example.entity.ClassTime;
import com.example.entity.Index;
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

@WebServlet("/ClassTimeServlet")
public class ClassTimeServlet extends HttpServlet {
    public ClassTimeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    private List<ClassTime> list = new ArrayList<ClassTime>();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF8");
        PrintWriter out = response.getWriter();


        int [] a=new int[]{0,0,0,1,1,0,0,0,0,0,0,0,0,0,0};

        String b = "2018104";
        list = new ClassTimeDao().gettime(b,a);
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
