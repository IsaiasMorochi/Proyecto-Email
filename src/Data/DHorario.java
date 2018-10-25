package Data;

public class DHorario extends Template {
	
    private int id;
    private int id_cronograma;
    private int id_dia;
    private int id_lugar;
    private String inicio;
    private String fin;
    private String created_at;
    private String updated_at;
    private String deleted_at;

    //create an object of SingleObject
  	private static DHorario instance = new DHorario();

  	//make the constructor private so that this class cannot be instantiated
  	public DHorario(){}

  	//Get the only object available
  	public static DHorario getInstance(){
  		return instance;
  	}	

    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId_cronograma() {
		return id_cronograma;
	}

	public void setId_cronograma(int id_cronograma) {
		this.id_cronograma = id_cronograma;
	}

	public int getId_dia() {
		return id_dia;
	}

	public void setId_dia(int id_dia) {
		this.id_dia = id_dia;
	}

	public int getId_lugar() {
		return id_lugar;
	}

	public void setId_lugar(int id_lugar) {
		this.id_lugar = id_lugar;
	}

	public String getInicio() {
		return inicio;
	}

	public void setInicio(String inicio) {
		this.inicio = inicio;
	}

	public String getFin() {
		return fin;
	}

	public void setFin(String fin) {
		this.fin = fin;
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
        return "insert into horario(id_cronograma, id_dia, id_lugar, inicio, fin, created_at) values("
                +id_cronograma+ ","
                +id_dia+ ","
                +id_lugar+ ","
                +"'"+inicio+","
                +"'"+fin+"',"
                +"'"+created_at+"'"
                +")";
    }

    @Override
    protected String modificar() {
        return "update horario set "
                + "inicio='"+inicio+"',"
                + "fin='"+fin+"',"
                + "updated_at='"+updated_at+"'"
                + "where id="+id;
    }

    @Override
    protected String borrar() {
        return "update horario set "
                + "deleted_at='"+deleted_at+"'"
                + " where id="+id;
    }

    @Override
    protected String listado() {
        return "select * from horario where deleted_at is null";
    }

    @Override
    protected int cantidadAtributos() {
        return 6;
    }
    
}
