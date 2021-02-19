package com.gapsi.jav.rest.demo.controllers;

import java.util.ArrayList;
import java.util.Optional;

import com.gapsi.jav.rest.demo.model.Producto;
import com.gapsi.jav.rest.demo.service.ProductosService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/producto")
public class ProductosController {

    @Autowired
    ProductosService productosService;

    @GetMapping()
    public ArrayList<Producto> getProductos(){
        return productosService.getProductos();
    }

    @PostMapping()
    public Producto saveProducto(@RequestBody Producto producto){
        return this.productosService.saveProducto(producto);
    }

    @GetMapping( path = "/{id}")
    public Optional<Producto> getProductoById(@PathVariable("id") String id) {
        return this.productosService.getById(id);
    }

    @GetMapping("/query")
    public ArrayList<Producto> getProductoByNombre(@RequestParam("nombre") String name){
        return this.productosService.getByName(name);
    }

    @DeleteMapping( path = "/{id}")
    public String deleteById(@PathVariable("id") String id){
        boolean ok = this.productosService.deleteProducto(id);
        if (ok){
            return "Se eliminó el usuario con id " + id;
        }else{
            return "No pudo eliminar el usuario con id" + id;
        }
    }
    
}
