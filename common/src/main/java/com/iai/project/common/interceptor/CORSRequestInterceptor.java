package com.iai.project.common.interceptor;

import org.springframework.http.HttpHeaders;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CORSRequestInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String origin  = request.getHeader(HttpHeaders.ORIGIN);
        if (origin != null) {
            //response.setHeader("Access-Control-Allow-Origin", "*");
            response.setHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS, DELETE, PUT, HEAD");
            //这里设置允许的自定义header参数
            response.setHeader("Access-Control-Expose-Headers","token");
            response.setHeader("Access-Control-Max-Age", "3600");
        }
        return true;
    }
}
