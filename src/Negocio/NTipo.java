package Negocio;

import Datos.DTipo;

import java.util.ArrayList;
import java.util.List;

public class NTipo {

    private DTipo o;

    public NTipo() throws Exception{
        this.o = new DTipo();
    }

    public DTipo getInfo(){
        return o;
    }

    public void add(String id, String description) throws Exception {
        try{
            o.setId(id);
            o.setDescription(description);
            o.add();
        } catch (Exception e){
            throw e;
        }
    }

    public void update(String id, String description) throws Exception {
        try{
            o.setId(id);
            o.setDescription(description);
            o.update();
        } catch (Exception e){
            throw e;
        }
    }

    public void delete(String id) throws Exception {
        try{
            o.setId(id);
            o.delete();
        } catch (Exception e){
            throw e;
        }
    }

    private List<DTipo> getAll() throws Exception{
        List<DTipo> ob = new ArrayList<>();
        List<Object> lista = (List<Object>) this.o.getAll();
        try {
            for (Object objecto : lista) {
                List<Object> obj = (List<Object>) objecto;
                DTipo oo = new DTipo();

                oo.setId(obj.get(0).toString());
                oo.setDescription(obj.get(1).toString());

                ob.add(oo);
            }
        } catch (Exception e) {
            throw e;
        }
        return ob;
    }

    public String Mostrar() throws Exception {
        String rx = "TIPO \n\n";
        try {
            List<DTipo> lObj = this.getAll();
            for (DTipo obj : lObj) {
                rx = rx +
                        "Codigo: " + obj.getId() +
                        "\nDescripcion: " + obj.getDescription() +
                        "\n\n"
                ;
            }
        } catch (Exception e){
            throw e;
        }
        return rx;
    }
}
