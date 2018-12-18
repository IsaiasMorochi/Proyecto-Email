package Negocio;

import Datos.DReserva;
import com.sun.org.apache.bcel.internal.generic.DREM;

import java.util.ArrayList;
import java.util.List;

public class NReserva {

    private DReserva o;

    public NReserva() throws Exception{
        this.o = new DReserva();
    }

    public void add(String date, String description, int user_id, int oferta_id) throws Exception {
        try{
            o.setDate(date);
            o.setDescription(description);
            o.setUser_id(user_id);
            o.setOferta_id(oferta_id);
            o.add();
        } catch (Exception e){
            throw e;
        }
    }

    public void update(int id, String date, String description) throws Exception {
        try{
            o.setId(id);
            o.setDate(date);
            o.setDescription(description);
            o.update();
        } catch (Exception e){
            throw e;
        }
    }

    public void delete(int id) throws Exception {
        try{
            o.setId(id);
            o.delete();
        } catch (Exception e){
            throw e;
        }
    }

    private List<DReserva> getAll() throws Exception{
        List<DReserva> ob = new ArrayList<>();
        List<Object> lista = (List<Object>) this.o.getAll();
        try {
            for (Object objecto : lista) {
                List<Object> obj = (List<Object>) objecto;
                DReserva oo = new DReserva();

                oo.setId(Integer.valueOf(obj.get(0).toString()));
                oo.setDate(obj.get(1).toString());
                oo.setDescription(obj.get(2).toString());
                oo.setUser_id(Integer.valueOf(obj.get(3).toString()));
                oo.setOferta_id(Integer.valueOf(obj.get(4).toString()));

                ob.add(oo);
            }
        } catch (Exception e) {
            throw e;
        }
        return ob;
    }

    public String Mostrar() throws Exception {
        String rx = "RESERVA \n\n";
        try {
            List<DReserva> lObj = this.getAll();
            for (DReserva obj : lObj) {
                rx = rx +
                        "Codigo: " + obj.getId()+
                        "\nFecha: " + obj.getOferta_id() +
                        "\nDescripcion: " + obj.getDescription() +
                        "\nID Cliente: " + obj.getDescription() +
                        "\nID Oferta: " + obj.getDescription() +
                        "\n\n"
                ;
            }
        } catch (Exception e){
            throw e;
        }
        return rx;
    }
}
