package Dato;

import java.util.List;

/**
 * @author Saulo
 * @version 1.0
 * @created 16-may-2018 12:48:14
 */
public class DPedido extends Plantilla{

    private int id;
    private String fecha;
    private String direccion;
    private float total;
    private boolean estado;
    private int idZona;
    private int idCliente;
    private int idServicio;

    public DPedido(){

    }

    public int getId() {
        return id;
    }

    public String getFecha() {
        return fecha;
    }

    public String getDireccion() {
        return direccion;
    }

    public float getTotal() {
        return total;
    }

    public boolean getEstado() {
        return estado;
    }

    public int getIdServicio() {
        return idServicio;
    }

    public int getIdZona() {
        return idZona;
    }

    public int getIdCliente() {
        return idCliente;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public void setIdServicio(int idServicio) {
        this.idServicio = idServicio;
    }

    public void setIdZona(int idZona) {
        this.idZona = idZona;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }
    
    @Override
    protected String registrar() {
        return "insert into Pedido(fecha,direccion,total,estado,idZona,idCliente,idServicio) values("
                +"CURRENT_DATE,"
                +"'"+direccion+ "',"
                +total+ ","
                +estado+ ","
                +idZona+ ","
                +idCliente+ ","
                +idServicio
                + ")";
    }

    @Override
    protected String modificar() {
        return "update Pedido set "
                //+"fecha =" +"'"+fecha+ "',"
                +"direccion = " +"'"+direccion+ "',"
                +"total = " +total+ ","
                //+"estado = " +estado+ ","
                +"idZona = " +idZona+ ","
                //+"idCliente = " +idCliente+ ","
                +"idServicio=" +idServicio
                + " where id=" +id;
    }
    
    public DPedido buscar(int idPedido){
        List<Object> servicio =(List<Object>) buscar("select * from Pedido where id="+idPedido);
        if (servicio!=null && !(servicio.isEmpty())) {
            DPedido dPedido=new DPedido();
            dPedido.setId(Integer.valueOf(servicio.get(0).toString()));
            dPedido.setFecha(servicio.get(1).toString());
            dPedido.setDireccion(servicio.get(2).toString());
            dPedido.setTotal(Float.valueOf(servicio.get(3).toString()));
            dPedido.setEstado(Boolean.valueOf(servicio.get(4).toString()));
            dPedido.setIdZona(Integer.valueOf(servicio.get(5).toString()));
            dPedido.setIdCliente(Integer.valueOf(servicio.get(6).toString()));
            dPedido.setIdServicio(Integer.valueOf(servicio.get(7).toString()));
            return dPedido;
        }
        return null;
    }

    @Override
    protected String borrar() {
        return "update Pedido set "
                +"estado = false"
                + " where id=" +id;
    }

    @Override
    protected String listado() {
        return "select * from Pedido";
    }

    @Override
    protected int cantidadAtributos() {
        return 8;
    }
}