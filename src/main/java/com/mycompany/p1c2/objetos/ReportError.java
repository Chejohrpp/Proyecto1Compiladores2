/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.p1c2.objetos;

/**
 *
 * @author sergi
 */
public class ReportError {
    
    private String tipoError;
    private int linea;
    private int columna;
    private String descripcion;
    private String solucion;
    
    public ReportError(){
        
    }

    public ReportError(String tipoError, int linea, int columna, String descripcion, String solucion) {
        this.tipoError = tipoError;
        this.linea = linea;
        this.columna = columna;
        this.descripcion = descripcion;
        this.solucion = solucion;
    }

    public String getTipoError() {
        return tipoError;
    }

    public void setTipoError(String tipoError) {
        this.tipoError = tipoError;
    }

    public int getLinea() {
        return linea;
    }

    public void setLinea(int linea) {
        this.linea = linea;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getSolucion() {
        return solucion;
    }

    public void setSolucion(String solucion) {
        this.solucion = solucion;
    }

    @Override
    public String toString() {
        return "ReportError{" + "tipoError=" + tipoError + ", linea=" + linea + ", columna=" + columna + ", descripcion=" + descripcion + ", solucion=" + solucion + '}';
    }
    
    
}
