package Negocio;

import Datos.DRequisito;

import java.util.ArrayList;
import java.util.List;

public class NRequisito {

    private DRequisito o;

    public NRequisito() throws Exception {
        this.o = new DRequisito();
    }

    public DRequisito getInfo(){
        return o;
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

    private List<DRequisito> getAll() throws Exception{
        List<DRequisito> ob = new ArrayList<>();
        List<Object> lista = (List<Object>) this.o.getAll();
        try {
            for (Object objecto : lista) {
                List<Object> obj = (List<Object>) objecto;
                DRequisito oo = new DRequisito();

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
        String rx = "REQUISITO \n\n";
        try {
            List<DRequisito> lObj = this.getAll();
            for (DRequisito obj : lObj) {
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
