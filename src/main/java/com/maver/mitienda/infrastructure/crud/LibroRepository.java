package com.maver.mitienda.infrastructure.crud;//(3.2)

import com.maver.mitienda.domain.dto.Book;
import com.maver.mitienda.domain.repository.BookRepository;
import com.maver.mitienda.infrastructure.entity.Libro;
import com.maver.mitienda.infrastructure.mapper.BookMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

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
    public Page<Book> getAll(Pageable pageable)
    {
        return libroPosRepository.findAll(pageable).map(bookMapper::toBook);
    }

    @Override
    public Book getById(Long idBook)
    {
        return libroPosRepository.findById(idBook)
                .map(bookMapper::toBook)
                .orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public Book save(Book book)
    {
        Libro libro = libroPosRepository.save(bookMapper.toLibro(book));
        return bookMapper.toBook(libro);
    }

    @Override
    public Book update(Long idBook, Book book)
    {
        book.setIdBook(idBook);
        if(libroPosRepository.findById(idBook).isPresent())
        {
            Libro libroB = libroPosRepository.findById(idBook).orElseThrow(EntityNotFoundException::new);
            Libro libro = bookMapper.toLibro(book);
            libro.setFechaCreacion(libroB.getFechaCreacion());
            libroPosRepository.save(libro);
        }
        else
        {
            throw new EntityNotFoundException();
        }
        return null;
    }
    @Override
    public void delete(Long idBook)
    {
        if (!libroPosRepository.findById(idBook).isPresent())
        {
            throw new EntityNotFoundException();
        }else
        {
            libroPosRepository.deleteById(idBook);
        }
    }
}
