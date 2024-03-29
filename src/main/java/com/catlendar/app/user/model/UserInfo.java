package com.catlendar.app.user.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserInfo {
    private String userId;
    private String email;
    private String password;
    private String name;
    private String birthDate;
    private String birthTime;
    private String calendarType;
    private String gender;
    private Date registDate;
}
