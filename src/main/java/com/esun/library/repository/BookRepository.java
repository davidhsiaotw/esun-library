package com.esun.library.repository;

import com.esun.library.common.BookStatus;
import com.esun.library.repository.entity.Book;
import com.esun.library.repository.entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    @Query(value = "SELECT name, b.isbn, i.quantity FROM library.book AS b " +
            "JOIN library.inventory AS i ON b.isbn=i.isbn WHERE name LIKE :name " +
            "GROUP BY name, b.isbn, quantity", nativeQuery = true)
    List<Object[]> findBooksQuantity(@Param("name") String name);

    /**
     * Find books by ISBN, which is {@link Inventory}'s primary key, and status.
     *
     * @param inventory {@link Inventory} with ISBN
     * @param status    {@link BookStatus}
     * @return list of {@link Book}
     * @see <a href="https://docs.spring.io/spring-data/jpa/reference/jpa/query-methods.html#jpa.query-methods.declared-queries">Spring Data JPA - Query Creation</a>
     */
    List<Book> findByInventoryAndStatus(Inventory inventory, BookStatus status);
}
