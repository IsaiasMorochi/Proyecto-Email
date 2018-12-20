package Datos;

public class DRol extends Template {

    private int id;
    private String name;

    private String created_at;
    private String updated_at;
    private String deleted_at;

    public DRol() throws Exception{}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        return "DRol{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    protected String addT() throws Exception {
        return "INSERT INTO role(" +
                "name, created_at)" +
                " VALUES ('"+ getName() +"', NOW());";
    }

    @Override
    protected String updateT() throws Exception {
        return "UPDATE role" +
                " SET name='"+ getName() +"', updated_at= NOW()" +
                " WHERE id= "+ getId() +";";
    }

    @Override
    protected String deleteT() throws Exception {
        return "UPDATE role" +
                " SET deleted_at= NOW()" +
                " WHERE id= "+ getId() +";";
    }

    @Override
    protected String getAllT() throws Exception {
        return "SELECT id, name" +
                " FROM role" +
                " WHERE deleted_at is null" +
                " ORDER BY id ASC;";
    }

    @Override
    protected int currentColumn() throws Exception {
        return 2;
    }
}
