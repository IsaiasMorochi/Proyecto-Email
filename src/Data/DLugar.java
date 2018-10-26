package Data;

public class DLugar extends Template {
	
    private int id;
    private String descripcion;
    private String created_at;
    private String updated_at;
    private String deleted_at;
    
    //create an object of SingleObject
  	private static DLugar instance = new DLugar();

  	//make the constructor private so that this class cannot be instantiated
  	public DLugar(){}

  	//Get the only object available
  	public static DLugar getInstance(){
  		return instance;
  	}	

    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
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
		return "DLugar [descripcion=" + descripcion + "]";
	}

	@Override
    protected String registrar() {
        return "insert into lugar(descripcion, created_at) values("
                +"'"+descripcion+ "',"
                +"'"+created_at+"'"
                + ")";
    }

    @Override
    protected String modificar() {
        return "update lugar set "
                + "descripcion='"+descripcion+"',"
                + "updated_at='"+updated_at+"'"
                + "where id="+id;
    }

    @Override
    protected String borrar() {
        return "update lugar set "
                + "deleted_at='"+deleted_at+"'"
                + "where id="+id;
    }

    @Override
    protected String listado() {
        return "select id, descripcion from lugar where deleted_at is null";
    }

    @Override
    protected int cantidadAtributos() {
        return 2;
    }

}
