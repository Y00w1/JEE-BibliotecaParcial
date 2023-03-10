package com.example.demo.baseDatos;

import com.example.demo.models.Book;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UtilDB {
    public static HashMap<String, Book> dataBaseBooks(){
        HashMap<String, Book> bookList = new HashMap<>();
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/dbBooks";
        String user = "admin_user";
        String password = "admin";
        try {
            Class.forName(driver);
            Connection connection = DriverManager.getConnection(url,user,password);
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM books");
            while (rs.next()){
                Book book = new Book(rs.getString("title"),rs.getString("author"),Integer.parseInt(rs.getString("amount")));
                bookList.put(book.getId(), book);
                System.out.println(rs.getString("title") + " se guardó exitosamente");
            }
            statement.close();
            return bookList;
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public static void saveBook(Book book){
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/dbBooks";
        String user = "admin_user";
        String password = "admin";
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, user, password);
            ps = connection.prepareStatement("INSERT INTO books VALUES (?,?,?,?,?,?)");
            ps.setString(1, book.getId());
            ps.setString(2, book.getImgLink());
            ps.setString(3, book.getTitle());
            ps.setString(4, book.getAuthor());
            ps.setBoolean(5, book.getAvailable());
            ps.setString(6, ""+book.getUnits());

            ps.executeUpdate();
            System.out.println("Conexion funcional");
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                if (connection != null){
                    connection.close();
                }
            }catch (SQLException e){
                System.out.println(e);
            }
        }
    }
}
