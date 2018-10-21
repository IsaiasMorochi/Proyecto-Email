package Negocio;

import Dato.DDetallePedido;
import Dato.DEvento;
import Dato.DFoto;
import Dato.DPedido;
import Dato.DPromocion;
import Dato.DPromocionServicio;
import Dato.DServicio;
import Dato.DUsuario;
import Dato.DZona;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import nucleo.utilidades.Herramientas;

/**
 * @author Saulo
 * @version 1.0
 * @created 16-may-2018 12:48:14
 */
public class NPedido {

    DPedido pedido;
    DDetallePedido detalle;

    public NPedido() {
        pedido = new DPedido();
        detalle = new DDetallePedido();
    }

    //NPedido
    public DPedido getPedido() {
        return pedido;
    }

    public DDetallePedido getDetalle() {
        return detalle;
    }

    //funcionalidades
    public boolean registrarPedido(String direccion, int idZona, int idCliente, int idServicio) {
        this.pedido.setDireccion(direccion);
        this.pedido.setTotal(0);
        this.pedido.setIdCliente(idCliente);
        this.pedido.setIdServicio(idServicio);
        this.pedido.setIdZona(idZona);
        this.pedido.setEstado(true);
        return this.pedido.insertar();
    }

    public boolean registrarDetalle(int cantidad, int idEvento, int idPedido) {
        this.pedido = pedido.buscar(idPedido); //encontrar pedido
        //para obtener el subtotal tomando en cuenta si existe una promocion para tal servicio
        DPromocionServicio promocionServicio = new DPromocionServicio();
        DPromocion promocion = promocionServicio.buscarServicioPromocion(pedido.getIdServicio());//encontrar promocion nombre y descuento
        DServicio servicio = new DServicio();
        servicio = servicio.buscar(pedido.getIdServicio());//encontrar servicio
        float subtotals = 0;
        if (promocion == null) {
            subtotals = servicio.getPrecio() * cantidad; //calculo de subtotal sin promocio
        } else {
            subtotals = (servicio.getPrecio() - ((promocion.getDescuento() / 100) * servicio.getPrecio())) * cantidad;//calculo con promocion
        }
        //guardar cambios de detalle y pedido
        detalle.setCantidad(cantidad);
        detalle.setIdEvento(idEvento);
        detalle.setIdPedido(idPedido);
        detalle.setSubtotal(subtotals);
        pedido.setTotal(pedido.getTotal() + detalle.getSubtotal());
        return this.pedido.actualizar() && this.detalle.insertar();
    }

    public boolean modificarPedido(int id, String direccion, int idZona, int idServicio) {
        pedido = pedido.buscar(id);
        this.pedido.setDireccion(direccion);
        this.pedido.setIdZona(idZona);
        this.pedido.setIdServicio(idServicio);
        return this.pedido.actualizar();
    }

    public boolean borrarDetalle(int idPedido, int idEvento) {
        detalle = detalle.buscar(idPedido, idEvento);
        if (detalle == null) {
            return false;
        }
        pedido = pedido.buscar(idPedido);
        pedido.setTotal(pedido.getTotal() - detalle.getSubtotal());
        return detalle.eliminar() && pedido.actualizar();
    }

    public boolean borrarPedido(int id) {
        this.pedido.setId(id);
        return pedido.eliminar();
    }

    public List<DPedido> listaPedidos() {

        List<DPedido> listaPedidos = new ArrayList<>();
        List<Object> listaObject = this.pedido.listar();
        if (listaObject == null || listaObject.isEmpty()) {
            return null;
        }
        for (Object objectX : listaObject) {
            DPedido pedidoX = new DPedido();
            List<Object> objectPedido = (List<Object>) objectX;
            pedidoX.setId(Integer.valueOf(objectPedido.get(0).toString()));
            pedidoX.setFecha(objectPedido.get(1).toString());
            pedidoX.setDireccion(objectPedido.get(2).toString());
            pedidoX.setTotal(Float.valueOf(objectPedido.get(3).toString()));
            pedidoX.setEstado(Boolean.valueOf(objectPedido.get(4).toString()));
            pedidoX.setIdZona(Integer.valueOf(objectPedido.get(5).toString()));
            pedidoX.setIdCliente(Integer.valueOf(objectPedido.get(6).toString()));
            pedidoX.setIdServicio(Integer.valueOf(objectPedido.get(7).toString()));
            listaPedidos.add(pedidoX);
        }
        return listaPedidos;
    }

