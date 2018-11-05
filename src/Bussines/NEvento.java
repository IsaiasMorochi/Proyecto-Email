package Bussines;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import Data.DEvento;
import Data.DPersona;
import Nucleo.utilidades.Utils;

public class NEvento {
	
	private DEvento evento;

	public NEvento() {
		this.evento = DEvento.getInstance();
	}
	
	public DEvento getEvento() {
		return evento;
	}

	public boolean registrar(String titulo, String fecha_inicio, String fecha_fin, float costo, char tipo){
		this.evento.setTitulo(titulo);
		this.evento.setFecha_inicio(fecha_inicio);
		this.evento.setFecha_fin(fecha_fin);
		this.evento.setCosto(costo);
		this.evento.setTipo(tipo);
		this.evento.setCreated_at(Utils.dateToString(new Date()));
		
		return this.evento.insertar();                        
	}
	
	public boolean modificar(int id,String titulo, String fecha_inicio, String fecha_fin, float costo, char tipo) {
		this.evento.setId(id);
		this.evento.setTitulo(titulo);
		this.evento.setFecha_inicio(fecha_inicio);
		this.evento.setFecha_fin(fecha_fin);
		this.evento.setCosto(costo);
		this.evento.setTipo(tipo);
		this.evento.setUpdated_at(Utils.dateToString(new Date()));
		return this.evento.actualizar();
    }
	
	public boolean eliminar(int id, String correo ){
		DPersona usuario = new DPersona();
	    usuario = usuario.buscarPorCorreo(correo);
//	        if (usuario.getTipo()== 3) {
	            this.evento.setDeleted_at(Utils.dateToString(new Date()));
	            this.evento.setId(id);
	            return this.evento.eliminar();
//	        }
//	    return false;
	}
	
	private List<DEvento> listar() {
	        List<Object> lista = (List<Object>) this.evento.listar();
	        List<DEvento> listaServicio= new ArrayList<>();
	        for (Object objecto : lista) {
	            List<Object> objetoX = (List<Object>) objecto;
	            DEvento objectY = new DEvento();
	            
	            objectY.setId(Integer.valueOf(objetoX.get(0).toString()));
	            objectY.setTitulo(objetoX.get(1).toString());
	            objectY.setFecha_inicio(objetoX.get(2).toString());
	            objectY.setFecha_fin(objetoX.get(3).toString());
	            objectY.setCosto(Float.valueOf(objetoX.get(4).toString()));
	            objectY.setTipo(objetoX.get(5).toString().charAt(0));
	            
	            listaServicio.add(objectY);
	        }
	        return listaServicio;
	 }
	 
	public String Mostrar() {
        List<DEvento> listarObjetos = this.listar();
        String resultado = "Eventos\n\n";
        for (DEvento objetoX : listarObjetos) {
            resultado = resultado +
                    "Codigo: " + objetoX.getId()+
                    "\nTitulo: " + objetoX.getTitulo() +
                    "\nFecha Inicio: " + objetoX.getFecha_inicio() +
                    "\nFecha Fin: " + objetoX.getFecha_fin() +
                    "\nCosto: " + objetoX.getCosto() +
                    "\nTipo: " + objetoX.getTipo() +
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
