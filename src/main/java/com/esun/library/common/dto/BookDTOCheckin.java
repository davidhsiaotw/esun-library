package com.esun.library.common.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class BookDTOCheckin {
    private Long id;
    private String isbn;
    private String name;
    private String checkoutTime;
}