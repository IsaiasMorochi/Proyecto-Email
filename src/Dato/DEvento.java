package Dato;

import java.util.List;

/**
 * @author Saulo
 * @version 1.0
 * @created 16-may-2018 12:48:07
 */
public class DEvento extends Plantilla{

    private int id;
    private String nombre;
    private String codigoAcceso;
    private String fechaEvento;
    private float total;
    private int idZona;
    private int idCliente;
    private boolean estado;

    public DEvento(){

    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCodigoAcceso() {
        return codigoAcceso;
    }

    public String getFechaEvento() {
        return fechaEvento;
    }

    public float getTotal() {
        return total;
    }

    public boolean getEstado() {
        return estado;
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

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCodigoAcceso(String codigoAcceso) {
        this.codigoAcceso = codigoAcceso;
    }

    public void setFechaEvento(String fechaEvento) {
        this.fechaEvento = fechaEvento;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public void setIdZona(int idZona) {
        this.idZona = idZona;
    }

    public void setIdCliente(int idClient) {
        this.idCliente = idClient;
    }
    
    @Override
    protected String registrar() {
        return "insert into Evento(nombre,codigoAcceso,fechaEvento,total,idZona,idCliente,estado) values("
                +"'"+nombre+ "',"
                +"'"+codigoAcceso+ "',"
                +"'"+fechaEvento+"',"
                +total+ ","
                +idZona+ ","
                +idCliente+ ","
                +estado
                + ")";
    }

    @Override
    protected String modificar() {
        return "update Evento set "
                +"nombre=" +"'"+nombre+ "',"
                +"codigoAcceso=" +"'"+codigoAcceso+ "',"
                +"fechaEvento=" +"'"+fechaEvento+ "',"
                +"total=" +total+ ","
                +"idZona=" +idZona+ ","
                +"idCliente=" +idCliente+ ","
                +"estado=" +estado
                + " where id=" +id;
    }

    @Override
    protected String borrar() {
        return "update Evento set "
                +"estado=" +false
                + " where id=" +id;
    }

    @Override
    protected String listado() {
        return "select * from Evento";
    }

    @Override
    protected int cantidadAtributos() {
        return 8;
    }

    public DEvento buscar(int idEvento) {
        List<Object> evento =(List<Object>) buscar("select * from Evento where id="+idEvento);
        if (evento!=null && !(evento.isEmpty())) {
            DEvento dEvento=new DEvento();
            dEvento.setId(Integer.valueOf(evento.get(0).toString()));
            dEvento.setNombre(evento.get(1).toString());
            dEvento.setCodigoAcceso(evento.get(2).toString());
            dEvento.setFechaEvento(evento.get(3).toString());
            dEvento.setTotal(Float.valueOf(evento.get(4).toString()));
            dEvento.setIdZona(Integer.valueOf(evento.get(5).toString()));
            dEvento.setIdCliente(Integer.valueOf(evento.get(6).toString()));
            dEvento.setEstado(Boolean.valueOf(evento.get(7).toString()));
            return dEvento;
        }
        return null;
    }
}