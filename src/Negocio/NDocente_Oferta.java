package Negocio;

import Datos.DDocente_Oferta;

import java.util.ArrayList;
import java.util.List;

public class NDocente_Oferta {

    private DDocente_Oferta o;

    public NDocente_Oferta() throws Exception{
        this.o = new DDocente_Oferta();
    }

    public DDocente_Oferta getInfo(){
        return o;
    }

    public void add(int oferta_id, int docente_id) throws Exception {
        try {
            o.setOferta_id(oferta_id);
            o.setUser_id(docente_id);
            o.add();
        } catch (Exception e) {
            throw e;
        }
    }

    public void update(int oferta_id, int docente_id) throws Exception {
        try {
            o.setOferta_id(oferta_id);
            o.setUser_id(docente_id);
            o.update();
        } catch (Exception e) {
            throw e;
        }
    }

    public void delete(int id) throws Exception {
        try {
            o.setId(id);
            o.delete();
        } catch (Exception e) {
            throw e;
        }
    }

    public List<DDocente_Oferta> getAll() throws Exception{
        List<DDocente_Oferta> ob = new ArrayList<>();
        List<Object> lista = (List<Object>) this.o.getAll();
        try {
            for (Object objecto : lista) {
                List<Object> obj = (List<Object>) objecto;
                DDocente_Oferta oo = new DDocente_Oferta();

                oo.setId(Integer.valueOf(obj.get(0).toString()));
                oo.setOferta_id(Integer.valueOf(obj.get(1).toString()));
                oo.setUser_id(Integer.valueOf(obj.get(2).toString()));

                ob.add(oo);
            }
        } catch (Exception e) {
            throw e;
        }
        return ob;
    }

    public String Mostrar() throws Exception {
        String rx = "DOCENTE OFERTA \n\n";
        try {
            List<DDocente_Oferta> lObj = this.getAll();
            for (DDocente_Oferta obj : lObj) {
                rx = rx +
                        "Codigo: " + obj.getId()+
                        "\nID Oferta: " + obj.getOferta_id() +
                        "\nID Docente: " + obj.getUser_id() +
                        "\n\n"
                ;
            }
        } catch (Exception e){
            throw e;
        }
        return rx;
    }


}
