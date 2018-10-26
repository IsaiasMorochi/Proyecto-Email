package Bussines;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Data.DCronograma;
import Data.DPersona;

import nucleo.utilidades.Utils;

public class NCronograma {
	
private DCronograma cronograma;
	
	public NCronograma(){
		this.cronograma = DCronograma.getInstance();
	}
	
	public DCronograma getCronograma() {
	    return cronograma;
	}
	
	public boolean registrar(int id_evento){
		this.cronograma.setId_evento(id_evento);
		this.cronograma.setCreated_at(Utils.dateToString(new Date()));
		return this.cronograma.insertar();
	}
	
	public boolean modificar(int id, int id_evento) {
		this.cronograma.setId(id);
		this.cronograma.setId_evento(id_evento);
		return this.cronograma.actualizar();
    }
	
	public boolean eliminar(int id, String correo ){
		DPersona usuario = new DPersona();
	    usuario = usuario.buscarPorCorreo(correo);
//	        if (usuario.getTipo()== 3) {
	            this.cronograma.setDeleted_at(Utils.dateToString(new Date()));
	            this.cronograma.setId(id);
	            return this.cronograma.eliminar();
//	        }
//	    return false;
	}
	
	private List<DCronograma> listar() {
	        List<Object> lista = (List<Object>) this.cronograma.listar();
	        List<DCronograma> listaServicio= new ArrayList<>();
	        for (Object objecto : lista) {
	            List<Object> objetoX = (List<Object>) objecto;
	            DCronograma objetoY = DCronograma.getInstance();
	            objetoY.setId(Integer.valueOf(objetoX.get(0).toString()));
	            objetoY.setId_evento(Integer.valueOf(objetoX.get(1).toString()));
	            objetoY.setCreated_at(objetoX.get(2).toString());
	            listaServicio.add(objetoY);
	        }
	        return listaServicio;
	 }
	 
	public String Mostrar() {
        List<DCronograma> listarObjetos = this.listar();
        String resultado = "Cronogramas\n\n";
        for (DCronograma objetoX : listarObjetos) {
            resultado = resultado +
                    "Codigo: " + objetoX.getId()+
                    "\nID Evento: " + objetoX.getId_evento();
                    ;
            if (!objetoX.getDeleted_at().equals(null)) {
                resultado = resultado + 
                        "\nEstado: Habilitada"+
                        "\n------------------------------------------------------\n";
            }else{
                resultado = resultado + 
                        "\nEstado: No Habilitada"+
                        "\n------------------------------------------------------\n";
            }
        }
        return resultado;
    }

}
