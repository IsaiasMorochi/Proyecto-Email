package Software.Template;

import Bussines.NCronograma;
import Nucleo.procesador.Anacom;
import Nucleo.utilidades.Herramientas;

public class MailCronograma extends TemplateMail {

	private NCronograma d = new NCronograma();
	
	@Override
	public boolean insertar(Anacom anacom, String correo) {
		anacom.Avanzar();
		int id_evento = anacom.Preanalisis().getAtributo();
		anacom.Avanzar();
		anacom.Avanzar();
		String titulo = Herramientas.quitarComillas(anacom.Preanalisis().getToStr());

		return this.d.registrar(id_evento, titulo);
	}

	@Override
	public boolean modificar(Anacom anacom, String correo) {
		// TODO Auto-generated method stub
		return false;
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
		return (sw) ? "Cronograma registrado exitosamente con id: " + d.getCronograma().autoincrement + d.getCronograma().toString() : "No se pudo registrar el cronograma";
	}

	@Override
	public String messageEdit(boolean sw) {
		return (sw) ? "Cronograma modificado exitosamente con id: " + d.getCronograma().autoincrement + d.getCronograma().toString() : "No se pudo modificar el cronograma";
	}

	@Override                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  
	public String messageRemove(boolean sw) {
		return (sw) ? "Cronograma eliminado exitosamente con id: " + d.getCronograma().autoincrement  + d.getCronograma().toString() : "No se pudo eliminar el cronograma";
	}

	@Override
	public String messageFindAll(boolean sw) {
		return (sw) ? "Listado de cronogramas: " : "No se pudo encontrar en listado de cronogramas";
	}

}
