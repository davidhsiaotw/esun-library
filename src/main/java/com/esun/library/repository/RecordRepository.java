package com.esun.library.repository;

import com.esun.library.repository.entity.Book;
import com.esun.library.repository.entity.Record;
import com.esun.library.repository.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecordRepository extends JpaRepository<Record, Long> {
    List<Record> findByUserAndCheckInTimeNull(User user);

    Record findByUserAndBookAndCheckInTimeNull(User user, Book book);
}
