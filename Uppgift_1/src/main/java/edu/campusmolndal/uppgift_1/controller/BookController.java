package edu.campusmolndal.uppgift_1.controller;

import edu.campusmolndal.uppgift_1.model.Book;
import edu.campusmolndal.uppgift_1.service.BookService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/book")
@Tag(name = "Library", description = "Operations related to books in the library")
public class BookController {

    private final BookService service;

    public BookController(BookService service){
        this.service = service;
    }

    @GetMapping
    @Operation(summary = "Fetch a list of available books", responses = {
            @ApiResponse(responseCode = "200", description = "Successfully fetched the list of books"),
            @ApiResponse(responseCode = "500", description = "Server error")
    })
    public ResponseEntity<List<Book>> getBooks(){
        return ResponseEntity.ok(service.getAllBooks());
    }

    @PostMapping
    @Operation(summary = "Add a new book", responses = {
            @ApiResponse(responseCode = "201", description = "The book was successfully created"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "500", description = "Server error")
    })
    public ResponseEntity<String> addBook(@Parameter(description = "book", required = true) @RequestBody Book book){
        service.createBook(book);
        return ResponseEntity.status(HttpStatus.CREATED).body("Book added");
    }
}
