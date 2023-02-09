package com.maver.mitienda.infrastructure.crud;//(1.1)

import com.maver.mitienda.infrastructure.entity.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LibroPosRepository extends JpaRepository<Libro, Long>
{
    //consulta los ultimos 6 libros publicados en base a su fecha de creacion orden desendente
    List<Libro> findTop6ByOrderByFechaCreacionDesc();

    //obtiene un libro por su slug
    Optional<Libro> findBySlug(String slug);
}
