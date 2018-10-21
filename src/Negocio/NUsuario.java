package Negocio;

import Dato.DCliente;
import Dato.DFotografo;
import Dato.DPersonal;
import Dato.DServicio;
import Dato.DUsuario;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Saulo
 * @version 1.0
 * @created 16-may-2018 12:48:27
 */
public class NUsuario {
    private DUsuario usuario;
    private DCliente cliente;
    private DFotografo fotografo;
    private DPersonal personal;
    
    public NUsuario(){
        usuario = new DUsuario();
        cliente = new DCliente();
        fotografo = new DFotografo();
        personal = new DPersonal();
    }

    public DUsuario getUsuario() {
        return usuario;
    }

    public DCliente getCliente() {
        return cliente;
    }

    public DFotografo getFotografo() {
        return fotografo;
    }

    public DPersonal getPersonal() {
        return personal;
    }

    public void setUsuario(DUsuario usuario) {
        this.usuario = usuario;
    }
    
    private boolean registrarUsuario(String nombre,String ci,int telefono,String correo,String password,char sexo,int tipo) {
        if (usuario.buscarPorCorreo(correo)!=null) {
            System.out.println("Ese usuario ya existe en la base de datos");
            return false;
        }
        this.usuario.setNombre(nombre);
        this.usuario.setCi(ci);
        this.usuario.setTelefono(telefono);
        this.usuario.setCorreo(correo);
        this.usuario.setPassword(password);
        this.usuario.setSexo(sexo);
        this.usuario.setTipo(tipo);
        this.usuario.setEstado(true);
        return usuario.insertar();
    }
    
    public DUsuario obtenerUsuarioPorCorreo(String correo){
        return usuario.buscarPorCorreo(correo);
    }
    
    public String registrarCliente(String nombre,String ci,int telefono,String correo,String password,char sexo) {
        if (!this.registrarUsuario(nombre, ci, telefono, correo, password, sexo, 1)) {
            return "El correo ya existe, usted ya se habia registrado tiempo atras.";
        }
        this.cliente.setIdUsuario(this.usuario.autoincrement);
        return this.cliente.insertar()?"Registro realizado correctamente su codigo de registro es: "+this.usuario.autoincrement:"";
    }
    
    public String registrarFotografo(String nombre,String ci,int telefono,String correo,String password,char sexo,int idServicio,String direccion) {
        if (!this.registrarUsuario(nombre, ci, telefono, correo, password, sexo, 2)) {
            return "El correo ya existe, usted ya se habia registrado tiempo atras.";
        }
        this.fotografo.setDireccion(direccion);
        this.fotografo.setDisponible(true);
        this.fotografo.setIdServicio(idServicio);
        this.fotografo.setIdUsuario(this.usuario.autoincrement);
        if (fotografo.insertar()) {
            return "Registro realizado correctamente su codigo de registro es: "+this.usuario.autoincrement;
        }
        return "Ocurrio un problema en la red intente de nuevo por favor";
        
    }
    
    public String registrarPersonal(String nombre,String ci,int telefono,String correo,String password,char sexo) {
        if (!this.registrarUsuario(nombre, ci, telefono, correo, password, sexo, 3)) {
            return "El correo ya existe, usted ya se habia registrado tiempo atras";
        }
        this.cliente.setIdUsuario(this.usuario.autoincrement);
        this.personal.setIdUsuario(this.usuario.autoincrement);
        this.cliente.insertar();
        return this.personal.insertar()?"Registro realizado correctamente su codigo de registro es: "+this.usuario.autoincrement:"";
    }
    
    public boolean modificar(int id,String nombre,String ci,int telefono,String correo,String password,char sexo) {
        this.usuario.setId(id);
        this.usuario.setNombre(nombre);
        this.usuario.setCi(ci);
        this.usuario.setTelefono(telefono);
        this.usuario.setCorreo(correo);
        this.usuario.setPassword(password);
        this.usuario.setSexo(sexo);
        return this.usuario.actualizar();
    }
    
    public boolean cambiarDisponibilidad(DFotografo fotografo){
        fotografo.setDisponible(!this.fotografo.getDisponible());
        return this.fotografo.actualizar();
    }
    
    //---------------
    public String modificarCliente(int id,String nombre,String ci,int telefono,String correo,String password,char sexo) {
        if (!this.modificar(id, nombre, ci, telefono, correo, password, sexo)) {
            return "El codigo no existe";
        }
        return "Registro modificado correctamente";
    }
    
    public String modificarFotografo(int id,String nombre,String ci,int telefono,String correo,String password,char sexo,int idServicio,String direccion) {
        if (!this.modificar(id, nombre, ci, telefono, correo, password, sexo)) {
            return "El codigo no existe";
        }
        this.fotografo.setDireccion(direccion);
        this.fotografo.setIdServicio(idServicio);
        this.fotografo.setIdUsuario(id);
        return fotografo.actualizar()?"Registro modificado correctamente":"";
    }
    
    public String modificarPersonal(int id,String nombre,String ci,int telefono,String correo,String password,char sexo) {
        if (!this.modificar(id, nombre, ci, telefono, correo, password, sexo)) {
            return "El codigo no existe";
        }
        return "Registro modificado correctamente";
    }
    //--------------------

    public String borrarUsuario(String correo) {
        usuario = usuario.buscarPorCorreo(correo);
        boolean verificacion = usuario.eliminar();
        if(verificacion){
            return "Usuario eliminado correctamente";
        }
        return "El correo no existe";
    }

