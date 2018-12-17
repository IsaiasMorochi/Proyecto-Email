package Datos;

import Nucleo.utilidades.Utils;

import java.util.Date;

public class Grupo extends Template{

    private int id;
    private String name;
    private String description;
    private int role_id;

    private String created_at;
    private String updated_at;
    private String deleted_at;

    public Grupo() throws Exception{}

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
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
        return "Grupo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", role_id=" + role_id +
                ", created_at='" + created_at + '\'' +
                ", updated_at='" + updated_at + '\'' +
                ", deleted_at='" + deleted_at + '\'' +
                '}';
    }

    @Override
    protected String addT() throws Exception {
        return "INSERT INTO group(" +
                "name, description, created_at, role_id) VALUES ("
                + getName() + ", "
                + getDescription() +", "
                + getCreated_at() +", "
                + getRole_id() +");";
    }

    @Override
    protected String updateT() throws Exception {
        return "UPDATE group" +
                "SET  name= "+ getName() +", description= "+ getDescription() +", updated_at= " + Utils.dateToString(new Date()) +", role_id=" + getRole_id() +
                "WHERE id = "+ getId() +";";
    }

    @Override
    protected String deleteT() throws Exception {
        return "UPDATE group" +
                "SET deleted_at=" + Utils.dateToString(new Date()) +
                "WHERE id = "+ getId() +";";
    }

    @Override
    protected String getAllT() throws Exception {
        return "SELECT id, name, description, created_at, updated_at, deleted_at, role_id" +
                "FROM group" +
                "WHERE deleted_at is null;";
    }

    @Override
    protected int currentColumn() throws Exception {
        return 7;
    }
}
