package Bussines;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Data.DContenido;
import Data.DPersona;

import nucleo.utilidades.Utils;

public class NContenido {

	private DContenido contenido;

	public NContenido() {
		this.contenido = DContenido.getInstance();
	}
	
	public DContenido getconContenido() {
		return contenido;
	}

	public boolean registrar(int id_evento, String titulo){
		this.contenido.setId_evento(id_evento);
		this.contenido.setTitulo(titulo);
		this.contenido.setCreated_at(Utils.dateToString(new Date()));
		
		return this.contenido.insertar();
	}
	
	public boolean modificar(int id, String titulo) {
		this.contenido.setId(id);
		this.contenido.setTitulo(titulo);
		this.contenido.setUpdated_at(Utils.dateToString(new Date()));
		
		return this.contenido.actualizar();
    }
	
	public boolean eliminar(int id, String correo ){
		DPersona usuario = new DPersona();
	    usuario = usuario.buscarPorCorreo(correo);
//	        if (usuario.getTipo()== 3) {
	            this.contenido.setId(id);
	            this.contenido.setDeleted_at(Utils.dateToString(new Date()));
	            return this.contenido.eliminar();
//	        }
//	    return false;
	}
	
	private List<DContenido> listar() {
	        List<Object> lista = (List<Object>) this.contenido.listar();
	        List<DContenido> listaServicio= new ArrayList<>();
	        for (Object objecto : lista) {
	            List<Object> objetoX = (List<Object>) objecto;
	            DContenido objectY = new DContenido();
	            
	            objectY.setId(Integer.valueOf(objetoX.get(0).toString()));
	            objectY.setId_evento(Integer.valueOf(objetoX.get(1).toString()));
	            objectY.setTitulo(objetoX.get(2).toString());
	        
	            listaServicio.add(objectY);
	        }
	        return listaServicio;
	 }
	 
	public String Mostrar() {
        List<DContenido> listarObjetos = this.listar();
        String resultado = "Contenidos\n\n";
        for (DContenido objetoX : listarObjetos) {
            resultado = resultado +
                    "Codigo: " + objetoX.getId()+
                    "\nID Evento: " + objetoX.getId_evento() +
                    "\nTitulo: " + objetoX.getTitulo() +
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
