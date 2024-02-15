package com.catlendar.app.user.controller;
import com.catlendar.app.user.model.PasswordInfo;
import com.catlendar.app.user.model.UserInfo;
import com.catlendar.app.user.model.UserTokenInfo;
import com.catlendar.app.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.security.crypto.password.PasswordEncoder;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = {"/user"})
public class UserController {
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserTokenInfo userInfo){
        return ResponseEntity.ok().body(userService.login(userInfo.getEmail(),userInfo.getPassword()));
    }

    @PostMapping("/test")
    public ResponseEntity<?> test(Authentication authentication){
        return ResponseEntity.ok().body("사용자명: "+authentication.getName());
    }

    // 모든 사용자리스트 가져오기
    @PostMapping("/getUserList")
    public List<UserInfo> getUserList() {
        return userService.getUserList();
    }

    // 로그인 회원 정보 가져오기
    @PostMapping("/getUser")
    public UserInfo getUser(@RequestBody UserInfo userinfo) {
        return userService.getUser(userinfo);
    }

    // 회원가입
    @PostMapping("/signUp")
    public String insertUser(@RequestBody UserInfo userinfo) {
        return userService.insertUser(userinfo);
    }

    // 이메일 중복 체크
    @PostMapping("/emailVerify")
    public String emailVerify(@RequestBody UserInfo userinfo) {
        return userService.emailVerify(userinfo);
    }

    // 회원정보 수정
    @PostMapping("/updateUser")
    public boolean updateUser(@RequestBody UserInfo userinfo) {
        return userService.updateUser(userinfo);
    }

    // 비밀번호 변경
    @PostMapping("/updatePassword")
    public String updatePassword(@RequestBody PasswordInfo passwordInfo) {
        return userService.updatePassword(passwordInfo);
    }

    // 회원 탈퇴
    @PostMapping("/deleteUser")
    public boolean deleteUser(@RequestBody UserInfo userinfo) {
        return userService.deleteUser(userinfo);
    }
}
