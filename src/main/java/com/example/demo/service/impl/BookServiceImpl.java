package com.example.demo.service.impl;

import com.example.demo.baseDatos.UtilDB;
import com.example.demo.models.Book;
import com.example.demo.service.BookService;

import java.util.HashMap;
import java.util.Map;

public class BookServiceImpl implements BookService {
    private HashMap<String, Book> books = new HashMap<>();

    public BookServiceImpl() {
        Book book = new Book("Titulo", "Autor", 3 );
        books.put(book.getId(), book);
        //books = UtilDB.dataBaseBooks();
    }

    @Override
    public Book findBook(String id) {
        for (Book book : books.values()) {
            if (book.getId().equals(id)){
                return book;
            }
        }
        return null;
    }

    public HashMap<String, Book> getBooks() {
        return books;
    }

    public void createBook(String title, String author, String amount){
        Book book = new Book(title, author, Integer.parseInt(amount));
        books.put(book.getId(), book);
        UtilDB.saveBook(book);
    }
}
