package com.example.demo6.service;

import com.example.demo6.domain.Book;
import com.example.demo6.domain.BorrowRecord;
import com.example.demo6.repo.BookRepository;
import com.example.demo6.repo.BorrowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BorrowServiceImpl implements BorrowService {
    @Autowired
    private BorrowRepository borrowRepository;

    @Autowired
    private BookRepository bookRepository;

//    @Override
//    public BorrowRecord borrowBook(BorrowRecord record) {
//        record.setBorrowDate(LocalDateTime.now());
//        record.setStatus("借出");
//        // 减库存（简化处理）
//        Book book = bookRepository.findById(record.getBook().getId()).orElseThrow();
//        book.setStock(book.getStock() - 1);
//        bookRepository.save(book);
//        return borrowRepository.save(record);
//    }

    @Override
    public BorrowRecord borrowBook(BorrowRecord record) {
        Book book = bookRepository.findById(record.getBook().getId()).orElseThrow();
        if (book.getStock() == null || book.getStock() <= 0) {
            throw new RuntimeException("库存不足，无法借阅");
        }

        book.setStock(book.getStock() - 1);
        bookRepository.save(book);

        record.setBorrowDate(LocalDateTime.now());
        record.setStatus("借出");
        return borrowRepository.save(record);
    }


    @Override
    public BorrowRecord returnBook(BorrowRecord record) {
        System.out.println("record = " + record);
        BorrowRecord origin = borrowRepository.findById(record.getId()).orElseThrow();
        origin.setStatus("已归还");
        origin.setReturnDate(LocalDateTime.now());
        // 加库存
        Book book = origin.getBook();
        book.setStock(book.getStock() + 1);
        bookRepository.save(book);
        return borrowRepository.save(origin);
    }

    @Override
    public List<BorrowRecord> findAll() {
        return borrowRepository.findAll();
    }

    @Override
    public List<BorrowRecord> findByUserId(Long userId) {
        return borrowRepository.findByUser_Id(userId);
    }
}  