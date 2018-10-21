package Data;

public class DPersona extends Template {
    private int id;
    private String nombre;
    private String telefono;
    private String nacionalidad;
    private String ci;
    private String direccion;
    private String tipo;
    private String created_at;
    private String updated_at;
    private String deleted_at;

    @Override
    protected String registrar() {
        return "insert into persona(nombre, telefono, nacionalidad, direccion, created_at) values("
                +"'"+nombre+ "',"
                +"'"+telefono+ "',"
                +"'"+nacionalidad+ "',"
                +"'"+direccion+"',"
                +"'"+created_at+"'"
                + ")";
    }

    @Override
    protected String modificar() {
        return "update persona set "
                + "nombre='"+nombre+"',"
                + "telefono='"+telefono+"',"
                + "nacionalidad='"+nacionalidad+"',"
                + "ci='"+ci+"',"
                + "direccion='"+direccion+"',"
                + "updated_at='"+updated_at+"',"
                + " where id="+id;
    }

    @Override
    protected String borrar() {
        return "update persona set "
                + "deleted_at="+deleted_at
                + " where id="+id;
    }

    @Override
    protected String listado() {
        return "select * from persona where deleted_at is null";
    }

    @Override
    protected int cantidadAtributos() {
        return 6;
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getCi() {
        return ci;
    }

    public void setCi(String ci) {
        this.ci = ci;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
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
}
