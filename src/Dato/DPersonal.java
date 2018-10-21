package Dato;

import java.util.List;

/**
 * @author Saulo
 * @version 1.0
 * @created 16-may-2018 12:48:16
 */
public class DPersonal extends Plantilla {

    private String fechaIngreso;
    private int idUsuario;

    public DPersonal(){

    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    
    @Override
    protected String registrar() {
        return "insert into Personal(fechaIngreso,idUsuario) values("
                +"CURRENT_DATE,"
                +idUsuario
                + ")";
    }

    @Override
    protected String modificar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected String borrar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected String listado() {
        return "select * from Usuario, Personal where id=idUsuario";
    }

    @Override
    protected int cantidadAtributos() {
        return 2;
    }

    public DPersonal buscar(int idPersonal) {
        List<Object> objetPersonal =buscar("select * from Personal where idUsuario="+idPersonal);
        DPersonal personal = new DPersonal();
        personal.setFechaIngreso(objetPersonal.get(0).toString());
        personal.setIdUsuario(Integer.valueOf(objetPersonal.get(1).toString()));
        return personal;
    }
}