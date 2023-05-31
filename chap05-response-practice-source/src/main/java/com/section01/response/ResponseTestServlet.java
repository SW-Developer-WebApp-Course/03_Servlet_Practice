package com.section01.response;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/response")
public class ResponseTestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //PrintWriter out = response.getWriter();

        StringBuilder responseBuilder = new StringBuilder();
        responseBuilder.append("<!doctype html>\n")
                .append("<html>\n")
                .append("<head>\n")
                .append("</head>\n")
                .append("<body>\n")
                .append("<h1>안녕 Servlet Response\n")
                .append("</body>\n")
                .append("</html>\n");

        System.out.println("default response type : " + response.getContentType());

        //html로 인식하도록 해줌
        response.setContentType("text/html");

        //plain text로 인식하도록 해줌
        //response.setContentType("text/plain");

        //기본적으로 설정된 인코딩 타입도 알 수 있음
        System.out.println("default response encoidng: " + response.getCharacterEncoding());
        response.setCharacterEncoding("UTF-8");

        //response.setContentType("text/html; charset=UTF-8;");

        PrintWriter out = response.getWriter();

        out.print(responseBuilder.toString());

        out.flush();
        out.close();

    }
}
