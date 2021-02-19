package com.gapsi.jav.rest.demo.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

import com.gapsi.jav.rest.demo.model.Producto;


@Repository
public interface IProductosRepository extends CrudRepository<Producto, String> {
    
    public abstract ArrayList<Producto> findByNombre(String nombre);
    
}
