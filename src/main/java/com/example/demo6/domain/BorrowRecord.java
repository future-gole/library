package com.example.demo6.domain;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "borrow_record")
public class BorrowRecord {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    private LocalDateTime borrowDate;
    private LocalDateTime returnDate;
    private String status; // 借出 / 已归还

    public BorrowRecord() {
    }

    public BorrowRecord(Long id, Book book, UserEntity user, LocalDateTime borrowDate, LocalDateTime returnDate, String status) {
        this.id = id;
        this.book = book;
        this.user = user;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
        this.status = status;
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
     * @return book
     */
    public Book getBook() {
        return book;
    }

    /**
     * 设置
     * @param book
     */
    public void setBook(Book book) {
        this.book = book;
    }

    /**
     * 获取
     * @return user
     */
    public UserEntity getUser() {
        return user;
    }

    /**
     * 设置
     * @param user
     */
    public void setUser(UserEntity user) {
        this.user = user;
    }

    /**
     * 获取
     * @return borrowDate
     */
    public LocalDateTime getBorrowDate() {
        return borrowDate;
    }

    /**
     * 设置
     * @param borrowDate
     */
    public void setBorrowDate(LocalDateTime borrowDate) {
        this.borrowDate = borrowDate;
    }

    /**
     * 获取
     * @return returnDate
     */
    public LocalDateTime getReturnDate() {
        return returnDate;
    }

    /**
     * 设置
     * @param returnDate
     */
    public void setReturnDate(LocalDateTime returnDate) {
        this.returnDate = returnDate;
    }

    /**
     * 获取
     * @return status
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置
     * @param status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    public String toString() {
        return "BorrowRecord{id = " + id + ", book = " + book + ", user = " + user + ", borrowDate = " + borrowDate + ", returnDate = " + returnDate + ", status = " + status + "}";
    }
    // getter/setter

}