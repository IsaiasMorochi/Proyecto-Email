package Bussines;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Data.DEvento;
import Data.DHorario;
import Data.DPersona;
import nucleo.utilidades.Utils;

public class NHorario {

	private DHorario h;

	public NHorario() {
		this.h = DHorario.getInstance();
	}
	
	public DHorario getHorario() {
		return h;
	}

	public boolean registrar(int id_cronograma, int id_dia, int id_lugar, String inicio, String fin){
		this.h.setId_cronograma(id_cronograma);
		this.h.setId_dia(id_dia);
		this.h.setId_lugar(id_lugar);
		this.h.setInicio(inicio);
		this.h.setFin(fin);
		this.h.setCreated_at(Utils.dateToString(new Date()));
		
		return this.h.insertar();                        
	}
	
	public boolean modificar(int id, String inicio, String fin) {
		this.h.setId(id);
		this.h.setInicio(inicio);
		this.h.setFin(fin);
		this.h.setUpdated_at(Utils.dateToString(new Date()));
		return this.h.actualizar();
    }
	
	public boolean eliminar(int id, String correo ){
		DPersona usuario = new DPersona();
	    usuario = usuario.buscarPorCorreo(correo);
//	        if (usuario.getTipo()== 3) {
	            this.h.setDeleted_at(Utils.dateToString(new Date()));
	            this.h.setId(id);
	            return this.h.eliminar();
//	        }
//	    return false;
	}
	
	private List<DHorario> listar() {
	        List<Object> lista = (List<Object>) this.h.listar();
	        List<DHorario> listaServicio= new ArrayList<>();
	        for (Object objecto : lista) {
	            List<Object> objetoX = (List<Object>) objecto;
	            DHorario objectY = new DHorario();
	            
	            objectY.setId(Integer.valueOf(objetoX.get(0).toString()));
	            objectY.setId_cronograma(Integer.valueOf(objetoX.get(0).toString()));
	            objectY.setId_dia(Integer.valueOf(objetoX.get(0).toString()));
	            objectY.setId_lugar(Integer.valueOf(objetoX.get(0).toString()));
	            objectY.setInicio(objetoX.get(1).toString());
	            objectY.setFin(objetoX.get(2).toString());
	            
	            listaServicio.add(objectY);
	        }
	        return listaServicio;
	 }
	 
	public String Mostrar() {
        List<DHorario> listarObjetos = this.listar();
        String resultado = "Horaios\n\n";
        for (DHorario objetoX : listarObjetos) {
            resultado = resultado +
                    "Codigo: " + objetoX.getId()+
                    "\nID Cronograma: " + objetoX.getId_cronograma() +
                    "\nID Dia: " + objetoX.getId_dia() +
                    "\nID Lugar: " + objetoX.getId_lugar() +
                    "\nHora Inicio: " + objetoX.getInicio() +
                    "\nHora Fin: " + objetoX.getFin() +
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
