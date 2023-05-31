package com.section01.forward;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/forward")
public class ReceiveInformationServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String userId = request.getParameter("userId");
        String password = request.getParameter("password");

        System.out.println(userId);
        System.out.println(password);

        request.setAttribute("userId", userId);

        //Request 보내는 방향 결정
        RequestDispatcher rd = request.getRequestDispatcher("print");
        rd.forward(request, response);

//        StringBuilder responseText = new StringBuilder();
//        responseText.append("<!DOCTYPE html>\n")
//                .append("<head>\n")
//                .append("</head>\n")
//                .append("<h3>" + userId + "님 환영합니다 🤗</h3>\n")
//                .append("<body>\n")
//                .append("</body>\n");
//
//        PrintWriter out = response.getWriter();
//        out.println(responseText.toString());
//        out.flush();
//        out.close();
    }
}
