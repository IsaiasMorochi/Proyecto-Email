package Data;

import java.sql.ResultSet;

public class DEvento extends Template {
	
    private int id;
    private String titulo;
    private String fecha_inicio;
    private String fecha_fin;
    private float costo;
    private char tipo;
    private String created_at;
    private String updated_at;
    private String deleted_at;
    
    //create an object of SingleObject
  	private static DEvento instance = new DEvento();

  	//make the constructor private so that this class cannot be instantiated
  	public DEvento(){}

  	//Get the only object available
  	public static DEvento getInstance(){
  		return instance;
  	}	
    
    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getFecha_inicio() {
		return fecha_inicio;
	}

	public void setFecha_inicio(String fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}

	public String getFecha_fin() {
		return fecha_fin;
	}

	public void setFecha_fin(String fecha_fin) {
		this.fecha_fin = fecha_fin;
	}

	public float getCosto() {
		return costo;
	}

	public void setCosto(float costo) {
		this.costo = costo;
	}

	public char getTipo() {
		return tipo;
	}

	public void setTipo(char tipo) {
		this.tipo = tipo;
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
		return "DEvento [titulo=" + titulo + ", fecha_inicio=" + fecha_inicio + ", fecha_fin=" + fecha_fin + ", costo="
				+ costo + ", tipo=" + tipo + "]";
	}

	@Override
    protected String registrar() {
        return "insert into evento(titulo, fecha_inicio, fecha_fin, costo, tipo, created_at) values("
                +"'"+titulo+ "',"
                +"'"+fecha_inicio+ "',"
                +"'"+fecha_fin+ "',"
                +"'"+costo+"',"
                +"'"+tipo+"',"
                +"'"+created_at+"'"
                +")";
    }

    @Override
    protected String modificar() {
        return "update evento set "
                + "titulo='"+titulo+"',"
                + "fecha_inicio='"+fecha_inicio+"',"
                + "fecha_fin='"+fecha_fin+"',"
                + "costo='"+costo+"',"
                + "tipo='"+tipo+"',"
                + "updated_at='"+updated_at+"'"
                + " where id="+id;
    }

    @Override
    protected String borrar() {
        return "update evento set "
                + "deleted_at= '"+deleted_at +"'"
                + " where id="+id;
    }

    @Override
    protected String listado() {
        return "select * from evento where deleted_at is null";
    }

    @Override
    protected int cantidadAtributos() {
        return 6;
    }
    
    public ResultSet obtenerReporte(){
        String consulta = " select p.nombre as nombre, COUNT(dv.id_persona) as Cantidad "
                + " from evento e, detalle_venta dv, persona p"
                + " where e.id = dv.id_evento and dv.id_persona = p.id"
                + " group by p.nombre ";
        return consultarDatos(consulta);
    }
    
    public ResultSet obtenerEstadistica(){
        String consulta = " select p.nombre as nombre, SUM(dv.id_persona) as Total "
                + " from evento e, detalle_venta dv, persona p"
                + " where e.id = dv.id_evento and dv.id_persona = p.id"
                + " group by p.nombre ";
        return consultarDatos(consulta);
    }
    
}
