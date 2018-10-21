package Dato;

import java.util.List;

/**
 * @author Saulo
 * @version 1.0
 * @created 16-may-2018 12:47:58
 */
public class DDetallePedido extends Plantilla{

    private int cantidad;
    private float subtotal;
    private int idPedido;
    private int idEvento;

    public DDetallePedido(){

    }

    public int getCantidad() {
        return cantidad;
    }

    public float getSubtotal() {
        return subtotal;
    }

    public int getIdEvento() {
        return idEvento;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setSubtotal(float subtotal) {
        this.subtotal = subtotal;
    }

    public void setIdEvento(int idEvento) {
        this.idEvento = idEvento;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }
    
    @Override
    protected String registrar() {
        return "insert into DetallePedido(cantidad,subtotal,idPedido,idEvento) values("
                +cantidad+ ","
                +subtotal+ ","
                +idPedido+ ","
                +idEvento
                + ")";
    }

    @Override
    protected String modificar() {
        return "update DetallePedido set "
                +"cantidad=" +cantidad+","
                +"subtotal=" +subtotal
                + " where idPedido=" +idPedido +" and "+"idEvento="+idEvento;
    }

    @Override
    protected String borrar() {
        return "delete from DetallePedido where idPedido="+idPedido +" and "+"idEvento="+idEvento;
    }

    @Override
    protected String listado() {
        return "select * from DetallePedido where idPedido= "+idPedido;
    }

    @Override
    protected int cantidadAtributos() {
        return 4;
    }

    public DDetallePedido buscar(int idPedido, int idEvento) {
        List<Object> pedidodetalle =(List<Object>) buscar("select * from detallePedido "
                + "where idEvento="+idEvento + " and idPedido="+idPedido);
        System.out.println(pedidodetalle);
        if (pedidodetalle!=null && !(pedidodetalle.isEmpty())) {
            DDetallePedido dDetalle=new DDetallePedido();
            dDetalle.setCantidad(Integer.valueOf(pedidodetalle.get(0).toString()));
            dDetalle.setSubtotal(Float.valueOf(pedidodetalle.get(1).toString()));
            dDetalle.setIdPedido(Integer.valueOf(pedidodetalle.get(2).toString()));
            dDetalle.setIdEvento(Integer.valueOf(pedidodetalle.get(3).toString()));
            return dDetalle;
        }
        return null;
    }
}