package Software.Template;

import Bussines.NPersona;
import Nucleo.procesador.Anacom;
import Nucleo.utilidades.Herramientas;

public class MailPersona extends TemplateMail {

	private NPersona obj = new NPersona();
	
	@Override
	public boolean insertar(Anacom anacom, String correo) {
		anacom.Avanzar();
		String nombre = Herramientas.quitarComillas(anacom.Preanalisis().getToStr());
		anacom.Avanzar();
		anacom.Avanzar();
		String telefono = Herramientas.quitarComillas(anacom.Preanalisis().getToStr());
		anacom.Avanzar();
		anacom.Avanzar();
		String nacionalidad = Herramientas.quitarComillas(anacom.Preanalisis().getToStr());
		anacom.Avanzar();
		anacom.Avanzar();
		String ci = Herramientas.quitarComillas(anacom.Preanalisis().getToStr());
		anacom.Avanzar();
		anacom.Avanzar();
		String direccion = Herramientas.quitarComillas(anacom.Preanalisis().getToStr());
		anacom.Avanzar();
		anacom.Avanzar();
		String tipo = Herramientas.quitarComillas(anacom.Preanalisis().getToStr());
		anacom.Avanzar();
		anacom.Avanzar();		
		String correou = Herramientas.quitarComillas(anacom.Preanalisis().getToStr());
		anacom.Avanzar();
		anacom.Avanzar();
		String password = Herramientas.quitarComillas(anacom.Preanalisis().getToStr());
	
		return this.obj.registrar(nombre, telefono, nacionalidad, ci, direccion, tipo, correou, password);
	}

	@Override
	public boolean modificar(Anacom anacom, String correo) {
		anacom.Avanzar();
		int id = anacom.Preanalisis().getAtributo();
		anacom.Avanzar();
		anacom.Avanzar();
		String tipo = Herramientas.quitarComillas(anacom.Preanalisis().getToStr());
		
		return this.obj.modificar(id, tipo);
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
		return (sw) ? "DUsuario registrado exitosamente con id: " + obj.getPersona().autoincrement +  obj.getPersona().toString() : "No se pudo registrar el usuario";
	}

	@Override
	public String messageEdit(boolean sw) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String messageRemove(boolean sw) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String messageFindAll(boolean sw) {
		return (sw) ? "Listado de Usuarios: " : "No se pudo encontrar en listado de Usuarios";
	}

}
