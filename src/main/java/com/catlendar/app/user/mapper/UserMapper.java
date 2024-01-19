package com.catlendar.app.user.mapper;

import com.catlendar.app.user.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    List<User> getUserList();
    User getUser(User user);
    int insertUser(User user);

    int updateUser(User user);
    int deleteUser(User user);
}
