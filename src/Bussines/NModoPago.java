package Bussines;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Data.DModoPago;
import Data.DPersona;
import Data.DRequisito;
import nucleo.utilidades.Utils;

public class NModoPago {

	private DModoPago obj;

	public NModoPago() {
		this.obj = DModoPago.getInstance();
	}
	
	public DModoPago getModoPago() {
		return obj;
	}

	public boolean registrar(String descripcion, int id_evento){
	    this.obj.setDescripcion(descripcion);
		this.obj.setId_evento(id_evento);
		this.obj.setCreated_at(Utils.dateToString(new Date()));
		
		return this.obj.insertar();
	}
	
	public boolean modificar(int id, String descripcion) {
		this.obj.setId(id);
		this.obj.setDescripcion(descripcion);
		this.obj.setUpdated_at(Utils.dateToString(new Date()));
		
		return this.obj.actualizar();
    }
	
	public boolean eliminar(int id, String correo ){
		DPersona usuario = new DPersona();
	    usuario = usuario.buscarPorCorreo(correo);
//	        if (usuario.getTipo()== 3) {
	            this.obj.setId(id);
	            this.obj.setDeleted_at(Utils.dateToString(new Date()));
	            return this.obj.eliminar();
//	        }
//	    return false;
	}
	
	private List<DModoPago> listar() {
        List<Object> lista = (List<Object>) this.obj.listar();
        List<DModoPago> listaServicio= new ArrayList<>();
        for (Object objecto : lista) {
            List<Object> objetoX = (List<Object>) objecto;
            DModoPago objectY = new DModoPago();
            
            objectY.setId(Integer.valueOf(objetoX.get(0).toString()));
            objectY.setDescripcion(objetoX.get(1).toString());
            objectY.setId_evento(Integer.valueOf(objetoX.get(2).toString()));
            
            listaServicio.add(objectY);
        }
        return listaServicio;
	 }
	 
	public String Mostrar() {
        List<DModoPago> listarObjetos = this.listar();
        String resultado = "Listado de Pagos\n\n";
        for (DModoPago objetoX : listarObjetos) {
            resultado = resultado +
                    "Codigo: " + objetoX.getId() +
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
