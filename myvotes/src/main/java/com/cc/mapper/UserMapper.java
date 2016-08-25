package com.cc.mapper;

import com.cc.model.User;
import org.apache.ibatis.annotations.Param;

/**
 * Created by Administrator on 2016/8/24.
 */
public interface UserMapper {

    User findUser(@Param("username") String username, @Param("password") String password);

    User loadUserByUsername(@Param("username") String username);
}
