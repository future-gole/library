package com.example.demo6.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String author;
    private String isbn;
    private Integer stock;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private BookCategory category;

    public Book() {
    }

    public Book(Long id, String title, String author, String isbn, Integer stock, BookCategory category) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.stock = stock;
        this.category = category;
    }

    /**
     * 获取
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取
     * @return title
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 获取
     * @return author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * 设置
     * @param author
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * 获取
     * @return isbn
     */
    public String getIsbn() {
        return isbn;
    }

    /**
     * 设置
     * @param isbn
     */
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    /**
     * 获取
     * @return stock
     */
    public Integer getStock() {
        return stock;
    }

    /**
     * 设置
     * @param stock
     */
    public void setStock(Integer stock) {
        this.stock = stock;
    }

    /**
     * 获取
     * @return category
     */
    public BookCategory getCategory() {
        return category;
    }

    /**
     * 设置
     * @param category
     */
    public void setCategory(BookCategory category) {
        this.category = category;
    }

    public String toString() {
        return "Book{id = " + id + ", title = " + title + ", author = " + author + ", isbn = " + isbn + ", stock = " + stock + ", category = " + category + "}";
    }
}