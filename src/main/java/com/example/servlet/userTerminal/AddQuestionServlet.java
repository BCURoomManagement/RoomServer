package com.example.servlet.userTerminal;

import com.example.dao.userTerminal.QuestionDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/AddQuestionServlet")
public class AddQuestionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF8");
        PrintWriter out = response.getWriter();
        String qmassage = new String(request.getParameter("qmassage").getBytes("iso8859-1"),"UTF-8");
        String quser = new String(request.getParameter("quser").getBytes("iso8859-1"),"UTF-8");

        out.print(new QuestionDao().instertQuestion(qmassage,quser));
        out.flush();
        out.close();
    }
}
