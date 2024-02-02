package com.catlendar.app.user.service;
import com.catlendar.app.user.mapper.UserMapper;
import com.catlendar.app.user.model.UserInfo;
import com.catlendar.utils.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.Base64Utils;
import org.springframework.util.ObjectUtils;

import javax.transaction.Transactional;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    @Autowired
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    @Value("${jwt.secret}")
    private String secretKey;
    private Long expiredMs = 1000*60*60l;

    public String login(String email, String password){
        // 회원 정보 확인
        UserInfo userInfo = userMapper.selectEmailInfo(email);
        if(ObjectUtils.isEmpty(userInfo)){
            return "존재하지 않는 이메일입니다.";
        }
        // 비밀번호 복호화
        if (!passwordEncoder.matches(password, userInfo.getPassword())) {
            return "비밀번호가 일치하지않습니다.";
        }
        else{
            return JwtUtil.createJwt(userInfo.getEmail(), secretKey, expiredMs);
        }
    }

    @Transactional
    public List<UserInfo> getUserList(){
        List<UserInfo> userInfo = userMapper.getUserList();
        return userInfo;
    }
    @Transactional
    public UserInfo getUser(UserInfo user){
        UserInfo userInfo = userMapper.getUser(user);
        return userInfo;
    }
    @Transactional
    public String insertUser(UserInfo user) {
        // 입력받은 비밀번호 암호화
        String encryptPassword = passwordEncoder.encode(user.getPassword());
        // user정보에 암호화한 비밀번호 삽입
        user.setPassword(encryptPassword);
        // 이메일 중복체크
        int emailVerifyCheck = userMapper.emailVerify(user);
        if(emailVerifyCheck==0) {
            int result = userMapper.insertUser(user);
            return "회원가입 되었습니다.";
        }
        return "중복된 이메일입니다.";
    }
    @Transactional
    public boolean emailVerify(UserInfo user){
        int result = userMapper.emailVerify(user);
        if(result==1){
            return false;
        }
        return true;
    }
    @Transactional
    public boolean updateUser(UserInfo user){
        int result = userMapper.updateUser(user);
        if(result<1){
            return false;
        }
        return true;
    }
    @Transactional
    public boolean deleteUser(UserInfo user){
        int result = userMapper.deleteUser(user);
        if(result<1){
            return false;
        }
        return true;
    }
}
