package com.bjpowernode.filter;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *  http://localhost:8080/myWeb/mm.jpg?age=89
 */
public class OneFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

           //1.通过拦截请求对象得到请求包参数信息，从而得到来访用户的真实年龄
           String age= servletRequest.getParameter("age");
           //2.根据年龄，帮助Http服务器判断本次请求合法性
           if(Integer.valueOf(age) < 70){ //合法请求
               //将拦截请求对象和响应对象交还给Tomcat,由Tomcat继续调用资源文件
               filterChain.doFilter(servletRequest, servletResponse);//放行
           }else{
               //过滤器代替Http服务器拒绝本次请求
               servletResponse.setContentType("text/html;charset=utf-8");
               PrintWriter out = servletResponse.getWriter();
               out.print("<center><font style='color:red;font-size:40px'>大爷，珍爱生命啊!</font></center>");
           }
    }
}
