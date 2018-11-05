package Data;

public class DRequisito extends Template {

    private int id;
    private String descripcion;
    private int id_evento;
    private String created_at;
    private String updated_at;
    private String deleted_at;
    
    //create an object of SingleObject
  	private static DRequisito instance = new DRequisito();

  	//make the constructor private so that this class cannot be instantiated
  	public DRequisito(){}

  	//Get the only object available
  	public static DRequisito getInstance(){
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

    public int getId_evento() {
        return id_evento;
    }

    public void setId_evento(int id_evento) {
        this.id_evento = id_evento;
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
		return "DRequisito [descripcion=" + descripcion + ", id_evento=" + id_evento + "]";
	}

	@Override
    protected String registrar() {
        return "insert into requisitos (id_evento, descripcion, created_at) values("
                +id_evento+ ","
                +"'"+descripcion+ "',"
                +"'"+created_at+ "'"
                +")";
    }

    @Override
    protected String modificar() {
        return "update requisitos set "
                +"descripcion = '"+descripcion+ "',"
                +"updated_at = '"+updated_at+ "'"
                +"where id=" +id;
    }

    @Override
    protected String borrar() {
        return "update requisitos set "
                +"deleted_at=" +"'"+deleted_at+"'"
                +"where id=" +id;
    }

    @Override
    protected String listado() {
        return "select * from requisitos where deleted_at is null";
    }

    @Override
    protected int cantidadAtributos() {
        return 3;
    }
}
