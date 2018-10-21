package Negocio;

import Dato.DServicio;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Saulo
 * @version 1.0
 * @created 16-may-2018 12:48:25
 */
public class NServicio {
    private DServicio servicio;

    public NServicio(){
        servicio = new DServicio();
    }

    public DServicio getServicio() {
        return servicio;
    }

    public void setServicio(DServicio servicio) {
        this.servicio = servicio;
    }
    
    public boolean registrar(String nombre, String descripcion,float precio, int tipo) {
        this.servicio.setNombre(nombre);
        this.servicio.setDescripcion(descripcion);
        this.servicio.setPrecio(precio);
        this.servicio.setTipo(tipo);
        this.servicio.setEstado(true);
        return this.servicio.insertar();
    }

    public boolean modificar(int id, String nombre, String descripcion, float precio, int tipo) {
        this.servicio.setId(id);
        this.servicio.setNombre(nombre);
        this.servicio.setDescripcion(descripcion);
        this.servicio.setPrecio(precio);
        this.servicio.setTipo(tipo);
        return this.servicio.actualizar();
    }

    public boolean borrar(int id) {
        this.servicio.setId(id);
        return this.servicio.eliminar();
    }

    public List<DServicio> listar() {
        List<Object> lista=(List<Object>)this.servicio.listar();
        List<DServicio> listaServicio=new ArrayList<>();
        for (Object objectServicio : lista) {
            List<Object> servicioX = (List<Object>)objectServicio;
            servicio = new DServicio();
            servicio.setId(Integer.valueOf(servicioX.get(0).toString()));
            servicio.setNombre(servicioX.get(1).toString());
            servicio.setDescripcion(servicioX.get(2).toString());
            servicio.setPrecio(Float.valueOf(servicioX.get(3).toString()));
            servicio.setTipo(Integer.valueOf(servicioX.get(4).toString()));
            servicio.setEstado(Boolean.valueOf(servicioX.get(5).toString()));
            listaServicio.add(servicio);
        }
        return listaServicio;
    }
    
    public String mostrarLista() {
        List<DServicio> listaServicio=this.listar();
        String resultado="Servicios\n\n";
        for (DServicio servicioX : listaServicio) {
            resultado = resultado +
                    "Codigo: "+servicioX.getId() +
                    "\nNombre: "+servicioX.getNombre() +
                    "\nDescripción: "+servicioX.getDescripcion()+
                    "\nPrecio: "+servicioX.getPrecio()
                    ;
            switch (servicioX.getTipo()){
                case 1:
                    resultado = resultado +
                    "\nPara: Eventos";
                    break;
                case 2:
                    resultado = resultado +
                    "\nPara: Pedidos";
                    break;
            }
            if (servicioX.getEstado()) {
                resultado = resultado + 
                        "\nEstado: Habilitada"+
                        "\n------------------------------------------------------\n";
            }else{
                resultado = resultado + 
                        "\nEstado: No Habilitada"+
                        "\n------------------------------------------------------\n";
            }
        }
        return resultado;
    }
}