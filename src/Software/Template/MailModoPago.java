package Software.Template;

import Bussines.NModoPago;
import nucleo.procesador.Anacom;
import nucleo.utilidades.Herramientas;

public class MailModoPago extends TemplateMail {

	private NModoPago obj = new NModoPago();
	
	@Override
	public boolean insertar(Anacom anacom, String correo) {
		anacom.Avanzar();
		String descripcion =  Herramientas.quitarComillas(anacom.Preanalisis().getToStr());
		anacom.Avanzar();
		anacom.Avanzar();
		int id_evento = anacom.Preanalisis().getAtributo();
		
		return obj.registrar(descripcion, id_evento);
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
