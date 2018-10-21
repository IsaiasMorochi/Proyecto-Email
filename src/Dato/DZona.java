package Dato;

import java.sql.ResultSet;
import java.util.List;

/**
 * @author Saulo
 * @version 1.0
 * @created 16-may-2018 12:48:29
 */
public class DZona extends Plantilla{

    private int id;
    private String nombre;
    private boolean estado;

    public DZona(){

    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean getEstado() {
        return estado;
    }
    
    
    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    @Override
    protected String registrar() {
        return "insert into Zona(nombre,estado) values("
                +"'"+nombre+ "',"
                +estado
                + ")";
    }

    @Override
    protected String modificar() {
        return "update Zona set "
                + "nombre='"+nombre+"'"
                + " where id="+id;
    }
    
    public DZona buscar(int id){
        List<Object> zona = buscar("select * from Zona where id = "+id);
        DZona dZona = new DZona();
        dZona.setId(Integer.valueOf(zona.get(0).toString()));
        dZona.setNombre(zona.get(1).toString());
        dZona.setEstado(Boolean.valueOf(zona.get(2).toString()));
        return dZona;
    }
    
    @Override
    protected String borrar() {
        return "update Zona set "
                + "estado="+estado
                + " where id="+id;
    }

    @Override
    protected String listado() {
        return "select * from zona where estado=true";
    }

    @Override
    protected int cantidadAtributos() {
        return 3;
    }
    
    public ResultSet obtenerReporte(){
        String consulta = " select zo.nombre as nombre, COUNT(zo.id) as cantidad "
                + " from zona zo, evento ev, pedido pe "
                + " where zo.id = ev.idZona and zo.id = pe.idZona "
                + " group by zo.nombre ";
        return consultarDatos(consulta);
    }
    
    public ResultSet obtenerEstadistica(){
        String consulta = " select zo.nombre as nombre, SUM(ev.total + pe.total) as Total "
                + " from zona zo, evento ev, pedido pe "
                + " where zo.id = ev.idZona and zo.id = pe.idZona "
                + " group by zo.nombre ";
        return consultarDatos(consulta);
    }
}