package Negocio;

import Datos.DRol;

import java.util.ArrayList;
import java.util.List;

public class NRol {

    private DRol o;

    public NRol() throws Exception{
        this.o = new DRol();
    }

    public void add(String name) throws Exception {
        try{
            o.setName(name);
            o.add();
        } catch (Exception e){
            throw e;
        }
    }

    public void update(int id, String name) throws Exception {
        try{
            o.setId(id);
            o.setName(name);
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

    private List<DRol> getAll() throws Exception{
        List<DRol> ob = new ArrayList<>();
        List<Object> lista = (List<Object>) this.o.getAll();
        try {
            for (Object objecto : lista) {
                List<Object> obj = (List<Object>) objecto;
                DRol oo = new DRol();

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
        String rx = "ROL \n\n";
        try {
            List<DRol> lObj = this.getAll();
            for (DRol obj : lObj) {
                rx = rx +
                        "Codigo: " + obj.getId() +
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
