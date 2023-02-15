package com.maver.mitienda.infrastructure.entity;//(1.1)

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Table(name = "libro")
@Entity
public class Libro
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idlibro")
    private Long idLibro;

    private String titulo;
    private String slug;
    private String descripcion;
    @Column(name = "ruta_portada")
    private String rutaPortada;
    @Column(name = "ruta_archivo")
    private String rutaArchivo;
    private Float precio;
    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion;
    @Column(name = "fecha_act")
    private LocalDateTime fechaActualizacion;
    @PrePersist
    private void prePersist()
    {
        fechaCreacion = LocalDateTime.now();
    }
    @PreUpdate
    private void preUpdate()
    {
        fechaActualizacion = LocalDateTime.now();
    }
}
