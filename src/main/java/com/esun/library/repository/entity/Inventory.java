package com.esun.library.repository.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Inventory {
    @Id
    private Long isbn;  // e.g. 978-0-3305-2362-2 => 9780330523622
    private int quantity;
}
