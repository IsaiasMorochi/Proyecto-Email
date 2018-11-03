/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Software;

import Software.Template.MailContenido;
import Software.Template.MailCronograma;
import Software.Template.MailDetalle_Contenido;
import Software.Template.MailDetalle_Venta;
import Software.Template.MailDia;
import Software.Template.MailDisertante;
import Software.Template.MailEvento;
import Software.Template.MailHorario;
import Software.Template.MailLugar;
import Software.Template.MailModoPago;
import Software.Template.MailObjetivos;
import Software.Template.MailPersona;
import Software.Template.MailReportes;
import Software.Template.MailRequisito;
import Software.Template.MailReserva;
import Software.Template.MailVenta;
import nucleo.procesador.Anacom;
import nucleo.procesador.Checker;
import nucleo.procesador.Cinta;
import nucleo.procesador.Token;
import nucleo.protocolos.ClienteSMTP;
import nucleo.utilidades.Ayuda;

public class software {
	
    MailPersona mail_persona = new MailPersona();
    MailLugar mail_lugar = new MailLugar(); 
    MailDia mail_dia = new MailDia();
    MailEvento mail_evento = new MailEvento();
    MailReserva mail_reserva = new MailReserva();
    MailCronograma mail_cronograma = new MailCronograma();
    MailDisertante mail_disertante = new MailDisertante();
    MailContenido mail_contenido = new MailContenido();
    MailDetalle_Contenido mail_detallecontenido = new MailDetalle_Contenido();
    MailObjetivos mail_objetivos = new MailObjetivos();
    MailHorario mail_horario = new MailHorario();
    MailVenta mail_venta = new MailVenta();
    MailDetalle_Venta mail_detalleVenta = new MailDetalle_Venta();
    MailModoPago mail_modoPago = new MailModoPago();
    MailRequisito mail_requisito = new MailRequisito();
    MailReportes mail_reporte = new MailReportes();
   

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

//      Si todo va bien, procesar el Comando
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
                mail_persona.create(anacom, destinatario, Ayuda.HELP_GLOBAL);
                break;   
            case Token.MODIFICARUSUARIO:
                mail_persona.edit(anacom, destinatario, Ayuda.HELP_GLOBAL);
                break;   
            case Token.ELIMINARUSUARIO:
                mail_persona.remove(anacom, destinatario, Ayuda.HELP_GLOBAL);
                break;   
            case Token.LISTARUSUARIOS:
                mail_persona.findAll(anacom, destinatario, Ayuda.HELP_GLOBAL);
                break;
                
            case Token.INSERTARDIA:
            	mail_dia.create(anacom, destinatario, Ayuda.HELP_GLOBAL);              
                break;  
                
            case Token.INSERTAREVENTO:
            	mail_evento.create(anacom, destinatario, Ayuda.HELP_GLOBAL);              
                break;
            case Token.MODIFICAREVENTO:  
            	mail_evento.edit(anacom, destinatario, Ayuda.HELP_GLOBAL);          
                break;
            case Token.ELIMINAREVENTO:  
            	mail_evento.remove(anacom, destinatario, Ayuda.HELP_GLOBAL);          
                break;
            case Token.LISTAREVENTOS:  
            	mail_evento.findAll(anacom, destinatario, Ayuda.HELP_GLOBAL);          
                break;     
                
            case Token.INSERTARCONTENIDO:
                mail_contenido.create(anacom, destinatario, Ayuda.HELP_GLOBAL);
                break;
            case Token.MODIFICARCONTENIDO:
                mail_contenido.edit(anacom, destinatario, Ayuda.HELP_GLOBAL);
                break;
            case Token.ELIMINARCONTENIDO:
                mail_contenido.remove(anacom, destinatario, Ayuda.HELP_GLOBAL);
                break;
            case Token.LISTARCONTENIDO:
                mail_contenido.findAll(anacom, destinatario, Ayuda.HELP_GLOBAL);
                break;
                
            case Token.INSERTARDETALLECONTENIDO:
            	mail_detallecontenido.create(anacom, destinatario, Ayuda.HELP_GLOBAL);
                break;
            case Token.MODIFICARDETALLECONTENIDO:
            	mail_detallecontenido.edit(anacom, destinatario, Ayuda.HELP_GLOBAL);
                break;
            case Token.ELIMINARDETALLECONTENIDO:
            	mail_detallecontenido.remove(anacom, destinatario, Ayuda.HELP_GLOBAL);
                break;
            case Token.LISTARDETALLECONTENIDO:
            	mail_detallecontenido.findAll(anacom, destinatario, Ayuda.HELP_GLOBAL);
                break;  
                
            case Token.INSERTARDISERTANTE:
                mail_disertante.create(anacom, destinatario, Ayuda.HELP_GLOBAL);
                break;
            case Token.MODIFICARDISERTANTE:
                mail_disertante.edit(anacom, destinatario, Ayuda.HELP_GLOBAL);
                break;
            case Token.ELIMINARDISERTANTE:
                mail_disertante.remove(anacom, destinatario, Ayuda.HELP_GLOBAL);
                break;
            case Token.LISTARDISERTANTES:
                mail_disertante.findAll(anacom, destinatario, Ayuda.HELP_GLOBAL);
                break;  
                                               
            case Token.INSERTAROBJETIVO:
            	mail_objetivos.create(anacom, destinatario, Ayuda.HELP_GLOBAL);
                break;
            case Token.MODIFICAROBJETIVO:
            	mail_objetivos.edit(anacom, destinatario, Ayuda.HELP_GLOBAL);
                break;
            case Token.ELIMINAROBJETIVO:
            	mail_objetivos.remove(anacom, destinatario, Ayuda.HELP_GLOBAL);
                break;
            case Token.LISTAROBJETIVOS:
            	mail_objetivos.findAll(anacom, destinatario, Ayuda.HELP_GLOBAL);
                break;    
                
