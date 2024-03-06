package com.esun.library.repository.entity;

import com.esun.library.common.BookStatus;
import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "isbn", referencedColumnName = "isbn")
    private Inventory inventory;
    private String name;
    private BookStatus status = BookStatus.CHECKIN;

    public Book(Inventory inventory, String name) {
        this.inventory = inventory;
        this.name = name;
    }
}
