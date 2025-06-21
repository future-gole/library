package com.example.demo6.service;

import com.example.demo6.domain.BookCategory;
import com.example.demo6.repo.BookCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookCategoryServiceImpl implements BookCategoryService {
    @Autowired
    private BookCategoryRepository repository;

    @Override
    public BookCategory save(BookCategory category) {
        return repository.save(category);
    }

    @Override
    public List<BookCategory> findAll() {
        return repository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public BookCategory update(BookCategory category) {
        return repository.save(category);
    }
}