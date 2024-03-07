package com.esun.library;

import com.esun.library.common.dto.BookDTOHome;
import com.esun.library.repository.BookRepository;
import com.esun.library.repository.entity.Book;
import com.esun.library.repository.entity.Inventory;
import com.esun.library.service.BookService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

public class BookServiceTest {
    @BeforeAll
    public static void setup() {
        BookRepository repository = Mockito.mock(BookRepository.class);
        // initialize two books, individually have 3 and 5 copies
        Inventory inventory1 = new Inventory(9789862012251L, 3);
        Book book1 = new Book(inventory1, "Java");
        Inventory inventory2 = new Inventory(9789862012252L, 5);
        Book book2 = new Book(inventory2, "Kotlin");
        repository.saveAll(List.of(book1, book1, book1));
        repository.saveAll(List.of(book2, book2, book2, book2, book2));
    }

    @Test
    public void testFindBooksAndQuantityByName() {
        BookService service = Mockito.mock(BookService.class);
        List<BookDTOHome> expect = List.of(new BookDTOHome("9789862012251", "Java", 3));
        Mockito.when(service.findBookDTOsHomeByName("Ja")).thenReturn(expect);
        List<BookDTOHome> books = service.findBookDTOsHomeByName("Ja");
        Assertions.assertEquals(books.size(), expect.size());
        for (int i = 0; i < books.size(); i++) {
            Assertions.assertEquals(books.get(i).getIsbn(), expect.get(i).getIsbn());
            Assertions.assertEquals(books.get(i).getName(), expect.get(i).getName());
            Assertions.assertEquals(books.get(i).getQuantity(), expect.get(i).getQuantity());
        }
    }
}
