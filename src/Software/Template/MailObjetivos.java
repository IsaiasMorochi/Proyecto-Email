package Software.Template;

import Bussines.NObjetivos;
import Nucleo.procesador.Anacom;
import Nucleo.utilidades.Herramientas;

public class MailObjetivos extends TemplateMail {

	private NObjetivos d = new NObjetivos();
	
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

	    return this.d.registrar(nombre, descripcion, id_evento);
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
	   	    
	    return d.modificar(id, nombre, descripcion);
	}

	@Override
	public boolean eliminar(Anacom anacom, String correo) {
		anacom.Avanzar();
		int id = anacom.Preanalisis().getAtributo();
		
		return d.eliminar(id, correo);
	}

	@Override
	public String listar() {
		return d.Mostrar();
	}

	@Override
	public String messageCreate(boolean sw) {
		return (sw) ? "Objetivos registrado exitosamente con id: " + d.getObjetivos().autoincrement + d.getObjetivos().toString() : "No se pudo registrar el Objetivos" ;
	}

	@Override
	public String messageEdit(boolean sw) {
		return (sw) ? "Objetivos modificado exitosamente con id: " + d.getObjetivos().autoincrement + d.getObjetivos().toString() : "No se pudo modificar el Objetivos" ;
	}

	@Override
	public String messageRemove(boolean sw) {
		return (sw) ? "Objetivos eliminado exitosamente con id: " + d.getObjetivos().autoincrement + d.getObjetivos().toString() : "No se pudo eliminar el Objetivos";
	}

	@Override
	public String messageFindAll(boolean sw) {
		return (sw) ? "Listado de Objetivos: " : "No se pudo encontrar en listado de Objetivos";
	}

}
