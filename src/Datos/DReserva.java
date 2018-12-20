package Datos;

public class DReserva extends Template{

    private int id;
    private String date;
    private String description;
    private int user_id;
    private int oferta_id;

    private String created_at;
    private String updated_at;
    private String deleted_at;

    public DReserva() throws Exception{}

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getOferta_id() {
        return oferta_id;
    }

    public void setOferta_id(int oferta_id) {
        this.oferta_id = oferta_id;
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
        return "DReserva{" +
                "date='" + date + '\'' +
                ", description='" + description + '\'' +
                ", user_id=" + user_id +
                ", oferta_id=" + oferta_id +
                '}';
    }

    @Override
    protected String addT() throws Exception {
        return "INSERT INTO reservation(" +
                "date, description, user_id, offer_id, created_at)" +
                " VALUES ('"+ getDate() +"', '"+ getDescription() +"', "+ getUser_id() +", "+ getOferta_id() +", NOW());";
    }

    @Override
    protected String updateT() throws Exception {
        return "UPDATE reservation" +
                " SET date='"+getDate() +"', description='"+ getDescription() +"', updated_at= NOW()" +
                " WHERE id = "+ getId() +";";
    }

    @Override
    protected String deleteT() throws Exception {
        return "UPDATE reservation" +
                " SET deleted_at= NOW()" +
                " WHERE id = "+ getId() +";";
    }

    @Override
    protected String getAllT() throws Exception {
        return "SELECT id, date, description, user_id, offer_id" +
                " FROM reservation" +
                " WHERE deleted_at is null" +
                " ORDER BY id ASC;";
    }

    @Override
    protected int currentColumn() throws Exception {
        return 5;
    }
}
