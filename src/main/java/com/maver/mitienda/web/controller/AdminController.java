package com.maver.mitienda.web.controller;//(5)

import com.maver.mitienda.domain.dto.Book;
import com.maver.mitienda.domain.service.BookServiceInterface;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping
@RestController
public class AdminController
{
    private final BookServiceInterface bookServiceInterface;

    public AdminController(BookServiceInterface bookServiceInterface) {
        this.bookServiceInterface = bookServiceInterface;
    }

    @GetMapping("/listar")
    public List<Book> getAll()
    {
        return bookServiceInterface.getAll();
    }
}
