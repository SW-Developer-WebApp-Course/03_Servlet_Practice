package com.section01.exception;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/show500error")
public class Show500ErrorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendError(500, "서버 내부 오류입니다.(개발자가 잘못한 에러입니다)");
    }

}
