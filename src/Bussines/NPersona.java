package Bussines;

import Data.DPersona;
import Data.DUsuario;
import nucleo.utilidades.Utils;

import java.util.Date;

public class NPersona {
    private DPersona personaModel;
    private DUsuario usuarioModel;

    public NPersona() {
        personaModel = new DPersona();
        usuarioModel = new DUsuario();
    }

    public Boolean registrar(String nombre, String telefono, String nacionalidad, String direccion, String correo, String password, String tipo){
        personaModel.setNombre(nombre); personaModel.setDireccion(direccion);
        personaModel.setTelefono(telefono); personaModel.setNacionalidad(nacionalidad);
        personaModel.setTipo(tipo); personaModel.setCreated_at(Utils.dateToString(new Date()));
        if(personaModel.insertar()){
            usuarioModel.setId_persona(personaModel.autoincrement);
            usuarioModel.setCorreo(correo);
            usuarioModel.setPassword(password);
            usuarioModel.setCreated_at(Utils.dateToString(new Date()));
            return usuarioModel.insertar();
        }
        return Boolean.FALSE;
    }
}
