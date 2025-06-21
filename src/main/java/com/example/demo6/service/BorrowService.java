package com.example.demo6.service;

import com.example.demo6.domain.BorrowRecord;

import java.util.List;

public interface BorrowService {
    BorrowRecord borrowBook(BorrowRecord record);
    BorrowRecord returnBook(BorrowRecord record);
    List<BorrowRecord> findAll();
    List<BorrowRecord> findByUserId(Long userId);
}