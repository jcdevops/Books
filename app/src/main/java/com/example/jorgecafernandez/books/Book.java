package com.example.jorgecafernandez.books;

/**
 * Created by jorge.c.a.fernandez on 9/11/2017.
 */

public class Book {
    public String id;
    public String title;
    public String subTitle;
    public String[] authors;
    public String publisher;
    public String PublishedDate;

    public Book(String id, String title, String subTitle, String[] authors, String publisher, String publishedDate) {

        this.id = id;
        this.title = title;
        this.subTitle = subTitle;
        this.authors = authors;
        this.publisher = publisher;
        PublishedDate = publishedDate;
    }
}
