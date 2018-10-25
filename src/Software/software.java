/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Software;

import Bussines.NLugar;
import Bussines.NPersona;
import Data.DPersona;
import Negocio.NProforma;
import Dato.DDetallePedido;
import Dato.DPedido;
import Dato.DUsuario;
import Negocio.NEstadistica;
import Negocio.NEvento;
import Negocio.NPedido;
import Negocio.NPromocion;
import Negocio.NServicio;
import Negocio.NUsuario;
import Negocio.NZona;
import Software.Template.MailDia;
import Software.Template.MailEvento;
import Software.Template.MailLugar;
import nucleo.procesador.Anacom;
import nucleo.procesador.Checker;
import nucleo.procesador.Cinta;
import nucleo.procesador.Token;
import nucleo.protocolos.ClienteSMTP;
import nucleo.utilidades.Ayuda;
import nucleo.utilidades.Herramientas;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class software {

    NUsuario nu = new NUsuario();
    
    MailLugar mail_lugar = new MailLugar(); 
    MailDia mail_dia = new MailDia();
    MailEvento mail_evento = new MailEvento();
   

    public void processMessage(String content, String destinatario, String url, String tipo) {

        Cinta cinta = new Cinta(content);
        Anacom anacom = new Anacom(cinta);
        Checker checker = new Checker(anacom);

        // Verificar Orden
        checker.Expresion();
 
        if (checker.errorFlag) {
            // Enviar Correo de Error
            ClienteSMTP.sendMail(destinatario, "Error de Comando",
                    "El comando introducido es incorrecto, trate consultando las ayudas con el comando HELP"
            );
            System.out.println("El comando introducido es incorrecto, trate consultando las ayudas con el comando HELP");
            //System.out.println(Ayuda.HELP_INSERTARMULTIMEDIA);
            return;
        }

//         Si todo va bien, procesar el Comando
        anacom.Init();
        Token token = anacom.Preanalisis();

        if (token.getNombre() == Token.HELP) {
            // Mostrar Ayudas
            ClienteSMTP.sendMail(destinatario, "Ayudas - Marketing\n el formato es COMANDO[\"texto\",numero,...]", Ayuda.HELP_GLOBAL);
            //System.out.println(Ayuda.HELP_GLOBAL);
            return;
        }

        switch (token.getAtributo()) {
            case Token.INSERTARUSUARIO:
                insertarUsuario(anacom, destinatario);
                break;
                
            case Token.INSERTARLUGAR:
            	mail_lugar.create(anacom, destinatario, Ayuda.HELP_LISTARUSUARIOS);
                break;
            case Token.MODIFICARLUGAR:
            	mail_lugar.edit(anacom, destinatario, Ayuda.HELP_AGREGARFOTOS);              
                break;
            case Token.ELIMINARLUGAR:
            	mail_lugar.remove(anacom, destinatario, Ayuda.HELP_AGREGARFOTOS);              
                break;
            case Token.LISTARLUGARES:
            	mail_lugar.findAll(anacom, destinatario, Ayuda.HELP_AGREGARFOTOS);              
                break;
            case Token.INSERTARDIA:
            	mail_dia.create(anacom, destinatario, Ayuda.HELP_AGREGARFOTOS);              
                break;
            case Token.INSERTAREVENTO:
            	mail_evento.create(anacom, destinatario, Ayuda.HELP_AGREGARFOTOS);              
                break;
            case Token.MODIFICAREVENTO:  
            	mail_evento.edit(anacom, destinatario, Ayuda.HELP_AGREGARFOTOS);          
                break;
            case Token.ELIMINAREVENTO:  
            	mail_evento.remove(anacom, destinatario, Ayuda.HELP_AGREGARFOTOS);          
                break;
            case Token.LISTAREVENTOS:  
            	mail_evento.findAll(anacom, destinatario, Ayuda.HELP_AGREGARFOTOS);          
                break;

            default:
                break;
        }
    }

    private boolean verificarPermisos(String destinatario, int token) {
        boolean b = false;

        int[] usuario = {
            Token.INSERTARUSUARIO,
            Token.MODIFICARUSUARIO,
            Token.ELIMINARUSUARIO,
            Token.LISTARUSUARIOS};
        	
        int[] lugar = {
        	Token.INSERTARLUGAR};
        
        
//        int[] evento = {
//            Token.INSERTAREVENTO,
//            Token.MODIFICAREVENTO,
//            Token.ELIMINAREVENTO,
//            Token.LISTAREVENTOS,
//            Token.AGREGARSERVICIOEVENTO,
//            Token.QUITARSERVICIOEVENTO,
//            Token.AGREGARFOTOS};
//        int[] zona = {
//            Token.INSERTARZONA,
//            Token.MODIFICARZONA,
//            Token.ELIMINARZONA,
//            Token.LISTARZONAS};
//        int[] promocion = {
//            Token.INSERTARPROMOCION,
//            Token.MODIFICARPROMOCION,
//            Token.ELIMINARPROMOCION,
//            Token.LISTARPROMOCIONES};
//        int[] servicio = {
//            Token.INSERTARSERVICIO,
//            Token.MODIFICARSERVICIO,
//            Token.ELIMINARSERVICIO,
//            Token.LISTARSERVICIOS,
//            Token.AGREGARPROMOCION,
//            Token.QUITARPROMOCION,
//            Token.VERPROMOCIONES};
//        int[] pedido = {
//            Token.INSERTARPEDIDO,
//            Token.MODIFICARPEDIDO,
//            Token.ELIMINARPEDIDO,
//            Token.LISTARPEDIDOS,
//            Token.AGREGAREVENTOPEDIDO,
//            Token.QUITAREVENTOPEDIDO};
//        int[] proforma = {
//            Token.INSERTARPROFORMA,
//            //Token.MODIFICARPROFORMA,
//            Token.ELIMINARPROFORMA,
//            Token.LISTARPROFORMAS,
//            Token.AGREGARSERVICIOPROFORMA,
//            Token.QUITARSERVICIOPROFORMA};
//        int[] reporte = {Token.MOSTRARESTADISTICA};
        
        if(token == Token.INSERTARUSUARIO){
            return true;
        }
        
        DUsuario u = nu.obtenerUsuarioPorCorreo(destinatario);
        if(u == null){
            ClienteSMTP.sendMail(destinatario, "Verificacion de permisos", "Usted no se encuentra registrado en el sistema");
            return false;
        }
        int tipo = u.getTipo();
        System.out.println("Usuario tipo:"+tipo);
        switch (tipo) {
            case 1:
                b = buscarComando(usuario, token);
//                if (!b) {
//                    b = buscarComando(evento, token);
//                }
//                if (!b) {
//                    b = buscarComando(pedido, token);
//                }
//                if (!b) {
//                    b = buscarComando(proforma, token);
//                }
                break;
            case 2:
//                if (token == Token.AGREGARFOTOS) {
//                    b = true;
//                }
                break;
            case 3:
                b = true;
                break;
        }
        return b;
    }

    private boolean buscarComando(int[] array, int valor) {
        boolean b = false;
        int i = 0;
        while (i < array.length && b == false) {
            if (valor == array[i]) {
                b = true;
            }
            i++;
        }
        return b;
    }

    private void insertarUsuario(Anacom anacom, String correoDest) {

        anacom.Avanzar();
        Token token = anacom.Preanalisis();
        if (token.getNombre() == Token.HELP) {
            ClienteSMTP.sendMail(correoDest, "Ayudas - Foto Studio OnLine", Ayuda.HELP_INSERTARUSUARIO);
            System.out.println(Ayuda.HELP_INSERTARUSUARIO);
            return;
        }
        anacom.Avanzar();
        String nombre = Herramientas.quitarComillas(anacom.Preanalisis().getToStr());
        anacom.Avanzar();
        anacom.Avanzar();
        String telefono = Herramientas.quitarComillas(anacom.Preanalisis().getToStr());
        anacom.Avanzar();
        anacom.Avanzar();
        String nacionalidad = Herramientas.quitarComillas(anacom.Preanalisis().getToStr());
        anacom.Avanzar();
        anacom.Avanzar();
        String direccion = Herramientas.quitarComillas(anacom.Preanalisis().getToStr());
        anacom.Avanzar();
        anacom.Avanzar();
        String correo = Herramientas.quitarComillas(anacom.Preanalisis().getToStr());
        anacom.Avanzar();
        anacom.Avanzar();
        String password = Herramientas.quitarComillas(anacom.Preanalisis().getToStr());
        anacom.Avanzar();
        anacom.Avanzar();
        String tipo = Herramientas.quitarComillas(anacom.Preanalisis().getToStr());
        NPersona nPersona = new NPersona();
        Boolean respuesta = false;
        switch (tipo) {
            case "A":
                respuesta = nPersona.registrar(nombre, telefono, nacionalidad, direccion, correo, password, tipo);
                break;
            case "B":
                respuesta = nPersona.registrar(nombre, telefono, nacionalidad, direccion, correo, password, tipo);
                break;
            case "C":
                respuesta = nPersona.registrar(nombre, telefono, nacionalidad, direccion, correo, password, tipo);
                break;
        }
        if(respuesta) {
            System.out.println("Se acaba de registrar un usuario exitosamentes");
            ClienteSMTP.sendMail(correoDest, "Registro de usuario", "correcto");
        }else{
            System.out.println("Error al registrar");
        }
        
    }
    
   
}
