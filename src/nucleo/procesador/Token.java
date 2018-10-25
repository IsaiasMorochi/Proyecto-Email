/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nucleo.procesador;


public class Token {

    public static final int NUM = 0; // Numero Valor
    public static final int STRING = 1; // String Constante
    public static final int FUNC = 2; // Alguna Funcion
    public static final int GB = 3; //Guion Bajo
    public static final int CA = 4; // Corchete Abierto
    public static final int CC = 5; // Corchete Cerrado
    public static final int COMA = 6; // Coma ,
    public static final int FIN = 7;
    public static final int ERROR = 8;
    public static final int TRUE = 9;
    public static final int FALSE = 10;
    public static final int HELP = 11;
    public static final int HELPGLOBAL = 12;

    public static final int INSERTARUSUARIO = 100;
    public static final int MODIFICARUSUARIO = 101;
    public static final int ELIMINARUSUARIO = 102;
    public static final int LISTARUSUARIOS = 103;
    
    
    public static final int INSERTARLUGAR = 200;
    public static final int MODIFICARLUGAR = 201;
    public static final int ELIMINARLUGAR = 202;
    public static final int LISTARLUGARES = 203;
    
    public static final int INSERTARDIA = 204;
    
    public static final int INSERTAREVENTO = 205;
    public static final int MODIFICAREVENTO = 206;
    public static final int ELIMINAREVENTO = 207;
    public static final int LISTAREVENTOS = 208;
    

  
    private int nombre;
    private int atributo;
    private String toStr;

    public Token() {
    }

    public Token(int nombre, int atributo, String toStr) {
        this.nombre = nombre;
        this.atributo = atributo;
        this.toStr = toStr;
    }

    public int getNombre() {
        return nombre;
    }

    public void setNombre(int nombre) {
        this.nombre = nombre;
    }

    public int getAtributo() {
        return atributo;
    }

    public void setAtributo(int atributo) {
        this.atributo = atributo;
    }

    public String getToStr() {
        return toStr;
    }

    public void setToStr(String toStr) {
        this.toStr = toStr;
    }

}
