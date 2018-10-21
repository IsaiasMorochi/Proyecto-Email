package Dato;

import java.util.List;

/**
 * @author Saulo
 * @version 1.0
 * @created 16-may-2018 12:47:54
 */
public class DDetalleEvento extends Plantilla{

    private float subtotal;
    private int idEvento;
    private int idServicio;

    public DDetalleEvento(){

    }

    public float getSubtotal() {
        return subtotal;
    }

    public int getIdServicio() {
        return idServicio;
    }

    public int getIdEvento() {
        return idEvento;
    }

    public void setSubtotal(float subtotal) {
        this.subtotal = subtotal;
    }

    public void setIdServicio(int idServicio) {
        this.idServicio = idServicio;
    }

    public void setIdEvento(int idEvento) {
        this.idEvento = idEvento;
    }

    @Override
    protected String registrar() {
        return "insert into DetalleEvento(subtotal,idEvento,idServicio) values("
                +subtotal+ ","
                +idEvento+ ","
                +idServicio
                + ")";
    }

    @Override
    protected String modificar() {
        return "update DetalleEvento set "
                +"subtotal=" +subtotal
                + " where idEvento=" +idEvento +" and "+"idServicio="+idServicio;
    }

    @Override
    protected String borrar() {
        return "delete from DetalleEvento where idEvento=" +idEvento +" and "+"idServicio="+idServicio;
    }

    @Override
    protected String listado() {
        return "select * from DetalleEvento where idEvento = "+idEvento;
    }

    @Override
    protected int cantidadAtributos() {
        return 3;
    }

    public DDetalleEvento buscar(int idEvento, int idServicio) {
        List<Object> pedidodetalle =(List<Object>) buscar("select * from DetalleEvento "
                + "where idServicio="+idServicio + " and idEvento="+idEvento);
        if (pedidodetalle!=null && !(pedidodetalle.isEmpty())) {
            DDetalleEvento dDetalle=new DDetalleEvento();
            dDetalle.setSubtotal(Float.valueOf(pedidodetalle.get(0).toString()));
            System.out.println(pedidodetalle.get(1).toString());
            dDetalle.setIdEvento(Integer.valueOf(pedidodetalle.get(1).toString()));
            dDetalle.setIdServicio(Integer.valueOf(pedidodetalle.get(2).toString()));
            return dDetalle;
        }
        return null;
    }
}