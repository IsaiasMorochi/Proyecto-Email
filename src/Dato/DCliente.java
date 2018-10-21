package Dato;

import java.sql.ResultSet;

/**
 * @author Saulo
 * @version 1.0
 * @created 16-may-2018 12:47:37
 */

public class DCliente extends Plantilla{

    private int idUsuario;

    public DCliente(){
        
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    
    @Override
    protected String registrar() {
        //"insert into cliente(id,direccion,web,vistos,publicaciones) 
        //values(" + id + ",'" + direccion + "','" + web + "'," + vistos + "," + publicaciones + ")";
        return "insert into Cliente(idUsuario) values("
                + idUsuario + ")";
    }

    @Override
    protected String modificar() {
        return "";
    }

    @Override
    protected String borrar() {
        return "";
    }

    @Override
    protected String listado() {
        return"";
    }

    @Override
    protected int cantidadAtributos() {
        return 1;
    }
    
    public ResultSet obtenerReporte(){
        String consulta = " select us.nombre as nombre, COUNT(us.id) as cantidad "
                + " from usuario us, cliente cl, evento ev, pedido pe, proforma pr "
                + " where us.id=cl.idUsuario and cl.idUsuario=ev.idCliente and cl.idUsuario=pe.idCliente and cl.idUsuario=pr.idCliente"
                + " group by us.nombre ";
        return consultarDatos(consulta);
    }
    
    public ResultSet obtenerEstadistica(){
        String consulta = " select us.nombre as nombre, SUM(pe.total + ev.total) as Total "
                + " from usuario us, cliente cl, evento ev, pedido pe "
                + " where us.id=cl.idUsuario and cl.idUsuario=ev.idCliente and cl.idUsuario=pe.idCliente "
                + " group by us.nombre ";
        return consultarDatos(consulta);
    }
    
}