package Email;

import Negocio.NPago;
import Nucleo.procesador.Anacom;
import Nucleo.utilidades.Herramientas;
import com.sun.corba.se.impl.orb.NormalParserAction;

public class MailPago extends TemplateMail {

    private NPago o;

    public MailPago() throws Exception{
        this.o = new NPago();
    }
    @Override
    public boolean insertar(Anacom anacom, String correo) throws Exception {
        try {
            anacom.Avanzar();
            double monto = anacom.Preanalisis().getAtributo();
            anacom.Avanzar();
            anacom.Avanzar();
            String type = Herramientas.quitarComillas(anacom.Preanalisis().getToStr());

            o.add(monto, type);
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
            double monto = anacom.Preanalisis().getAtributo();
            anacom.Avanzar();
            anacom.Avanzar();
            String type = Herramientas.quitarComillas(anacom.Preanalisis().getToStr());

            o.update(id, monto, type);
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
