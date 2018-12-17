package Datos;

public class Postgraduante_Oferta extends Template{

    private int id;
    private int user_id;
    private int oferta_id;

    public Postgraduante_Oferta() throws Exception{}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getOferta_id() {
        return oferta_id;
    }

    public void setOferta_id(int oferta_id) {
        this.oferta_id = oferta_id;
    }

    @Override
    public String toString() {
        return "Postgraduante_Oferta{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", oferta_id=" + oferta_id +
                '}';
    }

    @Override
    protected String addT() throws Exception {
        return "INSERT INTO posgraduante_offer(" +
                "offer_id, posgraduante_id)" +
                "VALUES ("+ getOferta_id() +", "+ getUser_id() +");";
    }

    @Override
    protected String updateT() throws Exception {
        return null;
    }

    @Override
    protected String deleteT() throws Exception {
        return null;
    }

    @Override
    protected String getAllT() throws Exception {
        return "SELECT id, offer_id, posgraduante_id" +
                "FROM posgraduante_offer;";
    }

    @Override
    protected int currentColumn() throws Exception {
        return 3;
    }
}
