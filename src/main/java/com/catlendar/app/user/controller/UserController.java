package com.catlendar.app.user.controller;

import com.catlendar.app.user.model.User;
import com.catlendar.app.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.http.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RestController
@RestController
@RequiredArgsConstructor
@RequestMapping(path = {"/user"})
public class UserController {
    private final UserService userService;

    // 모든 사용자리스트 가져오기
    @RequestMapping("/getUserList")
    public List<User> getUserList() {
        return userService.getUserList();
    }
    // 단일 사용자 가져오기
    @RequestMapping("/getUser")
    public User getUser(User user) {
        return userService.getUser(user);
    }
    // 회원가입
    @RequestMapping("/signIn")
    public boolean insertUser(User user) {
        return userService.insertUser(user);
    }

    // 회원정보 수정
    @RequestMapping("/updateUser")
    public boolean updateUser(User user) {
        return userService.updateUser(user);
    }
    // 회원 탈퇴
    @RequestMapping("/deleteUser")
    public boolean deleteUser(User user) {
        return userService.deleteUser(user);
    }
}
