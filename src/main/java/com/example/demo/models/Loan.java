package com.example.demo.models;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Loan {
    private String id;
    private Book book;
    private User user;
    private LocalDateTime dateBegin;
    private LocalDateTime dateFinish;

    public Loan(Book book, User user, LocalDateTime dateBegin, LocalDateTime dateFinish) {
        this.id = ""+Math.random()*100;
        this.book = book;
        this.user = user;
        this.dateBegin = dateBegin;
        this.dateFinish = dateFinish;
    }

    public Loan() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDateTime getDateBegin() {
        return dateBegin;
    }

    public void setDateBegin(LocalDateTime dateBegin) {
        this.dateBegin = dateBegin;
    }

    public LocalDateTime getDateFinish() {
        return dateFinish;
    }

    public void setDateFinish(LocalDateTime dateFinish) {
        this.dateFinish = dateFinish;
    }
}
