package Software.Template;

import Bussines.NDetalle_Contenido;
import Bussines.NDetalle_Venta;
import nucleo.procesador.Anacom;
import nucleo.utilidades.Herramientas;

public class MailDetalle_Contenido extends TemplateMail {

	NDetalle_Contenido d = new  NDetalle_Contenido();
	
	@Override
	public boolean insertar(Anacom anacom, String correo) {
		anacom.Avanzar();
		int id_contenido =  anacom.Preanalisis().getAtributo();
		anacom.Avanzar();
		anacom.Avanzar();
		String descripcion = Herramientas.quitarComillas(anacom.Preanalisis().getToStr());

		return d.registrar(id_contenido, descripcion);
	}

	@Override
	public boolean modificar(Anacom anacom, String correo) {
		anacom.Avanzar();
		int id =  anacom.Preanalisis().getAtributo();
		anacom.Avanzar();
		anacom.Avanzar();
		int id_contenido =  anacom.Preanalisis().getAtributo();
		anacom.Avanzar();
		anacom.Avanzar();
		String descripcion = Herramientas.quitarComillas(anacom.Preanalisis().getToStr());
		
		return d.modificar(id, id_contenido, descripcion);
	}

	@Override
	public boolean eliminar(Anacom anacom, String correo) {
		anacom.Avanzar();
		int id =  anacom.Preanalisis().getAtributo();
		
		return d.eliminar(id, correo);
	}

	@Override
	public String listar() {
		return d.Mostrar();
	}

	@Override
	public String messageCreate(boolean sw) {
		return (sw) ? "Detalle de contenido registrado exitosamente con id: " + d.getDetalle_Contenido().toString() : "No se pudo registrar el detalle de contenido" ;
	}

	@Override
	public String messageEdit(boolean sw) {
		return (sw) ? "Detalle de contenido modificado exitosamente con id: " + d.getDetalle_Contenido().toString() : "No se pudo modificar el Detalle de contenido" ;
	}

	@Override
	public String messageRemove(boolean sw) {
		return (sw) ? "Detalle de contenido eliminado exitosamente con id: " + d.getDetalle_Contenido().toString() : "No se pudo eliminar el Detalle de contenido";
	}

	@Override
	public String messageFindAll(boolean sw) {
		return (sw) ? "Listado de Detalle de contenido: " : "No se pudo encontrar en listado de Detalle de contenido";
	}
	

}
