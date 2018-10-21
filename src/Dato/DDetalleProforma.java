package Dato;

import java.util.List;

/**
 * @author Saulo
 * @version 1.0
 * @created 16-may-2018 12:48:05
 */
public class DDetalleProforma extends Plantilla {

    private float subtotal;
    private int cantidad;
    private int idServicio;
    private int idProforma;

    public DDetalleProforma(){

    }

    public float getSubtotal() {
        return subtotal;
    }

    public int getCantidad() {
        return cantidad;
    }

    public int getIdProforma() {
        return idProforma;
    }

    public int getIdServicio() {
        return idServicio;
    }

    public void setSubtotal(float subtotal) {
        this.subtotal = subtotal;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setIdProforma(int idProforma) {
        this.idProforma = idProforma;
    }

    public void setIdServicio(int idServicio) {
        this.idServicio = idServicio;
    }
    
    @Override
    protected String registrar() {
        return "insert into DetalleProforma(subtotal,cantidad,idServicio,idProforma) values("
                +subtotal+ ","
                +cantidad+ ","
                +idServicio+ ","
                +idProforma
                + ")";
    }

    @Override
    protected String modificar() {
        return "update DetalleProforma set "
                +"cantidad=" +cantidad+","
                +"subtotal=" +subtotal
                + " where idProforma=" +idProforma +" and "+"idServicio="+idServicio;
    }

    @Override
    protected String borrar() {
        return "delete from DetalleProforma where idProforma="+idProforma +" and "+"idServicio="+idServicio;
    }

    @Override
    protected String listado() {
        return "select * from DetalleProforma where idProforma= "+idProforma;
    }

    @Override
    protected int cantidadAtributos() {
        return 4;
    }

    public DDetalleProforma buscar(int idProforma,int idServicio) {
        List<Object> proforma =(List<Object>) buscar("select * from DetalleProforma "
                + "where idServicio="+idServicio + " and idProforma="+idProforma);
        if (proforma!=null && !(proforma.isEmpty())) {
            DDetalleProforma dDetalle=new DDetalleProforma();
            dDetalle.setSubtotal(Float.valueOf(proforma.get(0).toString()));
            dDetalle.setCantidad(Integer.valueOf(proforma.get(1).toString()));
            dDetalle.setIdServicio(Integer.valueOf(proforma.get(2).toString()));
            dDetalle.setIdProforma(Integer.valueOf(proforma.get(3).toString()));
            return dDetalle;
        }
        return null;
    }
}