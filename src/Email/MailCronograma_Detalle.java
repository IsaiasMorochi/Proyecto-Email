package Email;

import Negocio.NCronograma_Detalle;
import Nucleo.procesador.Anacom;

public class MailCronograma_Detalle extends TemplateMail {

    private NCronograma_Detalle o;

    public MailCronograma_Detalle() throws Exception{
        this.o = new NCronograma_Detalle();
    }
    @Override
    public boolean insertar(Anacom anacom, String correo) throws Exception {
        try {
            anacom.Avanzar();
            int cronograma_id = anacom.Preanalisis().getAtributo();
            anacom.Avanzar();
            anacom.Avanzar();
            int oferta_id = anacom.Preanalisis().getAtributo();

            o.add(cronograma_id, oferta_id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean modificar(Anacom anacom, String correo) throws Exception{
        try {
//            anacom.Avanzar();
//            int id = anacom.Preanalisis().getAtributo();
//            anacom.Avanzar();
//            anacom.Avanzar();
//            String description = Herramientas.quitarComillas(anacom.Preanalisis().getToStr());
//            anacom.Avanzar();
//            anacom.Avanzar();
//            String periodo_id = Herramientas.quitarComillas(anacom.Preanalisis().getToStr());
//
//            o.update(id, description, periodo_id);
            return false;
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
