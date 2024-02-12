package com.catlendar.app.calendar.controller;

import com.catlendar.app.calendar.model.BookmarkInfo;
import com.catlendar.app.calendar.model.CalendarInfo;
import com.catlendar.app.calendar.service.CalendarService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = {"/calendar"})
public class CalendarController {

    private final CalendarService calendarService;

    // 선택한 연도, 달의 캘린더 가져오기
    @PostMapping("/getSpecificMonth")
    public List<CalendarInfo> getSpecificMonth(@RequestBody CalendarInfo calendarInfo) {
        return calendarService.getSpecificMonth(calendarInfo);
    }

    // 이번 달 캘린더 가져오기
    @PostMapping("/getMonth")
    public List<CalendarInfo> getMonth(@RequestBody CalendarInfo calendarInfo) {
        return calendarService.getMonth(calendarInfo);
    }

    // 금일 캘린더 가져오기
    @PostMapping("/getToday")
    public List<CalendarInfo> getToday(@RequestBody CalendarInfo calendarInfo) {
        return calendarService.getToday(calendarInfo);
    }

    // 할 일 추가
    @PostMapping("/createCalendar")
    public String createCalendar(@RequestBody CalendarInfo calendarInfo) {
        return calendarService.createCalendar(calendarInfo);
    }

    // 할 일 수정
    @PostMapping("/updateCalendar")
    public String updateCalendar(@RequestBody CalendarInfo calendarInfo) {
        return calendarService.updateCalendar(calendarInfo);
    }

    // 할 일 삭제
    @PostMapping("/deleteCalendar")
    public String deleteCalendar(@RequestBody CalendarInfo calendarInfo) {
        return calendarService.deleteCalendar(calendarInfo);
    }

    // 즐겨찾기 리스트 가져오기
    @PostMapping("/getBookmark")
    public List<BookmarkInfo> getBookmark(@RequestBody BookmarkInfo bookmarkInfo) {
        return calendarService.getBookmark(bookmarkInfo);
    }

    // 즐겨찾기 페이지에서 북마크 추가
    @PostMapping("/createBookmark")
    public String createBookmark(@RequestBody BookmarkInfo bookmarkInfo) {
        return calendarService.createBookmark(bookmarkInfo);
    }

    // 즐겨찾기 페이지에서 할 일 리스트로 이동시키기
    @PostMapping("/bookmarkToCalendar")
    public String bookmarkToCalendar(@RequestBody BookmarkInfo bookmarkInfo) {
        return calendarService.bookmarkToCalendar(bookmarkInfo);
    }
}
