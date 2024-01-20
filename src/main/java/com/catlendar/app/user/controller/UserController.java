package com.catlendar.app.user.controller;
import com.catlendar.app.user.model.User;
import com.catlendar.app.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = {"/user"})
public class UserController {
    private final UserService userService;
    // 모든 사용자리스트 가져오기
    @PostMapping("/getUserList")
    public List<User> getUserList() {
        return userService.getUserList();
    }
    // 단일 사용자 가져오기
    @PostMapping("/getUser")
    public User getUser(@RequestBody User user) {
        return userService.getUser(user);
    }
    // 회원가입
    @PostMapping("/signIn")
    public boolean insertUser(@RequestBody User user) {
        return userService.insertUser(user);
    }
    // 회원정보 수정
    @PostMapping("/updateUser")
    public boolean updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }
    // 회원 탈퇴
    @PostMapping("/deleteUser")
    public boolean deleteUser(@RequestBody User user) {
        return userService.deleteUser(user);
    }
}
