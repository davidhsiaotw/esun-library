package com.esun.library.repository;

import com.esun.library.repository.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    @Query(value = "SELECT name, b.isbn, i.quantity FROM library.book AS b " +
            "JOIN library.inventory AS i ON b.isbn=i.isbn WHERE name LIKE :name " +
            "GROUP BY name, b.isbn, quantity", nativeQuery = true)
    List<Object[]> findBooksQuantity(@Param("name") String name);
}
