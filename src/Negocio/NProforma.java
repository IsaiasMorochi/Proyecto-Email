package Negocio;

import Dato.DDetalleProforma;
import Dato.DProforma;
import Dato.DPromocion;
import Dato.DPromocionServicio;
import Dato.DServicio;
import Dato.DUsuario;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import nucleo.utilidades.Herramientas;

/**
 * @author Saulo
 * @version 1.0
 * @created 16-may-2018 12:48:19
 */
public class NProforma {
    private DProforma proforma;
    private DDetalleProforma detalle;
    
    public NProforma(){
        proforma = new DProforma();
        detalle = new DDetalleProforma();
    }

    public DProforma getProforma() {
        return proforma;
    }
    
    public DDetalleProforma getDetalle() {
        return detalle;
    }
    
    public boolean registrarProforma(int idCliente) {
        this.proforma.setTotal(0);
        this.proforma.setIdCliente(idCliente);
        return proforma.insertar();
    }
    
    public boolean registrarDetalleProforma(int cantidad,int idServicio,int idProforma) {
        DServicio servicio= new DServicio();
        servicio = servicio.buscar(idServicio);
        proforma = new DProforma();
        proforma = proforma.buscar(idProforma);
        if (proforma!=null && servicio!=null) {
            DPromocionServicio promocionServicio=new DPromocionServicio();
            DPromocion promocion = promocionServicio.buscarServicioPromocion(idServicio);//encontrar promocion nombre y descuento
            float subtotal = 0;
            if (promocion==null) {
                subtotal = servicio.getPrecio() * cantidad; //calculo de subtotal sin promocio
            }else{
                subtotal = (servicio.getPrecio()-((promocion.getDescuento()/100)*servicio.getPrecio())) * cantidad;//calculo con promocion
            }
            proforma.setId(idProforma);
            proforma.setTotal(proforma.getTotal() + subtotal);
            this.detalle.setCantidad(cantidad);
            this.detalle.setIdProforma(idProforma);
            this.detalle.setIdServicio(idServicio);
            this.detalle.setSubtotal(subtotal);
            
            return proforma.actualizar() && this.detalle.insertar();
        }
        return false;
    }
    
    public boolean borrarProforma(int idProforma) {
        List<DDetalleProforma> listaDetalles = this.listarDetalles(idProforma);
        boolean eliminados=true;
        if (listaDetalles!=null && listaDetalles.size()!=0) {
            for (DDetalleProforma detalleX : listaDetalles) {
                eliminados = detalleX.eliminar();
            }
        }
        if (eliminados) {
            proforma.setId(idProforma);
            return proforma.eliminar();
        }
        return false;
    }
    
    public boolean borrarDetalles(int idProforma,int idServicio){
        proforma = new DProforma();
        proforma = proforma.buscar(idProforma);
        detalle = new DDetalleProforma();
        detalle = detalle.buscar(idProforma,idServicio);
        if (proforma!=null && detalle!=null) {
            proforma.setTotal(proforma.getTotal() - detalle.getSubtotal());
            return proforma.actualizar() && this.detalle.eliminar();
        }
        return false;
    }

    public List<DDetalleProforma> listarDetalles(int idProforma) {
        List<DDetalleProforma> listaDetalles = new ArrayList<>();
        this.detalle.setIdProforma(idProforma);
        List<Object> listaObject =(List<Object>) this.detalle.listar();
        for (Object object : listaObject) {
            List<Object> objectX =(List<Object>)object;
            this.detalle.setSubtotal(Float.valueOf(objectX.get(0).toString()));
            this.detalle.setCantidad(Integer.valueOf(objectX.get(1).toString()));
            this.detalle.setIdServicio(Integer.valueOf(objectX.get(2).toString()));
            this.detalle.setIdProforma(Integer.valueOf(objectX.get(3).toString()));
            listaDetalles.add(detalle);
        }
        return listaDetalles;
    }
    
    public String mostrarListaProforma(){
        List<Object> listarObject = this.proforma.listar();
        String listaProforma = "Lista De Proformas\n\n"+ "Codigo ";
        if (listarObject==null || listarObject.isEmpty()) {
            return "";
        }
        for (Object object : listarObject) {
            List<Object> objectX = (List<Object>)object;
            DUsuario usuario = new DUsuario();
           usuario= usuario.buscar(Integer.valueOf(objectX.get(3).toString()));
            //                  id                              fecha                       a nombre de:            el total
            listaProforma+= objectX.get(0).toString()+"  "+objectX.get(1).toString()+"  "+usuario.getNombre()+"  Total: "+objectX.get(2).toString()+"Bs \n";
        }
        return listaProforma;
    }
    
    public String mostrarProforma(int idProforma){
        this.proforma=this.proforma.buscar(idProforma);
        if (this.proforma==null) {
            return "";
        }
        DUsuario usuario=new DUsuario();
        usuario = usuario.buscar(this.proforma.getIdCliente());
        String resultado="Proforma\n\n";
        resultado=resultado+
                "Codigo: "+this.proforma.getId()+
                "Fecha: "+this.proforma.getFecha()+
                "Nombre: "+usuario.getNombre()+"\n\n\n"+
                this.tablaDetalles(this.proforma.getId())
                ;
        return resultado=resultado+"\n Total Pago: "+this.proforma.getTotal()+"\n---------------------------------------------------------------------------\n";
    }
    
    private String tablaDetalles(int idProforma){
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new Object[]{"Codigo","Servicio","Precio","Cantidad","Subtotal"});
        List<DDetalleProforma> listarDetalles = this.listarDetalles(idProforma);
        try {
            for (DDetalleProforma detalleX : listarDetalles) {
                Object[] obj = new Object[5];
                obj[0] = detalleX.getIdServicio();

                DServicio servicio = new DServicio();
                servicio = servicio.buscar(detalleX.getIdServicio());
                obj[1] = servicio.getNombre();
                obj[2] = servicio.getPrecio();
                obj[3] = detalleX.getCantidad();
                obj[4] = detalleX.getSubtotal();
                model.addRow(obj);
            }
            return Herramientas.dibujarTabla(model);
            
        } catch (Exception e) {
            return "";
        }
    }
}