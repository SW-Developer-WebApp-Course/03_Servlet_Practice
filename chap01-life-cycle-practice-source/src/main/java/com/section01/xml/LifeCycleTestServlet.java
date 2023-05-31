package com.section01.xml;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.io.IOException;

public class LifeCycleTestServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;


    private int initCount = 1;
    private int destroyCount = 1;
    private int serviceCount = 1;

    //기본 생성자 추가
    public LifeCycleTestServlet(){

    }

    public void init(ServletConfig config) throws ServletException{
        //서블릿 생성(초기화)
        System.out.println(">> xml mapping init() method called: " + initCount++);
    }

    public void destroy(){
        //서블릿 폐기
        System.out.println(">> xml mapping destroy() method called: " + destroyCount++);

    }

    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        //서블릿 서비스
        System.out.println(">> xml mapping service() method called: " + serviceCount++);

    }

}
