package com.example.demo6.service;

import com.example.demo6.domain.Book;

import java.util.List;

public interface BookService {
    Book save(Book book);
    List<Book> findAll();
    void deleteById(Long id);
    Book update(Book book);
    List<Book> searchByTitle(String keyword);
}