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

    @Override
    public List<BookDTOCheckout> findBookDTOsCheckoutByIsbn(String isbn) {
        List<Book> books = bookRepository.findByInventoryAndStatus(new Inventory(Long.parseLong(isbn), 0), BookStatus.CHECKIN);
        return books.stream().map(BookMapper::toBookDTOCheckout).toList();
    }

    @Override
    public void checkout(Long userId, Long bookId) {
        Book book = bookRepository.findById(bookId).orElseThrow();
        User user = new User(userId, null, null, null);

        if (book.getStatus() == BookStatus.CHECKOUT) {
            throw new RuntimeException("The book is already checked out");
        }

        // change the status to check-out
        book.setStatus(BookStatus.CHECKOUT);
        // minus the quantity of the inventory
        book.getInventory().setQuantity(book.getInventory().getQuantity() - 1);
        // add a new record
        Record record = new Record(user, book, LocalDateTime.now(), null);
        recordRepository.save(record);
    }
}
