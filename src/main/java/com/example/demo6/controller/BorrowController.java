package com.example.demo6.controller;

import com.example.demo6.domain.Book;
import com.example.demo6.domain.BorrowRecord;
import com.example.demo6.domain.UserEntity;
import com.example.demo6.repo.BookCategoryRepository;
import com.example.demo6.repo.BookRepository;
import com.example.demo6.repo.BorrowRepository;
import com.example.demo6.repo.UserEntityRepository;
import com.example.demo6.service.BorrowService;
import com.example.demo6.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/borrow")
@CrossOrigin
public class BorrowController {

    @Autowired
    private BorrowService borrowService;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private UserEntityRepository userRepository;

    @Autowired
    private BorrowRepository borrowRepository;

    @PostMapping("/borrow")
    public R borrow(@RequestBody Map<String, Object> payload) {
        Long bookId = Long.parseLong(payload.get("bookId").toString());
        Long userId = Long.parseLong(payload.get("userId").toString());

        System.out.println(bookId + " " + userId);
        Book book = bookRepository.findById(bookId).orElseThrow();
        UserEntity user = userRepository.findById(userId.intValue()).orElseThrow();

        BorrowRecord record = new BorrowRecord();
        record.setBook(book);
        record.setUser(user);

        return R.success(borrowService.borrowBook(record));
    }


    @PostMapping("/return")
    public R returnBook(@RequestBody Map<String, Object> payload) {
        Long id = Long.parseLong(payload.get("id").toString());
        BorrowRecord record = borrowRepository.findById(id).orElseThrow();
        return R.success(borrowService.returnBook(record));
    }

    @PostMapping("/list")
    public R listAll() {
        return R.success(borrowService.findAll());
    }

    @PostMapping("/my")
    public R myRecords(@RequestBody Map<String, Long> map) {
        System.out.println("map = " + map.toString());
        return R.success(borrowService.findByUserId(map.get("userId")));
    }
}
