package com.example.servlet.userTerminal;

import com.example.dao.userTerminal.ClassTimeDao;
import com.example.entity.userTerminal.Index;
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
    private List<Index> list = new ArrayList<Index>();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF8");
        PrintWriter out = response.getWriter();
        String typ = new String(request.getParameter("type").getBytes("iso8859-1"),"UTF-8");
        String b = new String(request.getParameter("Daydata").getBytes("iso8859-1"),"UTF-8");
        String aa = new String(request.getParameter("time").getBytes("iso8859-1"),"UTF-8");
        //String typp = typ.substring(1,2);
        System.out.println(typ+"typp");
//        int [] a=new int[]{0,0,0,1,1,0,0,0,0,0,0,0,0,0,0};

//        String b = "2018104";
        String b1 = aa.substring(1,aa.length()-1);
        String [] bb = b1.split(",");
        for (int i =0 ;i<bb.length;i++){
            System.out.println(bb[i]+",");
        }

        int [] a = new ClassTimeDao().stt(bb);

        list = new ClassTimeDao().gettime(typ,b,a);
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
