package Bussines;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Data.DDetalla_Venta;
import Dato.DUsuario;
import nucleo.utilidades.Utils;

public class NDetalle_Venta {

	private DDetalla_Venta detalle;

	public NDetalle_Venta() {
		this.detalle = DDetalla_Venta.getInstance();
	}
	
	public DDetalla_Venta getDetalle_Venta() {
		return detalle;
	}

	public boolean registrar(int id_venta, int id_persona, int id_usuario, int id_evento){
		this.detalle.setId_venta(id_venta);
		this.detalle.setId_persona(id_persona);
		this.detalle.setId_usuario(id_usuario);
		this.detalle.setId_evento(id_evento);
		this.detalle.setCreated_at(Utils.dateToString(new Date()));
		
		return this.detalle.insertar();
	}
	
	public boolean modificar(int id, int id_venta, int id_persona, int id_usuario, int id_evento) {
		this.detalle.setId(id);
		this.detalle.setId_venta(id_venta);
		this.detalle.setId_persona(id_persona);
		this.detalle.setId_usuario(id_usuario);
		this.detalle.setId_evento(id_evento);
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
	
	private List<DDetalla_Venta> listar() {
	        List<Object> lista = (List<Object>) this.detalle.listar();
	        List<DDetalla_Venta> listaServicio= new ArrayList<>();
	        for (Object objecto : lista) {
	            List<Object> objetoX = (List<Object>) objecto;
	            DDetalla_Venta objectY = DDetalla_Venta.getInstance();
	            objectY.setId(Integer.valueOf(objetoX.get(0).toString()));
	            objectY.setId_venta(Integer.valueOf(objetoX.get(1).toString()));
	            objectY.setId_persona(Integer.valueOf(objetoX.get(2).toString()));
	            objectY.setId_usuario(Integer.valueOf(objetoX.get(3).toString()));
	            objectY.setId_evento(Integer.valueOf(objetoX.get(4).toString()));
	            
	            listaServicio.add(objectY);
	        }
	        return listaServicio;
	 }
	 
	public String Mostrar() {
        List<DDetalla_Venta> listarObjetos = this.listar();
        String resultado = "Dias\n\n";
        for (DDetalla_Venta objetoX : listarObjetos) {
            resultado = resultado +
                    "Codigo: " + objetoX.getId()+
                    "\nID Venta: " + objetoX.getId_venta() +
                    "\nID Persona: " + objetoX.getId_persona() +
                    "\nID Usuario: " + objetoX.getId_usuario() +
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
