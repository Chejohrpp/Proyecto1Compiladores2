/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.p1c2.Almacenamiento;

import com.mycompany.p1c2.objetos.DescSonido;
import com.mycompany.p1c2.objetos.ListaReproduccion;
import com.mycompany.p1c2.objetos.Sonido;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.sound.sampled.Clip;

/**
 *
 * @author sergi
 */
public class Almacenamiento {
    
    private String path; 
    
    
    public Almacenamiento(){
        path = getPath();
        verificarDatos();
    }
    
    private String getPath(){  
        //se crear una carpeta llamada Datos
        File file0 =  new File("Datos");
        boolean bol = file0.mkdir();
        if (bol) {
          //System.out.println("Directorio creado: " + file0.getAbsolutePath());
        }
        //se crea el archivo sonido.zt
        File file = new File("Datos/sonido.zt");
        if (!file.exists()) {
            try {
              file.createNewFile();
            } catch (IOException ex) {
                 System.out.println("error al crear el archivo sonido.zt: " + ex.getMessage());
            }
        }
        return file.getAbsolutePath();
    }
    
    public Sonido getDatosMusica(){
        try{
            Object salida;
            try (ObjectInputStream flujoSalida = new ObjectInputStream(new FileInputStream(path))) {
                salida = flujoSalida.readObject();
            }
            return (Sonido) salida;            
        }catch(Exception e){
            return null;
        }        
    }
    
    public void setDatosMusica(Sonido sonido){
        try{
            try (ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(path))) {
                salida.writeObject(sonido);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    private void verificarDatos(){
        Sonido sonido = getDatosMusica();
        if (sonido == null) {
            sonido = new Sonido();
            try{
                generarMusica("resource/DARLING in the FRANXX Torikago.wav",sonido,"Torikago",0);
                generarMusica("resource/KISS OF DEATH DARLING in the FRANXX.wav",sonido,"Kiss Of Death",1);
                generarMusica("resource/One Last Kiss Hikaru Utada.wav",sonido,"One Last Kiss",2);        
                generarMusica("resource/Family Vacation.wav",sonido,"Family Vacation",3);
                generarListaReproduccion(sonido);
            }catch(Exception e){
                e.printStackTrace();
            }
            setDatosMusica(sonido);
        }       
    }
    
    private void generarMusica(String path,Sonido sonido,String name, int index) throws FileNotFoundException, IOException{
        File file = new File(path);
        InputStream is =new FileInputStream(file);
        byte[] data= is.readAllBytes();
        DescSonido descSonido = new DescSonido(index,name,data);
        sonido.getListaSonido().add(descSonido); // agregar a la lista        
    }
    
    private void generarListaReproduccion(Sonido sonido){
        ListaReproduccion anime = new ListaReproduccion("ANIME");
        anime.addMusica(sonido.getListaSonido().get(0));
        anime.addMusica(sonido.getListaSonido().get(1));
        anime.addMusica(sonido.getListaSonido().get(2));
        sonido.getListaReproducciones().add(anime);
        ListaReproduccion night = new ListaReproduccion("NIGHT");
        night.addMusica(sonido.getListaSonido().get(3));
        sonido.getListaReproducciones().add(night);
    }
    
}
