/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.controllers;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.dto.Usuario;
import com.example.demo.services.UsuarioServicelmpl;

import java.util.Optional;

/**
 *
 * @author bryan
 */
@RequestMapping("/productos")
@RestController
public class UsuarioController {

    @Autowired
    public UsuarioServicelmpl usuarioServicelmpl;

    @GetMapping("/todos")
    public List<Usuario> GetAllProductos(){
        return usuarioServicelmpl.GetAllProductos();
    }

    @GetMapping("/{id}")
    public Usuario ObtenerProductosID(@PathVariable(name="id") Long id){
        Optional<Usuario> usuario = usuarioServicelmpl.ObtenerProductosID(id);
        if(usuario.isPresent()){
            return usuario.get();
        }else{
            throw new NoSuchElementException();
        }

    }

    @PostMapping("/create")
    public Optional<Usuario> InsertarProducto(@RequestBody Usuario usuario){
        Optional<Usuario> NuevoProductoSexo = usuarioServicelmpl.InsertarProducto(usuario);
        if(NuevoProductoSexo.isPresent()){
            return NuevoProductoSexo;
        }else{

            throw new NoSuchElementException();
        }




    }


    @PutMapping("/actualizar/{id}")
    public Usuario ActualizarProducto(@PathVariable(name = "id") Long id, @RequestBody Usuario usuario) {
        return usuarioServicelmpl.ActualizarProducto(id, usuario)
                .orElseThrow(() -> new RuntimeException("No se pudo actualizar el producto con ID: " + id));
    }
    


}
