package Negocio;

import Datos.DPostgraduante_Oferta;

import java.util.ArrayList;
import java.util.List;

public class NPostgraduante_Oferta {

    private DPostgraduante_Oferta o;

    public NPostgraduante_Oferta() throws Exception{
        this.o = new DPostgraduante_Oferta();
    }

    public void add(int user_id, int oferta_id) throws Exception {
        try{
            o.setUser_id(user_id);
            o.setOferta_id(oferta_id);
            o.add();
        } catch (Exception e){
            throw e;
        }
    }

    private List<DPostgraduante_Oferta> getAll() throws Exception{
        List<DPostgraduante_Oferta> ob = new ArrayList<>();
        List<Object> lista = (List<Object>) this.o.getAll();
        try {
            for (Object objecto : lista) {
                List<Object> obj = (List<Object>) objecto;
                DPostgraduante_Oferta oo = new DPostgraduante_Oferta();

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
        String rx = "POSTGRADUANTE \n\n";
        try {
            List<DPostgraduante_Oferta> lObj = this.getAll();
            for (DPostgraduante_Oferta obj : lObj) {
                rx = rx +
                        "Codigo: " + obj.getId()+
                        "\nID Oferta: " + obj.getOferta_id() +
                        "\nID Postgraduante: " + obj.getUser_id() +
                        "\n\n"
                ;
            }
        } catch (Exception e){
            throw e;
        }
        return rx;
    }

}
