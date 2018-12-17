package Datos;

import Nucleo.utilidades.Utils;
import java.util.Date;

public class DDirigido extends Template{

    private int id;
    private String description;
    private int oferta_id;

    private String created_at;
    private String updated_at;
    private String deleted_at;

    public DDirigido() throws Exception{}

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
        return "DDirigido{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", oferta_id=" + oferta_id +
                ", created_at='" + created_at + '\'' +
                ", updated_at='" + updated_at + '\'' +
                ", deleted_at='" + deleted_at + '\'' +
                '}';
    }

    @Override
    protected String addT() throws Exception {
        return "INSERT INTO target_people(" +
                "offer_id, description, created_at)" +
                "VALUES ( "+ getOferta_id() +", "+ getDescription() +", "+ Utils.dateToString(new Date()) +");";
    }

    @Override
    protected String updateT() throws Exception {
        return "UPDATE target_people" +
                "SET description= "+ getDescription() +",  updated_at="+ Utils.dateToString(new Date()) +
                "WHERE id = "+ getId() +";";
    }

    @Override
    protected String deleteT() throws Exception {
        return "UPDATE target_people" +
                "SET deleted_at=" + Utils.dateToString(new Date()) +
                "WHERE id = "+ getId() +";";
    }

    @Override
    protected String getAllT() throws Exception {
        return "SELECT id, offer_id, description, created_at, updated_at, deleted_at" +
                "FROM target_people" +
                "WHERE deleted_at is null;";
    }

    @Override
    protected int currentColumn() throws Exception {
        return 6;
    }
}
