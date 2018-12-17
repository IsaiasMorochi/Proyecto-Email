package Datos;

public class DVenta extends Template{

    private int id;
    private Double total;
    private int user_id;

    private String created_at;
    private String updated_at;
    private String deleted_at;

    public DVenta() throws Exception{}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
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
        return "DVenta{" +
                "id=" + id +
                ", total=" + total +
                ", user_id=" + user_id +
                ", created_at='" + created_at + '\'' +
                ", updated_at='" + updated_at + '\'' +
                ", deleted_at='" + deleted_at + '\'' +
                '}';
    }

    @Override
    protected String addT() throws Exception {
        return "INSERT INTO venta(" +
                "    total, user_id, created_at)" +
                "    VALUES ("+ getTotal() +", "+ getUser_id() +", NOW());";
    }

    @Override
    protected String updateT() throws Exception {
        return "UPDATE venta" +
                "   SET total=?, updated_at= NOW()" +
                " WHERE id= "+ getId() +";";
    }

    @Override
    protected String deleteT() throws Exception {
        return "UPDATE venta" +
                "   SET deleted_at= NOW()" +
                " WHERE id= "+ getId() +";";
    }

    @Override
    protected String getAllT() throws Exception {
        return "SELECT id, total, user_id, created_at, updated_at, deleted_at" +
                "FROM venta" +
                "WHERE id= "+ getId() +";";
    }

    @Override
    protected int currentColumn() throws Exception {
        return 6;
    }
}
