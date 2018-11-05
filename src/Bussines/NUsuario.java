package Bussines;

import Data.DUsuario;

public class NUsuario {
	
    private DUsuario usuarioModel;
    
    public NUsuario(){
    	usuarioModel = DUsuario.getInstance();
    }

//    public NUsuario(DUsuario usuarioModel) {
//        this.usuarioModel = usuarioModel;
//    }

    public Boolean registrar(){
        return Boolean.TRUE;
    }
}
