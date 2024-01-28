package com.catlendar.app.user.controller;
import com.catlendar.app.user.model.UserInfo;
import com.catlendar.app.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = {"/user"})
public class UserController {
    private final UserService userService;


    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UserInfo userInfo){
        return ResponseEntity.ok().body(userService.login(userInfo.getName(),""));
    }
    @PostMapping("/test")
    public ResponseEntity<String> test(Authentication authentication){
        return ResponseEntity.ok().body("사용자명: "+authentication.getName());
    }

    // 모든 사용자리스트 가져오기
    @PostMapping("/getUserList")
    public List<UserInfo> getUserList() {
        return userService.getUserList();
    }
    // 단일 사용자 가져오기
    @PostMapping("/getUser")
    public UserInfo getUser(@RequestBody UserInfo userinfo) {
        return userService.getUser(userinfo);
    }
    // 회원가입
    @PostMapping("/signUp")
    public boolean insertUser(@RequestBody UserInfo userinfo) {
        return userService.insertUser(userinfo);
    }
    // 이메일 중복 체크
    @PostMapping("/emailVerify")
    public boolean emailVerify(@RequestBody UserInfo userinfo) {
        return userService.emailVerify(userinfo);
    }


    // 회원정보 수정
    @PostMapping("/updateUser")
    public boolean updateUser(@RequestBody UserInfo userinfo) {
        return userService.updateUser(userinfo);
    }
    // 회원 탈퇴
    @PostMapping("/deleteUser")
    public boolean deleteUser(@RequestBody UserInfo userinfo) {
        return userService.deleteUser(userinfo);
    }
}
