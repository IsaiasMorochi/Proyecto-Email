package Email;

import Negocio.NBoleta;
import Nucleo.procesador.Anacom;

public class MailBoleta extends TemplateMail {

    private NBoleta o;

    public MailBoleta() throws Exception{
        this.o = new NBoleta();
    }
    @Override
    public boolean insertar(Anacom anacom, String correo) throws Exception {
        try {
            anacom.Avanzar();
            double monto = anacom.Preanalisis().getAtributo();
            anacom.Avanzar();
            anacom.Avanzar();
            int pago = anacom.Preanalisis().getAtributo();

            o.add(monto, pago);
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

            o.update(id, monto);
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
