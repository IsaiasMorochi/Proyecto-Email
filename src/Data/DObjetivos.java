package Data;

public class DObjetivos extends Template {

    private int id;
    private String nombre;
    private String descripcion;
    private int id_evento;
    private String created_at;
    private String updated_at;
    private String deleted_at;
    
    //create an object of SingleObject
  	private static DObjetivos instance = new DObjetivos();

  	//make the constructor private so that this class cannot be instantiated
  	public DObjetivos(){}

  	//Get the only object available
  	public static DObjetivos getInstance(){
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

    @Override
	public String toString() {
		return "DObjetivos [nombre=" + nombre + ", descripcion=" + descripcion + ", id_evento=" + id_evento + "]";
	}

	@Override
    protected String registrar() {
        return "insert into objetivos(nombre, descripcion, id_evento, created_at) values("
                +"'"+nombre+ "',"
                +"'"+descripcion+ "',"
                +id_evento+ ","
                +"'"+created_at+ "'"
                + ")";
    }

    @Override
    protected String modificar() {
        return "update objetivos set "
                +"nombre = " +"'"+nombre+ "',"
                +"descripcion = " +"'"+descripcion+ "',"
                +"updated_at = " +"'"+updated_at+ "'"
                +"where id=" +id;
    }

    @Override
    protected String borrar() {
        return "update objetivos set "
                +"deleted_at='"+ deleted_at +"'"
                +"where id=" +id;
    }

    @Override
    protected String listado() {
        return "select * from objetivos where deleted_at is null";
    }

    @Override
    protected int cantidadAtributos() {
        return 4;
    }
}
