package Datos;

public class DPago extends Template {


    private int id;
    private Double monto;
    private String type;

    private String created_at;
    private String updated_at;
    private String deleted_at;

    public DPago() throws Exception{}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
        return "DPago{" +
                "monto=" + monto +
                ", type='" + type + '\'' +
                '}';
    }

    @Override
    protected String addT() throws Exception {
        return "INSERT INTO pago(" +
                "monto, created_at, type)" +
                "VALUES ("+ getMonto() +", NOW(), '"+ getType() +"');";
    }

    @Override
    protected String updateT() throws Exception {
        return "UPDATE pago" +
                " SET  monto="+ getMonto() +", updated_at= NOW(), type='" + getType() +"'"+
                " WHERE id = "+ getId() +";";
    }

    @Override
    protected String deleteT() throws Exception {
        return "UPDATE pago" +
                " SET deleted_at= NOW() "+
                " WHERE id = "+ getId() +";";
    }

    @Override
    protected String getAllT() throws Exception {
        return "SELECT id, monto, type" +
                " FROM pago" +
                " WHERE deleted_at is null" +
                " ORDER BY id ASC;";
    }

    @Override
    protected int currentColumn() throws Exception {
        return 3;
    }
}
