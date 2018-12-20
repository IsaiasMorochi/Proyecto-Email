package Datos;

import Nucleo.utilidades.Utils;

import java.util.Date;

public class DCronograma_Detalle extends Template {

    private int id;
    private int cronograma_id;
    private int oferta_id;

    private String created_at;
    private String updated_at;
    private String deleted_at;

    public DCronograma_Detalle() throws Exception{}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCronograma_id() {
        return cronograma_id;
    }

    public void setCronograma_id(int cronograma_id) {
        this.cronograma_id = cronograma_id;
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
        return "DCronograma_Detalle{" +
                "cronograma_id=" + cronograma_id +
                ", oferta_id=" + oferta_id +
                '}';
    }

    @Override
    protected String addT() throws Exception {
        return "INSERT INTO schedule_detail(" +
                "schedule_id, offer_id, created_at)" +
                "VALUES ("+ getCronograma_id() +", "+ getOferta_id() +", NOW() );";
    }

    @Override
    protected String updateT() throws Exception {
        return "UPDATE schedule_detail " +
                " SET updated_at= NOW() " +
                " WHERE id = "+ getId() +";";
    }

    @Override
    protected String deleteT() throws Exception {
        return "UPDATE schedule_detail" +
                " SET deleted_at= NOW()" +
                " WHERE id ="+ getId() +";";
    }

    @Override
    protected String getAllT() throws Exception {
        return "SELECT id, schedule_id, offer_id" +
                " FROM schedule_detail " +
                " WHERE deleted_at is null" +
                " ORDER BY id ASC;";
    }

    @Override
    protected int currentColumn() throws Exception {
        return 3;
    }
}
