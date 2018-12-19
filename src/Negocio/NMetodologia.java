package Negocio;

import Datos.DMetodologia;

import java.util.ArrayList;
import java.util.List;

public class NMetodologia {

    public DMetodologia o;

    public NMetodologia() throws Exception{
        this.o = new DMetodologia();
    }

    public DMetodologia getInfo(){
        return o;
    }

    public void add(String description, int ofertta_id) throws Exception {
        try{
            o.setDescription(description);
            o.setOferta_id(ofertta_id);
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

    private List<DMetodologia> getAll() throws Exception{
        List<DMetodologia> ob = new ArrayList<>();
        List<Object> lista = (List<Object>) this.o.getAll();
        try {
            for (Object objecto : lista) {
                List<Object> obj = (List<Object>) objecto;
                DMetodologia oo = new DMetodologia();

                oo.setId(Integer.valueOf(obj.get(0).toString()));
                oo.setOferta_id(Integer.valueOf(obj.get(1).toString()));
                oo.setDescription(obj.get(2).toString());

                ob.add(oo);
            }
        } catch (Exception e) {
            throw e;
        }
        return ob;
    }

    public String Mostrar() throws Exception {
        String rx = "METODOLOGIA \n\n";
        try {
            List<DMetodologia> lObj = this.getAll();
            for (DMetodologia obj : lObj) {
                rx = rx +
                        "Codigo: " + obj.getId()+
                        "\nID Oferta: " + obj.getOferta_id() +
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
