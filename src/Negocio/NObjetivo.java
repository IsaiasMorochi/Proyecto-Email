package Negocio;

import Datos.DObjetivo;

import java.util.ArrayList;
import java.util.List;

public class NObjetivo {

    private DObjetivo o;

    public NObjetivo() throws Exception{
        this.o = new DObjetivo();
    }

    public DObjetivo getInfo(){
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

    private List<DObjetivo> getAll() throws Exception{
        List<DObjetivo> ob = new ArrayList<>();
        List<Object> lista = (List<Object>) this.o.getAll();
        try {
            for (Object objecto : lista) {
                List<Object> obj = (List<Object>) objecto;
                DObjetivo oo = new DObjetivo();

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
        String rx = "";
        try {
            List<DObjetivo> lObj = this.getAll();

            rx = "<center><h2>OBJETIVOS</h2></center><br>";
            rx += " <table style=\"width:100%; border-style: outset; text-align: left;\" >" +
                    "             <thead>\n" +
                    "                   <tr >\n" +
                    "                         <th>#</th>\n" +
                    "                         <th>ID OFERTA</th>\n" +
                    "                         <th>DESCRIPCION</th>\n" +
                    "                   </tr>\n" +
                    "             </thead>\n" +
                    "                  <tbody> ";
            for (DObjetivo obj : lObj) {
                rx = rx +
                        "<tr style=\"\">\n" +
                        "   <td>"+ obj.getId() + "</td>\n" +
                        "   <td>"+ obj.getOferta_id() + "</td>\n" +
                        "   <td>"+ obj.getDescription() + "</td>\n" +
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
