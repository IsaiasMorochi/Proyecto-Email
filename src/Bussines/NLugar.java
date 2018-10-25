package Bussines;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Data.DLugar;
import Dato.DUsuario;
import nucleo.utilidades.Utils;

public class NLugar {
	
	private DLugar lugar = DLugar.getInstance();
	
	public DLugar getLugar(){
		return this.lugar;
	}
		
	public boolean registrar(String descripcion){
		this.lugar.setDescripcion(descripcion);
		this.lugar.setCreated_at(Utils.dateToString(new Date()));
		return this.lugar.insertar();
	}
	
	public boolean modificar(int id, String descripcion) {
		this.lugar.setId(id);
		this.lugar.setDescripcion(descripcion);
		this.lugar.setUpdated_at(Utils.dateToString(new Date()));
		return this.lugar.actualizar();
    }
	
	public boolean eliminar(int id, String correo ){
		DUsuario usuario = new DUsuario();
	    usuario = usuario.buscarPorCorreo(correo);
//	        if (usuario.getTipo()== 3) {
	            this.lugar.setDeleted_at(Utils.dateToString(new Date()));
	            this.lugar.setId(id);
	            return this.lugar.eliminar();
//	        }
//	    return false;
	}
	
	private List<DLugar> listar() {
	        List<Object> lista = (List<Object>) this.lugar.listar();
	        List<DLugar> listaServicio=new ArrayList<>();
	        for (Object object : lista) {
	            List<Object> objetoX = (List<Object>) object;
	            DLugar lugars = new DLugar();
	            lugars.setId(Integer.valueOf(objetoX.get(0).toString()));
	            lugars.setDescripcion(objetoX.get(1).toString());
	            listaServicio.add(lugars);
	        }
	        return listaServicio;
	  }
	 
	public String Mostrar() {
        List<DLugar> listaLugar = this.listar();
        String resultado="Lugares\n\n";
        for (DLugar objetoX : listaLugar) {
            resultado = resultado +
                    "Codigo: " + objetoX.getId()+
                    "\nDescripcion: " + objetoX.getDescripcion();
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
