/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 *
 * @author bryan
 */

 @Entity
 @Table(name="Productos")
public class Usuario {

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name="precio")
    private double precio;

    @Column(name = "existencia")
    private int existencia;

    @Column(name = "descripcion")
    private String descripcion;

    public Usuario(){}

    public Usuario(Long id, String nombre, Double precio, int existencia, String descripcion ){
        this.id=id;

        this.nombre=nombre;

        this.precio=precio;

        this.existencia=existencia;

        this.descripcion=descripcion;


    }

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id=id;
    }

    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre){
        this.nombre=nombre;

    }

    public Double getPrecio(){
        return precio;
    }
    
    public void setPrecio(Double precio){
        this.precio=precio;
    }

    public int getExistencia(){
        return existencia;
    }

    public void setExistencia(int existencia){
        this.existencia=existencia;

    }

    public String getDescripcion(){
        return descripcion;
    }

    public void setDescripcion(String descripcion){
        this.descripcion=descripcion;
    }

    
    @Override
    public String toString(){
        return "Usuario [id=" + id + ", nombre=" + nombre + ", precio= " +precio + ", exitencia= "+ existencia + ", descripcion= " + descripcion+" ]";

    }



    
}
