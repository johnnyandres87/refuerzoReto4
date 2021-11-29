package com.unab.stok.models;

import org.springframework.data.annotation.Id;

import lombok.Data;

@Data
public class Products {

    @Id
    Long id;
    String categoria;
    String nombre;
    String descripcion;
    String precio;
    String disponibilidad;
    int cantidad;

}
