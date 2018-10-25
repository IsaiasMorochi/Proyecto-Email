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
        "LISTARUSUARIOS",
        
        "INSERTARLUGAR",
        "MODIFICARLUGAR",
        "ELIMINARLUGAR",
        "LISTARLUGARES",
        
        "INSERTARDIA",
        
        "INSERTAREVENTO"
    ));

    private static final LinkedList<Token> tokens = new LinkedList<>(Arrays.asList(
        new Token(Token.HELP, -1, "HELP"),
        new Token(Token.TRUE, -1, "TRUE"),
        new Token(Token.FALSE, -1, "FALSE"),
        new Token(Token.FUNC, Token.INSERTARUSUARIO, "INSERTARUSUARIO"),
        new Token(Token.FUNC, Token.MODIFICARUSUARIO, "MODIFICARUSUARIO"),
        new Token(Token.FUNC, Token.ELIMINARUSUARIO, "ELIMINARUSUARIO"),
        new Token(Token.FUNC, Token.LISTARUSUARIOS, "LISTARUSUARIOS"),
        
        new Token(Token.FUNC, Token.INSERTARLUGAR, "INSERTARLUGAR"),
        new Token(Token.FUNC, Token.MODIFICARLUGAR, "MODIFICARLUGAR"),
        new Token(Token.FUNC, Token.ELIMINARLUGAR, "ELIMINARLUGAR"),
        new Token(Token.FUNC, Token.LISTARLUGARES, "LISTARLUGARES"),
        
        new Token(Token.FUNC, Token.INSERTARDIA, "INSERTARDIA"),
        
        new Token(Token.FUNC, Token.INSERTAREVENTO, "INSERTAREVENTO"),     
        new Token(Token.FUNC, Token.MODIFICAREVENTO, "MODIFICAREVENTO"),    
        new Token(Token.FUNC, Token.ELIMINAREVENTO, "ELIMINAREVENTO"),    
        new Token(Token.FUNC, Token.LISTAREVENTOS, "LISTAREVENTOS")    
        
        
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
