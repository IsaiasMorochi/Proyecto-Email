package Data;

import java.util.List;


public class DReserva extends Template {

    private int id;
    private String fecha;
    private int id_persona;
    private int id_evento;
    private String created_at;
    private String updated_at;
    private String deleted_at;
    
    //create an object of SingleObject
  	private static DReserva instance = new DReserva();

  	//make the constructor private so that this class cannot be instantiated
  	public DReserva(){}

  	//Get the only object available
  	public static DReserva getInstance(){
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

    public int getId_persona() {
        return id_persona;
    }

    public void setId_persona(int id_persona) {
        this.id_persona = id_persona;
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
		return "DReserva [fecha=" + fecha + ", id_persona=" + id_persona + ", id_evento=" + id_evento + "]";
	}

	@Override
    protected String registrar() {
        return "insert into reserva (fecha, id_persona, id_evento, created_at) values("
                +"'"+fecha+ "',"
                +id_persona+ ","
                +id_evento+ ","
                +"'"+created_at+ "'"
                + ")";
    }

    @Override
    protected String modificar() {
        return "update reserva set "
                + "fecha="+"'"+fecha+"'"
                + "updated_at="+"'"+updated_at+"'"
                + " where id="+id;
    }

    @Override
    protected String borrar() {
        return "update reserva set "
                +"deleted_at=" +"'"+deleted_at+"'"
                +"where id=" +id;
    }

    @Override
    protected String listado() {
        return "select * from reserva where deleted_at is null";
    }

    @Override
    protected int cantidadAtributos() {
        return 4;
    }
    
     public DReserva buscar(int id) {
        List<Object> rs =(List<Object>) buscar("select * from reserva where id="+ id);
        if (rs!=null && !(rs.isEmpty())) {
            DReserva objeto = new DReserva();
            objeto.setId(Integer.valueOf(rs.get(0).toString()));
            objeto.setFecha(rs.get(1).toString());
            objeto.setId_persona(Integer.valueOf(rs.get(2).toString()));
            objeto.setId_evento(Integer.valueOf(rs.get(3).toString()));
            objeto.setCreated_at(rs.get(4).toString());
            objeto.setUpdated_at(rs.get(5).toString());
            objeto.setDeleted_at(rs.get(6).toString());
            return objeto;
        }
        return null;
    }

}
