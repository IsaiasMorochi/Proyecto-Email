package Datos;

public class DPeriodo extends Template{

    private int id;
    private String description;
    private String start_date;
    private int oferta_id;

    private String created_at;
    private String updated_at;
    private String deleted_at;

    public DPeriodo() throws Exception{}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
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
        return "DPeriodo{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", start_date='" + start_date + '\'' +
                ", oferta_id=" + oferta_id +
                ", created_at='" + created_at + '\'' +
                ", updated_at='" + updated_at + '\'' +
                ", deleted_at='" + deleted_at + '\'' +
                '}';
    }

    @Override
    protected String addT() throws Exception {
        return "INSERT INTO execution_period(" +
                "offer_id, description, created_at, start_date)" +
                "VALUES ("+ getOferta_id() +", "+ getDescription() +", NOW(), "+ getStart_date() +");";
    }

    @Override
    protected String updateT() throws Exception {
        return "UPDATE execution_period" +
                "SET description="+ getDescription() +", updated_at= NOW(), start_date=" + getStart_date() +
                "WHERE id = "+ getId() +";";
    }

    @Override
    protected String deleteT() throws Exception {
        return "UPDATE execution_period" +
                "SET deleted_at= NOW() " +
                "WHERE id = "+ getId() +";";
    }

    @Override
    protected String getAllT() throws Exception {
        return "SELECT id, offer_id, description, created_at, updated_at, deleted_at, start_date" +
                "FROM execution_period " +
                "WHERE deleted_at is null;";
    }

    @Override
    protected int currentColumn() throws Exception {
        return 7;
    }
}
