
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
        
        "INSERTARDIA",
        
        "INSERTAREVENTO",
        "MODIFICAREVENTO",
        "ELIMINAREVENTO",
        "LISTAREVENTOS",
               
        "INSERTARCONTENIDO",
        "MODIFICARCONTENIDO",
        "ELIMINARCONTENIDO",
        "LISTARCONTENIDO",
        
        "INSERTARDETALLECONTENIDO",
        "MODIFICARDETALLECONTENIDO",
        "ELIMINARDETALLECONTENIDO",
        "LISTARDETALLECONTENIDO",
               
        "INSERTARDISERTANTE",
        "MODIFICARDISERTANTE",
        "ELIMINARDISERTANTE",
        "LISTARDISERTANTES",
        
        "INSERTARCRONOGRAMA",
        "ELIMINARCRONOGRAMA",     
             
        "INSERTAROBJETIVO",
        "MODIFICAROBJETIVO",
        "ELIMINAROBJETIVO",
        "LISTAROBJETIVOS",     
        
        "INSERTARLUGAR",
        "MODIFICARLUGAR",
        "ELIMINARLUGAR",
        "LISTARLUGARES",
        
        "INSERTARRESERVA",    
   
        "INSERTARHORARIO",
        "MODIFICARHORARIO",
        "ELIMINARHORARIO",
        "LISTARHORARIOS",
        
        "INSERTARVENTA",
        
        "INSERTARDETALLEVENTA",
        "MODIFICARDETALLEVENTA",
        "ELIMINARDETALLEVENTA",
        "LISTARDETALLEVENTAS",
        
        "INSERTARMODOPAGO",
        "MODIFICARMODOPAGO",
        "ELIMINARMODOPAGO",
        "LISTARMODOPAGOS",
        
        "INSERTARREQUISITO",
        "MODIFICARREQUISITO",
        "ELIMINARREQUISITO",
        "LISTARREQUISITOS",
        
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
        
        new Token(Token.FUNC, Token.INSERTAREVENTO, "INSERTAREVENTO"),     
        new Token(Token.FUNC, Token.MODIFICAREVENTO, "MODIFICAREVENTO"),    
        new Token(Token.FUNC, Token.ELIMINAREVENTO, "ELIMINAREVENTO"),    
        new Token(Token.FUNC, Token.LISTAREVENTOS, "LISTAREVENTOS"),
               
        new Token(Token.FUNC, Token.INSERTARCONTENIDO , "INSERTARCONTENIDO"),
        new Token(Token.FUNC, Token.MODIFICARCONTENIDO, "MODIFICARCONTENIDO"),
        new Token(Token.FUNC, Token.ELIMINARCONTENIDO, "ELIMINARCONTENIDO"),
        new Token(Token.FUNC, Token.LISTARCONTENIDO, "LISTARCONTENIDO"),
        
        new Token(Token.FUNC, Token.INSERTARDETALLECONTENIDO, "INSERTARDETALLECONTENIDO"),
        new Token(Token.FUNC, Token.MODIFICARDETALLECONTENIDO, "MODIFICARDETALLECONTENIDO"),
        new Token(Token.FUNC, Token.ELIMINARDETALLECONTENIDO, "ELIMINARDETALLECONTENIDO"),
        new Token(Token.FUNC, Token.LISTARDETALLECONTENIDO, "LISTARDETALLECONTENIDO"),
        
        new Token(Token.FUNC, Token.INSERTARDISERTANTE, "INSERTARDISERTANTE"),
        new Token(Token.FUNC, Token.MODIFICARDISERTANTE, "MODIFICARDISERTANTE"),
        new Token(Token.FUNC, Token.ELIMINARDISERTANTE, "ELIMINARDISERTANTE"),
        new Token(Token.FUNC, Token.LISTARDISERTANTES, "LISTARDISERTANTES"),
        
        new Token(Token.FUNC, Token.INSERTAROBJETIVO, "INSERTAROBJETIVO"),
        new Token(Token.FUNC, Token.MODIFICAROBJETIVO, "MODIFICAROBJETIVO"),
        new Token(Token.FUNC, Token.ELIMINAROBJETIVO, "ELIMINAROBJETIVO"),
        new Token(Token.FUNC, Token.LISTAROBJETIVOS, "LISTAROBJETIVOS"),
             
        new Token(Token.FUNC, Token.INSERTARLUGAR, "INSERTARLUGAR"),
        new Token(Token.FUNC, Token.MODIFICARLUGAR, "MODIFICARLUGAR"),
        new Token(Token.FUNC, Token.ELIMINARLUGAR, "ELIMINARLUGAR"),
        new Token(Token.FUNC, Token.LISTARLUGARES, "LISTARLUGARES"),

        new Token(Token.FUNC, Token.INSERTARRESERVA, "INSERTARRESERVA"),

        new Token(Token.FUNC, Token.INSERTARCRONOGRAMA, "INSERTARCRONOGRAMA"),
        new Token(Token.FUNC, Token.ELIMINARCRONOGRAMA, "ELIMINARCRONOGRAMA"),
      
        new Token(Token.FUNC, Token.INSERTARHORARIO, "INSERTARHORARIO"),
        new Token(Token.FUNC, Token.MODIFICARHORARIO, "MODIFICARHORARIO"),
        new Token(Token.FUNC, Token.ELIMINARHORARIO, "ELIMINARHORARIO"),
        new Token(Token.FUNC, Token.LISTARHORARIOS, "LISTARHORARIOS"),
   
        new Token(Token.FUNC, Token.INSERTARVENTA, "INSERTARVENTA"),
        
        new Token(Token.FUNC, Token.INSERTARDETALLEVENTA, "INSERTARDETALLEVENTA"),
        new Token(Token.FUNC, Token.MODIFICARDETALLEVENTA, "MODIFICARDETALLEVENTA"),
        new Token(Token.FUNC, Token.ELIMINARDETALLEVENTA, "ELIMINARDETALLEVENTA"),
        new Token(Token.FUNC, Token.LISTARDETALLEVENTAS, "LISTARDETALLEVENTAS"),
        
        new Token(Token.FUNC, Token.INSERTARMODOPAGO, "INSERTARMODOPAGO"),
        new Token(Token.FUNC, Token.MODIFICARMODOPAGO, "MODIFICARMODOPAGO"),
        new Token(Token.FUNC, Token.ELIMINARMODOPAGO, "ELIMINARMODOPAGO"),
        new Token(Token.FUNC, Token.LISTARMODOPAGOS, "LISTARMODOPAGOS"),
        
        new Token(Token.FUNC, Token.INSERTARREQUISITO, "INSERTARREQUISITO"),
        new Token(Token.FUNC, Token.MODIFICARREQUISITO, "MODIFICARREQUISITO"),
        new Token(Token.FUNC, Token.ELIMINARREQUISITO, "ELIMINARREQUISITO"),
        new Token(Token.FUNC, Token.LISTARREQUISITOS, "LISTARREQUISITOS"),
        
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
