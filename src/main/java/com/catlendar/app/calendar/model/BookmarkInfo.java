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
public class BookmarkInfo {
    private String bookmarkId;
    private String userId;
    private String bookmarkContent;
    private Date createDate;

    private Date calendarDate;
}