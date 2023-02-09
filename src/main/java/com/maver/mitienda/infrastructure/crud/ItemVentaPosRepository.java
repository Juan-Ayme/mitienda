package com.maver.mitienda.infrastructure.crud;

import com.maver.mitienda.infrastructure.entity.ItemVenta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemVentaPosRepository extends JpaRepository<ItemVenta, Long>
{

}
