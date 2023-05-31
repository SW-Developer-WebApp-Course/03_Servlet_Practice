package com.section01.forward;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/print")
public class PrintLoginSuccessServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String userId = (String) request.getAttribute("userId");

        response.setContentType("text/html; charseet=UTF-8");
        StringBuilder responseText = new StringBuilder();
        responseText.append("<!DOCTYPE html>\n")
                .append("<head>\n")
                .append("</head>\n")
                .append("<h3>" + userId + "님 환영합니다 🤗</h3>\n")
                .append("<body>\n")
                .append("</body>\n");

        PrintWriter out = response.getWriter();
        out.println(responseText.toString());
        out.flush();
        out.close();
    }
}
