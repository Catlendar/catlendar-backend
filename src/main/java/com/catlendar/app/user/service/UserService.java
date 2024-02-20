package com.catlendar.app.user.service;
import com.catlendar.app.user.mapper.UserMapper;
import com.catlendar.app.user.model.PasswordInfo;
import com.catlendar.app.user.model.UserInfo;
import com.catlendar.app.user.model.UserTokenInfo;
import com.catlendar.utils.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
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

    // 토큰 만료시간 72시간으로 설정
    private Long expiredMs = 1000*60*60*72l;
    public Object login(String email, String password){
        // 회원 정보 확인
        UserTokenInfo userInfo = userMapper.selectEmailInfo(email);
        if(ObjectUtils.isEmpty(userInfo)){
            return "존재하지 않는 이메일입니다.";
        }
        // 비밀번호 복호화
        if (!passwordEncoder.matches(password, userInfo.getPassword())) {
            return "비밀번호가 일치하지않습니다.";
        }
        else{
        userInfo.setToken(JwtUtil.createJwt(userInfo.getEmail(), secretKey, expiredMs));
            return userInfo;
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
        int result = userMapper.insertUser(user);
        return "회원가입 성공";
    }

    @Transactional
    public String emailVerify(UserInfo user){
        int result = userMapper.emailVerify(user);
        if(result==1){
            return "이미 가입된 이메일 주소 입니다.";
        }
        return "사용 가능한 이메일 입니다.";
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
    public String updatePassword(PasswordInfo passwordInfo){
        // 기존 비밀번호 가져오기
        PasswordInfo password = userMapper.selectPassword(passwordInfo);
        // 입력한 비밀번호와 암호화되어있는 기존 비밀번호가 일치하는지 검증
        if (!passwordEncoder.matches(passwordInfo.getPassword(), password.getPassword())) {
            return "기존 비밀번호와 일치하지 않습니다.";
        }
        // 새롭게 입력한 비밀번호를 암호화하고 변경
        String encryptPassword = passwordEncoder.encode(passwordInfo.getNewPassword());
        passwordInfo.setPassword(encryptPassword);
        userMapper.updatePassword(passwordInfo);
        return "비밀번호가 변경되었습니다.";
    }

    @Transactional
    public boolean deleteUser(UserInfo user){
        // user와 연결되어있는 모든 db값 삭제
        userMapper.deleteUserCalendar(user);
        userMapper.deleteUserBookmark(user);
        int result = userMapper.deleteUser(user);
        if(result<1){
            return false;
        }
        return true;
    }
}
