package com.iai.project.common.interceptor;

import com.iai.project.common.exceptions.GraceException;
import com.iai.project.common.result.ResponseStatusEnum;
import com.iai.project.common.utils.ED.TokenUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 用于拦截用户的请求信息
 */
public class UserTokenInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 从header中获得用户id和token
        String userToken = request.getHeader("token");

        if (StringUtils.equals(request.getMethod(), "OPTIONS")) {
            return true;
        }

        if (userToken == null){
            GraceException.display(ResponseStatusEnum.UN_LOGIN);
            return false;
        }

        // 判断header中token不能为空
        if (StringUtils.isNotBlank(userToken)) {
            boolean pass = TokenUtil.verifyToken(userToken);
            if (!pass){
                GraceException.display(ResponseStatusEnum.TICKET_INVALID);
            }
            return pass;
        } else {
            GraceException.display(ResponseStatusEnum.UN_LOGIN);
            return false;
        }
    }
}
