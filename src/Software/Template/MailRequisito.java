package Software.Template;

import Bussines.NRequisito;
import Nucleo.procesador.Anacom;
import Nucleo.utilidades.Herramientas;

public class MailRequisito extends TemplateMail {

	private NRequisito obj = new NRequisito();
	
	@Override
	public boolean insertar(Anacom anacom, String correo) {
		anacom.Avanzar();
		int id_evento = anacom.Preanalisis().getAtributo();
		anacom.Avanzar();
		anacom.Avanzar();
		String descripcion =  Herramientas.quitarComillas(anacom.Preanalisis().getToStr());

		return this.obj.registrar(id_evento, descripcion);
	}

	@Override
	public boolean modificar(Anacom anacom, String correo) {
		anacom.Avanzar();
		int id = anacom.Preanalisis().getAtributo();
		anacom.Avanzar();
		anacom.Avanzar();
		String descripcion = Herramientas.quitarComillas(anacom.Preanalisis().getToStr());
		
		return obj.modificar(id, descripcion);
	}

	@Override
	public boolean eliminar(Anacom anacom, String correo) {
		anacom.Avanzar();
		int id = anacom.Preanalisis().getAtributo();
		
		return obj.eliminar(id, correo);
	}

	@Override
	public String listar() {
		return obj.Mostrar();
	}

	@Override
	public String messageCreate(boolean sw) {
		return (sw) ? "DRequisito registrado exitosamente con id: " + obj.getRequisito().autoincrement +  obj.getRequisito().toString() : "No se pudo registrar el requisito";
	}

	@Override
	public String messageEdit(boolean sw) {
		return (sw) ? "DRequisito modificado exitosamente con id: " +  obj.getRequisito().autoincrement +  obj.getRequisito().toString() : "No se pudo modificar el requisito";
	}

	@Override
	public String messageRemove(boolean sw) {
		return (sw) ? "DRequisito eliminado exitosamente con id: " +  obj.getRequisito().autoincrement +  obj.getRequisito().toString() : "No se pudo eliminar el requisito";
	}

	@Override
	public String messageFindAll(boolean sw) {
		return (sw) ? "Listado de requisitos: " : "No se pudo encontrar en listado de requisitos";
	}

}
