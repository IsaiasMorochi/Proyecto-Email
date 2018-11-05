package Software.Template;

import Bussines.NLugar;
import Nucleo.procesador.Anacom;
import Nucleo.utilidades.Herramientas;

public class MailLugar extends TemplateMail {
	
	private NLugar l = new NLugar();

	@Override
	public boolean insertar(Anacom anacom, String correo) {
		 anacom.Avanzar();
         String descripcion = Herramientas.quitarComillas(anacom.Preanalisis().getToStr());
        
         return this.l.registrar(descripcion);
	}

	@Override
	public boolean modificar(Anacom anacom, String correo) {
		// TODO Auto-generated method stub
		anacom.Avanzar();
        int id = anacom.Preanalisis().getAtributo();
        anacom.Avanzar();
        anacom.Avanzar();
        String descripcion = Herramientas.quitarComillas(anacom.Preanalisis().getToStr()); 
     
		return this.l.modificar(id, descripcion);
	}

	@Override
	public boolean eliminar(Anacom anacom, String correo) {
		anacom.Avanzar();
        int id = anacom.Preanalisis().getAtributo();
		return this.l.eliminar(id, correo);
	}

	@Override
	public String listar() {
		return this.l.Mostrar();
	}

	@Override
	public String messageCreate(boolean sw) {
		return (sw) ? "Lugar registrado exitosamente con id: " + l.getLugar().autoincrement + l.getLugar().toString() : "No se pudo registrar el lugar" ;
	}

	@Override
	public String messageEdit(boolean sw) {
		return (sw) ? "Lugar modificado exitosamente con id edit: " + l.getLugar().autoincrement + ", " + l.getLugar().toString() : "No se pudo modificar el lugar" ;
	}

	@Override
	public String messageRemove(boolean sw) {
		return (sw) ? "Lugar eliminado exitosamente con id delete: " + l.getLugar().autoincrement  : "No se pudo eliminar el lugar" + l.getLugar() ;
	}

	@Override
	public String messageFindAll(boolean sw) {
		return (sw) ? "Listado de lugares: " : "No se pudo encontrar en listado de lugares" ;
	}

	
}
