package com.catlendar.app.calendar.service;


import com.catlendar.app.calendar.mapper.CalendarMapper;
import com.catlendar.app.calendar.model.BookmarkInfo;
import com.catlendar.app.calendar.model.CalendarInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CalendarService {

    @Autowired
    private final CalendarMapper calendarMapper;

    @Transactional
    public List<CalendarInfo> getSpecificMonth(CalendarInfo calendarInfo){
        List<CalendarInfo> specificMonth = calendarMapper.getSpecificMonth(calendarInfo);
        return specificMonth;
    }

    @Transactional
    public List<CalendarInfo> getMonth(CalendarInfo calendarInfo){
        List<CalendarInfo> month = calendarMapper.getMonth(calendarInfo);
        return month;
    }

    @Transactional
    public List<CalendarInfo> getToday(CalendarInfo calendarInfo){
        List<CalendarInfo> today = calendarMapper.getToday(calendarInfo);
        return today;
    }

    @Transactional
    public String createCalendar(CalendarInfo calendarInfo){
        calendarMapper.createCalendar(calendarInfo);
        return "할 일 리스트에 추가 되었습니다.";
    }

    @Transactional
    public String updateCalendar(CalendarInfo calendarInfo){
        calendarMapper.updateCalendar(calendarInfo);
        return "수정 되었습니다.";
    }

    @Transactional
    public String deleteCalendar(CalendarInfo calendarInfo){
        calendarMapper.deleteCalendar(calendarInfo);
        return "삭제 되었습니다.";
    }

    @Transactional
    public String completeCalendar(CalendarInfo calendarInfo){
        calendarMapper.completeCalendar(calendarInfo);
        return "변경 되었습니다.";
    }

    @Transactional
    public List<BookmarkInfo> getBookmarkList(BookmarkInfo bookmarkInfo){
        List<BookmarkInfo> bookmarkList = calendarMapper.getBookmarkList(bookmarkInfo);
        return bookmarkList;
    }

    @Transactional
    public BookmarkInfo getBookmark(BookmarkInfo bookmarkInfo){
        BookmarkInfo bookmark = calendarMapper.getBookmark(bookmarkInfo);
        return bookmark;
    }

    @Transactional
    public String createBookmark(BookmarkInfo bookmarkInfo){
        calendarMapper.createBookmark(bookmarkInfo);
        return "즐겨찾기에 추가 되었습니다.";
    }

    @Transactional
    public String deleteBookmark(BookmarkInfo bookmarkInfo){
        calendarMapper.deleteBookmark(bookmarkInfo);
        return "즐겨찾기가 삭제 되었습니다.";
    }

    @Transactional
    public String bookmarkToCalendar(BookmarkInfo bookmarkInfo){
        calendarMapper.bookmarkToCalendar(bookmarkInfo);
        return "할 일 리스트로 이동 되었습니다.";
    }
}