package Datos;

import Nucleo.utilidades.Utils;

import java.util.Date;

public class DHorario extends Template {

    private int id;
    private String description;
    private int periodo_id;

    private String created_at;
    private String updated_at;
    private String deleted_at;

    public DHorario() throws Exception{}

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

    public int getPeriodo_id() {
        return periodo_id;
    }

    public void setPeriodo_id(int periodo_id) {
        this.periodo_id = periodo_id;
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
        return "DHorario{" +
                "description='" + description + '\'' +
                ", periodo_id=" + periodo_id +
                '}';
    }

    @Override
    protected String addT() throws Exception {
        return "INSERT INTO horario(" +
                "execution_period_id, description, created_at)" +
                " VALUES ("+ getPeriodo_id() +", '"+ getDescription() +"', NOW() );";
    }

    @Override
    protected String updateT() throws Exception {
        return "UPDATE horario" +
                " SET description= '" + getDescription() +"', updated_at= NOW()" +
                " WHERE id = "+ getId() +";";
    }

    @Override
    protected String deleteT() throws Exception {
        return "UPDATE horario" +
                " SET description= '" + getDescription() +"', deleted_at= NOW() "+
                " WHERE id = "+ getId() +";";
    }

    @Override
    protected String getAllT() throws Exception {
        return "SELECT id, execution_period_id, description" +
                " FROM horario " +
                " WHERE deleted_at is null " +
                " ORDER BY id ASC;";
    }

    @Override
    protected int currentColumn() throws Exception {
        return 6;
    }
}
