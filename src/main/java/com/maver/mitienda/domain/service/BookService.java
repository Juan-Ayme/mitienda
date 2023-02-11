package com.maver.mitienda.domain.service;//(4.2)

import com.maver.mitienda.domain.dto.Book;
import com.maver.mitienda.domain.repository.BookRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public class BookService implements BookServiceInterface
{
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Page<Book> getAll(Pageable pageable)
    {
        return bookRepository.getAll(pageable);
    }

    @Override
    public Book getById(Long idBook) {
        return bookRepository.getById(idBook);
    }

    @Override
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book update(Long idBook, Book book)
    {
        return bookRepository.update(idBook, book);
    }

    @Override
    public void delete(Long idBook)
    {
        bookRepository.delete(idBook);
    }

}
