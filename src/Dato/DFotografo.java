package Dato;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Saulo
 * @version 1.0
 * @created 16-may-2018 12:48:11
 */
public class DFotografo extends Plantilla {

    private String fechaIngreso;
    private String direccion;
    private int idUsuario;
    private int idServicio;
    private boolean disponible;
    
    public DFotografo(){
        direccion = new String();
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public String getDireccion() {
        return direccion;
    }

    public int getIdUsuario() {
        return idUsuario;
    }
    
    public int getIdServicio() {
        return idServicio;
    }

    public boolean getDisponible() {
        return disponible;
    }
    
    
    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    
    public void setIdServicio(int idServicio) {
        this.idServicio = idServicio;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
    
    @Override//CURRENT_DATE,
    protected String registrar() {
        return "insert into Fotografo(fechaIngreso,direccion,disponible,idUsuario,idServicio) values("
                +"CURRENT_DATE,"
                +"'"+direccion+ "',"
                +disponible+ ","
                +idUsuario+ ","
                +idServicio
                + ")";
    }

    @Override
    protected String modificar() {
        return "update Fotografo set "
                +"direccion = " +"'"+direccion+ "',"
                +"idServicio=" +idServicio
                +"disponible = "+disponible
                + " where id=" +idUsuario;
    }

    @Override
    protected String borrar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected String listado() {
        return direccion.isEmpty()?"select * from Fotografo":"select * from Fotografo where disponible=true and idServicio="+idServicio;
    }

    @Override
    protected int cantidadAtributos() {
        return 5;
    }

    public DFotografo buscar(int idFotografo) {
        List<Object> objetFotografo =buscar("select * from Fotografo where idUsuario="+idFotografo);
        DFotografo fotografo = new DFotografo();
        fotografo.setFechaIngreso(objetFotografo.get(0).toString());
        fotografo.setDireccion(objetFotografo.get(1).toString());
        fotografo.setDisponible(Boolean.valueOf(objetFotografo.get(2).toString()));
        fotografo.setIdUsuario(Integer.valueOf(objetFotografo.get(3).toString()));
        fotografo.setIdServicio(Integer.valueOf(objetFotografo.get(4).toString()));
        return fotografo;
    }
        
}