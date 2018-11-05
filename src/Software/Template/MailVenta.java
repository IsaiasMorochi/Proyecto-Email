package Software.Template;

import Bussines.NVenta;
import Nucleo.procesador.Anacom;
import Nucleo.utilidades.Herramientas;

public class MailVenta extends TemplateMail {

	private NVenta obj = new NVenta();
	
	@Override
	public boolean insertar(Anacom anacom, String correo) {
		anacom.Avanzar();
		String fecha =  Herramientas.quitarComillas(anacom.Preanalisis().getToStr());
		
		return obj.registrar(fecha);
	}

	@Override
	public boolean modificar(Anacom anacom, String correo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminar(Anacom anacom, String correo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String listar() {
		return obj.Mostrar();
	}

	@Override
	public String messageCreate(boolean sw) {
		return (sw) ? "Venta registrado exitosamente con id: " + obj.getVenta().autoincrement +  obj.getVenta().toString() : "No se pudo registrar la Venta";
	}

	@Override
	public String messageEdit(boolean sw) {
		return (sw) ? "Venta modificado exitosamente con id: " +  obj.getVenta().autoincrement +  obj.getVenta().toString() : "No se pudo modificar la Venta";
	}

	@Override
	public String messageRemove(boolean sw) {
		return (sw) ? "Venta eliminado exitosamente con id: " +  obj.getVenta().autoincrement +  obj.getVenta().toString() : "No se pudo eliminar la Venta";
	}

	@Override
	public String messageFindAll(boolean sw) {
		return (sw) ? "Listado de Ventas: " : "No se pudo encontrar en listado de Ventas";
	}
	

}
