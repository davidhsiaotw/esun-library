package com.esun.library.repository.entity;

import com.esun.library.common.BookStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Book {
    @Id
    private @NonNull Long id;

    @ManyToOne
    @JoinColumn(name = "isbn", referencedColumnName = "isbn")
    private @NonNull Inventory inventory;
    private String name;
    private BookStatus status = BookStatus.CHECKIN;
}
