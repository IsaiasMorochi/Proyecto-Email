package Data;

import java.util.List;

public class DPersona extends Template {
	
    private int id;
    private String nombre;
    private String telefono;
    private String nacionalidad;
    private String ci;
    private String direccion;
    private String tipo;
    private String created_at;
    private String updated_at;
    private String deleted_at;
    
    //create an object of SingleObject
  	private static DPersona instance = new DPersona();

  	//make the constructor private so that this class cannot be instantiated
  	public DPersona(){}

  	//Get the only object available
  	public static DPersona getInstance(){
  		return instance;
  	}	

    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public String getCi() {
		return ci;
	}

	public void setCi(String ci) {
		this.ci = ci;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getCreated_at() {
		return created_at;
	}

	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}

	public String getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(String updated_at) {
		this.updated_at = updated_at;
	}

	public String getDeleted_at() {
		return deleted_at;
	}

	public void setDeleted_at(String deleted_at) {
		this.deleted_at = deleted_at;
	}

	@Override
	public String toString() {
		return "DPersona [nombre=" + nombre + ", telefono=" + telefono + ", nacionalidad=" + nacionalidad + ", ci=" + ci
				+ ", direccion=" + direccion + ", tipo=" + tipo + "]";
	}

	@Override
    protected String registrar() {
        return "insert into persona(nombre, telefono, nacionalidad, direccion, created_at) values("
                +"'"+nombre+ "',"
                +"'"+telefono+ "',"
                +"'"+nacionalidad+ "',"
                +"'"+direccion+"',"
                +"'"+created_at+"'"
                + ")";
    }

    @Override
    protected String modificar() {
        return "update persona set "
                + "nombre='"+nombre+"',"
                + "telefono='"+telefono+"',"
                + "nacionalidad='"+nacionalidad+"',"
                + "ci='"+ci+"',"
                + "direccion='"+direccion+"',"
                + "updated_at='"+updated_at+"'"
                + " where id="+id;
    }

    @Override
    protected String borrar() {
        return "update persona set "
                + "deleted_at="+ deleted_at +"'"
                + " where id="+id;
    }

    @Override
    protected String listado() {
        return "select * from persona where deleted_at is null";
    }

    @Override
    protected int cantidadAtributos() {
        return 6;
    }
    
    public DPersona buscar(int id) {
        List<Object> usuario =(List<Object>) buscar("select * from persona where id="+id);
        DPersona p = new DPersona();
        
        p.setId(Integer.valueOf(usuario.get(0).toString()));
        p.setNombre(usuario.get(1).toString());
        p.setTelefono(usuario.get(2).toString());
        p.setNacionalidad(usuario.get(3).toString());
        p.setCi(usuario.get(4).toString());
        p.setTipo(usuario.get(5).toString());
        p.setDireccion(usuario.get(6).toString());
         
        return p;
    }
    
    public DPersona buscarPorCorreo(String correo) {
        List<Object> usuario =(List<Object>) buscar("select id from usuario where correo='"+correo+"'");
        DPersona p = DPersona.getInstance();
        if (usuario==null || usuario.size()==0) {
            return null;
        }
        p.setId(Integer.valueOf(usuario.get(0).toString()));
        p.setNombre(usuario.get(1).toString());
        p.setTelefono(usuario.get(2).toString());
        p.setNacionalidad(usuario.get(3).toString());
        p.setCi(usuario.get(4).toString());
        p.setDireccion(usuario.get(5).toString());
        p.setDireccion(usuario.get(6).toString());
        
        return p;
    }

    
    
    
}
