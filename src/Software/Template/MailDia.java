package Software.Template;

import Bussines.NDia;
import Nucleo.procesador.Anacom;
import Nucleo.utilidades.Herramientas;

public class MailDia extends TemplateMail {
	
	private NDia d = new NDia();

	@Override
	public boolean insertar(Anacom anacom, String correo) {
		anacom.Avanzar();
		String dia = Herramientas.quitarComillas(anacom.Preanalisis().getToStr());
		
		return d.registrar(dia);
	}

	@Override
	public boolean modificar(Anacom anacom, String correo) {
		anacom.Avanzar();
		int id = anacom.Preanalisis().getAtributo();
		anacom.Avanzar();
		anacom.Avanzar();
		String dia = Herramientas.quitarComillas(anacom.Preanalisis().getToStr());
		
		return d.modificar(id, dia);
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
		return (sw) ? "Lugar registrado exitosamente con id: " + d.getDia().autoincrement + ", " + d.getDia().toString() : "No se pudo registrar el dia";
	}

	@Override
	public String messageEdit(boolean sw) {
		return (sw) ? "DDia modificado exitosamente con id: " + d.getDia().autoincrement + ", " +  d.getDia().toString() : "No se pudo modificar el dia";
	}

	@Override
	public String messageRemove(boolean sw) {
		return (sw) ? "DDia eliminado exitosamente con id: " + d.getDia().autoincrement + ", " +  d.getDia().toString() : "No se pudo eliminar el dia";
	}

	@Override
	public String messageFindAll(boolean sw) {
		return (sw) ? "Listado de dias: " : "No se pudo encontrar en listado de dias";
	}
}
