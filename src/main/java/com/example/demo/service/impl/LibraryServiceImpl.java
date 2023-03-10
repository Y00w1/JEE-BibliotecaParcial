package com.example.demo.service.impl;

import com.example.demo.service.BookService;
import com.example.demo.service.LoanService;

public class LibraryServiceImpl {
    private final BookService bookService;
    private final LoanService loanService;
    private final UserServiceImpl userService;

    public LibraryServiceImpl() {
        this.bookService = new BookServiceImpl();
        this.userService = new UserServiceImpl();
        this.loanService = new LoanServiceImpl();
    }
    public BookService getBookService() {
        return bookService;
    }

    public LoanService getLoanService() {
        return loanService;
    }

    public UserServiceImpl getUserService() {
        return userService;
    }
}
