package com.iai.project.common.service.Impl;

import com.iai.project.common.exceptions.GraceException;
import com.iai.project.common.mongo.User;
import com.iai.project.common.responsitory.UserResponsitory;
import com.iai.project.common.result.ResponseStatusEnum;
import com.iai.project.common.service.CommonUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.Optional;

@Slf4j
@Service
public class CommonUserServiceImpl implements CommonUserService {
    @Resource
    UserResponsitory userResponsitory;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Override
    public User findById(String userId) {
        Optional<User> byId = userResponsitory.findById(userId);
        if (!byId.isPresent()){
            GraceException.display(ResponseStatusEnum.USER_NOT_EXIST);
        }
        return byId.get();
    }
}
