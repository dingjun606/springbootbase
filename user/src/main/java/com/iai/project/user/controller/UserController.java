package com.iai.project.user.controller;

import com.iai.project.common.result.GraceJSONResult;
import com.iai.project.common.service.CommonUserService;
import com.iai.project.user.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/user")
@Api(value = "用户接口", tags = {"用户接口"})
public class UserController {
    @Resource
    UserService userService;

    @Resource
    CommonUserService commonUserService;

    @ApiOperation(value = "用户登录")
    @PostMapping("userLogin")
    public GraceJSONResult<String> userLogin(HttpServletRequest request) {
        String userId = request.getHeader("userId");
        String token = request.getHeader("token");
        return GraceJSONResult.ok(userId);
    }

}
