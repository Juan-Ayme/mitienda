package com.maver.mitienda.infrastructure.mapper;//(2.2)

import com.maver.mitienda.domain.dto.Book;
import com.maver.mitienda.infrastructure.entity.Libro;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public interface BookMapper
{
    //mappeo de libro a book
    @Mappings(
            {
                    @Mapping(source = "idLibro", target = "idBook"),
                    @Mapping(source = "titulo", target = "title"),
                    @Mapping(source = "rutaPortada", target = "coverRoute"),
                    @Mapping(source = "rutaArchivo", target = "fileRoute"),
                    @Mapping(source = "precio", target = "price"),
                    @Mapping(source ="descripcion", target = "description")
            }
    )
    Book toBook(Libro libro);
    List<Book> toBooks(List<Libro> libros);

    //mappeo de book a libro
    @InheritInverseConfiguration
    @Mappings(
            {
                    @Mapping(target = "fechaCreacion", ignore = true),
                    @Mapping(target = "fechaActualizacion", ignore = true)
            }
    )
    Libro toLibro(Book book);
}
