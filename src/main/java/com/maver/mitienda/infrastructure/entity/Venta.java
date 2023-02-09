package com.maver.mitienda.infrastructure.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Table(name = "venta")
@Entity
public class Venta
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idventa")
    private Long idVenta;
    private Float total;
    @Enumerated(EnumType.STRING)
    private Estado estado;
    private LocalDateTime fecha;

    @ManyToOne
    @JoinColumn(name = "idusuario",referencedColumnName = "idusuario")
    private Usuario usuario;

    @OneToMany(mappedBy = "venta",cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<ItemVenta> items;
    public enum Estado
    {
        CREADO,
        COMPLETADO
    }
}
