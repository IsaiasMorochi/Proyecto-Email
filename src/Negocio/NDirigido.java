package Negocio;

import Datos.DDirigido;

import java.util.ArrayList;
import java.util.List;

public class NDirigido {

    private DDirigido o;

    public NDirigido() throws Exception{
        this.o = new DDirigido();
    }

    public void add(String description, int oferta_id) throws Exception {
        try{
            o.setDescription(description);
            o.setOferta_id(oferta_id);
            o.add();
        } catch (Exception e){
            throw e;
        }
    }

    public void update(int id, String description) throws Exception {
        try{
            o.setId(id);
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

    public List<DDirigido> getAll() throws Exception{
        List<DDirigido> ob = new ArrayList<>();
        List<Object> lista = (List<Object>) this.o.getAll();
        try {
            for (Object objecto : lista) {
                List<Object> obj = (List<Object>) objecto;
                DDirigido oo = new DDirigido();

                oo.setId(Integer.valueOf(obj.get(0).toString()));
                oo.setDescription(obj.get(1).toString());
                oo.setOferta_id(Integer.valueOf(obj.get(2).toString()));

                ob.add(oo);
            }
        } catch (Exception e) {
            throw e;
        }
        return ob;
    }

    public String Mostrar() throws Exception {
        String rx = "DIRIGIDO \n\n";
        try {
            List<DDirigido> lObj = this.getAll();
            for (DDirigido obj : lObj) {
                rx = rx +
                        "Codigo: " + obj.getId()+
                        "\nDescripcion: " + obj.getDescription() +
                        "\nID Oferta: " + obj.getOferta_id() +
                        "\n\n"
                ;
            }
        } catch (Exception e){
            throw e;
        }
        return rx;
    }
}
