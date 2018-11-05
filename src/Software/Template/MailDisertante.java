package Software.Template;

import Bussines.NDisertante;
import Nucleo.procesador.Anacom;
import Nucleo.utilidades.Herramientas;

public class MailDisertante extends TemplateMail {

	NDisertante d = new NDisertante();
	
	@Override
	public boolean insertar(Anacom anacom, String correo) {
		anacom.Avanzar();
		int id_evento = anacom.Preanalisis().getAtributo();
		anacom.Avanzar();
		anacom.Avanzar();
		String nombre = Herramientas.quitarComillas(anacom.Preanalisis().getToStr());	
		anacom.Avanzar();
		anacom.Avanzar();
	    String descripcion = Herramientas.quitarComillas(anacom.Preanalisis().getToStr());	

	    return this.d.registrar(id_evento, nombre, descripcion);
	}

	@Override
	public boolean modificar(Anacom anacom, String correo) {
		anacom.Avanzar();
		int id = anacom.Preanalisis().getAtributo();
		anacom.Avanzar();
		anacom.Avanzar();
		String nombre = Herramientas.quitarComillas(anacom.Preanalisis().getToStr());	
		anacom.Avanzar();
		anacom.Avanzar();
	    String descripcion = Herramientas.quitarComillas(anacom.Preanalisis().getToStr());	
	   
		return this.d.modificar(id, nombre, descripcion);
	}

	@Override
	public boolean eliminar(Anacom anacom, String correo) {
		anacom.Avanzar();
		int id = anacom.Preanalisis().getAtributo();
		
		return this.d.eliminar(id, correo);
	}

	@Override
	public String listar() {
		return d.Mostrar();
	}

	@Override
	public String messageCreate(boolean sw) {
		return (sw) ? "Disertante registrado exitosamente con id: " + d.getDisertante().autoincrement + d.getDisertante().toString() : "No se pudo registrar el Disertante";
	}

	@Override
	public String messageEdit(boolean sw) {
		return (sw) ? "Disertante modificado exitosamente con id: " + d.getDisertante().autoincrement + d.getDisertante().toString() : "No se pudo modificar el Disertante";
	}

	@Override
	public String messageRemove(boolean sw) {
		return (sw) ? "Disertante eliminado exitosamente con id: " + d.getDisertante().autoincrement + d.getDisertante().toString() : "No se pudo eliminar el Disertante";
	}

	@Override
	public String messageFindAll(boolean sw) {
		return (sw) ? "Listado de Disertantes: " : "No se pudo encontrar en listado de Disertantes";
	}

}
