package com.catlendar.app.calendar.controller;

import com.catlendar.app.calendar.model.BookmarkInfo;
import com.catlendar.app.calendar.model.CalendarInfo;
import com.catlendar.app.calendar.service.CalendarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<String> createCalendar(@RequestBody CalendarInfo calendarInfo) {
        if (calendarInfo.getCalendarContent().trim().isEmpty()) {
            return ResponseEntity.badRequest().body("calendarContent is null or empty");
        }
        return ResponseEntity.ok(calendarService.createCalendar(calendarInfo));
    }

    // 할 일 수정
    @PostMapping("/updateCalendar")
    public ResponseEntity<String> updateCalendar(@RequestBody CalendarInfo calendarInfo) {
        if (calendarInfo.getCalendarContent().trim().isEmpty()) {
            return ResponseEntity.badRequest().body("calendarContent is null or empty");
        }
        return ResponseEntity.ok(calendarService.updateCalendar(calendarInfo));
    }

    // 할 일 삭제
    @PostMapping("/deleteCalendar")
    public String deleteCalendar(@RequestBody CalendarInfo calendarInfo) {
        return calendarService.deleteCalendar(calendarInfo);
    }

    // 할 일 완료 토글
    @PostMapping("/completeCalendar")
    public String completeCalendar(@RequestBody CalendarInfo calendarInfo) {
        return calendarService.completeCalendar(calendarInfo);
    }

    // 즐겨찾기 리스트 가져오기
    @PostMapping("/getBookmarkList")
    public List<BookmarkInfo> getBookmarkList(@RequestBody BookmarkInfo bookmarkInfo) {
        return calendarService.getBookmarkList(bookmarkInfo);
    }

    // 즐겨찾기 단일 정보 가져오기
    @PostMapping("/getBookmark")
    public BookmarkInfo getBookmark(@RequestBody BookmarkInfo bookmarkInfo) {
        return calendarService.getBookmark(bookmarkInfo);
    }

    // 즐겨찾기 페이지에서 북마크 추가
    @PostMapping("/createBookmark")
    public ResponseEntity<String> createBookmark(@RequestBody BookmarkInfo bookmarkInfo) {
        if (bookmarkInfo.getBookmarkContent().trim().isEmpty()) {
            return ResponseEntity.badRequest().body("bookmarkContent is null or empty");
        }
        return ResponseEntity.ok(calendarService.createBookmark(bookmarkInfo));
    }

    // 즐겨찾기 페이지에서 북마크 삭제
    @PostMapping("/deleteBookmark")
    public String deleteBookmark(@RequestBody BookmarkInfo bookmarkInfo) {
        return calendarService.deleteBookmark(bookmarkInfo);
    }

    // 즐겨찾기 페이지에서 할 일 리스트로 이동시키기
    @PostMapping("/bookmarkToCalendar")
    public String bookmarkToCalendar(@RequestBody BookmarkInfo bookmarkInfo) {
        return calendarService.bookmarkToCalendar(bookmarkInfo);
    }
}
