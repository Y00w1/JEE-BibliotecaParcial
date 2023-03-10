package com.example.demo.service;

import com.example.demo.models.Book;
import com.example.demo.models.User;

import java.util.HashMap;
import java.util.Map;

public interface BookService {
    Book findBook(String id);
    HashMap<String, Book> getBooks();
    void createBook(String title, String author, String amount);
}
