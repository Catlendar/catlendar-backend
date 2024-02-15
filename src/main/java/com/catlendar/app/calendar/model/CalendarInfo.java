package com.catlendar.app.calendar.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CalendarInfo {
    private String calendarId;
    private String userId;
    private Date calendarDate;
    private String calendarContent;
    private String bookmark;
    private String completed;
    private Date createDate;

    // 요청(Request)에서는 이 필드를 무시
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String targetDate;
}