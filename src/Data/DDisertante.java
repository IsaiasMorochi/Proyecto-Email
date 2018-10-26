package Data;

public class DDisertante extends Template {

    private int id;
    private String nombre;
    private String foto;
    private String nacionalidad;
    private String descripcion;
    private int id_evento;
    private String created_at;
    private String updated_at;
    private String deleted_at;
    
    //create an object of SingleObject
  	private static DDisertante instance = new DDisertante();

  	//make the constructor private so that this class cannot be instantiated
  	public DDisertante(){}

  	//Get the only object available
  	public static DDisertante getInstance(){
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

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getId_evento() {
		return id_evento;
	}

	public void setId_evento(int id_evento) {
		this.id_evento = id_evento;
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

	public static void setInstance(DDisertante instance) {
		DDisertante.instance = instance;
	}	

	@Override
	public String toString() {
		return "DDisertante [nombre=" + nombre + ", foto=" + foto + ", nacionalidad=" + nacionalidad + ", descripcion="
				+ descripcion + ", id_evento=" + id_evento + "]";
	}

	@Override
    protected String registrar() {
        return "insert into disertante(nombre, foto, nacionalidad, descripcion, id_evento, created_at) values("
                +"'"+nombre+ "',"
                +"'"+foto+ "',"
                +"'"+nacionalidad+ "',"
                +"'"+descripcion+ "',"
                +id_evento+ ","
                +"'"+created_at+ "'"
                + ")";                                  
    }

    @Override
    protected String modificar() {
        return "update disertante set "
                + "nombre = '"+ nombre +"',"
                + "foto = '"+ foto +"',"
                + "nacionalidad = '"+ nacionalidad +"',"
                + "descripcion = '"+ descripcion +"',"
                + "updated_at = '"+ updated_at +"'"
                + "where id ="+ id 
                + ")";
    }

    @Override
    protected String borrar() {
        return "update disertante set "
                +"deleted_at = '"+ deleted_at+"'"
                +"where id = " +id;
    }

    @Override
    protected String listado() {
        return "select * where deleted_at is null";
    }

    @Override
    protected int cantidadAtributos() {
        return 5;
    }
}
