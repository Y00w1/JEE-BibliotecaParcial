package com.example.demo.service;

import com.example.demo.models.Book;
import com.example.demo.models.User;

public interface LoanService {
    void makeLoan(User user, Book book);
}
