package Negocio;

import Datos.DHorario;

import java.util.ArrayList;
import java.util.List;

public class NHorario {

    private DHorario o;

    public NHorario() throws Exception{
        this.o = new DHorario();
    }

    public void add(String description, int periodo_id) throws Exception {
        try{
            o.setDescription(description);
            o.setPeriodo_id(periodo_id);
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

    public List<DHorario> getAll() throws Exception{
        List<DHorario> ob = new ArrayList<>();
        List<Object> lista = (List<Object>) this.o.getAll();
        try {
            for (Object objecto : lista) {
                List<Object> obj = (List<Object>) objecto;
                DHorario oo = new DHorario();

                oo.setId(Integer.valueOf(obj.get(0).toString()));
                oo.setPeriodo_id(Integer.valueOf(obj.get(1).toString()));
                oo.setDescription(obj.get(2).toString());

                ob.add(oo);
            }
        } catch (Exception e) {
            throw e;
        }
        return ob;
    }

    public String Mostrar() throws Exception {
        String rx = "GRUPOS \n\n";
        try {
            List<DHorario> lObj = this.getAll();
            for (DHorario obj : lObj) {
                rx = rx +
                        "Codigo: " + obj.getId()+
                        "\nID Periodo: " + obj.getPeriodo_id() +
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
