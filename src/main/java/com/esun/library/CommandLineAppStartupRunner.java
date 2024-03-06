package com.esun.library;


import com.esun.library.repository.BookRepository;
import com.esun.library.repository.FakeData;
import com.esun.library.repository.InventoryRepository;
import com.esun.library.repository.UserRepository;
import com.esun.library.repository.entity.Book;
import com.esun.library.repository.entity.Inventory;
import com.esun.library.repository.entity.User;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class CommandLineAppStartupRunner implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private InventoryRepository inventoryRepository;

    @Override
    public void run(String... args) {
        List<User> users = FakeData.getInstance().users;
        if (userRepository.count() == 0) userRepository.saveAll(users);
        List<Inventory> inventories = FakeData.getInstance().inventories;
        if (inventoryRepository.count() == 0) inventoryRepository.saveAll(inventories);
        List<Book> books = FakeData.getInstance().books;
        if (bookRepository.count() == 0) bookRepository.saveAll(books);
    }
}