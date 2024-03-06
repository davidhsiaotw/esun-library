package com.esun.library.service;

import com.esun.library.common.dto.BookDTOHome;

import java.util.List;

public interface BookService {
    List<BookDTOHome> findBookDtosHomeByIsbn(String isbn);

    List<BookDTOHome> findBookDtosHomeByName(String name);
}
