package com.cc.mapper;

import com.cc.model.User;

/**
 * Created by Administrator on 2016/8/24.
 */
public interface UserMapper {

    User findUser(String username, String password);
}
