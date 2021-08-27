/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.p1c2.ReglasGram;

/**
 *
 * @author sergi
 */
public class Token {
    
    private String nombreToken;
    private String lexema;
    private int linea;
    private int columna;
    private int resultado;

    public Token(String lexema, int linea, int columna) {
    	this.nombreToken = null;
        this.lexema = lexema;
        this.linea = linea;
        this.columna = columna;
    }
    public Token(String nombreToken,String lexema, int linea, int columna) {
    	this.nombreToken = nombreToken;
        this.lexema = lexema;
        this.linea = linea;
        this.columna = columna;
    }

    public String getNombreToken() {
        return nombreToken;
    }
    public void setNombreToken(String nombreToken) {
        this.nombreToken = nombreToken;
    }
    public String getLexema() {
        return lexema;
    }

    public int getLinea() {
        return linea;
    }

    public int getColumna() {
        return columna;
    }

    public void setLexema(String lexema) {
        this.lexema = lexema;
    }

    public int getResultado() {
        return resultado;
    }

    public void setResultado(int resultado) {
        this.resultado = resultado;
    }
    
}
