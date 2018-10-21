package Negocio;

import Dato.DDetalleEvento;
import Dato.DEvento;
import Dato.DFoto;
import Dato.DFotografo;
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
 * @created 16-may-2018 12:48:07
 */
public class NEvento {

    DEvento evento;
    DDetalleEvento detalle;
    DFoto foto;

    public NEvento(){

        evento = new DEvento();
        detalle = new DDetalleEvento();
        foto = new DFoto();
    }

    public DEvento getEvento() {
        return evento;
    }

    public DDetalleEvento getDetalle() {
        return detalle;
    }

    public DFoto getFoto() {
        return foto;
    }

    public void setEvento(DEvento evento) {
        this.evento = evento;
    }

    public void setFoto(DFoto foto) {
        this.foto = foto;
    }
    
    public boolean registrarEvento(String nombre, String codigoAcceso, String fecha, int idZona, int idCliente) {
        this.evento.setNombre(nombre);
        this.evento.setCodigoAcceso(codigoAcceso);
        this.evento.setTotal(0);
        this.evento.setIdZona(idZona);
        this.evento.setIdCliente(idCliente);
        this.evento.setFechaEvento(fecha);
        this.evento.setEstado(true);
        return evento.insertar();
    }

    public boolean modificarEvento(int idEvento, String nombre, String codigoAcceso, String fecha, int idZona) {
        evento = evento.buscar(idEvento);
        this.evento.setNombre(nombre);
        this.evento.setCodigoAcceso(codigoAcceso);
        this.evento.setTotal(0);
        this.evento.setIdZona(idZona);
        this.evento.setFechaEvento(fecha);
        return evento.actualizar();
    }

    public boolean registrarDetalleEvento(int idServicio, int idEvento) {
        DServicio servicio = new DServicio();
        servicio = servicio.buscar(idServicio);
        evento = new DEvento();
        evento = evento.buscar(idEvento);
        if (evento != null && servicio != null) {
            evento.setTotal(evento.getTotal() + servicio.getPrecio());
            this.detalle.setIdEvento(idEvento);
            this.detalle.setIdServicio(idServicio);
            DPromocionServicio detallePromocion = new DPromocionServicio();
          // promocion = new DPromocion();
             DPromocion promocion = detallePromocion.buscarServicioPromocion(idServicio);
            if (promocion != null) {
                this.detalle.setSubtotal(servicio.getPrecio() - ((promocion.getDescuento() / 100) * servicio.getPrecio()));
            } else {
                this.detalle.setSubtotal(servicio.getPrecio());
            }
            return evento.actualizar() && this.detalle.insertar();
        }
        return false;
    }

    public boolean registrarFoto(String url, int idEvento) {
        foto.setUrl(url);
        foto.setIdEvento(idEvento);
        return foto.insertar();
    }
    
    public String verListaFoto(int idEvento){
        this.foto.setIdEvento(idEvento);
        this.evento = this.evento.buscar(idEvento);
        this.foto.setIdEvento(idEvento);
        List<Object> listaObject = foto.listar();
        if (this.evento==null || listaObject==null || listaObject.isEmpty()) {
            return null;
        }
        List<String> listaFotos = new ArrayList<>();
        String resultado = "Evento "+evento.getId()+" "+evento.getNombre()+"\n\n"
                +"Codigo De Foto\n";
        for (Object object : listaObject) {
            List<Object> fotoX = (List<Object>)object;
            resultado+=fotoX.get(0).toString()+"\n";
        }
        return resultado;
    }
    
    public List<String> verFotos(int idEvento,String codigoAcceso){
        this.foto.setIdEvento(idEvento);
        List<Object> listaObject = foto.listar();
        DEvento evento = this.evento.buscar(idEvento);
        boolean b = evento.getCodigoAcceso().compareTo(codigoAcceso) != 0;
        if (evento==null || listaObject==null || listaObject.isEmpty() || b) {
            return null;
        }
        List<String> listaFotos = new ArrayList<>();
        for (Object object : listaObject) {
            List<Object> fotoX = (List<Object>)object;
            listaFotos.add(fotoX.get(1).toString());
        }
        return listaFotos;
    }
    public boolean borrarEvento(int idEvento) {
        evento.setId(idEvento);
        return evento.eliminar();
    }

    public boolean borrarDetalle(int idServicio, int  idEvento) {
        evento = new DEvento();
        evento = evento.buscar(idEvento);
        detalle = new DDetalleEvento();
        detalle = detalle.buscar(idEvento, idServicio);
        if (evento != null && detalle != null) {
            evento.setTotal(evento.getTotal() - detalle.getSubtotal());
            return evento.actualizar() && this.detalle.eliminar();
        }
        return false;
    }

