package com.example.demo6.controller;

import com.example.demo6.domain.Book;
import com.example.demo6.domain.BookCategory;
import com.example.demo6.repo.BookCategoryRepository;
import com.example.demo6.service.BookService;
import com.example.demo6.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/book")
@CrossOrigin
public class BookController {

    @Autowired
    private BookService bookService;
    @Autowired
    private BookCategoryRepository categoryRepository;

    @PostMapping("/add")
    public R add(@RequestBody Map<String, Object> payload) {
        Book book = new Book();
        book.setTitle((String) payload.get("title"));
        book.setAuthor((String) payload.get("author"));
        book.setIsbn((String) payload.get("isbn"));
        book.setStock(Integer.parseInt(payload.get("stock").toString()));

        Long categoryId = Long.parseLong(payload.get("categoryId").toString());
        BookCategory category = categoryRepository.findById(categoryId).orElseThrow();
        book.setCategory(category);

        return R.success(bookService.save(book));
    }


    @PostMapping("/list")
    public R list() {
        return R.success(bookService.findAll());
    }

    @PostMapping("/search")
    public R search(@RequestBody Map<String, String> param) {
        return R.success(bookService.searchByTitle(param.get("keyword")));
    }

    @PostMapping("/delete")
    public R delete(@RequestBody Book book) {
        bookService.deleteById(book.getId());
        return R.success("deleted");
    }

    @PostMapping("/update")
    public R update(@RequestBody Book book) {
        return R.success(bookService.update(book));
    }
}
