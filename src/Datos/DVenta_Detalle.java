package Datos;

public class DVenta_Detalle extends Template{

    private int id;
    private String date;
    private int venta_id;
    private int oferta_id;
    private int pago_id;
    private int user_id;

    private String created_at;
    private String updated_at;
    private String deleted_at;

    public DVenta_Detalle() throws Exception {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getVenta_id() {
        return venta_id;
    }

    public void setVenta_id(int venta_id) {
        this.venta_id = venta_id;
    }

    public int getOferta_id() {
        return oferta_id;
    }

    public void setOferta_id(int oferta_id) {
        this.oferta_id = oferta_id;
    }

    public int getPago_id() {
        return pago_id;
    }

    public void setPago_id(int pago_id) {
        this.pago_id = pago_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
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
        return "DVenta_Detalle{" +
                "date='" + date + '\'' +
                ", venta_id=" + venta_id +
                ", oferta_id=" + oferta_id +
                ", pago_id=" + pago_id +
                ", user_id=" + user_id +
                '}';
    }

    @Override
    protected String addT() throws Exception {
        return "INSERT INTO venta_detail(" +
                " date, venta_id, offer_id, pago_id, user_id, created_at)" +
                " VALUES ('"+ getDate() +"', "+ getVenta_id() +", "+ getOferta_id() +", "+ getPago_id()  +", "+ getUser_id() +", NOW());";
    }

    @Override
    protected String updateT() throws Exception {
        return "UPDATE venta_detail" +
                " SET date='"+ getDate() +"', updated_at= NOW()" +
                " WHERE id = "+ getId() +";";
    }

    @Override
    protected String deleteT() throws Exception {
        return "UPDATE venta_detail" +
                " SET deleted_at= NOW()" +
                " WHERE id= "+ getId() +";";
    }

    @Override
    protected String getAllT() throws Exception {
        return "SELECT id, date, venta_id, offer_id, pago_id, user_id" +
                " FROM venta_detail" +
                " WHERE deleted_at is null" +
                " ORDER BY id ASC;";
    }

    @Override
    protected int currentColumn() throws Exception {
        return 6;
    }
}
