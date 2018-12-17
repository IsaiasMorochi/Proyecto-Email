package Software.Template;

import Bussines.NReserva;
import Nucleo.procesador.Anacom;
import Nucleo.utilidades.Herramientas;

public class MailReserva extends TemplateMail {

    private NReserva d = new NReserva();

    @Override
    public boolean insertar(Anacom anacom, String correo) {
        anacom.Avanzar();
        String fecha = Herramientas.quitarComillas(anacom.Preanalisis().getToStr());
        anacom.Avanzar();
        anacom.Avanzar();
        int id_persona = anacom.Preanalisis().getAtributo();
        anacom.Avanzar();
        anacom.Avanzar();
        int id_evento =anacom.Preanalisis().getAtributo();

        return this.d.registrar(fecha, id_persona, id_evento);
    }

    @Override
    public boolean modificar(Anacom anacom, String correo) {
        return false;
    }

    @Override
    public boolean eliminar(Anacom anacom, String correo) {
        return false;
    }

    @Override
    public String listar() {
        return null;
    }

    @Override
    public String messageCreate(boolean sw) {
        return (sw) ? "DReserva registrado exitosamente con id: " + d.getReserva().autoincrement + d.getReserva().toString()  : "No se pudo registrar el DReserva" ;
    }

    @Override
    public String messageEdit(boolean sw) {
        return (sw) ? "DReserva modificado exitosamente con id: " + d.getReserva().autoincrement + d.getReserva().toString() : "No se pudo modificar el DReserva" ;
    }

    @Override
    public String messageRemove(boolean sw) {
        return (sw) ? "DReserva eliminado exitosamente con id: " + d.getReserva().autoincrement + d.getReserva().toString() : "No se pudo eliminar el DReserva";
    }

    @Override
    public String messageFindAll(boolean sw) {
        return (sw) ? "Listado de Reservas: " : "No se pudo encontrar el listado de DReserva";
    }
}
