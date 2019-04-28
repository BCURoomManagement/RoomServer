package com.example.servlet.managementTerminal;

import com.example.dao.userTerminal.LognDao;
import com.example.entity.userTerminal.Logn;
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

@WebServlet("/LoginMServlet")
public class LoginMServlet extends HttpServlet {
    public LoginMServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    private List<Logn> list = new ArrayList<Logn>();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF8");
        PrintWriter out = response.getWriter();
        String us = new String(request.getParameter("userName").getBytes("iso8859-1"),"UTF-8");
        String ps = new String(request.getParameter("userPwd").getBytes("iso8859-1"),"UTF-8");
        list = new LognDao().getlognM(us,ps);
        System.out.println(list);
        if (list != null) {
            if (!list.get(0).getPermission().equals("3")){
                JSONArray ja = JSONArray.fromObject(list);
                out.print(ja);
            }
            else {
                out.print("0");
            }
        } else {
            out.print("0");
        }
        out.flush();
        out.close();
    }
}
