package Dato;

import java.sql.ResultSet;
import java.util.List;

/**
 * @author Saulo
 * @version 1.0
 * @created 16-may-2018 12:48:25
 */
public class DServicio extends Plantilla{

    private int id;
    private String nombre;
    private String descripcion;
    private float precio;
    private int tipo;
    private boolean estado;

    public DServicio(){
        
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public float getPrecio() {
        return precio;
    }

    public int getTipo() {
        return tipo;
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

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    @Override
    protected String registrar() {
        return "insert into Servicio(nombre,Descripcion,precio,tipo,estado) values("
                +"'"+nombre+ "',"
                +"'"+descripcion+ "',"
                +precio+ ","
                +tipo+ ","
                +estado
                + ")";
    }

    @Override
    protected String modificar() {
        return "update Servicio set "
                + "nombre='"+nombre+"',"
                + "Descripcion='"+descripcion+"',"
                + "precio="+precio+","
                + "tipo="+tipo
                + " where id="+id;
    }
    
    public DServicio buscar(int idServicio){
        List<Object> servicio =(List<Object>) buscar("select * from servicio where id="+idServicio);
        if (servicio!=null && !(servicio.isEmpty())) {
            DServicio dServicio=new DServicio();
            dServicio.setId(Integer.valueOf(servicio.get(0).toString()));
            dServicio.setNombre(servicio.get(1).toString());
            dServicio.setDescripcion(servicio.get(2).toString());
            dServicio.setPrecio(Float.valueOf(servicio.get(3).toString()));
            dServicio.setTipo(Byte.valueOf(servicio.get(4).toString()));
            
            
            return dServicio;
        }
        return null;
    }
    
    @Override
    protected String borrar() {
        return "update Servicio set "
                + "estado="+false
                + " where id="+id;
    }

    @Override
    protected String listado() {
        return "select * from Servicio";
    }

    @Override
    protected int cantidadAtributos() {
        return 6;
    }
    
    public ResultSet obtenerReporte(){
        String consulta = " select se.nombre as nombre, COUNT(se.id) as Cantidad "
                + " from servicio se, detalleevento de, detalleproforma dp, pedido pe "
                + " where se.id = de.idServicio and se.id = dp.idServicio and se.id = pe.idServicio "
                + " group by se.nombre ";
        return consultarDatos(consulta);
    }
    
    public ResultSet obtenerEstadistica(){
        String consulta = " select se.nombre as nombre, SUM(pe.total + de.subtotal) as Total "
                + " from servicio se, detalleevento de, pedido pe "
                + " where se.id = de.idServicio and se.id = pe.idServicio "
                + " group by se.nombre ";
        return consultarDatos(consulta);
    }
    
}