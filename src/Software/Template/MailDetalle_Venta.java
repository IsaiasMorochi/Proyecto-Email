package Software.Template;

import Bussines.NDetalle_Venta;
import Nucleo.procesador.Anacom;
import Nucleo.utilidades.Herramientas;

public class MailDetalle_Venta extends TemplateMail {
	
	private NDetalle_Venta d = new NDetalle_Venta();

	@Override
	public boolean insertar(Anacom anacom, String correo) {
		anacom.Avanzar();
		int id_evento = anacom.Preanalisis().getAtributo();
		anacom.Avanzar();
		anacom.Avanzar();
		int id_usuario = anacom.Preanalisis().getAtributo();
		anacom.Avanzar();
		anacom.Avanzar();
		int id_persona = anacom.Preanalisis().getAtributo();
		anacom.Avanzar();
		anacom.Avanzar();
		int id_venta = anacom.Preanalisis().getAtributo();
		anacom.Avanzar();
		anacom.Avanzar();
		String nro_comprobante = Herramientas.quitarComillas(anacom.Preanalisis().getToStr());
		anacom.Avanzar();
		anacom.Avanzar();
		String fecha_comprobante = Herramientas.quitarComillas(anacom.Preanalisis().getToStr());

		return this.d.registrar(id_evento, id_usuario, id_persona, id_venta, nro_comprobante, fecha_comprobante);
	}

	@Override
	public boolean modificar(Anacom anacom, String correo) {
		anacom.Avanzar();
		int id = anacom.Preanalisis().getAtributo();
		anacom.Avanzar();
		anacom.Avanzar();
		String nro_comprobante = Herramientas.quitarComillas(anacom.Preanalisis().getToStr());
		anacom.Avanzar();
		anacom.Avanzar();
		String fecha_comprobante = Herramientas.quitarComillas(anacom.Preanalisis().getToStr());

		return this.d.modificar(id,fecha_comprobante, nro_comprobante );
	}

	@Override
	public boolean eliminar(Anacom anacom, String correo) {
		anacom.Avanzar();
        int id = anacom.Preanalisis().getAtributo();
		return this.d.eliminar(id, correo);
	}

	@Override
	public String listar() {
		return this.d.Mostrar();
	}

	@Override
	public String messageCreate(boolean sw) {
		return (sw) ? "Detalle de venta registrado exitosamente con id: " + d.getDetalle_Venta().autoincrement + d.getDetalle_Venta().toString() : "No se pudo registrar el detalle de venta" ;
	}

	@Override
	public String messageEdit(boolean sw) {
		return (sw) ? "detalle de venta modificado exitosamente con id: " + d.getDetalle_Venta().autoincrement + d.getDetalle_Venta().toString() : "No se pudo modificar el detalle de venta" ;
	}

	@Override
	public String messageRemove(boolean sw) {
		return (sw) ? "Detalle de venta eliminado exitosamente con id: " + d.getDetalle_Venta().autoincrement + d.getDetalle_Venta().toString() : "No se pudo eliminar el detalle de venta";
	}

	@Override
	public String messageFindAll(boolean sw) {
		return (sw) ? "Listado de detalles de venta: " : "No se pudo encontrar en listado de detalles de venta";
	}

}
