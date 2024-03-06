package com.esun.library.service.mapper;

import com.esun.library.repository.entity.Book;
import com.esun.library.repository.entity.Inventory;
import com.esun.library.service.dto.BookDTOHome;

public class BookMapper {
    public static BookDTOHome toBookDTOHome(Book book) {
        return new BookDTOHome(
                book.getInventory().getIsbn().toString(), book.getName(), book.getInventory().getQuantity()
        );
    }

    public static Book toBook(BookDTOHome bookDTOHome) {
        Long isbn = Long.parseLong(bookDTOHome.getIsbn().replace("-", ""));
        return new Book(new Inventory(isbn, bookDTOHome.getQuantity()), bookDTOHome.getName());
    }
}
