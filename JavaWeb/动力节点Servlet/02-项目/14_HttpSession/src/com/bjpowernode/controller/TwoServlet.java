package com.bjpowernode.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Enumeration;

public class TwoServlet extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

         //1.调用请求对象，向Tomcat索要当前用户在服务端私人储物柜
         HttpSession session = request.getSession();

         //2.将session中所有的key读取出来，存放一个枚举对象
        Enumeration goodsNames =session.getAttributeNames();
        while(goodsNames.hasMoreElements()){
              String goodsName =(String) goodsNames.nextElement();
              int goodsNum = (int)session.getAttribute(goodsName);
            System.out.println("商品名称 "+goodsName+" 商品数量 "+goodsNum);
        }
    }
}
