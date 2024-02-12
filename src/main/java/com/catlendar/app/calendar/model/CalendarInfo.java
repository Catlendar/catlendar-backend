package com.catlendar.app.calendar.model;

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

    private String year;
    private String month;
}