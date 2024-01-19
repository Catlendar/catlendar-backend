package com.catlendar.app.user.service;

import com.catlendar.app.user.mapper.UserMapper;
import com.catlendar.app.user.model.User;
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
    public List<User> getUserList(){
        List<User> userInfo = userMapper.getUserList();
        return userInfo;
    }
    @Transactional
    public User getUser(User user){
        User userInfo = userMapper.getUser(user);
        return userInfo;
    }
}
