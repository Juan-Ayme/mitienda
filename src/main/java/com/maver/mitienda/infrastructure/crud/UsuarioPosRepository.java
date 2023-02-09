package com.maver.mitienda.infrastructure.crud;

import com.maver.mitienda.infrastructure.entity.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioPosRepository extends JpaRepository<Usuario, Long>
{
    //obtiene un usuario por su email
    Optional<Usuario> findByEmail(String email);

    //obtiene si un usuario existe por su email
    Boolean existsByEmail(String email);
}
