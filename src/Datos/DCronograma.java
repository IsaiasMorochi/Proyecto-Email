package Datos;

import Nucleo.utilidades.Utils;

import java.util.Date;

public class DCronograma extends Template {

    private int id;
    private String description;
    private String period;

    private String created_at;
    private String updated_at;
    private String deleted_at;

    public DCronograma() throws Exception {}

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

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
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
        return "DCronograma{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", period='" + period + '\'' +
                ", created_at='" + created_at + '\'' +
                ", updated_at='" + updated_at + '\'' +
                ", deleted_at='" + deleted_at + '\'' +
                '}';
    }

    @Override
    protected String addT() throws Exception {
        return "INSERT INTO schedule(" +
                "description, created_at, period)" +
                "VALUES (" + getDescription() +","+ Utils.dateToString(new Date()) +", "+ getPeriod() +");";
    }

    @Override
    protected String updateT() throws Exception {
        return "UPDATE schedule" +
                "SET description="+ getDescription() +", updated_at="+ Utils.dateToString(new Date()) +", period= "+ getPeriod() +
                "WHERE id= "+ getId() +";";
    }

    @Override
    protected String deleteT() throws Exception {
        return "UPDATE schedule" +
                "SET deleted_at ="+ Utils.dateToString(new Date()) +
                "WHERE id "+ getId() +";";
    }

    @Override
    protected String getAllT() throws Exception {
        return "SELECT id, description, created_at, updated_at, deleted_at, period" +
                "FROM schedule " +
                "WHERE deleted_at is null ;";
    }

    @Override
    protected int currentColumn() throws Exception {
        return 6;
    }


}


