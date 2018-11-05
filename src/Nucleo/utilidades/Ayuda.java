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
            + "Administrativo o Cliente => INSERTARUSUARIO[id_persona,\"correo\",\"password\")]\n\n"

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







    public static final String HELP_INSERTARUSUARIO = "Insertar nuevo usuario\n\n"
            + "Este comando permite poder registrar a un nuevo usuario al sistema.\n"
            + "Parametros:\n"
            + "- CI (Introducir un numero)\n"
            + "- Nombre (String entre comillas dobles)\n"
            + "- Telefono (Introducir un numero)\n"
            + "- Correo (String entre comillas dobless)\n"
            + "- Contraseña (String entre comillas dobles)\n"
            + "- Sexo (F para femenino o M para masculino)\n"
            + "- Tipo (1 para clientes, 2 para fotografo, 3 para personal)\n"
            + "- idServicio (Solo para usuarios fotografos, id del servicio, se puede usar el comando LISTARSERVICIOS para obtener los id de los servicios del sistema)\n"
            + "- Direccion (Solo para usuarios fotografos, direccion del fotografo, debe ir entre comillas dobles)\n"
            + "Cliente o personal => INSERTARUSUARIO[CI, \"Nombre\", Telefono, \"Correo\", \"Contraseña\", Sexo]\n"
            + "Fotografo => INSERTARUSUARIO[CI, \"Nombre\", Telefono, \"Correo\", \"Contraseña\", Sexo, idServicio, \"Direccion\"]\n";

    public static final String HELP_MODIFICARUSUARIO = "Modificar los datos de un usuario\n\n"
            + "Este comando permite poder modificar los datos de un usuario del sistema.\n"
            + "Parametros:\n"
            + "- IdUsuario (Introducir el ID de uno de los usuarios del sistema)\n"
            + "- idUsuario (id del usuario a modificar, se puede usar el comando LISTARUSUARIOS para obtener los id de los usuarios del sistema)\n"
            + "- CI (nuevo CI del usuario, Introducir un numero)\n"
            + "- Nombre (nuevo nombre, debe ir entre comillas dobles)\n"
            + "- Telefono (nuevo telefono, introducir un numero)\n"
            + "- Correo (nuevo correo, debe ir entre comillas dobless)\n"
            + "- Contraseña (String entre comillas dobles)\n"
            + "- Sexo (F para femenino o M para masculino)\n"
            + "- Tipo (C para clientes, P para personal, F para fotografo)\n"
            + "- idServicio (Solo para usuarios fotografos, id del servicio, se puede usar el comando LISTARSERVICIOS para obtener los id de los servicios del sistema)\n"
            + "- Direccion (Solo para usuarios fotografos, nueva direccion del fotografo, debe ir entre comillas dobles)\n"
            + "Cliente o personal => MODIFICARUSUARIO[CI, \"Nombre\", Telefono, \"Correo\", \"Contraseña\", Sexo]\n"
            + "Fotografo => MODIFICARUSUARIO[CI, \"Nombre\", Telefono, \"Correo\", \"Contraseña\", Sexo, idServicio, \"Direccion\"]\n";

    public static final String HELP_ELIMINARUSUARIO = "Eliminar un usuario\n\n"
            + "Este comando permite poder eliminar un usuario del sistema\n"
            + "Parametros:\n"
            + "- Correo (Introducir el Correo de uno de los usuarios del sistema)\n"
            + "ELIMINARUSUARIO[Correo]\n";
    // + "- IdUsuario (Introducir el ID de uno de los usuarios del sistema)\n"
    // + "ELIMINARUSUARIO[idUsuario]\n";

    public static final String HELP_LISTARUSUARIOS = "Listar todos los usuarios\n\n"
            + "Este comando permite poder listar todos los usuarios registrados en el sistema\n"
            + "Parametros: Ninguno\n"
            + "LISTARUSUARIOS\n";

    /*-----------------------------------------------------------------------*/
    public static final String HELP_INSERTAREVENTO = "Insertar un nuevo evento\n\n"
            + "Este comando permite poder registrar un nuevo evento\n"
            + "Parametros:\n"
            + "- Nombre (nombre que tendra el evento, debe ir entre comillas dobles)\n"
            + "- codigoAcceso (codigo que se le solicitara a los clientes para obtener las fotos del evento,  debe ir entre comillas dobles)\n"
            + "- fechaEvento (fecha en que se realizara el evento, debe ir entre comillas dobles, el formato debe ser AAAA-MM-DD)\n"
            + "- horaEvento (hora en que se realizara el evento, debe ir entre comillas doble, el formato debe ser HH:MM)\n"
            + "- idZona (id de la zona a la que pertenece el evento, se puede usar el comando LISTARZONAS para obtener los id de las azonas del sistema)\n"
            + "INSERTAREVENTO[\"Nombre\", \"codigoAcceso\", \"fechaEvento\", \"horaEvento\", \"idZona\"]\n";

    public static final String HELP_MODIFICAREVENTO = "Modificar los datos de un evento\n\n"
            + "Este comando permite poder modificar los datos de un evento\n"
            + "Parametros:\n"
            + "- idEvento (id del evento que se modificara, se puede usar el comando LISTAREVENTOS para obtener los id de los eventos del sistema)\n"
            + "- Nombre (nuevo nombre que tendra el evento, debe ir entre comillas dobles)\n"
            + "- codigoAcceso (nuevo codigo que se le solicitara a los clientes para obtener las fotos del evento,  debe ir entre comillas dobles)\n"
            + "- fechaEvento (nueva fecha en que se realizara el evento, debe ir entre comillas dobles, el formato debe ser AAAA-MM-DD)\n"
            + "- horaEvento (hora en que se realizara el evento, debe ir entre comillas doble, el formato debe ser HH:MM)\n"
            + "- idZona (id de la zona a la que pertenece el evento, se puede usar el comando LISTARZONAS para obtener los id de las azonas del sistema)\n"
            + "MODIFICAREVENTO[\"Nombre\", \"codigoAcceso\", \"fechaEvento\", \"horaEvento\", \"idZona\"]\n";

    public static final String HELP_ELIMINAREVENTO = "Eliminar un evento\n\n"
            + "Este comando permite poder eleminar un evento registrado en el sistema\n"
            + "Parametros:\n"
            + "- idEvento (id del evento que se eliminara, se puede usar el comando LISTAREVENTOS para obtener los id de los eventos)\n"
            + "ELIMINAREVENTO[idEvento]\n";

    public static final String HELP_LISTAREVENTOS = "Listar los eventos\n\n"
            + "Este comando permite poder mostrar todos los eventos registrados en el sistema\n"
            + "Parametros: Ninguno\n"
            + "LISTAREVENTOS\n";

    public static final String HELP_AGREGARSERVICIOEVENTO = "Agregar un servicio a un evento\n\n"
            + "Este comando permite poder agregar un nuevo servicio a un determinado evento\n"
            + "Parametros:\n"
            + "- IdEvento (id del evento, se puede usar el comando LISTAREVENTOS, para obtener los id de los eventos)\n"
            + "- IdServicio (id del servicio, se puede usar el comando LISTARSERVICIOS, para obtener los id de los servicios)\n"
            + "AGREGARSERVICIOEVENTO[idEvento, idServicio]\n";

    public static final String HELP_QUITARSERVICIOEVENTO = "Quitar un servicio a un evento\n\n"
            + "Este comando permite poder quitar un servicio a un determinado evento\n"
            + "Parametros:\n"
            + "- IdEvento (id del evento, se puede usar el comando LISTAREVENTOS, para obtener los id de los eventos)\n"
            + "- IdServicio (id del servicio, se puede usar el comando LISTARSERVICIOS, para obtener los id de los servicios)\n"
            + "QUITARSERVICIOEVENTO[idEvento, idServicio]\n";

    public static final String HELP_AGREGARFOTOS = "Agregar fotos al evento\n\n" // Tal vez sea necesario corregir
            + "Este comando permite poder agregar fotos a un determinado evento\n"
            + "Parametros:\n"
            + "- idEvento (id del evento, se puede usar el comando LISTAREVENTOS, para obtener los id de los eventos)\n"
            + "- Archivo imagen (Foto que se desea agregar al evento)\n"
            + "AGREGARFOTOS[idEvento]\n";
    
    public static final String HELP_VERFOTOS = "Ver fotos de un evento\n\n"
            + "Este comando permite poder ver fotos de un determinado evento\n"
            + "Parametros:\n"
            + "- IdEvento (id del evento del cual se veran las fotos, se puede usar el comando LISTAREVENTOS, para obtener los id de los eventos)\n"
            + "- codigoAcceso (codigo de acceso del evento)\n"
            + "VERFOTOS[idEvento, codigoAcceso]\n";
    /*----------------------------------------------------------------------*/
    public static final String HELP_INSERTARZONA = "Insertar una nueva zona\n\n"
            + "Este comando permite poder registrar una nueva zona en el sistema\n"
            + "Parametros:\n"
            + "- Nombre (nombre que tendra la zona, debe ir entre comillas dobles)\n"
            + "INSERTARZONA[\"Nombre\"]\n";

    public static final String HELP_MODIFICARZONA = "Modificar una zona\n\n"
            + "Este comando permite poder modificar los datos de una zona en el sistema\n"
            + "Parametros:\n"
            + "- idZona (id de la zona que se desea modificar, se puede usar el comando LISTARZONAS para obtener los id de las zonas del sistema)\n"
            + "- idZona (id de la zona que se modificara, se puede usar el comando LISTARZONAS para obtener los id de las azonas del sistema)\n"
            + "- Nombre (nuevo nombre que tendra la zona, debe ir entre comillas dobles)\n"
            + "MODIFICARZONA[\"Nombre\"]\n";

    public static final String HELP_ELIMINARZONA = "Eliminar una zona\n\n"
            + "Este comando permite poder poder eliminar una zona registrada en el sistema\n"
            + "Parametros:\n"
            + "- idZona (id de la zona que se desea eleminar, se puede usar el comando LISTARZONAS para obtener los id de las zonas del sistema)\n"
            + "ELIMINARZONA[idZona]\n";

    public static final String HELP_LISTARZONAS = "Listar zonas del sistema\n\n"
            + "Este comando permite poder mostrar todas las zonas registradas en el sistema\n"
            + "Parametros: Ninguna\n"
            + "LISTARZONAS\n";

    /*----------------------------------------------------------------------*/
    public static final String HELP_INSERTARPROMOCION = "Insertar una nueva promocion\n\n"
            + "Este comando permite poder registrar una nueva promocion en el sistema\n"
            + "Parametros:\n"
            + "- Nombre (nombre de la promocion, debe ir entre comillas dobles)\n"
            + "- Descuento (el porcentaje de descuento que se aplicara sobre los servicios, debe ser un nuevo mayor a 0 y menor a 100)\n"
            + "- fechaInicion (Fecha desde la cual será valida la promocion, debe ir entre comillas dobles con el siguiente formato DD/MM/AAAA)\n"
            + "- fechaFin (Fecha hasta la cual será valida la promocion, debe ir entre comillas dobles con el siguiente formaro DD/MM/AAAA)\n"
            + "INSERTARPROMOCION[\"Nombre\", Descuento, \"fechaInicio\", \"fechaFin\"]\n";

    public static final String HELP_MODIFICARPROMOCION = "Modificar una promocion\n\n"
            + "Este comando permite poder modificar los datos de una promocion registrada en el sistema\n"
            + "Parametros:\n"
            + "- idPromocion (id de la promocion, se puede usar el comando LISTARPROMOCIONES para obtener los id de las promociones del sistema)\n"
            + "- idPromocion (id de la promocion que se modificara, se puede usar el comando LISTARPROMOCIONES para obtener los id de las promociones del sistema)\n"
            + "- Nombre (nuevo nombre de la promocion, debe ir entre comillas dobles)\n"
            + "- Descuento (nuevo porcentaje de descuento que se aplicara sobre los servicios, debe ser un nuevo mayor a 0 y menor a 100)\n"
            + "- fechaInicion (nueva fecha desde la cual será valida la promocion, debe ir entre comillas dobles con el siguiente formato DD/MM/AAAA)\n"
            + "- fechaFin (nueva fecha hasta la cual será valida la promocion, debe ir entre comillas dobles con el siguiente formaro DD/MM/AAAA)\n"
            + "MODIFICARPROMOCION[\"Nombre\", Descuento, \"fechaInicio\", \"fechaFin\"]\n";

    public static final String HELP_ELIMINARPROMOCION = "Eliminar una promocion\n\n"
            + "Este comando permite poder eliminar una promocion registrada en el sistema\n"
            + "Parametros:\n"
            + "- idPromocion (id de la promocion, se puede usar el comando LISTARPROMOCIONES para obtener los id de las promociones del sistema)\n"
            + "ELIMINARPROMOCION[idPromocion]\n";

    public static final String HELP_LISTARPROMOCIONES = "Listar las promociones\n\n"
            + "Este comando permite poder mostrar todas las promociones registradas en el sistema\n"
            + "Parametros: ninguno\n"
            + "LISTARPROMOCIONES\n";

    /*----------------------------------------------------------------------*/
    public static final String HELP_INSERTARSERVICIO = "Insertar un servicio\n\n"
            + "Este comando permite poder registrar un nuevo servicio al sistema\n"
            + "Parametros:\n"
            + "- Nombre (nombre del servicio, debe ir entre comillas dobles)\n"
            + "- Descripcion (Breve descripcion del servicio, debe ir entre comillas dobles)\n"
            + "- Precio (Precio del servicio)\n"
            + "- Tipo (Tipo de servicio, 1 para servicios de eventos y 2 para servicios de pedido)\n"
            + "INSERTARSERVICIO[\"Nombre\", \"Descripcion\", Precio, Tipo]";

    public static final String HELP_MODIFICARSERVICIO = "Modificar los datos de un servicio\n\n"
            + "Este comando permite poder modificar los datos de un servicio registrado en el sistema\n"
            + "Parametros:\n"
            + "- idServicio (id del servicio, se puede usar el comando LISTARSERVICIOS para obtener los id de los servicios del sistema)\n"
            + "- idServicio (id del servicio que se modificara, se puede usar el comando LISTARSERVICIOS para obtener los id de los servicios del sistema)\n"
            + "- Nombre (nuevo nombre del servicio, debe ir entre comillas dobles)\n"
            + "- Descripcion (nueva descripcion del servicio, debe ir entre comillas dobles)\n"
            + "- Precio (nuevo recio del servicio)\n"
            + "- Tipo (Tipo de servicio, 1 para servicios de eventos y 2 para servicios de pedido)\n"
            + "MODIFICARSERVICIO[\"Nombre\", \"Descripcion\", Precio, Tipo]";

    public static final String HELP_ELIMINARSERVICIO = "Eliminar un servicio\n\n"
            + "Este comando permite poder eliminar un servicio registrado en el sistema\n"
            + "Parametros:\n"
            + "- idServicio (id del servicio, se puede usar el comando LISTARSERVICIOS para obtener los id de los servicios del sistema)\n"
            + "ELIMINARSERVICIO[idServicio]\n";

    public static final String HELP_LISTARSERVICIOS = "Listar los servicios\n\n"
            + "Este comando permite poder mostrar todos los servicios registrados en el sistema\n"
            + "Parametros: Ninguno\n"
            + "LISTARSERVICIOS\n";

    public static final String HELP_AGREGARPROMOCION = "Agregar promocion a un servicio\n\n"
            + "Este comando permite poder agregar una promocion a un servicio\n"
            + "Parametros:\n"
            + "- idServicio (id del servicio, se puede usar el comando LISTARSERVICIOS para obtener los id de los servicios del sistema)\n"
            + "- idPromocion (id de la promocion, se puede usar el comando LISTARPROMOCIONES para obtener los id de las promociones del sistema)\n"
            + "AGREGARPROMOCION[idServicio, idPromocion]\n";

    public static final String HELP_QUITARPROMOCION = "Quitar promocion a un servicio\n\n"
            + "Este comando permite poder quitar una promocion a un servicio\n"
            + "Parametros:\n"
            + "- idServicio (id del servicio, se puede usar el comando LISTARSERVICIOS para obtener los id de los servicios del sistema)\n"
            + "- idPromocion (id de la promocion, se puede usar el comando LISTARPROMOCIONES para obtener los id de las promociones del sistema)\n"
            + "QUITARPROMOCION[idServicio, idPromocion]\n";

    public static final String HELP_VERPROMOCIONES = "Ver promociones\n\n"
            + "Este comando permite conocer que servicios estan de promocion y sus nuevos precios\n"
            + "Parametros: Ninguno\n"
            + "VERPROMOCIONES\n";

    /*----------------------------------------------------------------------*/
    public static final String HELP_INSERTARPEDIDO = "Insertar un nuevo pedido\n\n"
            + "Este comando permite poder registrar un nuevo pedido en el sistema\n"
            + "Parametros:\n"
            + "- Direccion (direccion del pedido, debe ir entre comillas dobles)\n"
            + "- idZona (id de la zona a la que se hara el pedido, se puede usar el comando LISTARZONAS para obtener los id de las zonas del sistema)\n"
            + "- idEvento (id del evento a las que pertenecen las fotos, se puede usar el comando LISTAREVENTOS para obtener los id de las eventos del sistema\n"
            + "- codigoAcceso (codigo de acceso del evento, debe ir entre comillas)\n"
            + "INSERTARPEDIDO[\"Direccion\", idZona, idEvento, \"codigoAcceso\"]\n";

    public static final String HELP_MODIFICARPEDIDO = "Modificar los datos de un pedido\n\n"
            + "Este comando permite poder modificar los datos de un pedido registrado en el sistmea\n"
            + "Parametros:\n"
            + "- idPedido (id del pedido que se modificara, se puede usar el comando LISTARPEDIDOS para obtener los id de los pedidos del sistema)\n"
            + "- Direccion (nueva direccion del pedido, debe ir entre comillas dobles)\n"
            + "- idZona (id de la zona a la que se hara el pedido, se puede usar el comando LISTARZONAS para obtener los id de las zonas del sistema)\n"
            + "- idEvento (id del evento a las que pertenecen las fotos, se puede usar el comando LISTAREVENTOS para obtener los id de las eventos del sistema\n"
            + "- codigoAcceso (codigo de acceso del evento, debe ir entre comillas)\n"
            + "MODIFICARPEDIDO[\"Direccion\", idZona, idEvento, \"codigoAcceso\"]\n";

    public static final String HELP_ELIMINARPEDIDO = "Eliminar un pedido\n\n"
            + "Este comando permite poder eliminar un pedido registrado en el sistema\n"
            + "Parametros:\n"
            + "- idPedido (id del pedido que se desea eliminar, se puede usar el comando LISTARPEDIDOS para obtener los id de los pedidos del sistema)\n"
            + "ELIMINARPEDIDO[idPedido]\n";

    public static final String HELP_LISTARPEDIDOS = "Listar todos los pedidos\n\n"
            + "Este comando permite poder mostrar todos los pedidos registrados en el sistema\n"
            + "Parametros: Ninguno\n"
            + "LISTARPEDIDOS\n";

    public static final String HELP_AGREGARSERVICIOPEDIDO = "Agregar un servicio a un pedido\n\n"
            + "Este comando permite poder agregar un servicio a un determinado pedido\n"
            + "Parametros:\n"
            + "- idPedido (id del pedido, se puede usar el comando LISTARPEDIDOS para obtener los id de los pedidos del sistema)\n"
            + "- idServicio (id del servicio, se puede usar el comando LISTARSERVICIOS para obtener los id de los servicios del sistema)\n"
            + "AGREGARSERVICIOPEDIDO[idPedido, idServicio]\n";

    public static final String HELP_QUITARSERVICIOPEDIDO = "Quitar un servicio a un pedido\n\n"
            + "Este comando permite poder quitar un servicio a un determinado pedido\n"
            + "Parametros: \n"
            + "- idPedido (id del pedido, se puede usar el comando LISTARPEDIDOS para obtener los id de los pedidos del sistema)\n"
            + "- idServicio (id del servicio, se puede usar el comando LISTARSERVICIOS para obtener los id de los servicios del sistema)\n"
            + "QUITARSERVICIOPEDIDO[idPedido, idServicio]\n";

    /*----------------------------------------------------------------------*/
    public static final String HELP_INSERTARPROFORMA = "Insertar una nueva proforma\n\n"
            + "Este comando permite poder registrar una nueva proforma en el sistema\n"
            + "Parametros: Ninguno\n"
            + "INSERTARPROFORMA[]\n";

    /*public static final String HELP_MODIFICARPROFORMA = "Modificar una proforma\n\n"
            + "Este comando permite poder modificar los datos de una proforma registrada en el sistema"
            + "Parametros:\n"
            + "- idProforma (id de la proforma que se modificara, se puede usar el comando LISTARPROFORMAS para obtener los ide de las proformas del sistema)\n"
            + "MODIFICARPROFORMA[]\n";*/

    public static final String HELP_ELIMINARPROFORMA = "Eliminar una proforma\n\n"
            + "Este comando permite poder eliminar una proforma registrada en el sistema\n"
            + "Parametros:\n"
            + "- idProforma (id de la proforma, se puede usar el comando LISTARPROFORMAS para obtener los id de las proformas del sistema)\n"
            + "ELIMINARPROFORMA[idProforma]\n";

    public static final String HELP_LISTARPROFORMAS = "Listar las proformas\n\n"
            + "Este comando permite pode mostrar las proformas registradas en el sistema\n"
            + "Parametros: Ninguno\n"
            + "LISTARPROFORMAS\n";

    public static final String HELP_AGREGARSERVICIOPROFORMA = "Agregar un servicio a una proforma\n\n"
            + "Este comando permite poder agregar un servicio a una determinada proforma\n"
            + "Parametros:\n"
            + "- cantidad (cantidad 1 si usa servicios de filmación o fotografia de lo contrario disponga poner cualquier otra cantidad LISTARPROFORMAS)\n"
            + "- idProforma (id de la proforma, se puede usar el comando LISTARPROFORMAS para obtener los id de las proformas del sistema)\n"
            + "- idServicio (id del servicio, se puede usar el comando LISTARSERVICIOS para obtener los id de los servicios del sistema)\n"
            + "AGREGARSERVICIOPROFORMA[idProforma, idServicio]\n";

    public static final String HELP_QUITARSERVICIOPROFORMA = "Quitar un servicio a una proforma\n\n"
            + "Este comando permite poder quitar un servicio a una determinada proforma\n"
            + "Parametros\n"
            + "- idProforma (id de la proforma, se puede usar el comando LISTARPROFORMAS para obtener los id de las proformas del sistema)\n"
            + "- idServicio (id del servicio, se puede usar el comando LISTARSERVICIOS para obtener los id de los servicios del sistema)\n"
            + "QUITARSERVICIOPROFORMA[idProforma, idServicio]\n";

    public static final String HELP_VERPROFORMA = "Ver proforma\n\n"
            + "Este comando permite ver el costo total de una proforma\n"
            + "Parametros:\n"
            + "- idProforma (id de la proforma, se puede usar el comando LISTARPROFORMAS para obtener los id de las proformas del sistema)\n"
            + "VERPROFORMA[idProforma]\n";

    /*----------------------------------------------------------------------*/
    public static final String HELP_MOSTRARESTADISTICA = "Mostrar estadisticas\n\n"
            + "Este comando permite poder obtener informaciòn acerca del funcionamiento del estudio fotográfico por graficos pastel\n"
            + "Parametros: Ninguno\n"
            + "MOSTRARESTADISTICA\n";
    
    public static final String HELP_MOSTRARREPORTE = "Mostrar reportes\n\n"
            + "Este comando permite poder obtener información acerca del funcionamiento del estudio fotográfico por medio de repotes en formato de tabla\n"
            + "Parametros: Ninguno\n"
            + "MOSTRARREPORTE\n";
    
    /*
    public static final String HELP_INSERTARCLIENTE = "Modificar Cliente\n"
            + "\n"
            + "Este comando permite registrar a un cliente en el sistema.\n"
            + "\n"
            + "PARAMETROS:\n"
            + "\n"
            + "- direccion (String con Comillas Dobles)\n"
            + "- web (String con Comillas Dobles)\n"
            + "INSERTARCLIENTE[\"direccion\",...]";
    public static final String HELP_MODIFICARCLIENTE = "Modificar Cliente!!!\n"
            + "\n"
            + "Lo que hace el siguiente comando es modificar a un cliente en el sistema.\n"
            + "\n"
            + "PARAMETROS:\n"
            + "\n"
            + "- direccion (String con Comillas Dobles)\n"
            + "- web (String con Comillas Dobles)\n"
            + "\n"
            + "OPCIONALES: (Usar guion bajo \"_\" para decir no cambiar)\n"
            + "\n"
            + "id, direccion, web";
    public static final String HELP_ELIMINARCLIENTE = "Eliminar Cliente!!!\n"
            + "\n"
            + "Lo que hace el siguiente comando es Eliminar a un cliente registrados en el sistema,\n"
            + "\n"
            + "PARAMETROS:\n"
            + "\n"
            + "- id (Entero)\n"
            + "Mensaje:\n "
            + "\n"
            + "Eliminacion exitosa.";
    public static final String HELP_LISTARCLIENTE = "Lista De Registros!!!\n"
            + "\n"
            + "Lo que hace el siguiente comando es listar los registros de la tabla en el sistema,\n"
            + "no es necesario enviar ningun parametro";
    
    
    public static final String HELP_INSERTARCOMENTARIO = "Insertar Comentario!!!\n"
            + "\n"
            + "Lo que hace el siguiente comando es insertar a un comentario en el sistema.\n"
            + "\n"
            + "PARAMETROS:\n"
            + "\n"
            + "- descripcion (String con Comillas Dobles)\n"
            + "- idMultimedia (Entero)\n"
            + "- idPersona (Entero)\n";
    public static final String HELP_MODIFICARCOMENTARIO = "Modificar Comentario!!!\n"
            + "\n"
            + "Lo que hace el siguiente comando es modificar un comentario en el sistema.\n"
            + "\n"
            + "PARAMETROS:\n"
            + "\n"
            + "- codigo (Entero codigo de comentario)\n"
            + "- descripcion (String con Comillas Dobles)\n"
            + "- Codigo Persona (Entero)\n"
            + "\n"
            + "OPCIONALES: (Usar guion bajo \"_\" para decir no cambiar)\n"
            + "\n"
            + "codigo, descripcion, CodigoPersona";
    public static final String HELP_ELIMINARCOMENTARIO = "Eliminar Comentario!!!\n"
            + "\n"
            + "Lo que hace el siguiente comando es eliminar un comentario registrado en el sistema,\n"
            + "\n"
            + "PARAMETROS:\n"
            + "\n"
            + "- id (Entero)\n"
            + "Mensaje:\n "
            + "\n"
            + "Eliminacion exitosa.";
    public static final String HELP_LISTARCOMENTARIO = "Lista De Comentarios De Una Publicacion Multimedia!!!\n"
            + "\n"
            + "Lo que hace el siguiente comando es listar los registros de la tabla en el sistema,\n"
            + "PARAMETROS:\n"
            + "\n"
            + "- Codigo Multimedia (Entero)\n";
    
    
    public static final String HELP_INSERTARCONTACTO = "Insertar Contacto!!!\n"
            + "\n"
            + "Lo que hace el siguiente comando es insertar a un contacto en el sistema.\n"
            + "\n"
            + "PARAMETROS:\n"
            + "\n"
            + "- idcliente (Entero)\n"
            + "- idusuario (Entero)\n";
    public static final String HELP_ELIMINARCONTACTO = "Elimina Contacto!!!\n"
            + "\n"
            + "Lo que hace el siguiente comando es Eliminar a un contacto registrados en el sistema,\n"
            + "\n"
            + "PARAMETROS:\n"
            + "\n"
            + "- CodigoTrabajador (Entero)\n"
            + "- CodigoEmpleador (Entero)\n"
            + "Mensaje:\n "
            + "\n"
            + "Eliminacion exitosa.";
    public static final String HELP_LISTARCONTACTO = "Lista De Registros!!!\n"
            + "\n"
            + "Lo que hace el siguiente comando es listar los registros de la tabla en el sistema,\n"
            + "no es necesario enviar ningun parametros";
    
    
    public static final String HELP_INSERTARDATOSPRINCIPALES = "Insertar Datos Principales!!!\n"
            + "\n"
            + "Lo que hace el siguiente comando es insertar a un dato principal del cliente en el sistema.\n"
            + "\n"
            + "PARAMETROS:\n"
            + "\n"
            + "- titulo (String con Comillas Dobles)\n"
            + "- descripcion (String con Comillas Dobles)\n"
            + "- idcliente (Entero)\n";
    public static final String HELP_MODIFICARDATOSPRINCIPALES = "Modificar Datos Principal!!!\n"
            + "\n"
            + "Lo que hace el siguiente comando es modificar un dato principal del cliente en el sistema.\n"
            + "\n"
            + "PARAMETROS:\n"
            + "\n"
            + "- Codigo (Entero)\n"
            + "- titulo (String con Comillas Dobles)\n"
            + "- descripcion (String con Comillas Dobles)\n"
            + "- CodigoCliente (Entero)\n"
            + "\n"
            + "OPCIONALES: (Usar guion bajo \"_\" para decir no cambiar)\n"
            + "\n"
            + "Codigo,titulo, descripcion, idcliente";
    public static final String HELP_ELIMINARDATOSPRINCIPALES = "Eliminar Datos Principal!!!\n"
            + "\n"
            + "Lo que hace el siguiente comando es Eliminar a un dato principal registrados en el sistema,\n"
            + "\n"
            + "PARAMETROS:\n"
            + "\n"
            + "- id (Entero)\n"
            + "Mensaje:\n "
            + "\n"
            + "Eliminacion exitosa.";
    public static final String HELP_LISTARDATOSPRINCIPALES = "Lista De Registros!!!\n"
            + "\n"
            + "Lo que hace el siguiente comando es listar los registros de la tabla en el sistema,\n"
            + "no es necesario enviar ningun parametros";
    
    
    public static final String HELP_INSERTARMULTIMEDIA = "Insertar Multimedia!!!\n"
            + "\n"
            + "Lo que hace el siguiente comando es insertar a un archivo multimedia del cliente en el sistema.\n"
            + "\n"
            + "PARAMETROS:\n"
            + "\n"
            + "- titulo (String con Comillas Dobles)\n"
            + "- tipo (Entero 1 si es foto 2 si es video)\n"
            + "- idcliente (Entero)\n";
    public static final String HELP_MODIFICARMULTIMEDIA = "Modificar Multimedia!!!\n"
            + "\n"
            + "Lo que hace el siguiente comando es modificar una publicidad multimedia en el sistema.\n"
            + "\n"
            + "PARAMETROS:\n"
            + "\n"
            + "- Codigo (Entero)\n"
            + "- titulo (String con Comillas Dobles)\n"
            + "- tipo (Entero 1 si es foto 2 si es video)\n"
            + "- CodigoCiente (Entero)\n"
            + "\n"
            + "OPCIONALES: (Usar guion bajo \"_\" para decir no cambiar)\n"
            + "\n"
            + "Codigo,titulo, descripcion, CodigoCliente";
    public static final String HELP_ELIMINARMULTIMEDIA = "Eliminar Multimedia!!!\n"
            + "\n"
            + "Lo que hace el siguiente comando es Eliminar a un multimedia registrados en el sistema,\n"
            + "\n"
            + "PARAMETROS:\n"
            + "\n"
            + "- id (Entero)\n"
            + "Mensaje:\n "
            + "\n"
            + "Eliminacion exitosa.";
    public static final String HELP_LISTARMULTIMEDIA = "Lista De Registros!!!\n"
            + "\n"
            + "Lo que hace el siguiente comando es listar los registros de la tabla en el sistema,\n"
            + "no es necesario enviar ningun parametros";
    

    public static final String HELP_INSERTARPERSONA = "Insertar Persona!!!\n"
            + "\n"
            + "Lo que hace el siguiente comando es insertar a un registro de los datos de la persona en el sistema.\n"
            + "\n"
            + "PARAMETROS:\n"
            + "\n"
            + "- nombre completo (String con Comillas Dobles)\n"
            + "- email (String con Comillas Dobles)\n"
            + "- password (String con Comillas Dobles)\n"
            + "- avatar 'imagen de perfil' (String con Comillas Dobles)\n"
            + "- celular (Entero)\n"
            + "- tipo (Entero 1 Trabajador'Personas que publican sus habilidades' 2 Empleador'Personas que buscan a personal trabajador ')\n"
            + "- genero (Entero 1 Masculino 2 Femenino)\n";
    public static final String HELP_MODIFICARPERSONA = "Modificar Persona!!!\n"
            + "\n"
            + "Lo que hace el siguiente comando es modificar los dato de la persona en el sistema.\n"
            + "\n"
            + "PARAMETROS:\n"
            + "\n"
            + "- nombre completo (String con Comillas Dobles)\n"
            + "- email (String con Comillas Dobles)\n"
            + "- password (String con Comillas Dobles)\n"
            + "- avatar 'imagen de perfil' (String con Comillas Dobles)\n"
            + "- celular (Entero)\n"
            + "- genero (Entero 1 Masculino 2 Femenino)\n";
    public static final String HELP_ELIMINARPERSONA = "Eliminar Persona!!!\n"
            + "\n"
            + "Lo que hace el siguiente comando es Eliminar a una persona registrado en el sistema,\n"
            + "\n"
            + "PARAMETROS:\n"
            + "\n"
            + "- id (Entero)\n"
            + "Mensaje:\n "
            + "\n"
            + "Eliminacion exitosa.";
    public static final String HELP_LISTARPERSONA = "Lista De Registros!!!\n"
            + "\n"
            + "Lo que hace el siguiente comando es listar los registros de la tabla en el sistema,\n"
            + "no es necesario enviar ningun parametros";
    
    
    public static final String HELP_INSERTARSUGERENCIA = "Insertar Sugerencia!!!\n"
            + "\n"
            + "Lo que hace el siguiente comando es registrar una sugerencia con respecto a una publicacion multimedia en el sistema.\n"
            + "\n"
            + "PARAMETROS:\n"
            + "\n"
            + "- idsugeridor (Entero)\n"
            + "- idreceptor (Entero)\n"
            + "- descripcion (String con Comillas Dobles)\n"
            + "- idmultimedia (Entero)\n";
    public static final String HELP_MODIFICARSUGERENCIA = "Modificar Sugerencia!!!\n"
            + "\n"
            + "Lo que hace el siguiente comando es modificar una sugerencia en el sistema.\n"
            + "\n"
            + "PARAMETROS:\n"
            + "\n"
            + "- idsugeridor (Entero)\n"
            + "- idreceptor (Entero)\n"
            + "- descripcion (String con Comillas Dobles)\n"
            + "- idmultimedia (Entero)\n";
    public static final String HELP_ELIMINARSUGERENCIA = "Eliminar Sugerencia!!!\n"
            + "\n"
            + "Lo que hace el siguiente comando es Eliminar a una sugerencia registrado en el sistema,\n"
            + "\n"
            + "PARAMETROS:\n"
            + "\n"
            + "- id (Entero)\n"
            + "Mensaje:\n "
            + "\n"
            + "Eliminacion exitosa.";
    public static final String HELP_LISTARSUGERENCIA = "Lista De Registros!!!\n"
            + "\n"
            + "Lo que hace el siguiente comando es listar los registros de la tabla en el sistema,\n"
            + "no es necesario enviar ningun parametros";
    
    
    public static final String HELP_INSERTARUSUARIO = "Insertar Usuario!!!\n"
            + "\n"
            + "Lo que hace el siguiente comando es registrar un usuario en el sistema.\n"
            + "\n"
            + "PARAMETROS:\n"
            + "\n"
            + "- nombre completo (String con Comillas Dobles)\n"
            + "- email (String con Comillas Dobles)\n"
            + "- password (String con Comillas Dobles)\n"
            + "- celular (Entero)\n"
            + "- tipo (Entero 1 Trabajador'Personas que publican sus habilidades' 2 Empleador'Personas que buscan a personal trabajador ')\n"
            + "- genero (Entero 1 Masculino 2 Femenino)\n"
            + "- empresa (String con Comillas Dobles)\n";
    public static final String HELP_MODIFICARUSUARIO = "Modificar Usuario!!!\n"
            + "\n"
            + "Lo que hace el siguiente comando es modificar un usuario en el sistema.\n"
            + "\n"
            + "PARAMETROS:\n"
            + "\n"
            + "- Codigo (Entero)\n"
            + "- nombre completo (String con Comillas Dobles)\n"
            + "- password (String con Comillas Dobles)\n"
            + "- celular (Entero)\n"
            + "- genero (Entero 1 Masculino 2 Femenino)\n"
            + "- empresa (String con Comillas Dobles)\n";
    public static final String HELP_ELIMINARUSUARIO = "Eliminar Usuario!!!\n"
            + "\n"
            + "Lo que hace el siguiente comando es Eliminar a un usuario registrados en el sistema,\n"
            + "\n"
            + "PARAMETROS:\n"
            + "Mensaje:\n "
            + "\n"
            + "Eliminacion exitosa.";
    public static final String HELP_LISTARUSUARIO = "Lista De Registros!!!\n"
            + "\n"
            + "Lo que hace el siguiente comando es listar los registros de la tabla en el sistema,\n"
            + "no es necesario enviar ningun parametros";
    public static final String HELP_VERMULTIMEDIA = "VERMULTIMEDIA!!!\n"
            + "\n"
            + "Lo que hace el siguiente comando es mostrar el contenido multimeda.\n"
            + "\n"
            + "PARAMETROS:\n"
            + "\n"
            + "- id (Entero, identificador de multimedia)\n"
            + "INSERTARCLIENTE[\"direccion\",...]";
    public static final String HELP_MOSTRARESTADISTICA = "MOSTRARESTADISTICA!!!\n"
            + "\n"
            + "Lo que hace el siguiente comando es mostrar la estadistica de un cliente.\n"
            + "\n"
            + "PARAMETROS:\n"
            + "\n"
            + "- id (Entero identificador de un cliente)\n"
            + "INSERTARCLIENTE[\"direccion\",...]";
     */
}
