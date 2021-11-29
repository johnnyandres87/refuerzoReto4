package com.unab.stok.repositories;

import java.util.List;

import com.unab.stok.models.Products;

import org.springframework.data.repository.CrudRepository;

public interface ProductsRepository extends CrudRepository<Products, Long> {

    List<Products> findByCategoria(String categoria);
    List<Products> findByNombre(String nombre);

    List<Products> findByDisponibilidad(String disponibilidad);

}

