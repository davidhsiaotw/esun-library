package com.esun.library.service;

import com.esun.library.common.dto.BookDTOCheckout;
import com.esun.library.common.dto.BookDTOHome;

import java.util.List;

public interface BookService {
    /**
     * Find books and their quantity in the inventory.
     *
     * @param isbn The ISBN of the book.
     * @return A list of books.
     */
    List<BookDTOHome> findBookDTOsHomeByIsbn(String isbn);

    /**
     * Find books and their quantity in the inventory.
     *
     * @param name The name of the book.
     * @return A list of books.
     */
    List<BookDTOHome> findBookDTOsHomeByName(String name);

    /**
     * @param isbn The ISBN of the book.
     * @return A list of books that can be checked out.
     */
    List<BookDTOCheckout> findBookDTOsCheckoutByIsbn(String isbn);

    void checkout(Long userId, Long bookId);
}
