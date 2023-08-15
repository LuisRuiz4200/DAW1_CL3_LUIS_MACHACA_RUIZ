package com.daw.producto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.daw.producto.model.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer>{

}
