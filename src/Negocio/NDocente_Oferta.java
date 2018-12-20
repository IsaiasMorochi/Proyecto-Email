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

//    public void update(int id, int oferta_id, int docente_id) throws Exception {
//        try {
//            o.setId(id);
//            o.setOferta_id(oferta_id);
//            o.setUser_id(docente_id);
//            o.update();
//        } catch (Exception e) {
//            throw e;
//        }
//    }

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

            rx = "<center><h2>OFERTA DE DOCENTES</h2></center><br>";
            rx = " <table style=\"width:100%; border-style: outset; text-align: left;\" >" +
                    "             <thead>\n" +
                    "                   <tr >\n" +
                    "                         <th>#</th>\n" +
                    "                         <th>ID OFERTA</th>\n" +
                    "                         <th>ID USUARIO</th>\n" +
                    "                   </tr>\n" +
                    "             </thead>\n" +
                    "                  <tbody> ";
            for (DDocente_Oferta obj : lObj) {
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
