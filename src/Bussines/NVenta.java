package Bussines;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Data.DVenta;
import Nucleo.utilidades.Utils;

public class NVenta {

	private DVenta obj;

	public NVenta() {
		this.obj = DVenta.getInstance();
	}
	
	public DVenta getVenta() {
		return obj;
	}

	public boolean registrar(String fecha){
		this.obj.setFecha(fecha);
		this.obj.setCreated_at(Utils.dateToString(new Date()));
		
		return this.obj.insertar();
	}
	
	public boolean modificar() {
		return false;
    }
	
	public boolean eliminar(int id, String correo ){
	    return false;
	}
	
	private List<DVenta> listar() {
        List<Object> lista = (List<Object>) this.obj.listar();
        List<DVenta> listaServicio= new ArrayList<>();
        for (Object objecto : lista) {
            List<Object> objetoX = (List<Object>) objecto;
            DVenta objectY = new DVenta();
            
            objectY.setId(Integer.valueOf(objetoX.get(0).toString()));
            objectY.setFecha(objetoX.get(1).toString());
                      
            listaServicio.add(objectY);
        }
        return listaServicio;
	 }
	 
	public String Mostrar() {
        List<DVenta> listarObjetos = this.listar();
        String resultado = "Listado de Ventas\n\n";
        for (DVenta objetoX : listarObjetos) {
            resultado = resultado +
                    "Codigo: " + objetoX.getId() +
                    "\nFecha: " + objetoX.getFecha() +
                    "\n\n"
                    ;
//            if (!objetoX.getDeleted_at().equals(null)) {
//                resultado = resultado + 
//                        "\nEstado: Habilitada"+
//                        "\n------------------------------------------------------\n";
//            }else{
//                resultado = resultado + 
//                        "\nEstado: No Habilitada"+
//                        "\n------------------------------------------------------\n";
//            }
        }
        return resultado;
    }

}