            case Token.INSERTARLUGAR:
            	mail_lugar.create(anacom, destinatario, Ayuda.HELP_GLOBAL);
                break;
            case Token.MODIFICARLUGAR:
            	mail_lugar.edit(anacom, destinatario, Ayuda.HELP_GLOBAL);              
                break;
            case Token.ELIMINARLUGAR:
            	mail_lugar.remove(anacom, destinatario, Ayuda.HELP_GLOBAL);              
                break;
            case Token.LISTARLUGARES:
            	mail_lugar.findAll(anacom, destinatario, Ayuda.HELP_GLOBAL);              
                break;   
                
            case Token.INSERTARRESERVA:
                mail_reserva.create(anacom, destinatario, Ayuda.HELP_GLOBAL);
                break;       
                
            case Token.INSERTARCRONOGRAMA:
                mail_cronograma.create(anacom, destinatario, Ayuda.HELP_GLOBAL);
                break;
            case Token.ELIMINARCRONOGRAMA:
            	mail_cronograma.remove(anacom, destinatario, Ayuda.HELP_GLOBAL);
                break;   
                
            case Token.INSERTARHORARIO:
            	mail_horario.create(anacom, destinatario, Ayuda.HELP_GLOBAL);
                break;
            case Token.MODIFICARHORARIO:
            	mail_horario.edit(anacom, destinatario, Ayuda.HELP_GLOBAL);
                break;
            case Token.ELIMINARHORARIO:
            	mail_horario.remove(anacom, destinatario, Ayuda.HELP_GLOBAL);
                break;
            case Token.LISTARHORARIOS:
            	mail_horario.findAll(anacom, destinatario, Ayuda.HELP_GLOBAL);
                break;         
                
            case Token.INSERTARVENTA:
                mail_venta.create(anacom, destinatario, Ayuda.HELP_GLOBAL);
                break;
                
            case Token.INSERTARDETALLEVENTA:
            	mail_detalleVenta.create(anacom, destinatario, Ayuda.HELP_GLOBAL);
            	break;
            case Token.MODIFICARDETALLEVENTA:
            	mail_detalleVenta.edit(anacom, destinatario, Ayuda.HELP_GLOBAL);
            	break;
            case Token.ELIMINARDETALLEVENTA:
             	mail_detalleVenta.remove(anacom, destinatario, Ayuda.HELP_GLOBAL);
                break;
            case Token.LISTARDETALLEVENTAS:
            	mail_detalleVenta.findAll(anacom, destinatario, Ayuda.HELP_GLOBAL);
            	break;  
            	
            case Token.INSERTARMODOPAGO:
            	mail_modoPago.create(anacom, destinatario, Ayuda.HELP_GLOBAL);
            	break;
            case Token.MODIFICARMODOPAGO:
            	mail_modoPago.edit(anacom, destinatario, Ayuda.HELP_GLOBAL);
                break;
            case Token.ELIMINARMODOPAGO:
            	mail_modoPago.remove(anacom, destinatario, Ayuda.HELP_GLOBAL);
                break;
            case Token.LISTARMODOPAGOS:
            	mail_modoPago.findAll(anacom, destinatario, Ayuda.HELP_GLOBAL);
                break;      
                
            case Token.INSERTARREQUISITO:
                mail_requisito.create(anacom, destinatario, Ayuda.HELP_GLOBAL);
                break;
            case Token.MODIFICARREQUISITO:
            	mail_requisito.edit(anacom, destinatario, Ayuda.HELP_GLOBAL);
                break;
            case Token.ELIMINARREQUISITO:
            	mail_requisito.remove(anacom, destinatario, Ayuda.HELP_GLOBAL);
                break;
            case Token.LISTARREQUISITOS:
            	mail_requisito.findAll(anacom, destinatario, Ayuda.HELP_GLOBAL);
                break; 
                
            case Token.REPORTE:
            	mail_reporte.findAll(anacom, destinatario, Ayuda.HELP_GLOBAL);
            	break;   
            default:
                break;
        }
    }

//    private boolean verificarPermisos(String destinatario, int token) {
//        boolean b = false;
//
//        int[] usuario = {
//            Token.INSERTARUSUARIO,
//            Token.MODIFICARUSUARIO,
//            Token.ELIMINARUSUARIO,
//            Token.LISTARUSUARIOS};
//        	       
        
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
        
//        if(token == Token.INSERTARUSUARIO){
//            return true;
//        }
        
//        DPersona u = nu.obtenerUsuarioPorCorreo(destinatario);
//        if(u == null){
//            ClienteSMTP.sendMail(destinatario, "Verificacion de permisos", "Usted no se encuentra registrado en el sistema");
//            return false;
//        }
//        int tipo = u.getTipo();
//        System.out.println("Usuario tipo:"+tipo);
//        switch (tipo) {
//            case 1:
//                b = buscarComando(usuario, token);
////                if (!b) {
////                    b = buscarComando(evento, token);
////                }
////                if (!b) {
////                    b = buscarComando(pedido, token);
////                }
////                if (!b) {
////                    b = buscarComando(proforma, token);
////                }
//                break;
//            case 2:
////                if (token == Token.AGREGARFOTOS) {
////                    b = true;
////                }
//                break;
//            case 3:
//                b = true;
//                break;
//        }
//        return b;
//    }

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
}
