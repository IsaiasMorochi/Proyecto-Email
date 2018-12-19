package Datos;

import Nucleo.utilidades.Utils;

import java.util.Date;

public class DBoleta extends Template{

    private int id;
    private Double monto;
    private int pago_id;

    private String created_at;
    private String updated_at;
    private String deleted_at;

    public DBoleta() throws Exception{}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public int getPago_id() {
        return pago_id;
    }

    public void setPago_id(int pago_id) {
        this.pago_id = pago_id;
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
        return "DBoleta{" +
                "monto=" + monto +
                ", pago_id=" + pago_id +
                '}';
    }

    @Override
    protected String addT() throws Exception {
        return "INSERT INTO ticket(" +
                "monto, pago_id, created_at) " +
                "VALUES ("
                + getMonto() +", "
                + getPago_id() +", "
                + " NOW());";
    }

    @Override
    protected String updateT() throws Exception {
        return "UPDATE ticket " +
                "SET monto= "+ getMonto() +", updated_at= NOW() " +
                "WHERE id ="+ getId() +";";
    }

    @Override
    protected String deleteT() throws Exception {
        return "UPDATE ticket " +
                "SET deleted_at= NOW() " +
                "WHERE id ="+ getId() +";";
    }

    @Override
    protected String getAllT() throws Exception {
        return "SELECT id, monto, pago_id, created_at, updated_at, deleted_at " +
                "FROM ticket " +
                "WHERE deleted_at is null;";
    }

    @Override
    protected int currentColumn() throws Exception {
        return 6;
    }
}
