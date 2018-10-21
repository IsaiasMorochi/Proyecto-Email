package Dato;

import java.sql.ResultSet;
import java.util.List;

/**
 * @author Saulo
 * @version 1.0
 * @created 16-may-2018 12:48:19
 */
public class DProforma extends Plantilla{

    private int id;
    private String fecha;
    private float total;
    private int idCliente;
    
    public DProforma(){

    }

    public int getId() {
        return id;
    }

    public String getFecha() {
        return fecha;
    }

    public float getTotal() {
        return total;
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

    public void setTotal(float total) {
        this.total = total;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    @Override
    protected String registrar() {
        return "insert into Proforma(fecha,total,idCliente) values("
                +"CURRENT_DATE,"
                +total+ ","
                +idCliente
                + ")";
    }

    @Override
    protected String modificar() {
        return "update Proforma set "
                + "total="+total 
                + " where id="+id;
    }

    @Override
    protected String borrar() {
        return "delete from Proforma where id="+id;
    }

    @Override
    protected String listado() {
        return "select * from Proforma";
    }

    @Override
    protected int cantidadAtributos() {
        return 4;
    }

    public DProforma buscar(int id) {
        List<Object> proforma =(List<Object>) buscar("select * from Proforma where id="+id);
        if (proforma!=null && !(proforma.isEmpty())) {
            DProforma dProforma=new DProforma();
            dProforma.setId(Integer.valueOf(proforma.get(0).toString()));
            dProforma.setFecha(proforma.get(1).toString());
            dProforma.setTotal(Float.valueOf(proforma.get(2).toString()));
            dProforma.setIdCliente(Integer.valueOf(proforma.get(3).toString()));
            return dProforma;
        }
        return null;
    }
    
    public ResultSet obtenerReporte(){
        String consulta = " select se.nombre as nombre, COUNT(se.id) as cantidad "
                + " from proforma pr, detalleproforma dp, servicio se "
                + " where pr.id = dp.idProforma and dp.idServicio = se.id "
                + " group by se.nombre ";
        return consultarDatos(consulta);
    }
    
    public ResultSet obtenerEstadistica(){
        String consulta = " select se.nombre as nombre, SUM(pr.total) as Total "
                + " from proforma pr, detalleproforma dp, servicio se "
                + " where pr.id = dp.idProforma and dp.idServicio = se.id "
                + " group by se.nombre ";
        return consultarDatos(consulta);
    }
    
}