package Dato;

import java.util.List;

/**
 * @author Saulo
 * @version 1.0
 * @created 16-may-2018 12:48:21
 */
public class DPromocion extends Plantilla{

    private int id;
    private String nombre;
    private float descuento;
    private String fechaInicio;
    private String fechaFin;
    private boolean estado;
    
    public DPromocion(){
        fechaFin="";
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public float getDescuento() {
        return descuento;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
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

    public void setDescuento(float descuento) {
        this.descuento = descuento;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }
    
    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    @Override
    protected String registrar() {
        return "insert into Promocion(nombre,descuento,fechaInicio,fechaFin,estado) values("
                +"'"+nombre+ "',"
                +descuento+ ","
                +"'"+fechaInicio+ "',"
                +"'"+fechaFin+ "',"
                +estado
                + ")";
    }

    @Override
    protected String modificar() {
        return "update Promocion set "
                + "nombre='"+nombre+"',"
                + "descuento="+descuento+","
                + "fechaInicio='"+fechaInicio+"',"
                + "fechaFin='"+fechaFin+"'"
                + " where id="+id;
    }

    @Override
    protected String borrar() {
        return "update Promocion set "
                + "estado="+ false
                + " where id="+id;
    }

    @Override
    protected String listado() {
        return fechaFin.isEmpty()?"select * from promocion where estado = true":"select * from promocion where CURRENT_DATE BETWEEN fechainicio and fechafin and estado = true";
    }

    @Override
    protected int cantidadAtributos() {
        return 6;
    }

    public DPromocion buscar(int id) {
        List<Object> objectPromocion = this.buscar("select * from Promocion where estado = true and id="+id);
        if (objectPromocion==null || objectPromocion.isEmpty()) {
            return null;
        }
        DPromocion promocion = new DPromocion();
        promocion.setId(Integer.valueOf(objectPromocion.get(0).toString()));
        promocion.setNombre(objectPromocion.get(1).toString());
        promocion.setDescuento(Float.valueOf(objectPromocion.get(2).toString()));
        promocion.setFechaInicio(objectPromocion.get(3).toString());
        promocion.setFechaFin(objectPromocion.get(4).toString());
        promocion.setEstado(Boolean.valueOf(objectPromocion.get(5).toString()));
        return promocion;
    }
}