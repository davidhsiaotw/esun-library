package com.esun.library.controller;

import com.esun.library.service.BookService;
import com.esun.library.common.dto.BookDTOHome;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/books")
public class BookController {
    private BookService bookService;

    @GetMapping(value = {"get", "get/{name}"})
    public ResponseEntity<List<BookDTOHome>> getBookByName(@PathVariable(required = false) String name) {
        try {
            List<BookDTOHome> books;
            if (name == null) {
                books = bookService.findBookDtosHomeByName("");
            } else {
                books = bookService.findBookDtosHomeByName(name);
            }
            return new ResponseEntity<>(books, HttpStatus.CREATED);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
