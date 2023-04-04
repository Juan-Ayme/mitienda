package com.maver.mitienda.domain.repository;//(3.1)

import com.maver.mitienda.domain.dto.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface BookRepository
{
    Page<Book> getAll(Pageable pageable);
    Book getById(Long idBook);
    Book save(Book book);
    Book update(Long idBook, Book book);
    void delete(Long idBook);
}
