/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.p1c2.objetos;

import java.io.Serializable;

/**
 *
 * @author sergi
 */
public class DescSonido implements Serializable {
 
    private int index;
    private String name;
    private byte[] audio;

    public DescSonido(int index, String name, byte[] audio) {
        this.index = index;
        this.name = name;
        this.audio = audio;
    }

    public DescSonido() {
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getAudio() {
        return audio;
    }

    public void setAudio(byte[] audio) {
        this.audio = audio;
    }   
}
