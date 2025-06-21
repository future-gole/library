package com.example.demo6.service;

import com.example.demo6.domain.Book;
import com.example.demo6.repo.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository repository;

    @Override
    public Book save(Book book) {
        return repository.save(book);
    }

    @Override
    public List<Book> findAll() {
        return repository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Book update(Book book) {
        return repository.save(book);
    }

    @Override
    public List<Book> searchByTitle(String keyword) {
        return repository.findByTitleAuthorOrIsbn(keyword);
    }
}