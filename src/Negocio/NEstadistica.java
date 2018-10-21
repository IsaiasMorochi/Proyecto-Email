
package Negocio;

import Dato.DCliente;
import Dato.DProforma;
import Dato.DServicio;
import Dato.DZona;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Sandoval-PC
 */
public class NEstadistica {
    
    DServicio servicio;
    DCliente cliente;
    DProforma proforma;
    DZona zona;
    
    public NEstadistica(){
        this.servicio = new DServicio();
        this.cliente = new DCliente();
        this.proforma = new DProforma();
        this.zona = new DZona();
    }
    
    public List<ResultSet> mostrarReporte(){
        List<ResultSet> datos = new ArrayList<>();
        datos.add(servicio.obtenerReporte());
        datos.add(cliente.obtenerReporte());
        datos.add(proforma.obtenerReporte());
        datos.add(zona.obtenerReporte());
        return datos;
    }
    
    public List<ResultSet> mostrarEstadistica(){
        List<ResultSet> datos = new ArrayList<>();
        System.out.println("Esta obteniendo los datos");
        datos.add(servicio.obtenerEstadistica());
        datos.add(cliente.obtenerEstadistica());
        datos.add(proforma.obtenerEstadistica());
        datos.add(zona.obtenerEstadistica());
        return datos;
    }
}
