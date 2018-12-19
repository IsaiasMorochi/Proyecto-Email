
package Nucleo.procesador;

import java.util.Arrays;
import java.util.LinkedList;

public class LCC {

    private static final LinkedList<String> comandos = new LinkedList<>(Arrays.asList(
        "HELP",
        "TRUE",
        "FALSE",

        "INSERTARUSUARIO",
        "MODIFICARUSUARIO",
        "ELIMINARUSUARIO",
        "LISTARUSUARIOS",
        
        "INSERTARDIA",
        "MODIFICARDIA",
        "ELIMINARDIA",
        "LISTARDIA",

        "INSERTAROFERTA",
        "MODIFICAROFERTA",
        "ELIMINAROFERTA",
        "LISTAROFERTA",

        "INSERTARCRONOGRAMA",
        "MODIFICARCRONOGRAMA",
        "ELIMINARCRONOGRAMA",
        "LISTARCRONOGRAMA",

        "INSERTARDETALLECRONOGRAMA",
        "ELIMINARDETALLECRONOGRAMA",
        "LISTARDETALLECRONOGRAMA",

        "INSERTARDIRIGIDO",
        "MODIFICARDIRIGIDO",
        "ELIMINARDIRIGIDO",
        "LISTARDIRIGIDO",

        "INSERTAROBJETIVO",
        "MODIFICAROBJETIVO",
        "ELIMINAROBJETIVO",
        "LISTAROBJETIVO",

        "INSERTARMETODOLOGIA",
        "MODIFICARMETODOLOGIA",
        "ELIMINARMETODOLOGIA",
        "LISTARMETODOLOGIA",

        "INSERTARPERIODO",
        "MODIFICARPERIODO",
        "ELIMINARPERIODO",
        "LISTARPERIODO",

        "INSERTARHORARIO",
        "MODIFICARHORARIO",
        "ELIMINARHORARIO",
        "LISTARHORARIO",

        "INSERTARHORARIODIA",
        "ELIMINARHORARIODIA",
        "LISTARHORARIODIA",

        "INSERTARROL",
        "MODIFICARROL",
        "ELIMINARROL",
        "LISTARROL",

        "INSERTARGRUPO",
        "MODIFICARGRUPO",
        "ELIMINARGRUPO",
        "LISTARGRUPO",

        "INSERTARVENTA",
        "MODIFICARVENTA",
        "ELIMINARVENTA",
        "LISTARVENTA",

        "INSERTARDETALLEVENTA",
        "MODIFICARDETALLEVENTA",
        "ELIMINARDETALLEVENTA",
        "LISTARDETALLEVENTA",

        "INSERTARPAGO",
        "MODIFICARPAGO",
        "ELIMINARPAGO",
        "LISTARPAGO",

        "INSERTARBOLETA",
        "MODIFICARBOLETA",
        "ELIMINARBOLETA",
        "LISTARBOLETA",

        "REPORTE"

    ));

