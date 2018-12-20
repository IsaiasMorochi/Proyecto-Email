package Negocio;

import Datos.DPostgraduante_Oferta;

import java.util.ArrayList;
import java.util.List;

public class NPostgraduante_Oferta {

    private DPostgraduante_Oferta o;

    public NPostgraduante_Oferta() throws Exception{
        this.o = new DPostgraduante_Oferta();
    }

    public DPostgraduante_Oferta getInfo(){
        return o;
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

    public void delete(int id) throws Exception {
        try{
            o.setId(id);
            o.delete();
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
        String rx = "";
        try {
            List<DPostgraduante_Oferta> lObj = this.getAll();

            rx = " <table style=\"width:100%; border-style: outset; text-align: left;\" >" +
                    "             <thead>\n" +
                    "                   <tr >\n" +
                    "                         <th>#</th>\n" +
                    "                         <th>ID OFERTA</th>\n" +
                    "                         <th>ID POSTGRADUANTE</th>\n" +
                    "                   </tr>\n" +
                    "             </thead>\n" +
                    "                  <tbody> ";
            for (DPostgraduante_Oferta obj : lObj) {
                rx = rx +
                        "<tr style=\"\">\n" +
                        "   <td>"+ obj.getId() + "</td>\n" +
                        "   <td>"+ obj.getOferta_id() + "</td>\n" +
                        "   <td>"+ obj.getUser_id() + "</td>\n" +
                        "</tr>\n"
                ;
            }
            rx  +=   "  </tbody>\n" +
                    "</table>\n"
            ;

        } catch (Exception e){
            throw e;
        }
        return rx;
    }

}
