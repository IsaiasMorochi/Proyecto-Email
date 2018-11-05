package Software.Template;

import Bussines.NModoPago;
import Nucleo.procesador.Anacom;
import Nucleo.utilidades.Herramientas;

public class MailModoPago extends TemplateMail {

	private NModoPago obj = new NModoPago();
	
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
		
		return this.obj.modificar(id, descripcion);
	}

	@Override
	public boolean eliminar(Anacom anacom, String correo) {
		anacom.Avanzar();
		int id = anacom.Preanalisis().getAtributo();
		
		return this.obj.eliminar(id, correo);
	}

	@Override
	public String listar() {
		return this.obj.Mostrar();
	}

	@Override
	public String messageCreate(boolean sw) {
		return (sw) ? "Modo de Pago registrado exitosamente con id: " + obj.getModoPago().autoincrement +  obj.getModoPago().toString() : "No se pudo registrar el Modo de Pago";
	}

	@Override
	public String messageEdit(boolean sw) {
		return (sw) ? "Modo de Pago modificado exitosamente con id: " + obj.getModoPago().autoincrement +  obj.getModoPago().toString() : "No se pudo modificar el Modo de Pago";
	}

	@Override
	public String messageRemove(boolean sw) {
		return (sw) ? "Modo de Pago eliminado exitosamente con id: " + obj.getModoPago().autoincrement +  obj.getModoPago().toString() : "No se pudo eliminar el Modo de Pago";
	}

	@Override
	public String messageFindAll(boolean sw) {
		return (sw) ? "Listado de Modo de Pagos: " : "No se pudo encontrar en listado de Modo de Pago";
	}
}
