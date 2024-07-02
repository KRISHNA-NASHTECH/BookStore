package com.example.BookStore.service;

import com.example.BookStore.model.BookStore;
import java.util.List;

public interface BookStoreService {
    List<BookStore> getAllBooks();
    BookStore getBookByName(String name);
    BookStore addBook(BookStore book);
    BookStore updateBook(String name, BookStore book);
    void deleteBook(String name);
}
