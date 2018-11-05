package Data;

import java.util.List;

public class DUsuario extends Template{
    private int id;
    private int id_persona;
    private String correo;
    private String password;
    private String created_at;
    private String updated_at;
    private String deleted_at;
    
    //create an object of SingleObject
  	private static DUsuario instance = new DUsuario();

  	//make the constructor private so that this class cannot be instantiated
  	public DUsuario(){}

  	//Get the only object available
  	public static DUsuario getInstance(){
  		return instance;
  	}	

    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId_persona() {
		return id_persona;
	}

	public void setId_persona(int id_persona) {
		this.id_persona = id_persona;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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
		return "DUsuario [id_persona=" + id_persona + ", correo=" + correo + ", password=" + password + "]";
	}

	@Override
    protected String registrar() {
        return "insert into usuario(id_persona, correo, password, created_at) values("
                +id_persona+ ","
                +"'"+correo+ "',"
                +"'"+password+ "',"
                +"'"+created_at+ "'"
                + ")";
    }

    @Override
    protected String modificar() {
        return "update usuario set "
                + "correo='"+correo+"',"
                + "password='"+password+"',"
                + "updated_at='"+updated_at+"'"
                + " where id="+id;
    }

    @Override
    protected String borrar() {
        return "update usuario set "
                + "deleted_at="+deleted_at + "'"
                + " where id="+id;
    }

    @Override
    protected String listado() {
        return "select * from usuario where deleted_at is null";
    }

    @Override
    protected int cantidadAtributos() {
        return 4;
    }
    
}
