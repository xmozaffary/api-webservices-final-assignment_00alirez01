package edu.campusmolndal.uppgift_1.model;


import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Details about book")
public class Book {

    @Schema(description = "Book name")
    String name;

    @Schema(description = "Author name")
    String author;

    @Schema(description = "Publish year")
    int year;

    public Book(String name, int year, String author) {
        this.name = name;
        this.author = author;
        this.year = year;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
