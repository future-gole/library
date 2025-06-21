package com.example.demo6.service;

import com.example.demo6.domain.BookCategory;

import java.util.List;

public interface BookCategoryService {
    BookCategory save(BookCategory category);
    List<BookCategory> findAll();
    void deleteById(Long id);
    BookCategory update(BookCategory category);
}
