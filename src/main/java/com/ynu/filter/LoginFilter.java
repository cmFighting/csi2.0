package com.ynu.filter;

import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;
        HttpSession session = request.getSession();

        if(session.getAttribute("user")==null && request.getRequestURI().indexOf("/login") == -1){
            // 没有登录
//            System.out.println(request.getContextPath());
//            System.out.println("咋回事，中文能不能成");
            response.sendRedirect(request.getContextPath()+"/login");
        }else{
            // 已经登录，继续请求下一级资源（继续访问）
            filterChain.doFilter(servletRequest, servletResponse);
        }

    }

    @Override
    public void destroy() {

    }
}
