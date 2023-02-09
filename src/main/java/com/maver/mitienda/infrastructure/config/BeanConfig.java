package com.maver.mitienda.infrastructure.config;

import com.maver.mitienda.domain.repository.BookRepository;
import com.maver.mitienda.domain.service.BookService;
import com.maver.mitienda.domain.service.BookServiceInterface;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig
{

    @Bean
    public BookServiceInterface bookServiceInterface(BookRepository bookRepository)
    {
        return new BookService(bookRepository);
    }
}
