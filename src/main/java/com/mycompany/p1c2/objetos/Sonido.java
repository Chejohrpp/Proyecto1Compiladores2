/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.p1c2.objetos;

import java.io.Serializable;
import java.util.ArrayList;
import javax.sound.sampled.AudioInputStream;

/**
 *
 * @author sergi
 */
public class Sonido implements Serializable {
    
    private ArrayList<DescSonido> listaSonido;
    private ArrayList<ListaReproduccion> listaReproducciones;

    public Sonido() {
        listaSonido = new ArrayList();
        listaReproducciones =  new ArrayList();
    }

    public ArrayList<DescSonido> getListaSonido() {
        return listaSonido;
    }

    public void setListaSonido(ArrayList<DescSonido> listaSonido) {
        this.listaSonido = listaSonido;
    }    

    public ArrayList<ListaReproduccion> getListaReproducciones() {
        return listaReproducciones;
    }

    public void setListaReproducciones(ArrayList<ListaReproduccion> listaReproducciones) {
        this.listaReproducciones = listaReproducciones;
    }
   
}
