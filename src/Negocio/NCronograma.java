package Negocio;

import Datos.DCronograma;
import org.postgresql.jdbc.EscapedFunctions;

import java.util.ArrayList;
import java.util.List;

public class NCronograma {

    private DCronograma o;

    public NCronograma() throws Exception{
        this.o = new DCronograma();
    }

    public DCronograma getInfo(){
        return o;
    }

    public void add(String description, String period) throws Exception{
        try{
            o.setDescription(description);
            o.setPeriod(period);
            o.add();
        } catch (Exception e){
            throw e;
        }
    }

    public void update(int id, String description, String period) throws Exception{
        try{
            o.setId(id);
            o.setDescription(description);
            o.setPeriod(period);
            o.update();
        } catch (Exception e){
            throw e;
        }
    }

    public void delete(int id) throws Exception{
        try{
            o.setId(id);
            o.delete();
        } catch (Exception e){
            throw e;
        }
    }

    public List<DCronograma> getAll() throws Exception{
        List<DCronograma> ob = new ArrayList<>();
        List<Object> lista = (List<Object>) this.o.getAll();
        try {
            for (Object objecto : lista) {
                List<Object> obj = (List<Object>) objecto;
                DCronograma oo = new DCronograma();

                oo.setId(Integer.valueOf(obj.get(0).toString()));
                oo.setDescription(obj.get(1).toString());
                oo.setPeriod(obj.get(2).toString());

                ob.add(oo);
            }
        } catch (Exception e) {
            System.out.println("Excepcion en la capa de estudiante Negocio select");
            throw e;
        }
        return ob;
    }

    public String Mostrar() throws Exception {
        String rx = "Cronograma \n\n";
        try {
            List<DCronograma> lObj = this.getAll();

            rx = " <table style=\"width:100%; border-style: outset; text-align: left;\" >" +
                    "             <thead>\n" +
                    "                   <tr >\n" +
                    "                         <th>#</th>\n" +
                    "                         <th>DESCRIPCION</th>\n" +
                    "                         <th>PERIODO</th>\n" +
                    "                   </tr>\n" +
                    "             </thead>\n" +
                    "                  <tbody> ";
            for (DCronograma obj : lObj) {
                rx = rx +
                        "<tr style=\"\">\n" +
                        "   <td>"+ obj.getId() + "</td>\n" +
                        "   <td>"+ obj.getDescription() + "</td>\n" +
                        "   <td>"+ obj.getPeriod() + "</td>\n" +
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
