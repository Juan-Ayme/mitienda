package com.maver.mitienda.domain.service;//(4.2)

import com.maver.mitienda.domain.dto.Book;
import com.maver.mitienda.domain.repository.BookRepository;

import java.util.List;


public class BookService implements BookServiceInterface
{
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> getAll()
    {
        return bookRepository.getAll();
    }
}