    public String mostrarPedidos() {
        String s = "";
        NPedido pedido = new NPedido();
        List<DPedido> listaPedidos = listaPedidos();
        if (listaPedidos != null) {
            s = "Lista de pedidos:\n";
            for (int i = 0; i < listaPedidos.size(); i++) {
                DPedido p = listaPedidos.get(i);
                s += "ID: " + p.getId() + "\n";
                s += "Direccion: " + p.getDireccion() + "\n";
                s += "Fecha: " + p.getFecha() + "\n";
                s += "------------------------------------\n";
            }

        }
        return s;
    }

    public List<DDetallePedido> listaDetalles(int idPedido) {
        this.detalle.setIdPedido(idPedido);
        List<DDetallePedido> listaDetalles = new ArrayList<>();
        List<Object> listaObject = this.detalle.listar();
        if (listaObject == null || listaObject.isEmpty()) {
            return null;
        }
        for (Object objectX : listaObject) {
            DDetallePedido detallePedido = new DDetallePedido();
            List<Object> objectDetalle = (List<Object>) objectX;
            detallePedido.setCantidad(Integer.valueOf(objectDetalle.get(0).toString()));
            detallePedido.setSubtotal(Float.valueOf(objectDetalle.get(1).toString()));
            detallePedido.setIdEvento(Integer.valueOf(objectDetalle.get(3).toString()));
            detallePedido.setIdPedido(Integer.valueOf(objectDetalle.get(2).toString()));

            listaDetalles.add(detallePedido);
        }
        return listaDetalles;
    }

    //mostrarLista muestra pedido en especifico cabezera y detalles
    public String mostrarLista(int idPedido) {
        pedido = pedido.buscar(idPedido);
        String pedidoCompleto = "Pedido\n\n";
        pedidoCompleto = pedidoCompleto
                + "Codigo: " + pedido.getId() + "    Fecha: " + pedido.getFecha() + " " + "\n";
        DZona zona = new DZona();
        zona = zona.buscar(pedido.getIdZona());
        DUsuario usuario = new DUsuario();
        usuario = usuario.buscar(pedido.getIdCliente());
        DServicio servicio = new DServicio();
        servicio = servicio.buscar(pedido.getIdServicio());

        pedidoCompleto = pedidoCompleto
                + "Zona: " + zona.getNombre() + "    Dirección: " + pedido.getDireccion() + "\n"
                + "Nombre: " + usuario.getNombre() + "    Carnet De Identidad:" + usuario.getCi() + "\n"
                + "Servicio De: " + servicio.getNombre() + "\n\n\n";
        pedidoCompleto += tablaDetalles(pedido.getId()) + "\n"
                + "Total: " + pedido.getTotal() + "\n"
                + "\n----------------------------------------------------------------------------------------------------";
        return pedidoCompleto;
    }

    public String tablaDetalles(int idPedido) {
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new Object[]{"Codigo", "Evento", "Precio", "Cantidad", "Subtotal"});
        List<DDetallePedido> listarDetalles = this.listaDetalles(idPedido);
        try {
            pedido = pedido.buscar(idPedido);
            DServicio servicio = new DServicio();
           servicio= servicio.buscar(pedido.getIdServicio());
            //para obtener el subtotal tomando en cuenta si existe una promocion para tal servicio
            DPromocionServicio promocionServicio = new DPromocionServicio();
            DPromocion promocion = promocionServicio.buscarServicioPromocion(pedido.getIdServicio());//encontrar promocion nombre y descuento
          
            if (promocion != null) {
                servicio.setPrecio(servicio.getPrecio() - ((promocion.getDescuento() / 100) * servicio.getPrecio()));
              
            }

            for (DDetallePedido detalleX : listarDetalles) {
                DEvento evento = new DEvento();
                evento = evento.buscar(detalleX.getIdEvento());
               
                Object[] obj = new Object[5];
                obj[0] = detalleX.getIdEvento();
                obj[1] = evento.getNombre();
                System.out.println(servicio.getPrecio());
                obj[2] = servicio.getPrecio();
                obj[3] = detalleX.getCantidad();
                obj[4] = detalleX.getSubtotal();
                model.addRow(obj);
            }
            return Herramientas.dibujarTabla(model);

        } catch (Exception e) {
            System.out.println(e);
            return "";
        }
    }
}
