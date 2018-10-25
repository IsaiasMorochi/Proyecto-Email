package Software.Template;

import Bussines.NEvento;
import nucleo.procesador.Anacom;
import nucleo.utilidades.Herramientas;

public class MailEvento extends TemplateMail {
	
	NEvento e = new NEvento();

	@Override
	public boolean insertar(Anacom anacom, String correo) {
		anacom.Avanzar();
		String titulo = Herramientas.quitarComillas(anacom.Preanalisis().getToStr());
		anacom.Avanzar();
		anacom.Avanzar();
		String fecha_inicio  = Herramientas.quitarComillas(anacom.Preanalisis().getToStr());
		anacom.Avanzar();
		anacom.Avanzar();
		String fecha_fin = Herramientas.quitarComillas(anacom.Preanalisis().getToStr()); 
		anacom.Avanzar();
		anacom.Avanzar();
		float costo = anacom.Preanalisis().getAtributo();
		anacom.Avanzar();
		anacom.Avanzar();
		char tipo = (Herramientas.quitarComillas(anacom.Preanalisis().getToStr())).charAt(0);
	
		return e.registrar(titulo,fecha_inicio,fecha_fin, costo, tipo);
	}

	@Override
	public boolean modificar(Anacom anacom, String correo) {
		anacom.Avanzar();
		int id = anacom.Preanalisis().getAtributo();
		anacom.Avanzar();
		anacom.Avanzar();
		String titulo = Herramientas.quitarComillas(anacom.Preanalisis().getToStr());
		anacom.Avanzar();
		anacom.Avanzar();
		String fecha_inicio  = Herramientas.quitarComillas(anacom.Preanalisis().getToStr());
		anacom.Avanzar();
		anacom.Avanzar();
		String fecha_fin = Herramientas.quitarComillas(anacom.Preanalisis().getToStr()); 
		anacom.Avanzar();
		anacom.Avanzar();
		float costo = anacom.Preanalisis().getAtributo();
		anacom.Avanzar();
		anacom.Avanzar();
		char tipo = (Herramientas.quitarComillas(anacom.Preanalisis().getToStr())).charAt(0);
	
		return e.modificar(id, titulo, fecha_inicio, fecha_fin, costo, tipo); 
	}

	@Override
	public boolean eliminar(Anacom anacom, String correo) {
		anacom.Avanzar();
        int id = anacom.Preanalisis().getAtributo();
		return e.eliminar(id, correo);
	}

	@Override
	public String listar() {
		return e.Mostrar();
	}

	@Override
	public String messageCreate(boolean sw) {
		return (sw) ? "Evento registrado exitosamente con id: " + e.getEvento().toString() : "No se pudo registrar el evento" + e.getEvento().toString();
	}

	@Override
	public String messageEdit(boolean sw) {
		return (sw) ? "Evento modificado exitosamente con id: " + e.getEvento().toString() : "No se pudo modificar el evento" + e.getEvento().toString() ;
	}

	@Override
	public String messageRemove(boolean sw) {
		return (sw) ? "Evento eliminado exitosamente con id: " + e.getEvento().toString() : "No se pudo eliminar el evento" + e.getEvento().toString();
	}

	@Override
	public String messageFindAll(boolean sw) {
		return (sw) ? "Listado de eventos: " : "No se pudo encontrar en listado de eventos" ;
	}

}
