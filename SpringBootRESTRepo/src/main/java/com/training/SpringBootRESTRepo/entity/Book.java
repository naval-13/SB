package com.training.SpringBootRESTRepo.entity;

import jakarta.persistence.*;
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookid;
    // default it creates column with length 255 and allows null. Modify using attributes as below
    @Column(length = 100, nullable = false)
    private String title;
    @Column(length = 100, nullable = false)
    private String author;
    @Column(name = "description")
    private String desc;

    private double price;

    public Book() {

    }

    public Book(int bookid, String title, String author, String desc, double price) {
        this.bookid = bookid;
        this.title = title;
        this.author = author;
        this.desc = desc;
        this.price = price;
    }

    public Book(String title, String author, String desc, double price) {
        this.title = title;
        this.author = author;
        this.desc = desc;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookid=" + bookid +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", desc='" + desc + '\'' +
                ", price=" + price +
                '}';
    }

    public int getBookid() {
        return bookid;
    }

    public void setBookid(int bookid) {
        this.bookid = bookid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
