package Bussines;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Data.DDetalla_Venta;
import Data.DPersona;
import Nucleo.utilidades.Utils;

public class NDetalle_Venta {

	private DDetalla_Venta detalle;

	public NDetalle_Venta() {
		this.detalle = DDetalla_Venta.getInstance();
	}
	
	public DDetalla_Venta getDetalle_Venta() {
		return detalle;
	}

	public boolean registrar(int id_evento, int id_usuario, int id_persona, int id_venta, String nro_comprobante, String fecha_comprobante){
		this.detalle.setId_evento(id_evento);
		this.detalle.setId_usuario(id_usuario);
		this.detalle.setId_persona(id_persona);
		this.detalle.setId_venta(id_venta);
		this.detalle.setNro_comprobante(nro_comprobante);
		this.detalle.setFecha_comprobante(fecha_comprobante);
		this.detalle.setCreated_at(Utils.dateToString(new Date()));
		
		return this.detalle.insertar();
	}
	
	public boolean modificar(int id, String nro_comprobante,String fecha_comprobante) {
		this.detalle.setId(id);
		this.detalle.setNro_comprobante(nro_comprobante);
		this.detalle.setFecha_comprobante(fecha_comprobante);
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
	            objectY.setFecha_comprobante(objetoX.get(5).toString());
				objectY.setNro_comprobante(objetoX.get(6).toString());
	            
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
                    "\nID Evento: " + objetoX.getId_evento() +
					"\nFecha Comprobante: " + objetoX.getFecha_comprobante() +
					"\nNro Comprobante: " + objetoX.getNro_comprobante() +
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
