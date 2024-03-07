package com.esun.library;

import com.esun.library.repository.BookRepository;
import com.esun.library.repository.FakeData;
import com.esun.library.repository.InventoryRepository;
import com.esun.library.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

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
        FakeData data = FakeData.INSTANCE;
        data.initialize();
        if (userRepository.count() == 0) userRepository.saveAll(data.users);
        if (inventoryRepository.count() == 0) inventoryRepository.saveAll(data.inventories);
        if (bookRepository.count() == 0) bookRepository.saveAll(data.books);
    }
}