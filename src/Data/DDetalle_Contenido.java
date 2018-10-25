package Data;

public class DDetalle_Contenido extends Template {
	
    private int id;
    private int id_contenido;
    private String descripcion;
    private String created_at;
    private String updated_at;
    private String deleted_at;
    
    //create an object of SingleObject
  	private static DDetalle_Contenido instance = new DDetalle_Contenido();

  	//make the constructor private so that this class cannot be instantiated
  	public DDetalle_Contenido(){}

  	//Get the only object available
  	public static DDetalle_Contenido getInstance(){
  		return instance;
  	}	

    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId_contenido() {
		return id_contenido;
	}

	public void setId_contenido(int id_contenido) {
		this.id_contenido = id_contenido;
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
    protected String registrar() {
        return "insert into detalle_contenido(id_contenido, descripcion, created_at) values("
                + "'"+ id_contenido + "',"
                + "'"+ descripcion + "',"
                + "'"+ created_at + "'"
                + ")";
    }

    @Override
    protected String modificar() {
        return "update detalle_contenido set "
                + "descripcion='"+ descripcion +"',"
                + "updated_at='"+ updated_at +"'"
                + "where id="+id;
    }

    @Override
    protected String borrar() {
        return "update detalle_contenido set "
                + "deleted_at='"+ deleted_at +"'"
                + "where id="+id;
    }

    @Override
    protected String listado() {
        return "select id, descripcion from detalle_contenido where deleted_at is null";
    }

    @Override
    protected int cantidadAtributos() {
        return 3;
    }
}
