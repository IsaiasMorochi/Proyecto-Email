package Data;

public class DVenta extends Template {
	
    private int id;
    private String fecha;
    private String created_at;
    private String updated_at;
    private String deleted_at;

    //create an object of SingleObject
  	private static DVenta instance = new DVenta();

  	//make the constructor private so that this class cannot be instantiated
  	public DVenta(){}

  	//Get the only object available
  	public static DVenta getInstance(){
  		return instance;
  	}	
    
    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
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
		return "DVenta [fecha=" + fecha + "]";
	}

	@Override
    protected String registrar() {
        return "insert into venta(fecha, created_at) values("
                +"'"+fecha+ "',"
                +"'"+created_at+ "'"
                +")";
    }

    @Override
    protected String modificar() {
        return null;
    }

    @Override
    protected String borrar() {
        return null;
    }

    @Override
    protected String listado() {
        return "select * from venta where deleted_at is null";
    }

    @Override
    protected int cantidadAtributos() {
        return 2;
    }

}
