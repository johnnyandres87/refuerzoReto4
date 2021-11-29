package com.unab.stok.controllers;

import java.util.List;
import java.util.Optional;

import com.unab.stok.models.Products;
import com.unab.stok.services.ProductsServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*",methods = {RequestMethod.GET,RequestMethod.POST})
@RequestMapping("/products")
public class ProductsControler {

    @Autowired
    private ProductsServices productsServices;

    @GetMapping()
    public Iterable<Products> getAllProducts() {
        return productsServices.getAllProducts();
    }

    @PostMapping
    public Products saveProducts(@RequestBody Products products) {
        return productsServices.saveProducts(products);
    }

    @GetMapping(path = "/{id}")
    public Optional<Products> getProductsById(@PathVariable("id") Long id) {
        return productsServices.getProductsById(id);
    }

    @GetMapping(path = "/categoria/{categoria}")
    public List<Products> getProductsByCategoria(@PathVariable("categoria") String categoria) {
        return productsServices.getProductsByCategoria(categoria);
    }

    @GetMapping(path = "/nombre/{nombre}")
    public List<Products> getProductsByNombre(@PathVariable("nombre") String nombre) {
        return productsServices.getProductsByNombre(nombre);
    }


    @GetMapping(path = "/disponibilidad/{disponibilidad}")
    List<Products> getProductsByDisponibilidad(@PathVariable("disponibilidad") String disponibilidad) {
        return productsServices.getProductsByDisponibilidad(disponibilidad);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteProducts(@PathVariable("id") Long id) {
        if(productsServices.deleteProducts(id))
        {
            return "Se elimino el cliente con id" + id;
        }
        else {
            return "No existe cliente con id" + id;
        }
    }


    
}
