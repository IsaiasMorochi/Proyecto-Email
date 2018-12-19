package Email;

import Negocio.NReserva;
import Nucleo.procesador.Anacom;
import Nucleo.utilidades.Herramientas;

public class MailReserva extends TemplateMail {

    private NReserva o;

    public MailReserva() throws Exception{
        this.o = new NReserva();
    }
    @Override
    public boolean insertar(Anacom anacom, String correo) throws Exception {
        try {
            anacom.Avanzar();
            String date = Herramientas.quitarComillas(anacom.Preanalisis().getToStr());
            anacom.Avanzar();
            anacom.Avanzar();
            String description = Herramientas.quitarComillas(anacom.Preanalisis().getToStr());
            anacom.Avanzar();
            anacom.Avanzar();
            int user_id = anacom.Preanalisis().getAtributo();
            anacom.Avanzar();
            anacom.Avanzar();
            int oferta_id = anacom.Preanalisis().getAtributo();

            o.add(date, description, user_id, oferta_id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean modificar(Anacom anacom, String correo) throws Exception{
        try {
            anacom.Avanzar();
            int id = anacom.Preanalisis().getAtributo();
            anacom.Avanzar();
            anacom.Avanzar();
            String date = Herramientas.quitarComillas(anacom.Preanalisis().getToStr());
            anacom.Avanzar();
            anacom.Avanzar();
            String description = Herramientas.quitarComillas(anacom.Preanalisis().getToStr());

            o.update(id, date, description);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean eliminar(Anacom anacom, String correo) throws Exception{
        try {
            anacom.Avanzar();
            int id = anacom.Preanalisis().getAtributo();
            o.delete(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public String listar() throws Exception {
        try {
            return o.Mostrar();
        } catch (Exception e){
            throw e;
        }
    }

    @Override
    public String messageCreate(boolean sw) {
        return (sw) ? "Contenido registrado exitosamente con id: "  + o.getInfo().toString() : "No se pudo registrar el contenido";

    }

    @Override
    public String messageEdit(boolean sw) {
        return (sw) ? "Contenido modificado exitosamente con id: " + o.getInfo().toString() : "No se pudo modificar el contenido";

    }

    @Override
    public String messageRemove(boolean sw) {
        return (sw) ? "Contenido eliminado exitosamente con id: " + o.getInfo().toString() : "No se pudo eliminar el contenido";
    }

    @Override
    public String messageFindAll(boolean sw) {
        return (sw) ? "Listado de contenidos: " : "No se pudo encontrar en listado de contenidos";
    }
}
