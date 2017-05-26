package com.example.demo.service.impl;

import com.example.demo.controller.UserController;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.IRegService;
import com.example.demo.user.User;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;

/**
 * Created by roc on 2017/5/25.
 */
@Service
public class RegService implements IRegService, Serializable {
    private Logger log = Logger.getLogger(UserController.class);
    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserById(String userId) {
        log.info("RegService userId = " + userId);
        return userMapper.findUserByUserId(userId);
    }

    @Override
    public boolean regUser(String userId, String userName, String pwd) {
        Boolean flag;
        try {
            flag = userMapper.insertUsers(userId, userName, pwd);
        } catch (Exception e) {
            return false;
        }
        return flag;
    }
}
