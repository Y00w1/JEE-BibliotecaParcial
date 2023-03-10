package com.example.demo.controller;

import com.example.demo.models.Book;
import com.example.demo.models.User;
import com.example.demo.service.impl.LibraryServiceImpl;

import java.util.HashMap;

public class ModelFactoryController {
    private LibraryServiceImpl lib;
    private static class SingletonHolder{
        private final static ModelFactoryController eINSTANCE = new ModelFactoryController();
    }
    public static ModelFactoryController getInstance() {
        return SingletonHolder.eINSTANCE;
    }

    public ModelFactoryController() {
        lib = new LibraryServiceImpl();
    }

    public LibraryServiceImpl getLib() {
        return lib;
    }
    //Login
    public Boolean login(String Email, String Password){
        return lib.getUserService().verifyCredentials(Email, Password);
    }
    //Book
    public void saveBook(String title, String author, String unit){
        lib.getBookService().createBook(title, author, unit);
    }

    public User getUser(){
        return lib.getUserService().getSessionUser();
    }

    //Books
    public Book findBook(String id){
        return lib.getBookService().findBook(id);
    }
    public HashMap<String, Book> loadBooks(){
        return lib.getBookService().getBooks();
    }


    public void makeLoan(User user, Book book){
        lib.getLoanService().makeLoan(user, book);
    }

}
