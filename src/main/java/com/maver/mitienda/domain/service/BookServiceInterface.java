package com.maver.mitienda.domain.service;//(4.1)

import com.maver.mitienda.domain.dto.Book;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookServiceInterface
{
    List<Book> getAll();
}
