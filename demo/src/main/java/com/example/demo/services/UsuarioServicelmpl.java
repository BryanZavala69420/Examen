/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.UsuarioRepository;
import com.example.demo.dto.Usuario;


import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.slf4j.LoggerFactory;


/**
 *
 * @author bryan
 */
@Service
public class UsuarioServicelmpl  implements UsuarioService{

    @Autowired
    public UsuarioRepository usuarioRepository;
    
    org.slf4j.Logger logger = LoggerFactory.getLogger(UsuarioServicelmpl.class);
    


    @Override
    public List<Usuario> GetAllProductos() {
        List<Usuario> Usuario = usuarioRepository.findAll();
        return Usuario;


    }

    @Override
    public Optional<Usuario> ObtenerProductosID(Long id) {
    Optional<Usuario> searchUser=usuarioRepository.findById(id);
        if(searchUser.isPresent()){
            logger.error("Encontrado el producto");
            return searchUser;
            
        }else{
            logger.error("NO encontrado el producto");
            throw new NoSuchElementException("No se encontro nada, vayase");
        }
    



    }

    @Override
    public Optional<Usuario> InsertarProducto(Usuario Usuario) {
        Optional<Usuario> optUsuario = Optional.of(Usuario);
        if(optUsuario.isPresent()){
            Usuario NuevoProducto= new Usuario();
            
            NuevoProducto.setNombre(Usuario.getNombre());
            NuevoProducto.setPrecio(Usuario.getPrecio());
            NuevoProducto.setExistencia(Usuario.getExistencia());
            NuevoProducto.setDescripcion(Usuario.getDescripcion());
            usuarioRepository.save(NuevoProducto);
            logger.info("Se ha insertado el producto chingon");
            
            Optional<Usuario> SexoProducto = Optional .of(NuevoProducto);
            return SexoProducto;


        }else{

            logger.error("No ha habido un usuario, sorry");
            throw new UnsupportedOperationException(" La puta que me pario al haber escogido informatica");

        }
        
    }

    @Override
    public Optional<Usuario> ActualizarProducto(Long id, Usuario Usuario) {
        Optional<Usuario> optUsuario = usuarioRepository.findById(id);
        if(optUsuario.isPresent()){
            Usuario Actualizate = optUsuario.get();

            Actualizate.setNombre(Usuario.getNombre());
            Actualizate.setPrecio(Usuario.getPrecio());
            Actualizate.setExistencia(Usuario.getExistencia());
            Actualizate.setDescripcion(Usuario.getDescripcion());

            usuarioRepository.save(Actualizate);





            
        

            logger.error("Se actualizo el producto con el id:  "+id);

            return Optional.of(Actualizate);

        }else{

        }
        logger.error("No se actualizo nada");

        throw new UnsupportedOperationException("Nada, sexo");




    }

    @Override
    public void BorrarProducto(Long id) {
        
        Optional<Usuario> optUsuario = usuarioRepository.findById(id);
        if(optUsuario.isPresent()){
            Usuario ProductoEpico = optUsuario.get();

            usuarioRepository.deleteById(ProductoEpico.getId());

            logger.error("Se borro el producto a la chingada");



        }else{
            logger.error("Llamen a Dios por favor");
        }






        
    }


    
}
