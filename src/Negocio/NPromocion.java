package Negocio;

import Dato.DPromocion;
import Dato.DPromocionServicio;
import Dato.DServicio;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import nucleo.utilidades.Herramientas;

/**
 * @author Saulo
 * @version 1.0
 * @created 16-may-2018 12:48:21
 */
public class NPromocion {

    private DPromocion promocion;
    private DPromocionServicio detalle;

    public NPromocion() {

        promocion = new DPromocion();
        detalle = new DPromocionServicio();
    }

    public DPromocion getPromocion() {
        return this.promocion;
    }

    public void setPromocion(DPromocion promocion) {
        this.promocion = promocion;
    }

    public DPromocionServicio getDetalle() {
        return detalle;
    }

    public boolean registrarPromocion(String nombre, float descuento, String fechaInicio, String fechaFin) {
        this.promocion.setNombre(nombre);
        this.promocion.setDescuento(descuento);
        this.promocion.setFechaInicio(fechaInicio);
        this.promocion.setFechaFin(fechaFin);
        this.promocion.setEstado(true);
        return this.promocion.insertar();
    }

    public boolean modificarPromocion(int id, String nombre, float descuento, String fechaInicio, String fechaFin) {
        this.promocion = this.promocion.buscar(id);
        if (this.promocion == null) {
            return false;
        }
        this.promocion.setId(id);
        this.promocion.setNombre(nombre);
        this.promocion.setDescuento(descuento);
        this.promocion.setFechaInicio(fechaInicio);
        this.promocion.setFechaFin(fechaFin);
        return this.promocion.actualizar();
    }
    
    
    public boolean agregarServicio(int idPromociones, int idServicios){
        this.detalle.setIdPromocion(idPromociones);
        this.detalle.setIdServicio(idServicios);
        return this.detalle.insertar();
    }
    
    public boolean quitarServicio(int idPromociones, int idServicios){
        this.detalle.setIdPromocion(idPromociones);
        this.detalle.setIdServicio(idServicios);
        return this.detalle.eliminar();
    }
    
    public boolean borrarPromocion(int id) {
        this.promocion.setId(id);
        this.promocion.setEstado(false);
        return this.promocion.eliminar();
    }

    public List<DPromocion> listarPromociones() {
        List<DPromocion> listaP = new ArrayList<>();
        List<Object> listaObject = (List<Object>) this.promocion.listar();

        if (listaObject == null || listaObject.isEmpty()) {
            return new ArrayList<>();
        }
        for (Object promocionN : listaObject) {
            List<Object> promocionX = (List<Object>) promocionN;
            this.promocion = new DPromocion();
            this.promocion.setId(Integer.valueOf(promocionX.get(0).toString()));
            this.promocion.setNombre(promocionX.get(1).toString());
            this.promocion.setDescuento(Float.valueOf(promocionX.get(2).toString()));
            this.promocion.setFechaInicio(promocionX.get(3).toString());
            this.promocion.setFechaFin(promocionX.get(4).toString());
            this.promocion.setEstado(Boolean.valueOf(promocionX.get(5).toString()));
           listaP.add(promocion);
        }
        return listaP;
    }

    public List<DPromocion> listarPromocionesVigentes() {
        promocion.setFechaFin("v");
        List<DPromocion> listaP = new ArrayList<>();
        List<Object> listaObject = (List<Object>) this.promocion.listar();
        if (listaObject == null || listaObject.isEmpty()) {
            return new ArrayList<>();
        }

        for (Object promocionN : listaObject) {
            List<Object> promocionX = (List<Object>) promocionN;
            this.promocion = new DPromocion();
            this.promocion.setId(Integer.valueOf(promocionX.get(0).toString()));
            this.promocion.setNombre(promocionX.get(1).toString());
            this.promocion.setDescuento(Float.valueOf(promocionX.get(2).toString()));
            this.promocion.setFechaInicio(promocionX.get(3).toString());
            this.promocion.setFechaFin(promocionX.get(4).toString());
            this.promocion.setEstado(Boolean.valueOf(promocionX.get(5).toString()));
            listaP.add(promocion);
        }
        return listaP;
    }
    
