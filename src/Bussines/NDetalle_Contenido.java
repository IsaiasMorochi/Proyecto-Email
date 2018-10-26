package Bussines;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Data.DDetalla_Venta;
import Data.DDetalle_Contenido;
import Data.Template;
import Dato.DUsuario;
import nucleo.utilidades.Utils;

public class NDetalle_Contenido {


	private DDetalle_Contenido detalle;

	public NDetalle_Contenido() {
		this.detalle = DDetalle_Contenido.getInstance();
	}
	
	public DDetalle_Contenido getDetalle_Contenido() {
		return detalle;
	}

	public boolean registrar(int id_contenido, String descripcion){
		this.detalle.setId_contenido(id_contenido);
		this.detalle.setDescripcion(descripcion);
		this.detalle.setCreated_at(Utils.dateToString(new Date()));
		
		return this.detalle.insertar();
	}
	
	public boolean modificar(int id, int id_contenido, String descripcion) {
		this.detalle.setId(id);
		this.detalle.setDescripcion(descripcion);
		this.detalle.setUpdated_at(Utils.dateToString(new Date()));
		
		return this.detalle.actualizar();
    }
	
	public boolean eliminar(int id, String correo ){
		DUsuario usuario = new DUsuario();
	    usuario = usuario.buscarPorCorreo(correo);
//	        if (usuario.getTipo()== 3) {
	            this.detalle.setId(id);
	            this.detalle.setDeleted_at(Utils.dateToString(new Date()));
	            return this.detalle.eliminar();
//	        }
//	    return false;
	}
	
	private List<DDetalle_Contenido> listar() {
	        List<Object> lista = (List<Object>) this.detalle.listar();
	        List<DDetalle_Contenido> listaServicio= new ArrayList<>();
	        for (Object objecto : lista) {
	            List<Object> objetoX = (List<Object>) objecto;
	            DDetalle_Contenido objectY = DDetalle_Contenido.getInstance();
	            objectY.setId(Integer.valueOf(objetoX.get(0).toString()));
	            objectY.setId_contenido(Integer.valueOf(objetoX.get(1).toString()));
	            objectY.setDescripcion(objetoX.get(2).toString());
	            
	            listaServicio.add(objectY);
	        }
	        return listaServicio;
	 }
	 
	public String Mostrar() {
        List<DDetalle_Contenido> listarObjetos = this.listar();
        String resultado = "Detalle de Contenidos\n\n";
        for (DDetalle_Contenido objetoX : listarObjetos) {
            resultado = resultado +
                    "Codigo: " + objetoX.getId()+
                    "\nID Contenido: " + objetoX.getId_contenido() +
                    "\nDescripcion: " + objetoX.getDescripcion()                  
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
