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
                oo.setStart_date(obj.get(3).toString());

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

            rx = " <table style=\"width:100%; border-style: outset; text-align: left;\" >" +
                    "             <thead>\n" +
                    "                   <tr >\n" +
                    "                         <th>#</th>\n" +
                    "                         <th>ID OFERTA</th>\n" +
                    "                         <th>DESCRIPCION</th>\n" +
                    "                         <th>DIA INICIO</th>\n" +
                    "                   </tr>\n" +
                    "             </thead>\n" +
                    "                  <tbody> ";
            for (DPeriodo obj : lObj) {
                rx = rx +
                        "<tr style=\"\">\n" +
                        "   <td>"+ obj.getId() + "</td>\n" +
                        "   <td>"+ obj.getOferta_id() + "</td>\n" +
                        "   <td>"+ obj.getDescription() + "</td>\n" +
                        "   <td>"+ obj.getStart_date() + "</td>\n" +
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
