/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nucleo.procesador;

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
        "LISTARUSUARIOS"
    ));

    private static final LinkedList<Token> tokens = new LinkedList<>(Arrays.asList(
        new Token(Token.HELP, -1, "HELP"),
        new Token(Token.TRUE, -1, "TRUE"),
        new Token(Token.FALSE, -1, "FALSE"),
        new Token(Token.FUNC, Token.INSERTARUSUARIO, "INSERTARUSUARIO"),
        new Token(Token.FUNC, Token.MODIFICARUSUARIO, "MODIFICARUSUARIO"),
        new Token(Token.FUNC, Token.ELIMINARUSUARIO, "ELIMINARUSUARIO"),
        new Token(Token.FUNC, Token.LISTARUSUARIOS, "LISTARUSUARIOS")
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
