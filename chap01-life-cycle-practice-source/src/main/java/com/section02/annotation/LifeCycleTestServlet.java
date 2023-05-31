package com.section02.annotation;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.io.IOException;

@WebServlet(value = "/annotation-lifecycle")
public class LifeCycleTestServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private int initCount = 1;
    private int destroyCount = 1;
    private int serviceCount = 1;

    //기본 생성자 추가
    public LifeCycleTestServlet(){

    }

    public void init(ServletConfig config) throws ServletException {
        //서블릿 생성(초기화)
        System.out.println(">> annotation mapping init() method called: " + initCount++);
    }

    public void destroy(){
        //서블릿 폐기
        System.out.println(">> annotation mapping destroy() method called: " + destroyCount++);

    }

    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        //서블릿 서비스
        System.out.println(">> annotation mapping service() method called: " + serviceCount++);

    }


}
