package Bussines;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Data.DDetalla_Venta;
import Data.DDisertante;
import Dato.DUsuario;
import nucleo.utilidades.Utils;

public class NDisertante {
	
	private DDisertante disertante;

	public NDisertante() {
		this.disertante = DDisertante.getInstance();
	}
	
	public DDisertante getDisertante() {
		return disertante;
	}

	public boolean registrar(String nombre, String foto, String nacionalidad, int id_evento){
		this.disertante.setNombre(nombre);
		this.disertante.setFoto(foto);
		this.disertante.setNacionalidad(nacionalidad);
		this.disertante.setId_evento(id_evento);
		this.disertante.setCreated_at(Utils.dateToString(new Date()));
		
		return this.disertante.insertar();
	}
	
	public boolean modificar(int id, String nombre, String foto, String nacionalidad, int id_evento) {
		this.disertante.setId(id);
		this.disertante.setNombre(nombre);
		this.disertante.setFoto(foto);
		this.disertante.setNacionalidad(nacionalidad);
		this.disertante.setId_evento(id_evento);
		this.disertante.setUpdated_at(Utils.dateToString(new Date()));
		
		return this.disertante.actualizar();
    }
	
	public boolean eliminar(int id, String correo ){
		DUsuario usuario = new DUsuario();
	    usuario = usuario.buscarPorCorreo(correo);
//	        if (usuario.getTipo()== 3) {
	            this.disertante.setId(id);
	            this.disertante.setDeleted_at(Utils.dateToString(new Date()));
	            return this.disertante.eliminar();
//	        }
//	    return false;
	}
	
	private List<DDisertante> listar() {
	        List<Object> lista = (List<Object>) this.disertante.listar();
	        List<DDisertante> listaServicio= new ArrayList<>();
	        for (Object objecto : lista) {
	            List<Object> objetoX = (List<Object>) objecto;
	            DDisertante objectY = DDisertante.getInstance();
	            objectY.setId(Integer.valueOf(objetoX.get(0).toString()));
	            objectY.setNombre(objetoX.get(1).toString());
	            objectY.setFoto(objetoX.get(2).toString());
	            objectY.setNacionalidad(objetoX.get(3).toString());
	            objectY.setId_evento(Integer.valueOf(objetoX.get(4).toString()));
	            
	            listaServicio.add(objectY);
	        }
	        return listaServicio;
	 }
	 
	public String Mostrar() {
        List<DDisertante> listarObjetos = this.listar();
        String resultado = "Dias\n\n";
        for (DDisertante objetoX : listarObjetos) {
            resultado = resultado +
                    "Codigo: " + objetoX.getId() +
                    "\nID Nombre: " + objetoX.getNombre() +
                    "\nID Foto: " + objetoX.getFoto() +
                    "\nID Nacionalidad: " + objetoX.getNacionalidad() +
                    "\nID Evento: " + objetoX.getId_evento()
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
