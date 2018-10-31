package Software.Template;

import nucleo.procesador.Anacom;

public class MailUsuario extends TemplateMail {

    @Override
    public boolean insertar(Anacom anacom, String correo) {
        return false;
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
        return null;
    }

    @Override
    public String messageEdit(boolean sw) {
        return null;
    }

    @Override
    public String messageRemove(boolean sw) {
        return null;
    }

    @Override
    public String messageFindAll(boolean sw) {
        return null;
    }
}
