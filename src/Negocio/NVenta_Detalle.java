package Negocio;

import Datos.DVenta_Detalle;
import java.util.ArrayList;
import java.util.List;

public class NVenta_Detalle {

    private DVenta_Detalle o;

    public NVenta_Detalle() throws Exception{
        this.o = new DVenta_Detalle();
    }

    public DVenta_Detalle getInfo(){
        return o;
    }

    public void add(String date, int venta_id, int oferta_id, int pago_id, int user_id) throws Exception{
        try{
            o.setDate(date);
            o.setVenta_id(venta_id);
            o.setOferta_id(oferta_id);
            o.setPago_id(pago_id);
            o.setUser_id(user_id);
            o.add();
        } catch (Exception e){
            throw e;
        }
    }

    public void update(int id, String date) throws Exception{
        try{
            o.setId(id);
            o.setDate(date);
            o.update();
        } catch (Exception e){
            throw e;
        }
    }

    public void delete(int id) throws Exception{
        try{
            o.setId(id);
            o.delete();
        } catch (Exception e){
            throw e;
        }
    }

    private List<DVenta_Detalle> getAll() throws Exception{
        List<DVenta_Detalle> ob = new ArrayList<>();
        List<Object> lista = (List<Object>) this.o.getAll();
        try {
            for (Object objecto : lista) {
                List<Object> obj = (List<Object>) objecto;
                DVenta_Detalle oo = new DVenta_Detalle();

                oo.setId(Integer.valueOf(obj.get(0).toString()));
                oo.setDate(obj.get(1).toString());
                oo.setVenta_id(Integer.valueOf(obj.get(2).toString()));
                oo.setOferta_id(Integer.valueOf(obj.get(3).toString()));
                oo.setPago_id(Integer.valueOf(obj.get(4).toString()));
                oo.setUser_id(Integer.valueOf(obj.get(5).toString()));

                ob.add(oo);
            }
        } catch (Exception e) {
            throw e;
        }
        return ob;
    }

    public String Mostrar() throws Exception {
        String rx = "DETALLE DE VENTA \n\n";
        try {
            List<DVenta_Detalle> lObj = this.getAll();
            for (DVenta_Detalle obj : lObj) {
                rx = rx +
                        "Codigo: " + obj.getId() +
                        "\nFecha: " + obj.getDate() +
                        "\nID Venta: " + obj.getVenta_id() +
                        "\nID Oferta: " + obj.getOferta_id() +
                        "\nID Pago: " + obj.getPago_id() +
                        "\nID User: " + obj.getUser_id() +
                        "\n\n"
                ;
            }
        } catch (Exception e){
            throw e;
        }
        return rx;
    }
}
