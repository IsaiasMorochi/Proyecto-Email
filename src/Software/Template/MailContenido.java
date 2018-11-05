package Software.Template;

import Bussines.NContenido;
import Nucleo.procesador.Anacom;
import Nucleo.utilidades.Herramientas;

public class MailContenido extends TemplateMail {
	
	private NContenido d = new NContenido();

	@Override
	public boolean insertar(Anacom anacom, String correo) {
		anacom.Avanzar();
		int id_evento = anacom.Preanalisis().getAtributo();
		anacom.Avanzar();
		anacom.Avanzar();
		String titulo = Herramientas.quitarComillas(anacom.Preanalisis().getToStr());
		
		return d.registrar(id_evento, titulo);	
	}

	@Override
	public boolean modificar(Anacom anacom, String correo) {
		anacom.Avanzar();
		int id = anacom.Preanalisis().getAtributo();
		anacom.Avanzar();
		anacom.Avanzar();
		String titulo = Herramientas.quitarComillas(anacom.Preanalisis().getToStr());
		
		return d.modificar(id, titulo);
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
		return (sw) ? "Contenido registrado exitosamente con id: " + d.getconContenido().autoincrement + d.getconContenido().toString(): "No se pudo registrar el contenido";
	}

	@Override
	public String messageEdit(boolean sw) {
		return (sw) ? "Contenido modificado exitosamente con id: " + d.getconContenido().autoincrement  + d.getconContenido().toString() : "No se pudo modificar el contenido";
	}

	@Override
	public String messageRemove(boolean sw) {
		return (sw) ? "Contenido eliminado exitosamente con id: " + d.getconContenido().autoincrement   + d.getconContenido().toString() : "No se pudo eliminar el contenido";
	}

	@Override
	public String messageFindAll(boolean sw) {
		return (sw) ? "Listado de contenidos: " : "No se pudo encontrar en listado de contenidos";
	}

}
