package com.catlendar.app.user.service;
import com.catlendar.app.user.mapper.UserMapper;
import com.catlendar.app.user.model.UserInfo;
import com.catlendar.utils.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    @Autowired
    private final UserMapper userMapper;

    @Value("${jwt.secret}")
    private String secretKey;
    private Long expiredMs = 1000*60*60l;
    public String login(String name, String password){
        return JwtUtil.createJwt(name, secretKey, expiredMs);
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
    public boolean insertUser(UserInfo user){
        int result = userMapper.insertUser(user);
        if(result<1){
            return false;
        }
        return true;
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
