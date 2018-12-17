package Datos;

import Nucleo.utilidades.Utils;

import java.util.Date;

public class DDia extends Template {

    private int id;
    private String name;

    private String created_at;
    private String updated_at;
    private String deleted_at;

    @Override
    protected String addT() throws Exception {
        return "INSERT INTO days(" +
                "name, created_at)" +
                "VALUES ( "+ getName() +", "+ Utils.dateToString(new Date()) +");";
    }

    @Override
    protected String updateT() throws Exception {
        return "UPDATE days" +
                "SET name= "+ getName() +",  updated_at=" + Utils.dateToString(new Date()) +
                "WHERE id = "+ getId() +";";
    }

    @Override
    protected String deleteT() throws Exception {
        return "UPDATE days" +
                "SET name= "+ getName() +", deleted_at=" + Utils.dateToString(new Date()) +
                "WHERE id="+ getId() +";";
    }

    @Override
    protected String getAllT() throws Exception {
        return "SELECT id, name, created_at, updated_at, deleted_at" +
                "FROM days" +
                "WHERE deleted_at is null;";
    }

    @Override
    protected int currentColumn() throws Exception {
        return 5;
    }

    public DDia() throws  Exception{}

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
        return "DDia{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", created_at='" + created_at + '\'' +
                ", updated_at='" + updated_at + '\'' +
                ", deleted_at='" + deleted_at + '\'' +
                '}';
    }


}
