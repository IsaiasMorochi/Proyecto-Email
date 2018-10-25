package Data;

public class DCronograma extends Template {
	
    private int id;
    private int id_evento;
    private String created_at;
    private String updated_at;
    private String deleted_at;
    
    //create an object of SingleObject
  	private static DCronograma instance = new DCronograma();

  	//make the constructor private so that this class cannot be instantiated
  	public DCronograma(){}

  	//Get the only object available
  	public static DCronograma getInstance(){
  		return instance;
  	}	

    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
    protected String registrar() {
        return "insert into cronograma(id_evento, created_at) values("
                + id_evento+ ","
                + "'"+created_at+ "'"
                + ")";
    }

    @Override
    protected String modificar() {
        return "update cronograma set "
                + "id_evento='"+id_evento+"',"
                + "updated_at='"+updated_at+"'"
                + " where id="+id;
    }

    @Override
    protected String borrar() {
        return "update cronograma set "
                + "deleted_at= '"+deleted_at+"'"
                + " where id="+id;
    }

    @Override
    protected String listado() {
        return "select * from cronograma where deleted_at is null";
    }

    @Override
    protected int cantidadAtributos() {
        return 2;
    }
}
