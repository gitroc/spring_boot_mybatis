package com.example.demo.service;

import com.example.demo.user.User;

/**
 * Created by roc on 2017/5/25.
 */
public interface IRegService {
    User getUserById(String userId);

    boolean regUser(String userId, String userName, String pwd);
}
