package com.maver.mitienda.domain.service;//(4.1)

import com.maver.mitienda.domain.dto.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookServiceInterface
{
    Page<Book> getAll(Pageable pageable);
    Book getById(Long idBook);
    Book save(Book book);
    Book update(Long idBook, Book book);
    void delete(Long idBook);
}
