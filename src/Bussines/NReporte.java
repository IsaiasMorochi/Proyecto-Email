package Bussines;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Data.DEvento;

public class NReporte {
	
	private DEvento evento;
//	private DPersona cliente;
	
	public NReporte(){
		this.evento = new DEvento();
//		this.cliente = new DPersona();
	}
		    
	public List<ResultSet> mostrarReporte(){
        List<ResultSet> datos = new ArrayList<>();
        datos.add(evento.obtenerReporte());
//	        datos.add(servicio.obtenerReporte());
//	        datos.add(cliente.obtenerReporte());
        return datos;
	 }
	    
//    public List<ResultSet> mostrarEstadistica(){
//        List<ResultSet> datos = new ArrayList<>();
//        System.out.println("Esta obteniendo los datos");
//        datos.add(evento.obtenerEstadistica());
//	        datos.add(servicio.obtenerEstadistica());
//	        datos.add(cliente.obtenerEstadistica());
//	        datos.add(proforma.obtenerEstadistica());
//	        datos.add(zona.obtenerEstadistica());
//        return datos;
//    }

}
