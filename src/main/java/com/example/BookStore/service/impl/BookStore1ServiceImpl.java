package com.example.BookStore.service.impl;

import com.example.BookStore.model.BookStore;
import com.example.BookStore.service.BookStoreService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Service
@Profile("store1")
public class BookStore1ServiceImpl implements BookStoreService {
    private static final Logger LOGGER = Logger.getLogger(BookStore1ServiceImpl.class.getName());
    private List<BookStore> books = new ArrayList<>();

    @Override
    public List<BookStore> getAllBooks() {
        LOGGER.info("Fetching all books from BookStore1");
        return books;
    }

    @Override
    public BookStore getBookByName(String name) {
        LOGGER.info("Fetching book by name from BookStore1: " + name);
        return books.stream()
                .filter(book -> book.getBookName().equals(name))
                .findFirst()
                .orElse(null);
    }

    @Override
    public BookStore addBook(BookStore book) {
        LOGGER.info("Adding book to BookStore1: " + book);
        books.add(book);
        return book;
    }

    @Override
    public BookStore updateBook(String name, BookStore book) {
        LOGGER.info("Updating book in BookStore1: " + name);
        BookStore existingBook = getBookByName(name);
        if (existingBook != null) {
            existingBook.setBookStore(book.getBookStore());
            existingBook.setAuthor(book.getAuthor());
            existingBook.setCost(book.getCost());
            existingBook.setLink(book.getLink());
        }
        return existingBook;
    }

    @Override
    public void deleteBook(String name) {
        LOGGER.info("Deleting book from BookStore1: " + name);
        books.removeIf(book -> book.getBookName().equals(name));
    }
}