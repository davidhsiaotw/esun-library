package com.esun.library.service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class BookDTOHome {
    private String isbn;
    private String name;
    private int quantity;
}
