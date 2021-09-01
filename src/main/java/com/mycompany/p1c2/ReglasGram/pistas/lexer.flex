 /*Codigo importado*/
package com.mycompany.p1c2.ReglasGram.pistas;
import com.mycompany.p1c2.ReglasGram.Token;
import java_cup.runtime.*;
import static com.mycompany.p1c2.ReglasGram.pistas.sym.*;
%%
/*configuracion*/
%class Lexer
%public
%unicode
%line
%column
%cup
decimal=([0]|[1-9][0-9]*)[\.][0-9][0-9]?[0-9]?[0-9]?[0-9]?[0-9]?
int = [0-9]+
char = [\']([^\'\#]|"#"[^\']|"#'")[\']
string_com_simples = [\']([^\'\#]|"#"[^\']|"#'")*[\']
string = [\"]([^\"\#]|"#"[^\"]|"#\"")*[\"]
id_variable = [a-zA-Z][a-zA-Z0-9\?\¿\.\@\_\#]*

lineTerminator = \r|\r\n
whiteSpace     = {lineTerminator} | [ \f]
comentarioLinea = ">>"[^\n]*
comentarioBloque = "<-"([^\-]|"-"[^\>])*"->"


pista = [pP]"ista"
extiende = [eE]"xtiende"
keep = [Kk]"eep"
var = [vV]"ar"
arreglo = [aA]"rreglo"

entero = [eE]"ntero"
boolean = [bB]"oolean"
doble = [dD]"oble"
caracter = [cC]"aracter"
cadena = [cC]"adena"

si = [sS]"i"
sino = [sS]"ino"
switch = [sS]"witch"
caso = [cC]"aso"
salir = [sS]"alir"
default = [dD]"efault"
para = [pP]"ara"
mientras = [mM]"ientras"
hacer = [hH]"acer"
continuar = [cC]"ontinuar"
retorna = [rR]"etorna"

reproducir = [rR]"eproducir"
esperar = [eE]"sperar"
ordenar = [oO]"rdenar"
sumarizar= [sS]"umarizar"
longitud = [lL]"ongitud"
mensaje = [mM]"ensaje"

principal = [pP]"rincipal"

%{
	private String quitarComilla(String str){
		str = str.substring(1, str.length()-1);
		return str;
	}	
%}

%eofval{
  return new java_cup.runtime.Symbol(sym.EOF);
%eofval}

%%

/* reglas gramaticales */

/*Palabras reservadas*/
<YYINITIAL> {pista}				{return new Symbol(PISTA,yyline+1,yycolumn+1, new Token(yytext(),yyline+1,yycolumn+1 )); }
<YYINITIAL> {extiende}		{return new Symbol(EXTIENDE,yyline+1,yycolumn+1, new Token(yytext(),yyline+1,yycolumn+1 )); }
<YYINITIAL> {keep}				{return new Symbol(KEEP,yyline+1,yycolumn+1, new Token(yytext(),yyline+1,yycolumn+1 )); }
<YYINITIAL> {var}					{return new Symbol(VAR,yyline+1,yycolumn+1, new Token(yytext(),yyline+1,yycolumn+1 )); }
<YYINITIAL> {arreglo}			{return new Symbol(ARREGLO,yyline+1,yycolumn+1, new Token(yytext(),yyline+1,yycolumn+1 )); }

<YYINITIAL> {si}					{return new Symbol(SI,yyline+1,yycolumn+1, new Token(yytext(),yyline+1,yycolumn+1 )); }
<YYINITIAL> {sino}				{return new Symbol(SINO,yyline+1,yycolumn+1, new Token(yytext(),yyline+1,yycolumn+1 )); }
<YYINITIAL> {switch}			{return new Symbol(SWITCH,yyline+1,yycolumn+1, new Token(yytext(),yyline+1,yycolumn+1 )); }
<YYINITIAL> {caso}				{return new Symbol(CASO,yyline+1,yycolumn+1, new Token(yytext(),yyline+1,yycolumn+1 )); }
<YYINITIAL> {salir}				{return new Symbol(SALIR,yyline+1,yycolumn+1, new Token(yytext(),yyline+1,yycolumn+1 )); }
<YYINITIAL> {default}			{return new Symbol(DEFAULT,yyline+1,yycolumn+1, new Token(yytext(),yyline+1,yycolumn+1 )); }
<YYINITIAL> {para}				{return new Symbol(PARA,yyline+1,yycolumn+1, new Token(yytext(),yyline+1,yycolumn+1 )); }
<YYINITIAL> {mientras}		{return new Symbol(MIENTRAS,yyline+1,yycolumn+1, new Token(yytext(),yyline+1,yycolumn+1 )); }
<YYINITIAL> {hacer}				{return new Symbol(HACER,yyline+1,yycolumn+1, new Token(yytext(),yyline+1,yycolumn+1 )); }
<YYINITIAL> {continuar}		{return new Symbol(CONTINUAR,yyline+1,yycolumn+1, new Token(yytext(),yyline+1,yycolumn+1 )); }
<YYINITIAL> {retorna}			{return new Symbol(RETORNA,yyline+1,yycolumn+1, new Token(yytext(),yyline+1,yycolumn+1 )); }


<YYINITIAL> {reproducir}	{return new Symbol(REPRODUCIR,yyline+1,yycolumn+1, new Token(yytext(),yyline+1,yycolumn+1 )); }
<YYINITIAL> {esperar}			{return new Symbol(ESPERAR,yyline+1,yycolumn+1, new Token(yytext(),yyline+1,yycolumn+1 )); }
<YYINITIAL> {ordenar}			{return new Symbol(ORDENAR,yyline+1,yycolumn+1, new Token(yytext(),yyline+1,yycolumn+1 )); }
<YYINITIAL> {sumarizar}		{return new Symbol(SUMARIZAR,yyline+1,yycolumn+1, new Token(yytext(),yyline+1,yycolumn+1 )); }
<YYINITIAL> {longitud}		{return new Symbol(LONGITUD,yyline+1,yycolumn+1, new Token(yytext(),yyline+1,yycolumn+1 )); }
<YYINITIAL> {mensaje}			{return new Symbol(MENSAJE,yyline+1,yycolumn+1, new Token(yytext(),yyline+1,yycolumn+1 )); }

<YYINITIAL> {principal}			{return new Symbol(PRINCIPAL,yyline+1,yycolumn+1, new Token(yytext(),yyline+1,yycolumn+1 )); }

/*Tipos de variables*/
<YYINITIAL> "true"			{return new Symbol(BOOLEAN,yyline+1,yycolumn+1, new Token(yytext(),yyline+1,yycolumn+1 )); }
<YYINITIAL> "false"			{return new Symbol(BOOLEAN,yyline+1,yycolumn+1, new Token(yytext(),yyline+1,yycolumn+1 )); }
<YYINITIAL> "verdadero"	{return new Symbol(BOOLEAN,yyline+1,yycolumn+1, new Token(yytext(),yyline+1,yycolumn+1 )); }
<YYINITIAL> "falso"			{return new Symbol(BOOLEAN,yyline+1,yycolumn+1, new Token(yytext(),yyline+1,yycolumn+1 )); }

/*Variables*/
<YYINITIAL> {entero}			{return new Symbol(ID_ENTERO,yyline+1,yycolumn+1, new Token(yytext(),yyline+1,yycolumn+1 )); }
<YYINITIAL> {boolean}			{return new Symbol(ID_BOOLEAN,yyline+1,yycolumn+1, new Token(yytext(),yyline+1,yycolumn+1 )); }
<YYINITIAL> {doble}				{return new Symbol(ID_DOBLE,yyline+1,yycolumn+1, new Token(yytext(),yyline+1,yycolumn+1 )); }
<YYINITIAL> {caracter}		{return new Symbol(ID_CARACTER,yyline+1,yycolumn+1, new Token(yytext(),yyline+1,yycolumn+1 )); }
<YYINITIAL> {cadena}			{return new Symbol(ID_CADENA,yyline+1,yycolumn+1, new Token(yytext(),yyline+1,yycolumn+1 )); }

<YYINITIAL>{
	/*cadenas*/
	{decimal}				{return new Symbol(DECIMAL,yyline+1,yycolumn+1, new Token(yytext(),yyline+1,yycolumn+1));}
	{int}						{return new Symbol(ENTERO,yyline+1,yycolumn+1, new Token(yytext(),yyline+1,yycolumn+1));}
	{char}				{return new Symbol(CHAR,yyline+1,yycolumn+1, new Token(quitarComilla(yytext()),yyline+1,yycolumn+1));}
	{string}				{return new Symbol(STRING,yyline+1,yycolumn+1, new Token(quitarComilla(yytext()),yyline+1,yycolumn+1));}
	{string_com_simples} {return new Symbol(STRING_SIMPLE,yyline+1,yycolumn+1, new Token(quitarComilla(yytext()),yyline+1,yycolumn+1));}
	{id_variable}		{return new Symbol(ID_VARIABLE,yyline+1,yycolumn+1, new Token(yytext(),yyline+1,yycolumn+1));}

	/*simbolos*/
 	"("									{return new Symbol(PAI,yyline+1,yycolumn+1, new Token(yytext(),yyline+1,yycolumn+1));}
	")"									{return new Symbol(PAD,yyline+1,yycolumn+1, new Token(yytext(),yyline+1,yycolumn+1));}
	"["									{return new Symbol(CORI,yyline+1,yycolumn+1, new Token(yytext(),yyline+1,yycolumn+1));}
	"]"									{return new Symbol(CORD,yyline+1,yycolumn+1, new Token(yytext(),yyline+1,yycolumn+1));}
	","									{return new Symbol(COMA,yyline+1,yycolumn+1, new Token(yytext(),yyline+1,yycolumn+1));}
	"="									{return new Symbol(IGUAL,yyline+1,yycolumn+1, new Token(yytext(),yyline+1,yycolumn+1));}
	";"									{return new Symbol(SEMI,yyline+1,yycolumn+1, new Token(yytext(),yyline+1,yycolumn+1));}

	"\n"								{return new Symbol(SALTO,yyline+1,yycolumn+1, new Token(yytext(),yyline+1,yycolumn+1));}
	"\t"								{return new Symbol(TAB,yyline+1,yycolumn+1, new Token(yytext(),yyline+1,yycolumn+1));}
	"=="								{return new Symbol(IGUALACION,yyline+1,yycolumn+1, new Token(yytext(),yyline+1,yycolumn+1));}
	"<="								{return new Symbol(MEN_QUE,yyline+1,yycolumn+1, new Token(yytext(),yyline+1,yycolumn+1));}
	"<"									{return new Symbol(MENQ,yyline+1,yycolumn+1, new Token(yytext(),yyline+1,yycolumn+1));}
	">"									{return new Symbol(MAYQ,yyline+1,yycolumn+1, new Token(yytext(),yyline+1,yycolumn+1));}
	">="								{return new Symbol(MAY_QUE,yyline+1,yycolumn+1, new Token(yytext(),yyline+1,yycolumn+1));}
	"!="								{return new Symbol(DIFERENTE,yyline+1,yycolumn+1, new Token(yytext(),yyline+1,yycolumn+1));}
	"!!"								{return new Symbol(NULO,yyline+1,yycolumn+1, new Token(yytext(),yyline+1,yycolumn+1));}

	"+="								{return new Symbol(MAS_IGUAL,yyline+1,yycolumn+1, new Token(yytext(),yyline+1,yycolumn+1));}
	"++"								{return new Symbol(INCREMENTO,yyline+1,yycolumn+1, new Token(yytext(),yyline+1,yycolumn+1));}
	"--"								{return new Symbol(DECREMENTO,yyline+1,yycolumn+1, new Token(yytext(),yyline+1,yycolumn+1));}

	"&&"									{return new Symbol(AND,yyline+1,yycolumn+1, new Token(yytext(),yyline+1,yycolumn+1));}
	"!&&"									{return new Symbol(NAND,yyline+1,yycolumn+1, new Token(yytext(),yyline+1,yycolumn+1));}
	"||"									{return new Symbol(OR,yyline+1,yycolumn+1, new Token(yytext(),yyline+1,yycolumn+1));}
	"!||"									{return new Symbol(NOR,yyline+1,yycolumn+1, new Token(yytext(),yyline+1,yycolumn+1));}
	"&|"									{return new Symbol(XOR,yyline+1,yycolumn+1, new Token(yytext(),yyline+1,yycolumn+1));}
	"!"									{return new Symbol(NOT,yyline+1,yycolumn+1, new Token(yytext(),yyline+1,yycolumn+1));}

	"*"									{return new Symbol(MULT,yyline+1,yycolumn+1, new Token(yytext(),yyline+1,yycolumn+1));}
	"+"									{return new Symbol(SUMA,yyline+1,yycolumn+1, new Token(yytext(),yyline+1,yycolumn+1));}
	"-"									{return new Symbol(MENOS,yyline+1,yycolumn+1, new Token(yytext(),yyline+1,yycolumn+1));}
	"/"									{return new Symbol(DIV,yyline+1,yycolumn+1, new Token(yytext(),yyline+1,yycolumn+1));}
	"%"									{return new Symbol(MODULO,yyline+1,yycolumn+1, new Token(yytext(),yyline+1,yycolumn+1));}
	"^"									{return new Symbol(POTENCIA,yyline+1,yycolumn+1, new Token(yytext(),yyline+1,yycolumn+1));}

	"{"								{return new Symbol(LLAI,yyline+1,yycolumn+1, new Token(yytext(),yyline+1,yycolumn+1));}
	"}"								{return new Symbol(LLAD,yyline+1,yycolumn+1, new Token(yytext(),yyline+1,yycolumn+1));}

	/* espacios en blanco */
	{whiteSpace}					{ /* ignorar */ }
	{comentarioLinea}					{ /* ignorar */ }
	{comentarioBloque}					{ /* ignorar */ }
}

/* error */
    [^]                              	{return new Symbol(INVALID,yyline+1,yycolumn+1, new Token(yytext(),yyline+1,yycolumn+1));}