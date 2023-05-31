package com.section01.headers;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet("/headers")
public class RequestHeaderPrintServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Enumeration<String> headerNames = request.getHeaderNames();
        while(headerNames.hasMoreElements()) {
            System.out.println(headerNames.nextElement());
        }
    /*
        host
        connection
        sec-ch-ua
        sec-ch-ua-mobile
        sec-ch-ua-platform
        upgrade-insecure-requests
        user-agent
        accept
        sec-fetch-site
        sec-fetch-mode
        sec-fetch-user
        sec-fetch-dest
        referer
        accept-encoding
        accept-language
        cookie
     */

        System.out.println(request.getHeader("host"));
        System.out.println(request.getHeader("connection"));
        System.out.println(request.getHeader("sec-ch-ua"));
        System.out.println(request.getHeader("sec-ch-ua-mobile"));
        System.out.println(request.getHeader("sec-ch-ua-platform"));
        System.out.println(request.getHeader("upgrade-insecure-requests"));
        System.out.println(request.getHeader("user-agent"));
        System.out.println(request.getHeader("accept"));
        System.out.println(request.getHeader("sec-fetch-site"));
        System.out.println(request.getHeader("sec-fetch-mode"));
        System.out.println(request.getHeader("sec-fetch-user"));
        System.out.println(request.getHeader("sec-fetch-dest"));
        System.out.println(request.getHeader("referer"));
        System.out.println(request.getHeader("accept-encoding"));
        System.out.println(request.getHeader("accept-language"));
        System.out.println(request.getHeader("cookie"));


    }
}
