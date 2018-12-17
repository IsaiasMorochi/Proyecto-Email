package Datos;

import Nucleo.utilidades.Utils;

import java.util.Date;

public class Boleta extends Template{

    private int id;
    private Double monto;
    private int pago_id;

    private String created_at;
    private String updated_at;
    private String deleted_at;

    public Boleta() throws Exception{}

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
        return "Boleta{" +
                "id=" + id +
                ", monto=" + monto +
                ", pago_id=" + pago_id +
                ", created_at='" + created_at + '\'' +
                ", updated_at='" + updated_at + '\'' +
                ", deleted_at='" + deleted_at + '\'' +
                '}';
    }

    @Override
    protected String addT() throws Exception {
        return "INSERT INTO public.ticket(" +
                "monto, pago_id, created_at)" +
                "VALUES ("
                + getMonto() +", "
                + getPago_id() +", "
                + Utils.dateToString(new Date()) +");";
    }

    @Override
    protected String updateT() throws Exception {
        return "UPDATE ticket" +
                "SET monto= "+ getMonto() +", updated_at="+ Utils.dateToString(new Date()) +
                "WHERE id ="+ getId() +";";
    }

    @Override
    protected String deleteT() throws Exception {
        return "UPDATE ticket" +
                "SET deleted_at="+ Utils.dateToString(new Date()) +
                "WHERE id ="+ getId() +";";
    }

    @Override
    protected String getAllT() throws Exception {
        return "SELECT id, monto, pago_id, created_at, updated_at, deleted_at" +
                "FROM ticket" +
                "WHERE deleted_at is null;";
    }

    @Override
    protected int currentColumn() throws Exception {
        return 6;
    }
}
