/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Software;

import Email.*;
import Nucleo.procesador.Anacom;
import Nucleo.procesador.Checker;
import Nucleo.procesador.Cinta;
import Nucleo.procesador.Token;
import Nucleo.protocolos.ClienteSMTP;
import Nucleo.utilidades.Ayuda;

public class ProcesadorMensaje {

    private MailUsuario mail_usuario = new MailUsuario();
    private MailDia mail_dia = new MailDia();
    private MailOferta mail_oferta = new MailOferta();
    private MailCronograma mail_cronograma = new MailCronograma();
    private MailCronograma_Detalle mail_cronograma_detalle = new MailCronograma_Detalle();
    private MailDirigido mail_dirigido = new MailDirigido();
    private MailObjetivo mail_objetivo = new MailObjetivo();
    private MailMetodologia mail_metodologia = new MailMetodologia();
    private MailPeriodo mail_periodo = new MailPeriodo();
    private MailHorario mail_horario = new MailHorario();
    private MailHorario_Dia mail_horario_dia = new MailHorario_Dia();
    private MailRol mail_rol = new MailRol();
    private MailGrupo mail_grupo = new MailGrupo();
    private MailVenta mail_venta = new MailVenta();
    private MailVenta_Detalle mail_venta_detalle = new MailVenta_Detalle();
    private MailPago mail_pago = new MailPago();
    private MailBoleta mail_boleta = new MailBoleta();

    public ProcesadorMensaje() throws Exception {
    }

