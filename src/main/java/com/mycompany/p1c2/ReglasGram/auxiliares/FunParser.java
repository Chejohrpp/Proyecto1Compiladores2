/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.p1c2.ReglasGram.auxiliares;

/**
 *
 * @author sergi
 */
public class FunParser {
    
    public FunParser(){
        
    }
    public String nameTokenEsperado(String nameToken){
        switch (nameToken){
            case "SALTO" : return "Salto de linea";
            case "ID_ENTERO" : return "entero";
            case "ID_BOOLEAN" : return "boolean";
            case "ID_DOBLE" : return "doble";
            case "ID_CARACTER" : return "caracter";
            case "ID_CADENA" : return "cadena";
            case "ID_VARIABLE" : return "cadena alfanumerica";
            case "STRING" : return "cadena encerrada en comillas";
            case "STRING_SIMPLE" : return "cadena encerrada en comillas simples";
            case "TAB" : return "Tabulacion";
            case "NULO" : return "!!";
            case "MENQ" : return "<";
            case "CORI" : return "[";
            case "CORD" : return "]";
            case "IGUAL" : return "=";
            case "MAQ" : return ">";
            case "DIV" : return "/";
            case "LLAI" : return "{";
            case "LLAD" : return "}";
            case "COMA" : return ",";
            case "NOT" : return "!";
            case "SEMI" : return ";";
            case "SUMA" : return "+";
            case "MENOS" : return "-";
            case "MULT" : return "*";
            case "IGUALACION" : return "==";
            case "MEN_QUE" : return "<=";
            case "MAY_QUE" : return ">=";
            case "DIFERENTE" : return "!=";
            case "CHAR" : return "caracter";
            case "DECIMAL" : return "decimal";
            case "ENTERO" : return "numero entero";
            case "BOOLEAN" : return "true/verdadero o false/falso";
            case "INVALID" : return "caracter cualquiera";
            case "PAI" : return "(";
            case "PAD": return ")";
            case "POTENCIA" : return "^";
            case "MODULO" : return "%";
            case "XOR" : return "&|";
            case "NOR" : return "!||";
            case "OR" : return "||";
            case "NAND" : return "!&&";
            case "AND" : return "&&";
            case "MAS_IGUAL" : return "+=";
            case "INCREMENTO" : return "++";
            case "DECREMENTO" : return "--";
            default: return null;
	}
    }
    public String nameTokenNoEsperado(String nameToken){
        switch (nameToken){
            case "TAB" : return "Tabulacion";
            case "SALTO" : return "salto de linea";
            default: return null;            
        }
    }
}
