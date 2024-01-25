package com.catlendar.app.user.mapper;

import com.catlendar.app.user.model.UserInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    List<UserInfo> getUserList();
    UserInfo getUser(UserInfo user);
    int insertUser(UserInfo user);
    int updateUser(UserInfo user);
    int deleteUser(UserInfo user);
}
