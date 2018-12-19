package Negocio;

import Datos.DPeriodo;

import java.util.ArrayList;
import java.util.List;

public class NPeriodo {

    private DPeriodo o;

    public NPeriodo() throws Exception{
        this.o = new DPeriodo();
    }

    public DPeriodo getInfo(){
        return o;
    }

    public void add(String description, String start_date, int oferta_id) throws Exception {
        try{
            o.setDescription(description);
            o.setStart_date(start_date);
            o.setOferta_id(oferta_id);
            o.add();
        } catch (Exception e){
            throw e;
        }
    }

    public void update(int id, String description, String start_date) throws Exception {
        try{
            o.setId(id);
            o.setDescription(description);
            o.setStart_date(start_date);
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

    private List<DPeriodo> getAll() throws Exception{
        List<DPeriodo> ob = new ArrayList<>();
        List<Object> lista = (List<Object>) this.o.getAll();
        try {
            for (Object objecto : lista) {
                List<Object> obj = (List<Object>) objecto;
                DPeriodo oo = new DPeriodo();

                oo.setId(Integer.valueOf(obj.get(0).toString()));
                oo.setOferta_id(Integer.valueOf(obj.get(1).toString()));
                oo.setDescription(obj.get(2).toString());
                oo.setStart_date(obj.get(6).toString());

                ob.add(oo);
            }
        } catch (Exception e) {
            throw e;
        }
        return ob;
    }

    public String Mostrar() throws Exception {
        String rx = "PERIODO \n\n";
        try {
            List<DPeriodo> lObj = this.getAll();
            for (DPeriodo obj : lObj) {
                rx = rx +
                        "Codigo: " + obj.getId()+
                        "\nID Oferta: " + obj.getOferta_id() +
                        "\nDescripcion: " + obj.getDescription() +
                        "\nDia Inicio: " + obj.getStart_date() +
                        "\n\n"
                ;
            }
        } catch (Exception e){
            throw e;
        }
        return rx;
    }
}
