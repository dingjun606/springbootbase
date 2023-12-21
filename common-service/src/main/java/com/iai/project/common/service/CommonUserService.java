package com.iai.project.common.service;

import com.iai.project.common.mongo.User;

public interface CommonUserService {

    /**
     * 根据用户id查询用户信息
     */
    User findById(String userId);
}
