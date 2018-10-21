package Dato;

import java.util.List;

/**
 * @author Saulo
 * @version 1.0
 * @created 16-may-2018 12:48:27
 */
public class DUsuario extends Plantilla{

    private int id;
    private String nombre;
    private String ci;
    private int telefono;
    private String correo;
    private String password;
    private char sexo;
    private int tipo;
    private boolean estado;

    public DUsuario(){

    }

    public int getId() {
        return id;
    }

    public String getCi() {
        return ci;
    }

    public String getNombre() {
        return nombre;
    }

    public int getTelefono() {
        return telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public String getPassword() {
        return password;
    }

    public char getSexo() {
        return sexo;
    }

    public boolean getEstado() {
        return estado;
    }

    public int getTipo() {
        return tipo;
    }
    
    
    public void setId(int id) {
        this.id = id;
    }

    public void setCi(String ci) {
        this.ci = ci;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
    
    @Override
    protected String registrar() {
        return "insert into Usuario(nombre,ci,telefono,correo,password,sexo,tipo,estado) values("
                +"'"+nombre+ "',"
                +"'"+ci+ "',"
                +telefono+ ","
                +"'"+correo+ "',"
                +"'"+password+ "',"
                +"'"+sexo+ "',"
                +tipo+ ","
                +estado
                + ")";
    }

    @Override
    protected String modificar() {
        return "update Usuario set "
                + "nombre='"+nombre+"',"
                + "ci='"+ci+"',"
                + "telefono="+telefono+","
               /// + "correo='"+correo+"',"
                + "password='"+password+"',"
                + "sexo='"+sexo+"'"
                + " where id="+id;
    }

    @Override
    protected String borrar() {
        return "update Usuario set "
                + "estado="+false
                + " where id="+id;
    }

    @Override
    protected String listado() {
        return "select * from Usuario where estado = true";
    }

    @Override
    protected int cantidadAtributos() {
        return 9;
    }

    public DUsuario buscar(int id) {
        List<Object> usuario =(List<Object>) buscar("select * from Usuario where id="+id);
        DUsuario dUsuario = new DUsuario();
        dUsuario.setId(Integer.valueOf(usuario.get(0).toString()));
        dUsuario.setNombre(usuario.get(1).toString());
        dUsuario.setCi(usuario.get(2).toString());
        dUsuario.setTelefono(Integer.valueOf(usuario.get(3).toString()));
        dUsuario.setCorreo(usuario.get(4).toString());
        dUsuario.setPassword(usuario.get(5).toString());
        dUsuario.setSexo(usuario.get(6).toString().charAt(0));
        dUsuario.setTipo(Integer.valueOf(usuario.get(7).toString()));
        dUsuario.setEstado(Boolean.valueOf(usuario.get(8).toString()));
        return dUsuario;
    }
    
    public DUsuario buscarPorCorreo(String correo) {
        List<Object> usuario =(List<Object>) buscar("select * from Usuario where correo='"+correo+"'");
        DUsuario dUsuario = new DUsuario();
        if (usuario==null || usuario.size()==0) {
            return null;
        }
        dUsuario.setId(Integer.valueOf(usuario.get(0).toString()));
        dUsuario.setNombre(usuario.get(1).toString());
        dUsuario.setCi(usuario.get(2).toString());
        dUsuario.setTelefono(Integer.valueOf(usuario.get(3).toString()));
        dUsuario.setCorreo(usuario.get(4).toString());
        dUsuario.setPassword(usuario.get(5).toString());
        dUsuario.setSexo(usuario.get(6).toString().charAt(0));
        dUsuario.setTipo(Integer.valueOf(usuario.get(7).toString()));
        dUsuario.setEstado(Boolean.valueOf(usuario.get(8).toString()));
        return dUsuario;
    }
}