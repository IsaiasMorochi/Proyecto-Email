/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Nucleo.utilidades;

/**
 *
 * @author isaias
 *
 */
public class Ayuda {

    public static String separador = "------------------------------------------------------------\n\n";

    public static final String HELP_GLOBAL = "Bienvenido!!!\n\n"
            + "A continuacion se listaran los comandos disponibles para interactuar con el sistema\n"
            + "Ejemplo: COMANDO HELP\n"
            + separador

            + "Insertar un usuario:\n"
            + "Administrativo o Cliente => INSERTARUSUARIO[\"nombre\", \"telefono\", \"nacionalidad\", \"ci\", \"direccion\", \"tipo\", \"correo\", \"password\"]\n\n"

            + "Modificar los datos de un usuario:\n"
            + "Administrativo o Cliente =>  MODIFICARUSUARIO[id, id_persona,\"correo\",\"password\"]\n\n"

            + "Eliminar un usuario:\n"
            + "ELIMINARUSUARIO[id]\n\n"

            + "Listar todos los usuarios:\n"
            + "LISTARUSUARIOS\n\n"
            + separador

            + "Insertar un dia:\n"
            + "INSERTARDIA[\"Dia\"]\n\n"
            +separador

            + "Insertar un evento:\n"
            + "INSERTAREVENTO[\"Titulo\", \"fecha de inicio\", \"fecha fin\", \"costo\",\"tipo\"]\n\n"
            + "Modificar los datos de un evento:\n"
            + "MODIFICAREVENTO[id,\"Titulo\", \"fecha de inicio\", \"fecha fin\", \"costo\",\"tipo\"]\n\n"
            + "Eliminar un evento\n"
            + "ELIMINAREVENTO[id]\n\n"
            + "Listar todos los eventos:\n"
            + "LISTAREVENTOS\n\n"
            + separador

            +"Insertar un contenido:\n"
            +"INSERTARCONTENIDO[id_evento,\"Titulo\"]\n\n"
            +"Modificar los datos de contenido:\"MODIFICARCONTENIDO[id,id_evento,\"Titulo\"]\n\n"
            + "Eliminar un contenido:\n"
            +"ELIMINARCONTENIDO[id]\n\n"
            +"Listar los contenidos:\n"
            +"LISTARCONTENIDO\n\n"
            + separador

            +"Insertar detalle de contenido:\n"
                    +"INSERTARDETALLECONTENIDO[id_contenido,\"descripcion\"]\n\n"
                    +"Modificar dato de contenido:\n"
                    +"MODIFICARDETALLECONTENIDO[id,id_contenido,\"descripcion\"]\n\n"
                    +"Eliminar detalle de contenido:\n"
                    +"ELIMINARDETALLECONTENIDO[id]\n\n"
                    +"Listar los detalles de contenido:\n"
                    +"LISTARDETALLECONTENIDO\n\n"
                    + separador

            + "Insertar un Disertante:\n"
                    + "INSERTARDISERTANTE[id_evento,\"Nombre \",\"Descripcion\"]\n\n"
                    + "Modificar datos de un disertante:\n"
                    + "MODIFICARDISERTANTE[id,id_evento,\"Nombre \",\"Descripcion\"]\n\n"
                    + "Eliminar a un disertante:\n"
                    + "ELIMINARDISERTANTE[id]\n\n"
                    + "Listar todos los disertantes:\n"
                    + "LISTARDISERTANTES\n\n"
                    + separador

           + "Insertar un objetivo:\n"
                   + "INSERTAROBJETIVO[id_evento, \"Nombre\", \"Descripcion\"]\n\n"
                   + "Modificar un objetivo:\n"
                   + "MODIFICAROBJETIVO[id,id_evento, \"Nombre,\",\"Descripcion\"]\n\n"
                   + "Eliminar un objetivo:\n"
                   + "ELIMINAROBJETIVO[id]\n"
                   + "Listar todos los objetivos:\n"
                   + "LISTAROBJETIVOS\n\n"
                   + separador

           + " Insertar un lugar:\n"
                   + "INSERTARLUGAR[\"Descripcion\"]\n\n"
                   + "Modificar datos de lugar:\n"
                   + "MODIFICARLUGAR[id,\"Descripcion\"]\n\n"
                   + "Eliminar un lugar:\n"
                   + "ELIMINARLUGAR[id]\n\n"
                   + "Listar todos los lugares:\n"
                   + "LISTARLUGARES\n\n"
                   + separador

           + "Ingresar una reserva:\n"
                   + "INSERTARRESERVA[\"fecha\", id_persona, id_evento]\n\n"
                   + separador

           + "Ingresar un cronograma:\n"
                   + "INSERTARCRONOGRAMA[id_evento]\n\n"
                   + "Eliminar un cronograna:\n"
                   + "ELIMINARCRONOGRAMA[id]\n\n"
                   + separador

           + "Ingresar un horario:\n"
                   + "INSERTARHORARIO[\"inicio\", \"fin\"]\n\n"
                   + "Modificar un horario:\n"
                   + "MODIFICARHORARIO[id,\"inicio\", \"fin\"]\n\n"
                   + "Eliminar un horario:\n"
                   + "ELIMINARHORARIO[id]\n\n"
                   + "Listar todos los horarios:\n"
                   + "LISTARHORARIOS\n\n"
                   + separador

           + "Insertar una venta:\n"
                   + "INSERTARVENTA[\"fecha\"]\n\n"
                   + separador

           + "Ingresar detalle de venta:\n"
                   + "INSERTARDETALLEVENTA[id_venta, id_persona, id_usuario, id_evento, \"fecha de comprobante\", \"numero de comprobante\"]\n\n"
                   + "Modificar datos de detalle de venta:\n"
                   + "MODIFICARDETALLEVENTA[id,id_venta, id_persona, id_usuario, id_evento, \"fecha de comprobante\", \"numero de comprobante\"]\n\n"
            + "ELIMINARDETALLEVENTA[id]\n\n"
            + "Listar detalles de ventas:\n"
            + "LISTARDETALLEVENTAS\n\n"
            + separador

            + "Ingresar modo de pago:\n"
                    + "INSERTARMODOPAGO[id_evento, \"Descripcion\"]\n\n"
                    + "Modificar modo de pago:\n"
                    + "MODIFICARMODOPAGO[id, id_evento, \"Descripcion\"]\n\n"
                    + "Eliminar un modo de pago:\n"
                    + "ELIMINARMODOPAGO[id]\n\n"
                    + "Listar todos los modos de pagos:\n"
                    + "LISTARMODOPAGOS\n\n"
                    + separador

            + "Ingresar un requisito:\n"
                    + "INSERTARREQUISITO[id_evento,\"Descripcion\"]\n\n"
                    + "Modificar un requisito:\n"
                    + "MODIFICARREQUISITO[id, id_evento,\"Descripcion\"]\n\n"
                    + "Eliminar un requisito:\n"
                    + "ELIMINARREQUISITO[id]\n\n"
                    + "Lista todo los requisitos:\n"
                    + "LISTARREQUISITOS\n\n"
                    + separador

            + "Muestre los reportes:\n"
                    + "REPORTE\n\n"
                    + separador;

}