    public List<DPromocionServicio> listarServiciosPromociones(int idPromocion){
        detalle.setIdPromocion(idPromocion);
        List<Object> listaObject = detalle.listar();
        if (listaObject==null || listaObject.isEmpty()) {
            return new ArrayList<>();
        }
        List<DPromocionServicio> listaServicios = new ArrayList<>();
        for (Object object : listaObject) {
            List<Object> objectServicio = (List<Object>)object;
            DPromocionServicio detallePromocion = new DPromocionServicio();
          
            detallePromocion.setIdServicio(Integer.valueOf(objectServicio.get(0).toString()));
            detallePromocion.setIdPromocion(Integer.valueOf(objectServicio.get(1).toString()));
            listaServicios.add(detallePromocion);
        }
        return listaServicios;
    }
    
    public String mostrarPromocion(int idPromocion){
        this.promocion = this.promocion.buscar(idPromocion);
        if (promocion==null) {
             return "No existe el codigo de promocion introducido";
        }
        String resultado="Promoción\n\n"
                + "Codigo: "+ this.promocion.getId()+"\n"
                + "Nombre: "+ this.promocion.getNombre()+"\n"
                + "Descuento: "+ this.promocion.getDescuento()+"%\n"
                + "Fecha Inicio: "+ this.promocion.getFechaInicio()+"\n"
                + "Fecha Final: "+ this.promocion.getFechaFin()+"\n"
                +"Estado: "
                ;
    
        resultado +=this.promocion.getEstado()?"Vigente":"No Vigente";
        return resultado+"\n\n";
    }
    
    public String mostrarDetallePromocion(int idPromocion){
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new Object[]{"Codigo","Servicio","Precio","Precio Promocion"});
        List<DPromocionServicio> listarDetalles = this.listarServiciosPromociones(idPromocion);
        try {
            this.promocion=this.promocion.buscar(idPromocion);
            if (promocion==null) {
                return "No existe detalles de esta promocion";
            }
            
            for (DPromocionServicio detalleX : listarDetalles) {
                Object[] obj = new Object[4];
                obj[0] = detalleX.getIdServicio();
                    DServicio servicio=new DServicio();
                  servicio= servicio.buscar(detalleX.getIdServicio());
                obj[1] = servicio.getNombre();
                obj[2] = servicio.getPrecio();
                obj[3] =servicio.getPrecio()-(servicio.getPrecio()*(promocion.getDescuento()/100));
                model.addRow(obj);
            }
            return Herramientas.dibujarTabla(model);
        } catch (Exception e) {
            
            System.out.println(e);
            return "Ocurrio un problema intente de nuevo NPromociones linea 111";
        }
    }
    /*
    * funcion para mostrar lista de todas las promociones realizadas
    */
    public String mostrarListaPromociones() {
        List<DPromocion> listaPromocion = this.listarPromociones();
        String resultado = "Promociones\n\n\n";
        for (DPromocion promocionX : listaPromocion) {
            resultado+= this.mostrarPromocion(promocionX.getId())+"\n"
                    +this.mostrarDetallePromocion(promocionX.getId())+
                    "\n\n";
            
        }
        return resultado;
    }
    /*
    *@see funcion para mostrar lista impresa de promociones vigentes
    */
    public String mostrarListaPromocionesVigentes() {
        List<DPromocion> listaPromocion = this.listarPromocionesVigentes();
        String resultado = "Promociones\n\n\n";
        for (DPromocion promocionX : listaPromocion) {
            resultado+= this.mostrarPromocion(promocionX.getId())+"\n"
                    +this.mostrarDetallePromocion(promocionX.getId())+
                    "\n\n";
        }
        return resultado;
    }
}
