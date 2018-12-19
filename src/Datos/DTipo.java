package Datos;

public class DTipo extends Template {

    private String  id;
    private String description;

    private String created_at;
    private String updated_at;
    private String deleted_at;

    public DTipo() throws Exception{}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
        return "DTipo{" +
                "id='" + id + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    protected String addT() throws Exception {
        return "INSERT INTO type( id, description, created_at)" +
                "    VALUES ('"+ getId() +"', '"+ getDescription() +"', NOW());";
    }

    @Override
    protected String updateT() throws Exception {
        return "UPDATE type" +
                " SET description='"+ getDescription() +"', updated_at= NOW() " +
                " WHERE id = '"+ getId() +"';";
    }

    @Override
    protected String deleteT() throws Exception {
        return "UPDATE type" +
                " SET deleted_at= NOW()" +
                " WHERE id = '"+ getId() +"';";
    }

    @Override
    protected String getAllT() throws Exception {
        return "SELECT id, description, created_at, updated_at, deleted_at" +
                " FROM type" +
                " WHERE deleted_at is null";
    }

    @Override
    protected int currentColumn() throws Exception {
        return 5;
    }
}
