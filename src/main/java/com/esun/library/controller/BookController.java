package com.esun.library.controller;

import com.esun.library.common.dto.BookDTOCheckout;
import com.esun.library.service.BookService;
import com.esun.library.common.dto.BookDTOHome;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/books")
public class BookController {
    private BookService bookService;

    @GetMapping(value = {"home/get", "home/get/{name}"})
    public ResponseEntity<List<BookDTOHome>> getBooksByName(@PathVariable(required = false) String name) {
        try {
            List<BookDTOHome> books;
            if (name == null) {
                books = bookService.findBookDTOsHomeByName("");
            } else {
                books = bookService.findBookDTOsHomeByName(name);
            }
            return new ResponseEntity<>(books, HttpStatus.CREATED);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("checkout/get/{isbn}")
    public ResponseEntity<List<BookDTOCheckout>> getBooksByIsbn(@PathVariable String isbn) {
        try {
            List<BookDTOCheckout> books = bookService.findBookDTOsCheckoutByIsbn(isbn);
            return new ResponseEntity<>(books, HttpStatus.CREATED);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("checkout")
    public ResponseEntity<String> checkout(@RequestParam(name = "userId") Long userId,
                                           @RequestParam(name = "bookId") Long bookId) {
        try {
            bookService.checkout(userId, bookId);
            return new ResponseEntity<>("Checkout successfully", HttpStatus.CREATED);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