    public List<DEvento> listarEvento() {
        List<DEvento> listaEventos = new ArrayList<>();
        List<Object> listaObject = this.evento.listar();
        if (listaObject != null && listaObject.isEmpty()) {
            return null;
        }
        for (Object object : listaObject) {
            List<Object> eventoX = (List<Object>) object;
            this.evento = new DEvento();
            this.evento = this.evento.buscar(Integer.valueOf(eventoX.get(0).toString()));
            listaEventos.add(evento);
        }
        return listaEventos;
    }
    
    public String mostrarListaEvento(){
        String resultado = "Lista De Eventos\n-----------------------------------------\n";
        List<Object> listaObject = this.evento.listar();
        if (listaObject==null || listaObject.isEmpty()) {
            return "";
        }
        for (Object object : listaObject) {
            List<Object> eventoX = (List<Object>)object;
            this.evento = new DEvento();
            this.evento = this.evento.buscar(Integer.valueOf(eventoX.get(0).toString()));
            resultado+="Codigo: "+this.evento.getId()+"\n"+"Nombre: "+this.evento.getNombre()+"\n";
            resultado+="-------------------------------------\n";
        }
        return resultado;
    }

    public List<DDetalleEvento> listarDetalles(int idEvento) {
        List<DDetalleEvento> listaDetalles = new ArrayList<>();
        this.detalle.setIdEvento(idEvento);
        List<Object> listaObject = (List<Object>) this.detalle.listar();
        for (Object object : listaObject) {
            List<Object> objectX = (List<Object>) object;
            this.detalle.setSubtotal(Float.valueOf(objectX.get(0).toString()));
            this.detalle.setIdServicio(Integer.valueOf(objectX.get(2).toString()));
            this.detalle.setIdEvento(Integer.valueOf(objectX.get(1).toString()));
            listaDetalles.add(detalle);
        }
        return listaDetalles;
    }
//nose
    public String mostrarEvento(int idEvento, String correo) {
        this.evento = new DEvento();
        this.evento = this.evento.buscar(idEvento);
        DUsuario usuario = new DUsuario();
        DZona zona = new DZona();
        if (evento == null && usuario == null) {
            return "";
        }
        zona = zona.buscar(this.evento.getIdZona());
        usuario = usuario.buscar(evento.getIdCliente());
            String resultado = "Evento\n\n";
        resultado
                += "Codigo: " + this.evento.getId() + "\n"
                + "Fecha: " + this.evento.getFechaEvento() + "\n"
                + "Nombre: " + usuario.getNombre() + "\n"
                + "Codigo de acceso: " + this.evento.getCodigoAcceso() + "\n"
                + "Zona: " + zona.getNombre() + "\n";
        resultado += (this.evento.getEstado() ? "Habilitado" : "Cancelado") + "\n\n\n" + this.tablaDetalles(this.evento.getId());
        return resultado += "\n Total Pago: " + this.evento.getTotal();
    }

    public String tablaDetalles(int idEvento) {
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new Object[]{"Codigo", "Servicio", "Precio", "Precio Promocion", "Encargado"});
        List<DDetalleEvento> listarDetalles = this.listarDetalles(idEvento);
        try {
            for(DDetalleEvento detalleX : listarDetalles) {
                Object[] obj = new Object[5];
                obj[0] = detalleX.getIdServicio();
                DServicio servicio = new DServicio();
              servicio =  servicio.buscar(detalleX.getIdServicio());
                obj[1] = servicio.getNombre();
                obj[2] = servicio.getPrecio();
                obj[3] = detalleX.getSubtotal();

                DFotografo fotografo = new DFotografo();
                fotografo.setDireccion("b");
                fotografo.setIdServicio(servicio.getId());
                List<Object> listarFotografosDisponibles = fotografo.listar();
                if (listarFotografosDisponibles == null || listarFotografosDisponibles.isEmpty()) {
                    fotografo = new DFotografo();
                    listarFotografosDisponibles = fotografo.listar();
                }
                String nombre = "";
                for (Object fotografoN : listarFotografosDisponibles) {
                    List<Object> fotografoX = (List<Object>) fotografoN;
                    if (Boolean.valueOf(fotografoX.get(2).toString())) {
                        DUsuario usuario = new DUsuario();
                        usuario = usuario.buscar(Integer.valueOf(fotografoX.get(3).toString()));
                        nombre = usuario.getNombre();
                        NUsuario nUsuario = new NUsuario();
                        DFotografo fotogr = new DFotografo();
                        fotogr = fotogr.buscar(usuario.getId());
                        nUsuario.cambiarDisponibilidad(fotogr);
                    }
                }

                if (nombre.isEmpty()) {
                    List<Object> fotografoX = (List<Object>) listarFotografosDisponibles.get(0);
                    DUsuario usuario = new DUsuario();
                    usuario = usuario.buscar(Integer.valueOf(fotografoX.get(3).toString()));
                    nombre = usuario.getNombre();
                }
                obj[4] = nombre;
                model.addRow(obj);
            }
            return Herramientas.dibujarTabla(model);

        } catch (Exception e) {
            return "";
        }
    }
}
