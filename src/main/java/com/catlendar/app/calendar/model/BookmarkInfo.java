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
public class BookmarkInfo {
    private String bookmarkId;
    private String userId;
    private String bookmarkContent;
    private Date createDate;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY) // 요청(Request)에서는 이 필드를 무시
    private Date targetDate;
}