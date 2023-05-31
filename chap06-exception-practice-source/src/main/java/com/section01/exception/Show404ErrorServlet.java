package com.section01.exception;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/show404error") //진입점 어노테이션
public class Show404ErrorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendError(404, "Page is not FOUND"); //에러 전송을 위해 에러 코드와 에러 메세지 전달
    }
}
