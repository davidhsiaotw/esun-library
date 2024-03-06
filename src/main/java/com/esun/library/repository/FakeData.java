package com.esun.library.repository;

import com.esun.library.repository.entity.Book;
import com.esun.library.repository.entity.Inventory;
import com.esun.library.repository.entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FakeData {
    private static final FakeData INSTANCE = new FakeData();

    private FakeData() {
        Map<Long, Integer> inventories = Map.of(
                9780330523622L, 5,
                9780330523623L, 2,
                9780330523624L, 1,
                9780330523625L, 8,
                9780330523626L, 6,
                9780330523627L, 10,
                9780330523628L, 1,
                9780330523629L, 3
        );

        // initialize books
        inventories.forEach((isbn, quantity) -> {
            Inventory inventory = new Inventory(isbn, quantity);
            this.inventories.add(inventory);
            for (int i = 0; i < quantity; i++) {
                books.add(new Book(inventory, "Book " + isbn + "-" + i));
            }
        });
    }

    public static FakeData getInstance() {
        return INSTANCE;
    }

    public final List<User> users = List.of(
            new User("0912345678", "123456", "John"),
            new User("0912345679", "123456", "Mary"),
            new User("0912345670", "123456", "Tom"),
            new User("0912345671", "123456", "Jerry"),
            new User("0912345672", "123456", "Mickey"),
            new User("0912345673", "123456", "Donald"),
            new User("0912345674", "123456", "Daisy"),
            new User("0912345675", "123456", "Goofy"),
            new User("0912345676", "123456", "Pluto")
    );
    public final List<Inventory> inventories = new ArrayList<>();
    public final List<Book> books = new ArrayList<>();
}
