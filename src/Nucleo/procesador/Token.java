/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Nucleo.procesador;


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

    
    /**
     * Usuarios
     */
    public static final int INSERTARUSUARIO = 20;
    public static final int MODIFICARUSUARIO = 21;
    public static final int ELIMINARUSUARIO = 22;
    public static final int LISTARUSUARIOS = 23;
    
    /**
     * DDia
     */
    public static final int INSERTARDIA = 24;
    
    /**
     * EVENTO
     */
    public static final int INSERTAREVENTO = 25;
    public static final int MODIFICAREVENTO = 26;
    public static final int ELIMINAREVENTO = 27;
    public static final int LISTAREVENTOS = 28;
    
    /**
     * CONTENIDO
     */
    public static final int INSERTARCONTENIDO = 29;
    public static final int MODIFICARCONTENIDO = 30;
    public static final int ELIMINARCONTENIDO = 31;
    public static final int LISTARCONTENIDO = 32;
    
    /**
     * DETALLE CONTENIDO
     */
    public static final int INSERTARDETALLECONTENIDO = 33;
    public static final int MODIFICARDETALLECONTENIDO = 34;
    public static final int ELIMINARDETALLECONTENIDO = 35;
    public static final int LISTARDETALLECONTENIDO = 36;
    
    /**
     * DISERTANTE
     */
    public static final int INSERTARDISERTANTE = 37;
    public static final int MODIFICARDISERTANTE = 38;
    public static final int ELIMINARDISERTANTE = 39;
    public static final int LISTARDISERTANTES = 40;
    
    /**
     * CRONOGRAMA
     */
    public static final int INSERTARCRONOGRAMA = 41;
    public static final int ELIMINARCRONOGRAMA = 42;
        
    /**
     * OBJETIVOS
     */
    public static final int INSERTAROBJETIVO = 43;
    public static final int MODIFICAROBJETIVO = 44;
    public static final int ELIMINAROBJETIVO = 45;
    public static final int LISTAROBJETIVOS = 46;
            
    /**
     * LUGAR
     */
    public static final int INSERTARLUGAR = 47;
    public static final int MODIFICARLUGAR = 48;
    public static final int ELIMINARLUGAR = 49;
    public static final int LISTARLUGARES = 50;
    
    /**
     * RESERVA
     */
    public static final int INSERTARRESERVA = 51;
    
    /**
     * HORARIO
     */
    public static final int INSERTARHORARIO = 52;
    public static final int MODIFICARHORARIO = 53;
    public static final int ELIMINARHORARIO = 54;
    public static final int LISTARHORARIOS = 55;
    
//    
    /**
     * DVenta
     */
    public static final int INSERTARVENTA = 56;
    
    /**
     * Detalle DVenta
     */
    public static final int INSERTARDETALLEVENTA = 57;
    public static final int MODIFICARDETALLEVENTA = 58;
    public static final int ELIMINARDETALLEVENTA = 59;
    public static final int LISTARDETALLEVENTAS = 60;
    
    /**
     * Modo de DPago
     */
    public static final int INSERTARMODOPAGO = 61;
    public static final int MODIFICARMODOPAGO = 62;
    public static final int ELIMINARMODOPAGO = 63;
    public static final int LISTARMODOPAGOS = 64;
    
    /**
     * Requisitos
     */
    public static final int INSERTARREQUISITO = 65;
    public static final int MODIFICARREQUISITO = 66;
    public static final int ELIMINARREQUISITO = 67;
    public static final int LISTARREQUISITOS = 68;
    
    public static final int REPORTE = 69;
    
  
  
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
