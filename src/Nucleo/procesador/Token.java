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
     * Dia
     */
    public static final int INSERTARDIA = 24;
    public static final int MODIFICARDIA = 25;
    public static final int ELIMINARDIA = 26;
    public static final int LISTARDIA = 27;

    /**
     * OFERTA
     */
    public static final int INSERTAROFERTA = 28;
    public static final int MODIFICAROFERTA = 29;
    public static final int ELIMINAROFERTA = 30;
    public static final int LISTAROFERTA = 31;

    /**
     * CRONOGRAMA
     */
    public static final int INSERTARCRONOGRAMA = 32;
    public static final int MODIFICARCRONOGRAMA = 33;
    public static final int ELIMINARCRONOGRAMA = 34;
    public static final int LISTARCRONOGRAMA = 35;

    /**
     * DETALLE CRONOGRAMA
     */
    public static final int INSERTARDETALLECRONOGRAMA = 36;
    public static final int ELIMINARDETALLECRONOGRAMA = 37;
    public static final int LISTARDETALLECRONOGRAMA = 38;

    /**
     * DIRIGIDO
     */
    public static final int INSERTARDIRIGIDO = 39;
    public static final int MODIFICARDIRIGIDO = 40;
    public static final int ELIMINARDIRIGIDO = 41;
    public static final int LISTARDIRIGIDO = 42;


    /**
     * OBJETIVO
     */
    public static final int INSERTAROBJETIVO = 43;
    public static final int MODIFICAROBJETIVO = 44;
    public static final int ELIMINAROBJETIVO = 45;
    public static final int LISTAROBJETIVO = 46;

    /**
     * METODOLOGIA
     */
    public static final int INSERTARMETODOLOGIA = 47;
    public static final int MODIFICARMETODOLOGIA = 48;
    public static final int ELIMINARMETODOLOGIA = 49;
    public static final int LISTARMETODOLOGIA = 50;

    /**
     * PERIODO
     */
    public static final int INSERTARPERIODO = 51;
    public static final int MODIFICARPERIODO = 52;
    public static final int ELIMINARPERIODO = 53;
    public static final int LISTARPERIODO = 54;

    /**
     * HORARIO
     */
    public static final int INSERTARHORARIO = 55;
    public static final int MODIFICARHORARIO = 56;
    public static final int ELIMINARHORARIO = 57;
    public static final int LISTARHORARIO = 58;

    /**
     * HORARIO-DIA
     */
    public static final int INSERTARHORARIODIA = 59;
    public static final int ELIMINARHORARIODIA = 60;
    public static final int LISTARHORARIODIA = 61;

    /**
     * ROL
     */
    public static final int INSERTARROL = 62;
    public static final int MODIFICARROL = 63;
    public static final int ELIMINARROL = 64;
    public static final int LISTARROL = 65;

    /**
     * GRUPO
     */
    public static final int INSERTARGRUPO = 66;
    public static final int MODIFICARGRUPO = 67;
    public static final int ELIMINARGRUPO = 68;
    public static final int LISTARGRUPO = 69;

    /**
     * VENTA
     */
    public static final int INSERTARVENTA = 70;
    public static final int MODIFICARVENTA = 71;
    public static final int ELIMINARVENTA = 72;
    public static final int LISTARVENTA = 73;

    /**
     * DETALLE VENTA
     */
    public static final int INSERTARDETALLEVENTA = 74;
    public static final int MODIFICARDETALLEVENTA = 75;
    public static final int ELIMINARDETALLEVENTA = 76;
    public static final int LISTARDETALLEVENTA = 77;

    /**
     * PAGO
     */
    public static final int INSERTARPAGO = 78;
    public static final int MODIFICARPAGO = 79;
    public static final int ELIMINARPAGO = 80;
    public static final int LISTARPAGO = 81;

    /**
     * PAGO
     */
    public static final int INSERTARBOLETA = 82;
    public static final int MODIFICARBOLETA = 83;
    public static final int ELIMINARBOLETA = 84;
    public static final int LISTARBOLETA = 85;

    /**
     * DOCENTE OFERA
     */
    public static final int INSERTARDO = 86;
    public static final int ELIMINARDO = 87;
    public static final int LISTARDO = 88;

    /**
     * POSTGRADUANTE OFERTA
     */
    public static final int INSERTARPO = 89;
    public static final int ELIMINARPO = 90;
    public static final int LISTARPO = 91;

    /**
     * TIPO
     */
    public static final int INSERTARTIPO = 92;
    public static final int MODIFICARTIPO = 93;
    public static final int ELIMINARTIPO = 94;
    public static final int LISTARTIPO = 95;

    /**
     * REQUISITO
     */
    public static final int INSERTARREQUISITO = 96;
    public static final int MODIFICARREQUISITO = 97;
    public static final int ELIMINARREQUISITO = 98;
    public static final int LISTARREQUISITO = 99;

    /**
     * RESERVA
     */
    public static final int INSERTARRESERVA = 100;
    public static final int MODIFICARRESERVA = 101;
    public static final int ELIMINARRESERVA = 102;
    public static final int LISTARRESERVA = 103;

    /**
     * REPORTE
     */
    public static final int REPORTE = 104;
    

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
