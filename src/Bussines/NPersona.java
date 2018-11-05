package Bussines;

import Data.DPersona;
import Data.DUsuario;
import Nucleo.utilidades.Utils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NPersona {
	
    private DPersona personaModel;
    private DUsuario usuarioModel;

    public NPersona() {
        personaModel = new DPersona();
        usuarioModel = new DUsuario();
    }
    
    public DPersona getPersona(){
    	return personaModel;
    }
    
    public Boolean registrar(String nombre, String telefono, String nacionalidad, String ci, String direccion, String tipo, String correo, String password){
        personaModel.setNombre(nombre); 
        personaModel.setTelefono(telefono);
        personaModel.setNacionalidad(nacionalidad);
        personaModel.setCi(ci);
        personaModel.setDireccion(direccion);
        personaModel.setTipo(tipo); 
        personaModel.setCreated_at(Utils.dateToString(new Date()));
        if(personaModel.insertar()){
            usuarioModel.setId_persona(personaModel.autoincrement);
            usuarioModel.setCorreo(correo);
            usuarioModel.setPassword(password);
            usuarioModel.setCreated_at(Utils.dateToString(new Date()));
            
            return usuarioModel.insertar();
        }
        return false;
    }
    
	public boolean modificar(int id, String tipo) {
		 personaModel.setId(id);
	     personaModel.setTipo(tipo); 
		 personaModel.setUpdated_at(Utils.dateToString(new Date()));
		
		return this.personaModel.actualizar();
    }    
    
	public boolean eliminar(int id, String correo ){
		DPersona usuario = new DPersona();
	    usuario = usuario.buscarPorCorreo(correo);
//	        if (usuario.getTipo()== 3) {
	            this.personaModel.setId(id);
	            this.personaModel.setDeleted_at(Utils.dateToString(new Date()));
	            return this.personaModel.eliminar();
//	        }
//	    return false;
	}
	    
    private List<DPersona> listar() {
        List<Object> lista = (List<Object>) this.personaModel.listar();
        List<DPersona> listaServicio= new ArrayList<>();
        for (Object objecto : lista) {
            List<Object> objetoX = (List<Object>) objecto;
            DPersona objectY = new DPersona();
            
            objectY.setId(Integer.valueOf(objetoX.get(0).toString()));
            objectY.setNombre(objetoX.get(1).toString());
            objectY.setTelefono(objetoX.get(2).toString());
            objectY.setCi(objetoX.get(2).toString());
            objectY.setNacionalidad(objetoX.get(3).toString());
            objectY.setDireccion(objetoX.get(4).toString());
                        
            listaServicio.add(objectY);
        }
        return listaServicio;
	 }
	 
	public String Mostrar() {
        List<DPersona> listarObjetos = this.listar();
        String resultado = "Listado de Usuarios\n\n";
        for (DPersona objetoX : listarObjetos) {
            resultado = resultado +
                    "Codigo: " + objetoX.getId() +
                    "\nNombre: " + objetoX.getNombre() +
                    "\nTelefono: " + objetoX.getTelefono() + 
                    "\nCI: " + objetoX.getTelefono() + 
                    "\nNacionalidad: " + objetoX.getNacionalidad() + 
                    "\nDireccion: " + objetoX.getDireccion() + 
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
