package com.unab.stok.services;

import java.util.List;
import java.util.Optional;

import com.unab.stok.models.Products;
import com.unab.stok.repositories.ProductsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductsServices {

    @Autowired
    ProductsRepository productsRepository;

    public Iterable<Products> getAllProducts() {
        return productsRepository.findAll();
    }

    public Products saveProducts(Products products) {
        return productsRepository.save(products);
    }

    public Optional<Products> getProductsById(Long id) {
        return productsRepository.findById(id);
    }

    public List<Products> getProductsByCategoria(String categoria) {
        return productsRepository.findByCategoria(categoria);
    }

    public List<Products> getProductsByNombre(String nombre) {
        return productsRepository.findByNombre(nombre);
    }

    public List<Products> getProductsByDisponibilidad(String disponibilidad) {
        return productsRepository.findByDisponibilidad(disponibilidad);
    }

    public boolean deleteProducts(Long id) {
        if (productsRepository.findById(id).isPresent()) {
            productsRepository.deleteById(id);
            return true;
        } else
            return false;

    }
}
