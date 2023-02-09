package com.maver.mitienda.infrastructure.crud;

import com.maver.mitienda.infrastructure.entity.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VentaPosRepository extends JpaRepository<Venta, Long>
{
    //obtiene una venta por su id y por su estado
    Optional<Venta> findByIdVentaAndEstado(Long idVenta, Venta.Estado estado);
    //obtiene una venta por su id
    Optional<Venta> findByIdVenta(Long idVenta);
}
