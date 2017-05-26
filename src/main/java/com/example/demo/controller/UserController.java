package com.example.demo.controller;

import com.example.demo.service.IRegService;
import com.example.demo.user.User;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by roc on 2017/5/25.
 */
@Controller
@EnableAutoConfiguration
public class UserController {
    private Logger log = Logger.getLogger(UserController.class);
    @Autowired
    private IRegService regService;

    @RequestMapping("/")
    String home() {
        return "index";
    }

    @RequestMapping(value = "/getUserById", method = RequestMethod.POST)
    @ResponseBody
    User getUserById(@RequestParam("userId") String userId) {
        log.info("userId = " + userId);
        User user = regService.getUserById(userId);
        log.info("user= " + user.toString());
        return user;
    }

    @RequestMapping(value = "/reg", method = RequestMethod.POST)
    @ResponseBody
    Boolean reg(@RequestParam("loginPwd") String loginPwd, @RequestParam("userName") String userName, @RequestParam("userId") String userId) {
        String pwd = creatMD5(loginPwd);
        log.info(userId + ":" + userName + ":" + loginPwd);
        return regService.regUser(userId, userName, pwd);
    }

    private String creatMD5(String loginNum) {
        // 生成一个MD5加密计算摘要
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("MD5");
            md.update(loginNum.getBytes());

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return new BigInteger(1, md.digest()).toString(16);
    }
}
