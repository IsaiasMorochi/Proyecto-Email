package Email;

import Negocio.NVenta_Detalle;
import Nucleo.procesador.Anacom;
import Nucleo.utilidades.Herramientas;

public class MailVenta_Detalle extends TemplateMail {

    private NVenta_Detalle o;

    public MailVenta_Detalle() throws Exception{
        this.o = new NVenta_Detalle();
    }
    @Override
    protected boolean insertar(Anacom anacom, String correo) throws Exception {
        try {
            anacom.Avanzar();
            String date = Herramientas.quitarComillas(anacom.Preanalisis().getToStr());
            anacom.Avanzar(); anacom.Avanzar();
            int venta_id = anacom.Preanalisis().getAtributo();
            anacom.Avanzar(); anacom.Avanzar();
            int oferta_id = anacom.Preanalisis().getAtributo();
            anacom.Avanzar(); anacom.Avanzar();
            int pago_id = anacom.Preanalisis().getAtributo();
            anacom.Avanzar(); anacom.Avanzar();
            int user_id = anacom.Preanalisis().getAtributo();

            o.add(date, venta_id, oferta_id, pago_id, user_id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    protected boolean modificar(Anacom anacom, String correo) throws Exception{
        try {
            anacom.Avanzar();
            int id = anacom.Preanalisis().getAtributo();
            anacom.Avanzar();
            anacom.Avanzar();
            String date = Herramientas.quitarComillas(anacom.Preanalisis().getToStr());

            o.update(id, date);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    protected boolean eliminar(Anacom anacom, String correo) throws Exception{
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
    protected String listar() throws Exception {
        try {
            return o.Mostrar();
        } catch (Exception e){
            throw e;
        }
    }

    @Override
    protected String messageCreate(boolean sw) {
        return (sw) ? "Contenido registrado exitosamente con id: "  + o.getInfo().toString() : "No se pudo registrar el contenido";

    }

    @Override
    protected String messageEdit(boolean sw) {
        return (sw) ? "Contenido modificado exitosamente con id: " + o.getInfo().toString() : "No se pudo modificar el contenido";

    }

    @Override
    protected String messageRemove(boolean sw) {
        return (sw) ? "Contenido eliminado exitosamente con id: " + o.getInfo().toString() : "No se pudo eliminar el contenido";
    }

    @Override
    protected String messageFindAll(boolean sw) {
        return (sw) ? "Listado de contenidos: " : "No se pudo encontrar en listado de contenidos";
    }
}
