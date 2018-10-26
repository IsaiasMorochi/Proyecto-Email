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



    
    public static final int INSERTARDIA = 204;
    
    
    /**
     * EVENTO
     */
    public static final int INSERTAREVENTO = 205;
    public static final int MODIFICAREVENTO = 206;
    public static final int ELIMINAREVENTO = 207;
    public static final int LISTAREVENTOS = 208;
    
    /**
     * CONTENIDO
     */
    public static final int INSERTARCONTENIDO = 209;
    public static final int MODIFICARCONTENIDO = 210;
    public static final int ELIMINARCONTENIDO = 211;
    public static final int LISTARCONTENIDO = 212;
    
    public static final int INSERTARDETALLECONTENIDO = 213;
    public static final int MODIFICARDETALLECONTENIDO = 214;
    public static final int ELIMINARDETALLECONTENIDO = 215;
    public static final int LISTARDETALLECONTENIDO = 216;
    
    /**
     * DISERTANTE
     */
    public static final int INSERTARDISERTANTE = 217;
    public static final int MODIFICARDISERTANTE = 218;
    public static final int ELIMINARDISERTANTE = 219;
    public static final int LISTARDISERTANTES = 220;
    
    /**
     * CRONOGRAMA
     */
    public static final int INSERTARCRONOGRAMA = 221;
    public static final int ELIMINARCRONOGRAMA = 222;
        
    /**
     * OBJETIVOS
     */
    public static final int INSERTAROBJETIVO = 223;
    public static final int MODIFICAROBJETIVO = 224;
    public static final int ELIMINAROBJETIVO = 225;  
    public static final int LISTAROBJETIVOS = 226;
            
    /**
     * LUGAR
     */
    public static final int INSERTARLUGAR = 227;
    public static final int MODIFICARLUGAR = 228;
    public static final int ELIMINARLUGAR = 229;
    public static final int LISTARLUGARES = 230;
    
    /**
     * RESERVA
     */
    public static final int INSERTARRESERVA = 231;
    
    /**
     * HORARIO
     */
    public static final int INSERTARHORARIO = 232;
    public static final int MODIFICARHORARIO = 233;
    public static final int ELIMINARHORARIO = 234;
    public static final int LISTARHORARIOS = 235;
    
  
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
