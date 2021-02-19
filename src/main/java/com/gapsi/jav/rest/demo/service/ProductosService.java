package com.gapsi.jav.rest.demo.service;

import java.util.ArrayList;
import java.util.Optional;

import com.gapsi.jav.rest.demo.model.Producto;
import com.gapsi.jav.rest.demo.repository.IProductosRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductosService {

    @Autowired
    IProductosRepository productosRepository;

    public ArrayList<Producto> getProductos(){
        return (ArrayList<Producto>) productosRepository.findAll();
    }

    public Producto saveProducto(Producto producto){
        return productosRepository.save(producto);
    }

    public Optional<Producto> getById(String id){
        return productosRepository.findById(id);
    }

    public ArrayList<Producto>  getByName(String name) {
        return productosRepository.findByNombre(name);
    }

    public boolean deleteProducto(String id) {
        try{
            productosRepository.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }
    
}
