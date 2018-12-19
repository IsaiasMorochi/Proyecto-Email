package Datos;

import Nucleo.utilidades.Utils;

import java.util.Date;

public class DHorario_Dia extends Template {

    private int id;
    private int horario_id;
    private int dia_id;

    private String created_at;
    private String updated_at;
    private String deleted_at;

    public DHorario_Dia() throws Exception{}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHorario_id() {
        return horario_id;
    }

    public void setHorario_id(int horario_id) {
        this.horario_id = horario_id;
    }

    public int getDia_id() {
        return dia_id;
    }

    public void setDia_id(int dia_id) {
        this.dia_id = dia_id;
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
        return "DHorario_Dia{" +
                "horario_id=" + horario_id +
                ", dia_id=" + dia_id +
                '}';
    }

    @Override
    protected String addT() throws Exception {
        return "INSERT INTO horario_days(" +
                "horario_id, days_id, created_at)" +
                "VALUES ("+ getHorario_id() +", "+ getDia_id() +", NOW() );";
    }

    @Override
    protected String updateT() throws Exception {
        return null;
    }

    @Override
    protected String deleteT() throws Exception {
        return "UPDATE horario_days" +
                "SET deleted_at= NOW() " +
                "WHERE id =" + getId() +";";
    }

    @Override
    protected String getAllT() throws Exception {
        return "SELECT id, horario_id, days_id, created_at, updated_at, deleted_at" +
                " FROM horario_days" +
                " WHERE deleted_at is null;";
    }

    @Override
    protected int currentColumn() throws Exception {
        return 6;
    }
}
