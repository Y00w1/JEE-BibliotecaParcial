package com.example.demo.service.impl;

import com.example.demo.models.Book;
import com.example.demo.models.Loan;
import com.example.demo.models.User;
import com.example.demo.service.LoanService;

import java.io.FileNotFoundException;
import java.io.IOException;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class LoanServiceImpl implements LoanService {
    Map<String, Loan> loans = new HashMap<>();

    public void makeLoan(User user, Book book){
        LocalDateTime dateBgn = LocalDateTime.now();
        LocalDateTime dateEnd = dateBgn.plusDays(10);
        Loan loan = new Loan( book, user, dateBgn, dateEnd);
        loans.put(loan.getId(), loan);
    }
}
