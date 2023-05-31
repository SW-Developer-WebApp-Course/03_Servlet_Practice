package com.section01.exception;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet("/showErrorPage")
public class ExceptionHandlerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Enumeration<String> attrName = request.getAttributeNames();
        while(attrName.hasMoreElements()) {
            System.out.println(attrName.nextElement());
        }

        /*
        javax.servlet.error.request_uri
        javax.servlet.forward.request_uri
        javax.servlet.forward.context_path
        javax.servlet.forward.servlet_path
        javax.servlet.forward.mapping
        javax.servlet.error.status_code
        javax.servlet.error.message
        javax.servlet.error.servlet_name
        javax.servlet.error.request_uri
         */

        String requestUri = (String) request.getAttribute("javax.servlet.error.request_uri");
        String contextPath = (String) request.getAttribute("javax.servlet.forward.context_path");
        String servletPath = (String) request.getAttribute("javax.servlet.forward.servlet_path");
        Integer statusCode = (Integer) request.getAttribute(" javax.servlet.error.status_code");
        System.out.println("ddd" + request.getAttribute(" javax.servlet.error.status.code"));

        String message = (String) request.getAttribute("javax.servlet.error.message");
        String servletName = (String) request.getAttribute("javax.servlet.error.servlet_name");
        String errorRequestUri = (String) request.getAttribute("javax.servlet.error.request_uri");
        HttpServletMapping mapping = request.getHttpServletMapping();

        System.out.println(requestUri);
        System.out.println(contextPath);
        System.out.println(servletPath);
        System.out.println(statusCode);
        System.out.println(message);
        System.out.println(servletName);
        System.out.println(errorRequestUri);
        System.out.println(mapping.getServletName());
        System.out.println(mapping.getMatchValue());
        System.out.println(mapping.getMappingMatch());
        System.out.println(mapping.getPattern());
        System.out.println(mapping);

        StringBuilder errorPage = new StringBuilder();
        errorPage.append("<!DOCTYPE html>\n")
                .append("<html>\n")
                .append("<head>\n")
                .append("</head>\n")
                .append("<body>\n")
                .append("<h1>\n")
                .append(statusCode)
                .append(":")
                .append(message)
                .append("</h1>\n")
                .append("</body>\n")
                .append("</html>\n");

        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.println(errorPage.toString());

        out.flush();
        out.close();
    }
}
