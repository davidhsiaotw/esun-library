package com.esun.library.service.mapper;

import com.esun.library.common.dto.BookDTOCheckout;
import com.esun.library.repository.entity.Book;
import com.esun.library.repository.entity.Inventory;
import com.esun.library.common.dto.BookDTOHome;

public class BookMapper {
    public static BookDTOHome toBookDTOHome(Book book) {
        return new BookDTOHome(
                book.getInventory().getIsbn().toString(), book.getName(), book.getInventory().getQuantity()
        );
    }

    public static Book toBook(BookDTOHome bookDTOHome) {
        return new Book(
                new Inventory(Long.parseLong(bookDTOHome.getIsbn()), bookDTOHome.getQuantity()),
                bookDTOHome.getName()
        );
    }

    public static BookDTOCheckout toBookDTOCheckout(Book book) {
        return new BookDTOCheckout(
                book.getId(), book.getInventory().getIsbn().toString(), book.getName(), book.getStatus()
        );
    }

    public static Book toBook(BookDTOCheckout bookDTOCheckout) {
        return new Book(bookDTOCheckout.getId(),
                new Inventory(Long.parseLong(bookDTOCheckout.getIsbn()), 0),
                bookDTOCheckout.getName(), bookDTOCheckout.getStatus()
        );
    }
}