    public void processMessage(String content, String destinatario, String url, String tipo) {

        Cinta cinta = new Cinta(content);
        Anacom anacom = new Anacom(cinta);
        Checker checker = new Checker(anacom);

        // Verificar Orden
        checker.Expresion();
 
        if (checker.errorFlag) {
            // Enviar Correo de Error
            ClienteSMTP.sendMail(destinatario, "ERROR DE COMANDO",
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
//                mail_persona.create(anacom, destinatario, Ayuda.HELP_GLOBAL);
                break;
            case Token.MODIFICARUSUARIO:
//                mail_persona.create(anacom, destinatario, Ayuda.HELP_GLOBAL);
                break;
            case Token.ELIMINARUSUARIO:
//                mail_persona.create(anacom, destinatario, Ayuda.HELP_GLOBAL);
                break;
            case Token.LISTARUSUARIOS:
//                mail_persona.create(anacom, destinatario, Ayuda.HELP_GLOBAL);
                break;

            case Token.INSERTARDIA:
//                mail_persona.create(anacom, destinatario, Ayuda.HELP_GLOBAL);
                break;
            case Token.MODIFICARDIA:
//                mail_persona.create(anacom, destinatario, Ayuda.HELP_GLOBAL);
                break;
            case Token.ELIMINARDIA:
//                mail_persona.create(anacom, destinatario, Ayuda.HELP_GLOBAL);
                break;
            case Token.LISTARDIA:
//                mail_persona.create(anacom, destinatario, Ayuda.HELP_GLOBAL);
                break;

            case Token.INSERTAROFERTA:
//                mail_persona.create(anacom, destinatario, Ayuda.HELP_GLOBAL);
                break;
            case Token.MODIFICAROFERTA:
//                mail_persona.create(anacom, destinatario, Ayuda.HELP_GLOBAL);
                break;
            case Token.ELIMINAROFERTA:
//                mail_persona.create(anacom, destinatario, Ayuda.HELP_GLOBAL);
                break;
            case Token.LISTAROFERTA:
//                mail_persona.create(anacom, destinatario, Ayuda.HELP_GLOBAL);
                break;

            case Token.INSERTARCRONOGRAMA:
//                mail_persona.create(anacom, destinatario, Ayuda.HELP_GLOBAL);
                break;
            case Token.MODIFICARCRONOGRAMA:
//                mail_persona.create(anacom, destinatario, Ayuda.HELP_GLOBAL);
                break;
            case Token.ELIMINARCRONOGRAMA:
//                mail_persona.create(anacom, destinatario, Ayuda.HELP_GLOBAL);
                break;
            case Token.LISTARCRONOGRAMA:
//                mail_persona.create(anacom, destinatario, Ayuda.HELP_GLOBAL);
                break;

            case Token.INSERTARDETALLECRONOGRAMA:
//                mail_persona.create(anacom, destinatario, Ayuda.HELP_GLOBAL);
                break;
            case Token.ELIMINARDETALLECRONOGRAMA:
//                mail_persona.create(anacom, destinatario, Ayuda.HELP_GLOBAL);
                break;
            case Token.LISTARDETALLECRONOGRAMA:
//                mail_persona.create(anacom, destinatario, Ayuda.HELP_GLOBAL);
                break;

            case Token.INSERTARDIRIGIDO:
//                mail_persona.create(anacom, destinatario, Ayuda.HELP_GLOBAL);
                break;
            case Token.MODIFICARDIRIGIDO:
//                mail_persona.create(anacom, destinatario, Ayuda.HELP_GLOBAL);
                break;
            case Token.ELIMINARDIRIGIDO:
//                mail_persona.create(anacom, destinatario, Ayuda.HELP_GLOBAL);
                break;
            case Token.LISTARDIRIGIDO:
//                mail_persona.create(anacom, destinatario, Ayuda.HELP_GLOBAL);
                break;

            case Token.INSERTAROBJETIVO:
//                mail_persona.create(anacom, destinatario, Ayuda.HELP_GLOBAL);
                break;
            case Token.MODIFICAROBJETIVO:
//                mail_persona.create(anacom, destinatario, Ayuda.HELP_GLOBAL);
                break;
            case Token.ELIMINAROBJETIVO:
//                mail_persona.create(anacom, destinatario, Ayuda.HELP_GLOBAL);
                break;
            case Token.LISTAROBJETIVO:
//                mail_persona.create(anacom, destinatario, Ayuda.HELP_GLOBAL);
                break;

            case Token.INSERTARMETODOLOGIA:
//                mail_persona.create(anacom, destinatario, Ayuda.HELP_GLOBAL);
                break;
            case Token.MODIFICARMETODOLOGIA:
//                mail_persona.create(anacom, destinatario, Ayuda.HELP_GLOBAL);
                break;
            case Token.ELIMINARMETODOLOGIA:
//                mail_persona.create(anacom, destinatario, Ayuda.HELP_GLOBAL);
                break;
            case Token.LISTARMETODOLOGIA:
//                mail_persona.create(anacom, destinatario, Ayuda.HELP_GLOBAL);
                break;

            case Token.INSERTARPERIODO:
//                mail_persona.create(anacom, destinatario, Ayuda.HELP_GLOBAL);
                break;
            case Token.MODIFICARPERIODO:
//                mail_persona.create(anacom, destinatario, Ayuda.HELP_GLOBAL);
                break;
            case Token.ELIMINARPERIODO:
//                mail_persona.create(anacom, destinatario, Ayuda.HELP_GLOBAL);
                break;
            case Token.LISTARPERIODO:
//                mail_persona.create(anacom, destinatario, Ayuda.HELP_GLOBAL);
                break;

            case Token.INSERTARHORARIO:
//                mail_persona.create(anacom, destinatario, Ayuda.HELP_GLOBAL);
                break;
            case Token.MODIFICARHORARIO:
//                mail_persona.create(anacom, destinatario, Ayuda.HELP_GLOBAL);
                break;
            case Token.ELIMINARHORARIO:
//                mail_persona.create(anacom, destinatario, Ayuda.HELP_GLOBAL);
                break;
            case Token.LISTARHORARIO:
//                mail_persona.create(anacom, destinatario, Ayuda.HELP_GLOBAL);
                break;

            case Token.INSERTARHORARIODIA:
//                mail_persona.create(anacom, destinatario, Ayuda.HELP_GLOBAL);
                break;
            case Token.ELIMINARHORARIODIA:
//                mail_persona.create(anacom, destinatario, Ayuda.HELP_GLOBAL);
                break;
            case Token.LISTARHORARIODIA:
//                mail_persona.create(anacom, destinatario, Ayuda.HELP_GLOBAL);
                break;

            case Token.INSERTARROL:
//                mail_persona.create(anacom, destinatario, Ayuda.HELP_GLOBAL);
                break;
            case Token.MODIFICARROL:
//                mail_persona.create(anacom, destinatario, Ayuda.HELP_GLOBAL);
                break;
            case Token.ELIMINARROL:
//                mail_persona.create(anacom, destinatario, Ayuda.HELP_GLOBAL);
                break;
            case Token.LISTARROL:
//                mail_persona.create(anacom, destinatario, Ayuda.HELP_GLOBAL);
                break;

            case Token.INSERTARGRUPO:
//                mail_persona.create(anacom, destinatario, Ayuda.HELP_GLOBAL);
                break;
            case Token.MODIFICARGRUPO:
//                mail_persona.create(anacom, destinatario, Ayuda.HELP_GLOBAL);
                break;
            case Token.ELIMINARGRUPO:
//                mail_persona.create(anacom, destinatario, Ayuda.HELP_GLOBAL);
                break;
            case Token.LISTARGRUPO:
//                mail_persona.create(anacom, destinatario, Ayuda.HELP_GLOBAL);
                break;

            case Token.INSERTARVENTA:
//                mail_persona.create(anacom, destinatario, Ayuda.HELP_GLOBAL);
                break;
            case Token.MODIFICARVENTA:
//                mail_persona.create(anacom, destinatario, Ayuda.HELP_GLOBAL);
                break;
            case Token.ELIMINARVENTA:
//                mail_persona.create(anacom, destinatario, Ayuda.HELP_GLOBAL);
                break;
            case Token.LISTARVENTA:
//                mail_persona.create(anacom, destinatario, Ayuda.HELP_GLOBAL);
                break;

            case Token.INSERTARDETALLEVENTA:
//                mail_persona.create(anacom, destinatario, Ayuda.HELP_GLOBAL);
                break;
            case Token.MODIFICARDETALLEVENTA:
//                mail_persona.create(anacom, destinatario, Ayuda.HELP_GLOBAL);
                break;
            case Token.ELIMINARDETALLEVENTA:
//                mail_persona.create(anacom, destinatario, Ayuda.HELP_GLOBAL);
                break;
            case Token.LISTARDETALLEVENTA:
//                mail_persona.create(anacom, destinatario, Ayuda.HELP_GLOBAL);
                break;

            case Token.INSERTARPAGO:
//                mail_persona.create(anacom, destinatario, Ayuda.HELP_GLOBAL);
                break;
            case Token.MODIFICARPAGO:
//                mail_persona.create(anacom, destinatario, Ayuda.HELP_GLOBAL);
                break;
            case Token.ELIMINARPAGO:
//                mail_persona.create(anacom, destinatario, Ayuda.HELP_GLOBAL);
                break;
            case Token.LISTARPAGO:
//                mail_persona.create(anacom, destinatario, Ayuda.HELP_GLOBAL);
                break;

            case Token.INSERTARBOLETA:
//                mail_persona.create(anacom, destinatario, Ayuda.HELP_GLOBAL);
                break;
            case Token.MODIFICARBOLETA:
//                mail_persona.create(anacom, destinatario, Ayuda.HELP_GLOBAL);
                break;
            case Token.ELIMINARBOLETA:
//                mail_persona.create(anacom, destinatario, Ayuda.HELP_GLOBAL);
                break;
            case Token.LISTARBOLETA:
//                mail_persona.create(anacom, destinatario, Ayuda.HELP_GLOBAL);
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
//        System.out.println("DUsuario tipo:"+tipo);
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
