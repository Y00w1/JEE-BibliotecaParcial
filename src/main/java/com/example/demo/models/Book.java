package com.example.demo.models;

import java.time.LocalDate;

public class Book {
    private String id;
    private String imgLink;
    private String title;
    private String author;
    private Boolean available;
    private Integer units;

    public Book(String title, String author, Integer units) {
        this.id = ""+Math.random() * 100;
        this.title = title;
        this.author = author;
        this.imgLink = "C:\\Users\\gomar\\Documents\\Universidad\\programacion\\Universidad\\demo1\\src\\main\\webapp\\imgs\\BookTemplate.png";
        //TODO: The user add the image of the book.
        this.available = units>0;
        this.units = units;
    }

    public Book() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImgLink() {
        return imgLink;
    }

    public void setImgLink(String imgLink) {
        this.imgLink = imgLink;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public Integer getUnits() {
        return units;
    }

    public void setUnits(Integer units) {
        this.units = units;
    }
}