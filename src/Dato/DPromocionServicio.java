package Dato;

import java.util.List;

/**
 * @author Saulo
 * @version 1.0
 * @created 16-may-2018 12:48:23
 */
public class DPromocionServicio extends Plantilla{

    private int idServicio;
    private int idPromocion;

    public DPromocionServicio(){

    }

    public int getIdPromocion() {
        return idPromocion;
    }

    public int getIdServicio() {
        return idServicio;
    }

    
    public void setIdPromocion(int idPromocion) {
        this.idPromocion = idPromocion;
    }

    public void setIdServicio(int idServicio) {
        this.idServicio = idServicio;
    }

    @Override
    protected String registrar() {
        return "insert into PromocionServicio(idServicio,idPromocion) values("
                +idServicio+ ","
                +idPromocion
                + ")";
    }

    @Override
    protected String modificar() {
        return "";
    }

    @Override
    protected String borrar() {
        return "delete from PromocionServicio where idPromocion="+idPromocion +" and "+"idServicio="+idServicio;
    }

    @Override
    protected String listado() {
        return "select * from PromocionServicio where idPromocion= "+idPromocion;
    }
    
    public DPromocionServicio buscar(int idPromocion,int idServicio){
        List<Object> objectPromocionServicio = this.buscar("select * from PromocionServicio where idPromocion="+idPromocion+ " and idServicio ="+idServicio);
        if (objectPromocionServicio==null || objectPromocionServicio.isEmpty()) {
            return null;
        }
        DPromocionServicio promocionServicio = new DPromocionServicio();
        promocionServicio.setIdServicio(Integer.valueOf(objectPromocionServicio.get(0).toString()));
        promocionServicio.setIdPromocion(Integer.valueOf(objectPromocionServicio.get(1).toString()));
        return promocionServicio;
    }
    
    public DPromocion buscarServicioPromocion(int idServicio) {
        List<Object> objectPromocion = this.buscar("select distinct nombre,descuento from promocion p,promocionServicio ps "
                + "where p.estado="+true
                + " and ps.idServicio="+idServicio + " and (CURRENT_DATE BETWEEN fechainicio and fechafin) ");
        if (objectPromocion==null || objectPromocion.isEmpty()) {
            return null;
        }
        DPromocion promocion = new DPromocion();
        promocion.setNombre(objectPromocion.get(0).toString());
        promocion.setDescuento(Float.valueOf(objectPromocion.get(1).toString()));
        return promocion;
    }

    @Override
    protected int cantidadAtributos() {
        return 2;
    }
}