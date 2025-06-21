package com.example.demo6.controller;

import com.example.demo6.domain.BookCategory;
import com.example.demo6.service.BookCategoryService;
import com.example.demo6.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/category")
@CrossOrigin
public class BookCategoryController {

    @Autowired
    private BookCategoryService categoryService;

    @PostMapping("/add")
    public R add(@RequestBody BookCategory category) {
        System.out.println("添加分类：" + category.getName() + " - " + category.getDescription());
        return R.success(categoryService.save(category));
    }

    @PostMapping("/list")
    public R list() {
        return R.success(categoryService.findAll());
    }

    @PostMapping("/delete")
    public R delete(@RequestBody BookCategory category) {
        categoryService.deleteById(category.getId());
        return R.success("deleted");
    }

    @PostMapping("/update")
    public R update(@RequestBody BookCategory category) {
        return R.success(categoryService.update(category));
    }
}
