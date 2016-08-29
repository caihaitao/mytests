package com.cc.service;

import com.cc.mapper.UserMapper;
import com.cc.model.User;
import com.cc.util.EncryptUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2016/8/24.
 */
@Service
public class UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserMapper userMapper;

    public User findUser(String username, String password) {
        logger.info("user-findUser: username-{},password-{}", username, password);
        password = EncryptUtils.encodeMD5String(password);
        return userMapper.findUser(username, password);
    }

    public User loadUserByUsername(String username) {
        return userMapper.loadUserByUsername(username);
    }
}
