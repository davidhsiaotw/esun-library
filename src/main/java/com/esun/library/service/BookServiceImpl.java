package com.esun.library.service;

import com.esun.library.common.BookStatus;
import com.esun.library.common.dto.BookDTOCheckout;
import com.esun.library.repository.BookRepository;
import com.esun.library.repository.RecordRepository;
import com.esun.library.repository.entity.Book;
import com.esun.library.repository.entity.Inventory;
import com.esun.library.common.dto.BookDTOHome;
import com.esun.library.repository.entity.Record;
import com.esun.library.repository.entity.User;
import com.esun.library.service.mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private RecordRepository recordRepository;

    @Override
    public List<BookDTOHome> findBookDTOsHomeByIsbn(String isbn) {
        // TODO: implement
        return null;
    }

    @Override
    public List<BookDTOHome> findBookDTOsHomeByName(String name) {
        return bookRepository.findBooksQuantity("%" + name + "%").stream().map(records -> {
                    String bookName = (String) records[0];
                    Long isbn = (Long) records[1];
                    int quantity = (int) records[2];
                    return BookMapper.toBookDTOHome(new Book(new Inventory(isbn, quantity), bookName));
                }
        ).toList();
    }
}