    private List<DUsuario> listar() {
        List<Object> listaObject = this.usuario.listar();
        if (listaObject==null || listaObject.size()==0) {
            return null;
        }
        List<DUsuario> listaUsuario=new ArrayList<>();
        for (Object object : listaObject) {
            List<Object> usuarioX =(List<Object>) object;
            this.usuario = new DUsuario();
            this.usuario.setId(Integer.valueOf(usuarioX.get(0).toString()));
            this.usuario.setNombre(usuarioX.get(1).toString());
            this.usuario.setCi(usuarioX.get(2).toString());
            this.usuario.setTelefono(Integer.valueOf(usuarioX.get(3).toString()));
            this.usuario.setCorreo(usuarioX.get(4).toString());
            this.usuario.setPassword(usuarioX.get(5).toString());
            this.usuario.setSexo(usuarioX.get(6).toString().charAt(0));
            this.usuario.setTipo(Integer.valueOf(usuarioX.get(7).toString()));
            this.usuario.setEstado(Boolean.valueOf(usuarioX.get(8).toString()));
            listaUsuario.add(usuario);
        }
        return listaUsuario;
    }
    
    public List<DFotografo> listarFotografo() {
        List<Object> listaObject = this.fotografo.listar();
        if (listaObject!=null && listaObject.size()==0) {
            return null;
        }
        List<DFotografo> listaFotografo=new ArrayList<>();
        for (Object object : listaObject) {
            List<Object> fotografoX =(List<Object>) object;
            this.fotografo = new DFotografo();
            this.fotografo.setFechaIngreso(fotografoX.get(0).toString());
            this.fotografo.setDireccion(fotografoX.get(1).toString());
            this.fotografo.setDisponible(Boolean.valueOf(fotografoX.get(2).toString()));
            this.fotografo.setIdUsuario(Integer.valueOf(fotografoX.get(3).toString()));
            this.fotografo.setIdServicio(Integer.valueOf(fotografoX.get(4).toString()));
            listaFotografo.add(this.fotografo);
        }
        return listaFotografo;
    }
    
    public String mostrarFotografo(int idFotografo) {
        String resultado="Lista De Fotografos\n\n";
        fotografo = this.fotografo.buscar(idFotografo);
        usuario=usuario.buscar(fotografo.getIdUsuario());
        resultado+="Codigo: "+usuario.getId()+" Carnet Identidad: "+usuario.getCi()+"\n"+
                " Sexo: "+usuario.getSexo()+"  Telefono: "+usuario.getTelefono()+"\n"+
                "Nombre: "+usuario.getNombre()+"\n";
                DServicio servicio = new DServicio();
                servicio = servicio.buscar(fotografo.getIdServicio());
                resultado+="Disponible:";
                resultado+=fotografo.getDisponible()?"Si\n":"No\n";
                resultado+="Servicio: "+servicio.getNombre()+"\n";
        return resultado+"------------------------------------------------------------------------\n";
    }
    
    public String mostrarListaFotografos(){
        String resultado="Lista De Fotografos\n\n";
        List<DFotografo> lista = this.listarFotografo();
        for (DFotografo fotografoX : lista) {
            usuario=usuario.buscar(fotografoX.getIdUsuario());
            resultado+="Codigo: "+usuario.getId()+"\nCarnet Identidad: "+usuario.getCi()+"\n"+
                    "Sexo: "+usuario.getSexo()+"\nTelefono: "+usuario.getTelefono()+"\n"+
                    "Nombre: "+usuario.getNombre()+"\n";
                    DServicio servicio = new DServicio();
                    servicio = servicio.buscar(fotografoX.getIdServicio());
                    resultado+="Disponible:";
                    resultado+=fotografoX.getDisponible()?"Si\n":"No\n";
                    resultado+="Servicio: "+servicio.getNombre()+"\n"
                            + "------------------------------------------------------------------------\n";
        }
        return resultado;
    }
    
    public String mostrarLista(){
        String resultado="Lista De Usuarios\n\n";
        List<DUsuario> lista = this.listar();
        if(lista==null){
            return "No se encuentran registrados usuarios\n";
        }
            
        for (DUsuario usuarioX : lista) {
            resultado+="Codigo: "+usuarioX.getId()+" Carnet Identidad: "+usuarioX.getCi()+"\n"+
                    "Sexo: "+usuarioX.getSexo()+"  Telefono: "+usuarioX.getTelefono()+"\n"+
                    "Nombre: "+usuarioX.getNombre()+"\n"+
                    "Correo: "+usuarioX.getCorreo()+"\n"+
                    "Clave: "+usuarioX.getPassword()+"\n"
                    ;
            switch (usuarioX.getTipo()){
                case 1:
                    resultado+="  Tipo: Cliente"+"\n";
                    break;
                case 2:
                    fotografo=fotografo.buscar(usuarioX.getId());
                    DServicio servicio = new DServicio();
                    servicio = servicio.buscar(fotografo.getIdServicio());
                    resultado+="Fecha De Ingreso: "+fotografo.getFechaIngreso()+"\n"+
                            "Dirección: "+fotografo.getDireccion()+"\n"+
                            "Disponible:"
                            ;
                    resultado+=fotografo.getDisponible()?"Si\n":"No\n";
                    
                    resultado+="Servicio: "+servicio.getNombre()+"\n";
                    resultado+="  Tipo: Fotografo"+"\n";
                    break;
                case 3:
                    personal=personal.buscar(usuarioX.getId());
                    resultado+="Fecha De Ingreso: "+personal.getFechaIngreso()+"\n"
                            +"  Tipo: Personal"+"\n";
                    break;
            }
            if (usuarioX.getEstado()) {
                resultado+="  Estado: Habilitado"+"\n";
            }
            resultado += "----------------------------------------------\n";
        }
        return resultado;
    }
}