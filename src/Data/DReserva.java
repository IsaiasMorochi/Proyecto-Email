package Data;


public class DReserva extends Template {

    private int id;
    private String fecha;
    private int id_persona;
    private int id_evento;
    private String create_at;
    private String update_at;
    private String delete_at;

    private DReserva(){

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

    public String getCreate_at() {
        return create_at;
    }

    public void setCreate_at(String create_at) {
        this.create_at = create_at;
    }

    public String getUpdate_at() {
        return update_at;
    }

    public void setUpdate_at(String update_at) {
        this.update_at = update_at;
    }

    public String getDelete_at() {
        return delete_at;
    }

    public void setDelete_at(String delete_at) {
        this.delete_at = delete_at;
    }

    @Override
    protected String registrar() {
        return "insert into reserva (fecha, id_persona, id_evento, create_at) values("
                +"'"+fecha+ "',"
                +id_persona+ ","
                +id_evento+ ","
                +"'"+create_at+ "',"
                + ")";
    }

    @Override
    protected String modificar() {
        return "update reserva set "
                + "fecha="+"'"+fecha+"'"
                + "update_at="+"'"+update_at+"'"
                + " where id="+id;
    }

    @Override
    protected String borrar() {
        return "update reserva set "
                +"delete_at=" +"'"+delete_at+"'"
                +"where id=" +id;
    }

    @Override
    protected String listado() {
        return "select * from reserva where delete_at is null";
    }

    @Override
    protected int cantidadAtributos() {
        return 4;
    }

}
