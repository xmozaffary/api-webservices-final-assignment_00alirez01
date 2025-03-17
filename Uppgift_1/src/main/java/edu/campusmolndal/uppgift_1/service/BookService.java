package edu.campusmolndal.uppgift_1.service;

import edu.campusmolndal.uppgift_1.model.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Service
public class BookService {

    List<Book> books = new ArrayList<>(Arrays.asList(
            new Book("To Kill a Mockingbird", 1960, "Harper Lee"),
            new Book( "1984", 1949, "George Orwell"),
            new Book("The Great Gatsby", 1925, "F. Scott Fitzgerald")
    ));

    public List<Book> getAllBooks(){
        return books;
    }

    public void createBook(Book book){
        books.add(book);
    }
}
