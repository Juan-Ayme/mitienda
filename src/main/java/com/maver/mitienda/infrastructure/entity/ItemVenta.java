package com.maver.mitienda.infrastructure.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "item_venta")
@Entity
public class ItemVenta
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "iditem_venta")
    private Long idItemVenta;
    private Float precio;
    @Column(name = "num_desc_disp")
    private Integer numeroDescargasDisponibles;
    @ManyToOne
    @JoinColumn(name="idlibro",referencedColumnName = "idlibro")
    private Libro libro;

    @ManyToOne
    @JoinColumn(name="idventa",referencedColumnName = "idventa")
    @JsonBackReference
    private Venta venta;

}
