package Data;

public class DDetalla_Venta extends Template {

	 private int id;
	    private int id_venta;
	    private int id_persona;
	    private int id_usuario;
	    private int id_evento;
	    private String fecha_comprobante;
	    private String nro_comprobante;
	    private String created_at;
	    private String updated_at;
	    private String deleted_at; 
	    
	    //create an object of SingleObject
	  	private static DDetalla_Venta instance = new DDetalla_Venta();

	  	//make the constructor private so that this class cannot be instantiated
	  	public DDetalla_Venta(){}

	  	//Get the only object available
	  	public static DDetalla_Venta getInstance(){
	  		return instance;
	  	}	

	    public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public int getId_venta() {
			return id_venta;
		}

		public void setId_venta(int id_venta) {
			this.id_venta = id_venta;
		}

		public int getId_persona() {
			return id_persona;
		}

		public void setId_persona(int id_persona) {
			this.id_persona = id_persona;
		}

		public int getId_usuario() {
			return id_usuario;
		}

		public void setId_usuario(int id_usuario) {
			this.id_usuario = id_usuario;
		}

		public int getId_evento() {
			return id_evento;
		}

		public void setId_evento(int id_evento) {
			this.id_evento = id_evento;
		}

		public String getFecha_comprobante() {
			return fecha_comprobante;
		}

		public void setFecha_comprobante(String fecha_comprobante) {
			this.fecha_comprobante = fecha_comprobante;
		}

		public String getNro_comprobante() {
			return nro_comprobante;
		}

		public void setNro_comprobante(String nro_comprobante) {
			this.nro_comprobante = nro_comprobante;
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
			return "DDetalla_Venta [id_venta=" + id_venta + ", id_persona=" + id_persona + ", id_usuario=" + id_usuario
					+ ", id_evento=" + id_evento + ", fecha_comprobante=" + fecha_comprobante + ", nro_comprobante="
					+ nro_comprobante + "]";
		}

		@Override
	    protected String registrar() {
	        return "insert into detalle_venta(id_venta, id_persona, id_usuario, id_evento, fecha_comprobante, nro_comprobante, created_at) values("
	                + id_venta+ "',"
	                + id_persona+ "',"
	                + id_usuario+ "',"
	                + id_evento+"',"
	                + "'"+fecha_comprobante+  "'"
	                + "'"+nro_comprobante+"'"
	                + "'"+created_at+ "'"
	                + ")";
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
	        return "select id_venta, id_persona, id_usuario, id_evento, fecha_comprobante, nro_comprobante from detalle_venta where deleted_at is null";
	    }

	    @Override
	    protected int cantidadAtributos() {
	        return 7;
	    }
}
