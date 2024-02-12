package com.catlendar.app.calendar.mapper;


import com.catlendar.app.calendar.model.BookmarkInfo;
import com.catlendar.app.calendar.model.CalendarInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CalendarMapper {

    List<CalendarInfo> getSpecificMonth(CalendarInfo calendarInfo);

    List<CalendarInfo> getMonth(CalendarInfo calendarInfo);

    List<CalendarInfo> getToday(CalendarInfo calendarInfo);

    int createCalendar(CalendarInfo calendarInfo);

    int updateCalendar(CalendarInfo calendarInfo);

    int deleteCalendar(CalendarInfo calendarInfo);

    List<BookmarkInfo> getBookmark(BookmarkInfo bookmarkInfo);

    int createBookmark(BookmarkInfo bookmarkInfo);

    int bookmarkToCalendar(BookmarkInfo bookmarkInfo);
}
