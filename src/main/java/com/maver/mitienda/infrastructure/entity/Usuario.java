package com.maver.mitienda.infrastructure.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Table(name = "usuario")
@Entity
public class Usuario
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idusuario")
    private Long idUsuario;
    private String nombres;
    private String apellidos;
    @Column(name = "nombre_completo")
    private String nombreCompleto;
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private Rol rol;
    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion;
    @Column(name = "fecha_act")
    private LocalDateTime fechaActualizacion;
    public enum Rol
    {
        ADMIN,
        LECTOR
    }
}
