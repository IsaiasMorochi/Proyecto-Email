package Software.Template;

import Bussines.NHorario;
import Nucleo.procesador.Anacom;
import Nucleo.utilidades.Herramientas;

public class MailHorario extends TemplateMail {

	NHorario h = new NHorario();
	
	@Override
	public boolean insertar(Anacom anacom, String correo) {
		anacom.Avanzar();
		int id_evento = anacom.Preanalisis().getAtributo();
		anacom.Avanzar();
		anacom.Avanzar();
		int id_dia =  anacom.Preanalisis().getAtributo();
		anacom.Avanzar();
		anacom.Avanzar();
		int id_lugar = anacom.Preanalisis().getAtributo();
		anacom.Avanzar();
		anacom.Avanzar();
		String inicio = Herramientas.quitarComillas(anacom.Preanalisis().getToStr());
		anacom.Avanzar();
		anacom.Avanzar();
		String fin = Herramientas.quitarComillas(anacom.Preanalisis().getToStr());
		
		return h.registrar(id_evento, id_dia, id_lugar, inicio, fin);
	}

	@Override
	public boolean modificar(Anacom anacom, String correo) {
		anacom.Avanzar();
		int id = anacom.Preanalisis().getAtributo();
		anacom.Avanzar();
		anacom.Avanzar();
		String inicio = Herramientas.quitarComillas(anacom.Preanalisis().getToStr());
		anacom.Avanzar();
		anacom.Avanzar();
		String fin = Herramientas.quitarComillas(anacom.Preanalisis().getToStr());
		
		return h.modificar(id, inicio, fin);
	}

	@Override
	public boolean eliminar(Anacom anacom, String correo) {
		anacom.Avanzar();
		int id = anacom.Preanalisis().getAtributo();
		
		return this.h.eliminar(id, correo);
	}

	@Override
	public String listar() {
		return this.h.Mostrar();
	}

	@Override
	public String messageCreate(boolean sw) {
		return (sw) ? "Horario registrado exitosamente con id: " + h.getHorario().autoincrement + h.getHorario().toString() : "No se pudo registrar el Horario";
	}

	@Override
	public String messageEdit(boolean sw) {
		return (sw) ? "Horario modificado exitosamente con id: " + h.getHorario().autoincrement + h.getHorario().toString() : "No se pudo modificar el Horario";
	}

	@Override
	public String messageRemove(boolean sw) {
		return (sw) ? "Horario eliminado exitosamente con id: " + h.getHorario().autoincrement + h.getHorario().toString() : "No se pudo eliminar el Horario";
	}

	@Override
	public String messageFindAll(boolean sw) {
		return (sw) ? "Listado de Horarios: " : "No se pudo encontrar en listado de Horarios";
	}

}
