package Datos;

import Nucleo.utilidades.Utils;

import java.util.Date;

public class DObjetivo extends Template{

    private int id;
    private String description;
    private int oferta_id;

    private String created_at;
    private String updated_at;
    private String deleted_at;

    public DObjetivo() throws Exception{}

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
        return "DObjetivo{" +
                "description='" + description + '\'' +
                ", oferta_id=" + oferta_id +
                '}';
    }

    @Override
    protected String addT() throws Exception {
        return "INSERT INTO objetive(" +
                "offer_id, description, created_at)" +
                " VALUES ("+ getOferta_id() +", '"+ getDescription() +"' , NOW());";
    }

    @Override
    protected String updateT() throws Exception {
        return "UPDATE objetive" +
                " SET  description= '"+ getDescription() +"', update_at= NOW() " +
                " WHERE id = "+ getId() +";";
    }

    @Override
    protected String deleteT() throws Exception {
        return "UPDATE objetive" +
                " SET deleted_at= NOW()" +
                " WHERE id = "+ getId() +";";
    }

    @Override
    protected String getAllT() throws Exception {
        return "SELECT id, offer_id, description" +
                " FROM objetive" +
                " WHERE deleted_at is null" +
                " ORDER BY id ASC;";
    }

    @Override
    protected int currentColumn() throws Exception {
        return 3;
    }
}
