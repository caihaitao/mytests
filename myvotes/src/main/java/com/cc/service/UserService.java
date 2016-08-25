package com.cc.service;

import com.cc.mapper.UserMapper;
import com.cc.model.User;
import com.cc.util.EncryptUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/8/24.
 */
@Service
public class UserService implements UserDetailsService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Value("${user.super.username}")
    private String superUsername;
    @Value("${user.super.password}")
    private String superPassword;
    @Value("${user.super.role}")
    private String role;

    @Autowired
    private UserMapper userMapper;

    public User findUser(String username, String password) {
        logger.info("user-findByUsername: username-{},password-{}", username, password);
        password = EncryptUtils.encodeMD5String(password);
        if (username.equalsIgnoreCase(superUsername) && password.equalsIgnoreCase(superPassword)) {
            User user = getSuperUser();
            return user;
        }

        return userMapper.findUser(username, password);
    }

    private User getSuperUser() {
        User user = new User();
        user.setUsername(superUsername);
        user.setPassword(superPassword);
        user.setRole(role);
        return user;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = null;
        if (username.equals(superUsername)) {
            user = getSuperUser();
        }
        if (user == null) {
            user = userMapper.loadUserByUsername(username);
        }
        if (user == null) {
            throw new UsernameNotFoundException("username not found");
        }
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(user.getRole()));
        logger.info("username is " + username + ", " + user.getRole());
        return new org.springframework.security.core.userdetails.User(user.getUsername(),
                user.getPassword(), authorities);
    }
}
