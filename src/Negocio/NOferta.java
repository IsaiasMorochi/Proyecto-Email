package Negocio;

import Datos.DOferta;

import java.util.ArrayList;
import java.util.List;

public class NOferta {

    private DOferta o;

    public NOferta() throws Exception{
        this.o = new DOferta();
    }

    public DOferta getInfo() {
        return o;
    }

    public void add(String name, String description, Double price, String type_id) throws Exception {
        try{
            o.setName(name);
            o.setDescription(description);
            o.setPrice(price);
            o.setType_id(type_id);
            o.add();
        } catch (Exception e){
            throw e;
        }
    }

    public void update(int id, String name, String description, Double price) throws Exception {
        try{
            o.setId(id);
            o.setName(name);
            o.setDescription(description);
            o.setPrice(price);
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

    private List<DOferta> getAll() throws Exception{
        List<DOferta> ob = new ArrayList<>();
        List<Object> lista = (List<Object>) this.o.getAll();
        try {
            for (Object objecto : lista) {
                List<Object> obj = (List<Object>) objecto;
                DOferta oo = new DOferta();

                oo.setId(Integer.valueOf(obj.get(0).toString()));
                oo.setName(obj.get(1).toString());
                oo.setDescription(obj.get(2).toString());
                oo.setPrice(Double.valueOf(obj.get(3).toString()));
                oo.setType_id(obj.get(4).toString());

                ob.add(oo);
            }
        } catch (Exception e) {
            throw e;
        }
        return ob;
    }

    public String Mostrar() throws Exception {
        String rx = "OFERTA \n\n";
        try {
            List<DOferta> lObj = this.getAll();
            for (DOferta obj : lObj) {
                rx = rx +
                        "Codigo: " + obj.getId()+
                        "\nNombre: " + obj.getName() +
                        "\nDescripcion: " + obj.getDescription() +
                        "\nPrecio: " + obj.getPrice() +
                        "\nTipo: " + obj.getType_id() +
                        "\n\n"
                ;
            }
        } catch (Exception e){
            throw e;
        }
        return rx;
    }

}
