package com.catlendar.app.user.service;
import com.catlendar.app.user.mapper.UserMapper;
import com.catlendar.app.user.model.UserInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    @Autowired
    private final UserMapper userMapper;
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
