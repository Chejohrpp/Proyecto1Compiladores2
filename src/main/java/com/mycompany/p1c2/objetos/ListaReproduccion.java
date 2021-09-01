/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.p1c2.objetos;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author sergi
 */
public class ListaReproduccion implements Serializable {
    private String name;
    private ArrayList<DescSonido> contenido;
    
    public ListaReproduccion(String name){
        this.name = name;
        contenido = new ArrayList();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<DescSonido> getContenido() {
        return contenido;
    }

    public void setContenido(ArrayList<DescSonido> contenido) {
        this.contenido = contenido;
    }
    
    public void addMusica(DescSonido sonido){
        contenido.add(sonido);
    }
    
}
