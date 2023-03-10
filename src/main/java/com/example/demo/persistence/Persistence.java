/*
package com.example.demo.persistence;

import com.example.demo.controller.ModelFactoryController;
import com.example.demo.models.Book;
import com.example.demo.models.Loan;
import com.example.demo.models.User;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Persistence {
    public static final String USER_PATH = "C:\\Users\\gomar\\Documents\\Universidad\\programacion\\Universidad\\demo1\\src\\main\\java\\com\\example\\demo\\resources\\Users.txt";
    public static final String BOOK_PATH = "C:\\Users\\gomar\\Documents\\Universidad\\programacion\\Universidad\\demo1\\src\\main\\java\\com\\example\\demo\\resources\\Books.txt";
    public static final String LOAN_PATH = "C:\\Users\\gomar\\Documents\\Universidad\\programacion\\Universidad\\demo1\\src\\main\\java\\com\\example\\demo\\resources\\Loans.txt";
    public static ModelFactoryController mfc = ModelFactoryController.getInstance();


    //Loading the Users for the login
    public static HashMap<String, User> loadUsers() throws FileNotFoundException, IOException {
        System.out.println("cargando datos");
        HashMap<String, User> users = new HashMap<>();

        ArrayList<String> content = Util.readFile(USER_PATH);
        String line = "";

        System.out.println(content);
        for (String s : content) {
            User user = new User();
            line = s;

            user.setName(line.split("&")[0]);
            user.setPassword(line.split("&")[1]);
            user.setEmail(line.split("&")[2]);
            user.setAddress(line.split("&")[3]);
            user.setPhone(line.split("&")[4]);

            users.put(user.getId(), user);
        }
        System.out.println(users);
        return users;
    }

    //Saving books in the persistence file
    public static void saveBook(Book book) throws IOException{
        String content = book.getId()+"&"+book.getTitle()+"&"+book.getAuthor()+"&"+book.getAvailable()+"&"+book.getUnits()+"\n";
        Util.saveFile(BOOK_PATH, content, false);
    }

    //loading books from the persistence file
    public static HashMap<String, Book> loadBooks() throws FileNotFoundException, IOException {
        HashMap<String, Book> books = new HashMap<>();
        ArrayList<String> content = Util.readFile(BOOK_PATH);
        String line = "";

        for (String s : content) {
            Book book = new Book();
            line = s;
            book.setId(line.split("&")[0]);
            book.setTitle(line.split("&")[1]);
            book.setAuthor(line.split("&")[2]);
            book.setAvailable(Boolean.valueOf(line.split("&")[3]));
            book.setUnits(Integer.valueOf(line.split("&")[4]));
            books.put(""+book.getId(), book);
        }
        return books;
    }


    //Saving loans
    public static void saveLoan(Loan loan) throws IOException{
        String content = loan.getId()+"&"+loan.getBook().getId()+"&"+loan.getUser().getId()+"&"+loan.getDateBegin()+"&"+loan.getDateFinish();
        Util.saveFile(LOAN_PATH, content, false);
    }
    //Loading loans
    public static HashMap<String, Loan> loadLoans() throws FileNotFoundException, IOException{
        HashMap<String, Loan> loans = new HashMap<>();
        ArrayList<String> content = Util.readFile(BOOK_PATH);
        String line = "";

        for (String s : content) {
            Loan loan = new Loan();
            line = s;
            loan.setId(line.split("&")[0]);
            Book book = mfc.getLib().getBookService().findBook(line.split("&")[1]);
            loan.setBook(book);
            User user = mfc.getLib().getUserService().findUser(line.split("&")[2]);
            loan.setUser(user);
            loan.setDateBegin(LocalDate.parse(line.split("&")[3]));
            loan.setDateFinish(LocalDate.parse(line.split("&")[4]));

            loans.put(""+loan.getId(), loan);
        }
        return loans;
    }
}
*/