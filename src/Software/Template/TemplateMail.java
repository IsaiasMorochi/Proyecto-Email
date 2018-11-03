package Software.Template;

import nucleo.procesador.Anacom;
import nucleo.procesador.Token;
import nucleo.protocolos.ClienteSMTP;

/**
 * 
 * @author isaias
 *
 */
public abstract class TemplateMail {
	
	
	public void create(Anacom anacom, String email, String comandHelp){
		anacom.Avanzar();
        Token token = anacom.Preanalisis();
        
        if (token.getNombre() == Token.HELP) {
            ClienteSMTP.sendMail(email, "Ayudas - Marketing", comandHelp);
            System.out.println(comandHelp);
            return;
        }
        
        boolean sw = this.insertar(anacom, email);
        System.out.println(sw);
        
        if (sw) {
	         System.out.println(this.messageCreate(sw));
//	         ClienteSMTP.sendMail(email, "REGISTRO CON EXITO", this.messageCreate(sw));
	         ClienteSMTP.sendMailHTML(email, "REGISTRO CON EXITO", "<h2>" + this.messageCreate(sw) + "</h2>");
        }else{
        	System.out.println(this.messageCreate(sw));
//            ClienteSMTP.sendMail(email, "REGISTRO SIN EXITO", this.messageCreate(sw));
            ClienteSMTP.sendMailHTML(email, "REGISTRO SIN EXITO", "<h2>" + this.messageCreate(sw) + "</h2>");
            return;
        }
    }
	
	public void edit(Anacom anacom, String email, String comandHelp){
		anacom.Avanzar();
        Token token = anacom.Preanalisis();
        
        if (token.getNombre() == Token.HELP) {
            ClienteSMTP.sendMail(email, "Ayudas - Marketing", comandHelp);
            System.out.println(comandHelp);
            return;
        }
        
        boolean sw = this.modificar(anacom, email);
        
        if (sw) {
	        System.out.println(this.messageEdit(sw));
	        ClienteSMTP.sendMail(email, "Modificacion con exito", this.messageEdit(sw));
        }else{
        	System.out.println(this.messageEdit(sw));
        	ClienteSMTP.sendMail(email, "Modificacion sin exito", this.messageEdit(sw));	
        	return;
        }
	}
	
	public void remove(Anacom anacom, String email, String comandHelp){
		anacom.Avanzar();
        Token token = anacom.Preanalisis();
        
        if (token.getNombre() == Token.HELP) {
            ClienteSMTP.sendMail(email, "Ayudas - Marketing", comandHelp);
            System.out.println(comandHelp);
            return;
        }
        
        boolean sw = this.eliminar(anacom, email);
                        
        if (sw) {
        	 System.out.println(messageRemove(sw));
	         ClienteSMTP.sendMail(email, "Eliminacion con exito", messageRemove(sw));
        }else{
        	 System.out.println(this.messageRemove(sw));
             ClienteSMTP.sendMail(email, "Eliminacion sin exito", messageRemove(sw));
             return;
        }	
	}
	
	public void findAll(Anacom anacom, String email, String comandHelp){
        anacom.Avanzar();
        Token token = anacom.Preanalisis();
        
        if (token.getNombre() == Token.HELP) {
            ClienteSMTP.sendMail(email, "Ayudas - Marketing", comandHelp);
            System.out.println(comandHelp);
            return;
        }
        
        String lista = this.listar();
        // lista.equals("")
        if (lista.isEmpty()) {
            System.out.println(this.messageFindAll(false));
            ClienteSMTP.sendMail(email, "Listado sin exito", this.messageFindAll(false));
            return;
        }else{
        	System.out.println();
            ClienteSMTP.sendMail(email, "Listado con exito", this.messageFindAll(true) + lista);	
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
