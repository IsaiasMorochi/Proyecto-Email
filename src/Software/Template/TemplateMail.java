package Software.Template;

import Nucleo.procesador.Anacom;
import Nucleo.procesador.Token;
import Nucleo.protocolos.ClienteSMTP;

/**
 * 
 * @author isaias
 *
 */
public abstract class TemplateMail {


    private boolean messageHelp(Anacom anacom, String email, String comandHelp) {
        anacom.Avanzar();
        Token token = anacom.Preanalisis();

        if (token.getNombre() == Token.HELP) {
//            ClienteSMTP.sendMail(email, "AYUDAS - MARKETING", comandHelp);
            ClienteSMTP.sendMailHTML(email, "AYUDAS - MARKETING", comandHelp);
            System.out.println(comandHelp);
            return true;
        }
        return false;
    }

	public void create(Anacom anacom, String email, String comandHelp){
        if (messageHelp(anacom, email, comandHelp)) return;

        boolean sw = this.insertar(anacom, email);
        System.out.println(sw);
        
        if (sw) {
	         System.out.println(this.messageCreate(sw));
	         ClienteSMTP.sendMailHTML(email, "REGISTRO CON EXITO", "<h2>" + this.messageCreate(sw) + "</h2>");
	
        }else{
        	System.out.println(this.messageCreate(sw));
            ClienteSMTP.sendMailHTML(email, "REGISTRO SIN EXITO", "<h2>" + this.messageCreate(sw) + "</h2>");
        }
    }


    public void edit(Anacom anacom, String email, String comandHelp){
        if (messageHelp(anacom, email, comandHelp)) return;

        boolean sw = this.modificar(anacom, email);
        
        if (sw) {
	        System.out.println(this.messageEdit(sw));
	        ClienteSMTP.sendMailHTML(email, "MODIFICACION CON EXITO", this.messageEdit(sw));
        }else{
        	System.out.println(this.messageEdit(sw));
        	ClienteSMTP.sendMailHTML(email, "MODIFICACION SINT EXITO", this.messageEdit(sw));
        }
	}
	
	public void remove(Anacom anacom, String email, String comandHelp){
        if (messageHelp(anacom, email, comandHelp)) return;

        boolean sw = this.eliminar(anacom, email);
                        
        if (sw) {
        	 System.out.println(messageRemove(sw));
	         ClienteSMTP.sendMailHTML(email, "ELIMINACION CON EXITO", messageRemove(sw));
        }else{
        	 System.out.println(this.messageRemove(sw));
             ClienteSMTP.sendMailHTML(email, "ELIMINACION CON EXITO", messageRemove(sw));
        }	
	}
	
	public void findAll(Anacom anacom, String email, String comandHelp){
        if (messageHelp(anacom, email, comandHelp)) return;

        String lista = this.listar();

        if (lista.isEmpty()) {
            System.out.println(this.messageFindAll(false));
//            ClienteSMTP.sendMail(email, "LISTADO CON EXITO", this.messageFindAll(false));
            ClienteSMTP.sendMailHTML(email, "LISTADO SIN EXITO", this.messageFindAll(false));
        }else{
        	System.out.println();
//            ClienteSMTP.sendMail(email, "LISTADO SIN EXITO", this.messageFindAll(true) + lista);
            ClienteSMTP.sendMailHTML(email, "LISTADO CON EXITO", this.messageFindAll(true) + lista);
        }                 
	}
	
	public abstract boolean insertar(Anacom anacom, String correo);
	public abstract boolean modificar(Anacom anacom, String correo);
	public abstract boolean eliminar(Anacom anacom, String correo);
	public abstract String listar();

	public abstract String messageCreate(boolean sw);
	public abstract String messageEdit(boolean sw);
	public abstract String messageRemove(boolean sw);
	public abstract String messageFindAll(boolean sw);

}
