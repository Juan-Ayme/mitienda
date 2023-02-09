package com.maver.mitienda.domain.repository;//(3.1)

import com.maver.mitienda.domain.dto.Book;

import java.util.List;

public interface BookRepository
{
    List<Book> getAll();
}
