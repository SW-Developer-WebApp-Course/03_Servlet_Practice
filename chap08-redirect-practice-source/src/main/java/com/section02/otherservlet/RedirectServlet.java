package com.section02.otherservlet;

import com.sun.org.apache.xpath.internal.operations.String;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/redirect")
public class RedirectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Redirect 성공!");

        StringBuilder redirectText = new StringBuilder();
        redirectText.append("<!DOCTYPE html>\n")
                .append("<head>\n")
                .append("</head>\n")
                .append("<body>\n")
                .append("<h1>Redirect page로 redirect 성공!</h1>")
                .append("</body>\n")
                .append("</html>");

        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.print(redirectText.toString());

        out.flush();
        out.close();
    }


}
