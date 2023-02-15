package com.maver.mitienda.web.controller;//(5)

import com.maver.mitienda.domain.dto.Book;
import com.maver.mitienda.domain.service.BookServiceInterface;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/admin")
@RestController
public class AdminController
{
    private final BookServiceInterface bookServiceInterface;

    public AdminController(BookServiceInterface bookServiceInterface) {
        this.bookServiceInterface = bookServiceInterface;
    }

    @GetMapping("/books")
    public ResponseEntity<Page<Book>> getAll(@PageableDefault(sort = "titulo",size = 5) Pageable pageable)
    {
        return ResponseEntity.ok(bookServiceInterface.getAll(pageable));
    }

    @GetMapping("/books/{idBook}")
    public ResponseEntity<Book> getById(@PathVariable("idBook") Long idBook)
    {
        return ResponseEntity.ok(bookServiceInterface.getById(idBook));
    }
    @PostMapping("/save")         //Validated para validar los datos en cascada
    public ResponseEntity<Book> save(@RequestBody @Validated Book book)
    {
        return new ResponseEntity<>(bookServiceInterface.save(book), HttpStatus.CREATED);
    }

    @PutMapping("/update/{idBook}")
    public ResponseEntity<Book> update(@PathVariable("idBook") Long idBook, @RequestBody Book book)
    {
        if (bookServiceInterface.update(idBook, book) != null)
        {
            return ResponseEntity.ok(bookServiceInterface.update(idBook, book));
        }
        else
        {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{idBook}")
    public ResponseEntity<Void> delete(@PathVariable("idBook") Long idBook)
    {
        bookServiceInterface.delete(idBook);
        return ResponseEntity.noContent().build();
    }
}
