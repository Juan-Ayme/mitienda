package com.maver.mitienda.infrastructure.crud;//(3.2)

import com.maver.mitienda.domain.dto.Book;
import com.maver.mitienda.domain.repository.BookRepository;
import com.maver.mitienda.infrastructure.mapper.BookMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LibroRepository implements BookRepository
{
    private final LibroPosRepository libroPosRepository;
    private final BookMapper bookMapper;

    public LibroRepository(LibroPosRepository libroPosRepository, BookMapper bookMapper)
    {
        this.libroPosRepository = libroPosRepository;
        this.bookMapper = bookMapper;
    }

    @Override
    public List<Book> getAll()
    {
        return bookMapper.toBooks(libroPosRepository.findAll());
    }
}