    private static final LinkedList<Token> tokens = new LinkedList<>(Arrays.asList(
        new Token(Token.HELP, -1, "HELP"),
        new Token(Token.TRUE, -1, "TRUE"),
        new Token(Token.FALSE, -1, "FALSE"),
        
        new Token(Token.FUNC, Token.INSERTARUSUARIO, "INSERTARUSUARIO"),
        new Token(Token.FUNC, Token.MODIFICARUSUARIO, "MODIFICARUSUARIO"),
        new Token(Token.FUNC, Token.ELIMINARUSUARIO, "ELIMINARUSUARIO"),
        new Token(Token.FUNC, Token.LISTARUSUARIOS, "LISTARUSUARIOS"),
        
        new Token(Token.FUNC, Token.INSERTARDIA, "INSERTARDIA"),
        new Token(Token.FUNC, Token.MODIFICARDIA, "MODIFICARDIA"),
        new Token(Token.FUNC, Token.ELIMINARDIA, "ELIMINARDIA"),
        new Token(Token.FUNC, Token.LISTARDIA, "LISTARDIA"),

        new Token(Token.FUNC, Token.INSERTAROFERTA, "INSERTAROFERTA"),
        new Token(Token.FUNC, Token.MODIFICAROFERTA, "MODIFICAROFERTA"),
        new Token(Token.FUNC, Token.ELIMINAROFERTA, "ELIMINAROFERTA"),
        new Token(Token.FUNC, Token.LISTAROFERTA, "LISTAROFERTA"),

        new Token(Token.FUNC, Token.INSERTARCRONOGRAMA , "INSERTARCRONOGRAMA"),
        new Token(Token.FUNC, Token.MODIFICARCRONOGRAMA, "MODIFICARCRONOGRAMA"),
        new Token(Token.FUNC, Token.ELIMINARCRONOGRAMA, "ELIMINARCRONOGRAMA"),
        new Token(Token.FUNC, Token.LISTARCRONOGRAMA, "LISTARCRONOGRAMA"),
        
        new Token(Token.FUNC, Token.INSERTARDETALLECRONOGRAMA, "INSERTARDETALLECRONOGRAMA"),
        new Token(Token.FUNC, Token.ELIMINARDETALLECRONOGRAMA, "ELIMINARDETALLECRONOGRAMA"),
        new Token(Token.FUNC, Token.LISTARDETALLECRONOGRAMA, "LISTARDETALLECRONOGRAMA"),

        new Token(Token.FUNC, Token.INSERTARDIRIGIDO, "INSERTARDIRIGIDO"),
        new Token(Token.FUNC, Token.MODIFICARDIRIGIDO, "MODIFICARDIRIGIDO"),
        new Token(Token.FUNC, Token.ELIMINARDIRIGIDO, "ELIMINARDIRIGIDO"),
        new Token(Token.FUNC, Token.LISTARDIRIGIDO, "LISTARDIRIGIDO"),

        new Token(Token.FUNC, Token.INSERTAROBJETIVO, "INSERTAROBJETIVO"),
        new Token(Token.FUNC, Token.MODIFICAROBJETIVO, "MODIFICAROBJETIVO"),
        new Token(Token.FUNC, Token.ELIMINAROBJETIVO, "ELIMINAROBJETIVO"),
        new Token(Token.FUNC, Token.LISTAROBJETIVO, "LISTAROBJETIVO"),

        new Token(Token.FUNC, Token.INSERTARMETODOLOGIA, "INSERTARMETODOLOGIA"),
        new Token(Token.FUNC, Token.MODIFICARMETODOLOGIA, "MODIFICARMETODOLOGIA"),
        new Token(Token.FUNC, Token.ELIMINARMETODOLOGIA, "ELIMINARMETODOLOGIA"),
        new Token(Token.FUNC, Token.LISTARMETODOLOGIA, "LISTARMETODOLOGIA"),
             
        new Token(Token.FUNC, Token.INSERTARPERIODO, "INSERTARPERIODO"),
        new Token(Token.FUNC, Token.MODIFICARPERIODO, "MODIFICARPERIODO"),
        new Token(Token.FUNC, Token.ELIMINARPERIODO, "ELIMINARPERIODO"),
        new Token(Token.FUNC, Token.LISTARPERIODO, "LISTARPERIODO"),

        new Token(Token.FUNC, Token.INSERTARHORARIO, "INSERTARHORARIO"),
        new Token(Token.FUNC, Token.MODIFICARHORARIO, "MODIFICARHORARIO"),
        new Token(Token.FUNC, Token.ELIMINARHORARIO, "ELIMINARHORARIO"),
        new Token(Token.FUNC, Token.LISTARHORARIO, "LISTARHORARIO"),

        new Token(Token.FUNC, Token.INSERTARHORARIODIA, "INSERTARHORARIODIA"),
        new Token(Token.FUNC, Token.ELIMINARHORARIODIA, "ELIMINARHORARIODIA"),
        new Token(Token.FUNC, Token.LISTARHORARIODIA, "LISTARHORARIODIA"),

        new Token(Token.FUNC, Token.INSERTARROL, "INSERTARROL"),
        new Token(Token.FUNC, Token.MODIFICARROL, "MODIFICARROL"),
        new Token(Token.FUNC, Token.ELIMINARROL, "ELIMINARROL"),
        new Token(Token.FUNC, Token.LISTARROL, "LISTARROL"),

        new Token(Token.FUNC, Token.INSERTARGRUPO, "INSERTARGRUPO"),
        new Token(Token.FUNC, Token.MODIFICARGRUPO, "MODIFICARGRUPO"),
        new Token(Token.FUNC, Token.ELIMINARGRUPO, "ELIMINARGRUPO"),
        new Token(Token.FUNC, Token.LISTARGRUPO, "LISTARGRUPO"),

        new Token(Token.FUNC, Token.INSERTARVENTA, "INSERTARVENTA"),
        new Token(Token.FUNC, Token.MODIFICARVENTA, "MODIFICARVENTA"),
        new Token(Token.FUNC, Token.ELIMINARVENTA, "ELIMINARVENTA"),
        new Token(Token.FUNC, Token.LISTARVENTA, "LISTARVENTA"),

        new Token(Token.FUNC, Token.INSERTARDETALLEVENTA, "INSERTARDETALLEVENTA"),
        new Token(Token.FUNC, Token.MODIFICARDETALLEVENTA, "MODIFICARDETALLEVENTA"),
        new Token(Token.FUNC, Token.ELIMINARDETALLEVENTA, "ELIMINARDETALLEVENTA"),
        new Token(Token.FUNC, Token.ELIMINARDETALLEVENTA, "ELIMINARDETALLEVENTA"),
        new Token(Token.FUNC, Token.LISTARDETALLEVENTA, "LISTARDETALLEVENTA"),

        new Token(Token.FUNC, Token.INSERTARPAGO, "INSERTARPAGO"),
        new Token(Token.FUNC, Token.MODIFICARPAGO, "MODIFICARPAGO"),
        new Token(Token.FUNC, Token.ELIMINARPAGO, "ELIMINARPAGO"),
        new Token(Token.FUNC, Token.LISTARPAGO, "LISTARPAGO"),

        new Token(Token.FUNC, Token.INSERTARBOLETA, "INSERTARBOLETA"),
        new Token(Token.FUNC, Token.MODIFICARBOLETA, "MODIFICARBOLETA"),
        new Token(Token.FUNC, Token.ELIMINARBOLETA, "ELIMINARBOLETA"),
        new Token(Token.FUNC, Token.LISTARBOLETA, "LISTARBOLETA"),

        new Token(Token.FUNC, Token.REPORTE, "REPORTE")
       
    ));

    public static Token estaEnLCC(String lexema) {
        lexema = lexema.toUpperCase();
        for (int i = 0; i < comandos.size(); i++) {
            if (comandos.get(i).toUpperCase().equals(lexema)) {
                Token token = new Token();
                token.setNombre(tokens.get(i).getNombre());
                token.setAtributo(tokens.get(i).getAtributo());
                token.setToStr(tokens.get(i).getToStr());
                return token;
            }
        }
        return null;
    }
}
