package com.example.servlet.managementTerminal;

import com.example.dao.managementTerminal.PurposeAnalysisDao;
import com.example.entity.userTerminal.Record;
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

@WebServlet("/PurposeAnalysisServlet")
public class PurposeAnalysisServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    private List<Record> list = new ArrayList<Record>();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        double a=0,b=0,c=0,d=0,e=0,sum=0;
        double a1,b1,c1,d1,e1;
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF8");
        PrintWriter out = response.getWriter();
        String roomid = new String(request.getParameter("roomid").getBytes("iso8859-1"),"UTF-8");
        String data = new String(request.getParameter("data").getBytes("iso8859-1"),"UTF-8");
        list = new PurposeAnalysisDao().getPurposeAnalysis(data,roomid);
        for (int i=0 ;i<list.size();i++)
        {
            if (list.get(i).getUse().equals("a")){
                a++;
            }
            if (list.get(i).getUse().equals("b")){
                b++;
            }
            if (list.get(i).getUse().equals("c")){
                c++;
            }
            if (list.get(i).getUse().equals("d")){
                d++;
            }
            if (list.get(i).getUse().equals("e")){
                e++;
            }
        }
        sum = a+b+c+d+e;
        a1 = a/sum+0.0;
        b1 = b/sum;
        c1 = c/sum;
        d1 = d/sum;
        e1 = e/sum;
        JSONArray jsonarray = new JSONArray();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("roomid",roomid);
        jsonObject.put("a",a1);
        jsonObject.put("b",b1);
        jsonObject.put("c",c1);
        jsonObject.put("d",d1);
        jsonObject.put("e",e1);
        jsonObject.put("sum",sum);
        jsonarray.add(jsonObject);

        out.print(jsonarray);
        out.flush();
        out.close();

    }
}
