package Bussines;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import Data.DDia;
import Data.DPersona;

import Nucleo.utilidades.Utils;

public class NDia {

	private DDia dia;
	
	public NDia(){
		this.dia = DDia.getInstance();
	}
	
	public DDia getDia() {
	    return dia;
	}
	
	public boolean registrar(String dia){
		this.dia.setDia(dia);
		this.dia.setCreated_at(Utils.dateToString(new Date()));
		return this.dia.insertar();
	}
	
	public boolean modificar(int id, String dia) {
		this.dia.setId(id);
		this.dia.setDia(dia);
		return this.dia.actualizar();
    }
	
	public boolean eliminar(int id, String correo ){
		DPersona usuario = new DPersona();
	    usuario = usuario.buscarPorCorreo(correo);
//	        if (usuario.getTipo()== 3) {
	            this.dia.setDeleted_at(Utils.dateToString(new Date()));
	            this.dia.setId(id);
	            return this.dia.eliminar();
//	        }
//	    return false;
	}
	
	private List<DDia> listar() {
	        List<Object> lista = (List<Object>) this.dia.listar();
	        List<DDia> listaServicio= new ArrayList<>();
	        for (Object objecto : lista) {
	            List<Object> objetoX = (List<Object>) objecto;
	            DDia dia = DDia.getInstance();
	            dia.setId(Integer.valueOf(objetoX.get(0).toString()));
	            dia.setDia(objetoX.get(1).toString());
	            dia.setCreated_at(objetoX.get(2).toString());
	            listaServicio.add(dia);
	        }
	        return listaServicio;
	 }
	 
	public String Mostrar() {
        List<DDia> listarObjetos = this.listar();
        String resultado = "Dias\n\n";
        for (DDia objetoX : listarObjetos) {
            resultado = resultado +
                    "Codigo: " + objetoX.getId()+
                    "\nDDia: " + objetoX.getDia();
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
