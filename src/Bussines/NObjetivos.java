package Bussines;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Data.DObjetivos;
import Data.DPersona;
import Nucleo.utilidades.Utils;

public class NObjetivos {
	
	private DObjetivos detalle;

	public NObjetivos() {
		this.detalle = DObjetivos.getInstance();
	}
	
	public DObjetivos getObjetivos() {
		return detalle;
	}

	public boolean registrar(String nombre, String descripcion, int id_evento){
		this.detalle.setId_evento(id_evento);
		this.detalle.setNombre(nombre);
		this.detalle.setDescripcion(descripcion);
		this.detalle.setCreated_at(Utils.dateToString(new Date()));
		
		return this.detalle.insertar();
	}
	
	public boolean modificar(int id, String nombre, String descripcion) {
		this.detalle.setId(id);
		this.detalle.setNombre(nombre);
		this.detalle.setDescripcion(descripcion);
		this.detalle.setUpdated_at(Utils.dateToString(new Date()));
		
		return this.detalle.actualizar();
    }
	
	public boolean eliminar(int id, String correo ){
		DPersona usuario = new DPersona();
	    usuario = usuario.buscarPorCorreo(correo);
//	        if (usuario.getTipo()== 3) {
	            this.detalle.setId(id);
	            this.detalle.setDeleted_at(Utils.dateToString(new Date()));
	            return this.detalle.eliminar();
//	        }
//	    return false;
	}
	
	private List<DObjetivos> listar() {
        List<Object> lista = (List<Object>) this.detalle.listar();
        List<DObjetivos> listaServicio= new ArrayList<>();
        for (Object objecto : lista) {
            List<Object> objetoX = (List<Object>) objecto;
            DObjetivos objectY = new DObjetivos();
            
            objectY.setId(Integer.valueOf(objetoX.get(0).toString()));
            objectY.setNombre(objetoX.get(1).toString());
            objectY.setDescripcion(objetoX.get(2).toString());
            objectY.setId_evento(Integer.valueOf(objetoX.get(3).toString()));
            
            listaServicio.add(objectY);
        }
        return listaServicio;
	 }
	 
	public String Mostrar() {
        List<DObjetivos> listarObjetos = this.listar();
        String resultado = "Listado de Objetivos\n\n";
        for (DObjetivos objetoX : listarObjetos) {
            resultado = resultado +
                    "Codigo: " + objetoX.getId()+
                    "\nNombre: " + objetoX.getNombre() +
                    "\nDescripcion: " + objetoX.getDescripcion() +
                    "\nID Evento: " + objetoX.getId_evento() + 
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
