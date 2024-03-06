package com.esun.library.common.dto;

import com.esun.library.common.BookStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class BookDTOCheckout {
    private Long id;
    private String isbn;    // e.g. 978-0-3305-2362-2
    private String name;
    private BookStatus status;
}