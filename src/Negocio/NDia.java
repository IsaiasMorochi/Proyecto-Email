package Negocio;

import Datos.DDia;

import java.util.ArrayList;
import java.util.List;

public class NDia {

    private DDia o;

    public NDia() throws Exception{
        this.o = new DDia();
    }

    public void add(String name) throws Exception {
        try{
            o.setName(name);
            o.add();
        } catch (Exception e) {
            throw e;
        }
    }

    public void update(int id, String name) throws Exception {
        try{
            o.setId(id);
            o.setName(name);
            o.add();
        } catch (Exception e) {
            throw e;
        }
    }

    public void delete(int id) throws Exception {
        try{
            o.setId(id);
            o.add();
        } catch (Exception e) {
            throw e;
        }
    }

    public List<DDia> getAll() throws Exception{
        List<DDia> ob = new ArrayList<>();
        List<Object> lista = (List<Object>) this.o.getAll();
        try {
            for (Object objecto : lista) {
                List<Object> obj = (List<Object>) objecto;
                DDia oo = new DDia();

                oo.setId(Integer.valueOf(obj.get(0).toString()));
                oo.setName(obj.get(1).toString());

                ob.add(oo);
            }
        } catch (Exception e) {
            throw e;
        }
        return ob;
    }

    public String Mostrar() throws Exception {
        String rx = "DIA \n\n";
        try {
            List<DDia> lObj = this.getAll();
            for (DDia obj : lObj) {
                rx = rx +
                        "Codigo: " + obj.getId()+
                        "\nNombre: " + obj.getName() +
                        "\n\n"
                ;
            }
        } catch (Exception e){
            throw e;
        }
        return rx;
    }
}
