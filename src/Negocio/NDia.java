package Negocio;

import Datos.DDia;
import org.omg.PortableInterceptor.DISCARDING;

import java.util.ArrayList;
import java.util.List;

public class NDia {

    private DDia o;

    public NDia() throws Exception{
        this.o = new DDia();
    }

    public DDia getInfo(){
        return o;
    }

    public void add(String name) throws Exception {
        try{
            o.setName(name);
            o.add();
        } catch (Exception e) {
            throw e;
        }
    }

    public void update(int id, String name) throws Exception {
        try{
            o.setId(id);
            o.setName(name);
            o.update();
        } catch (Exception e) {
            throw e;
        }
    }

    public void delete(int id) throws Exception {
        try{
            o.setId(id);
            o.delete();
        } catch (Exception e) {
            throw e;
        }
    }

    public List<DDia> getAll() throws Exception{
        List<DDia> ob = new ArrayList<>();
        List<Object> lista = (List<Object>) this.o.getAll();
        try {
            for (Object objecto : lista) {
                List<Object> obj = (List<Object>) objecto;
                DDia oo = new DDia();

                oo.setId(Integer.valueOf(obj.get(0).toString()));
                oo.setName(obj.get(1).toString());

                ob.add(oo);
            }
        } catch (Exception e) {
            throw e;
        }
        return ob;
    }

    public String Mostrar() throws Exception {
        String rx = ""; String rf = "";
        try {
            List<DDia> lObj = this.getAll();

            rx = "<center><h2>DIA</h2></center><br>";
            rx += " <table style=\"width:100%; border-style: outset; text-align: left;\" >" +
        "             <thead>\n" +
        "                   <tr >\n" +
        "                         <th>#</th>\n" +
        "                         <th>NOMBRE</th>\n" +
        "                   </tr>\n" +
        "             </thead>\n" +
"                  <tbody> ";
            for (DDia obj : lObj) {
                rx = rx +
                        "<tr style=\"\">\n" +
                        "   <td>"+ obj.getId() + "</td>\n" +
                        "   <td>"+ obj.getName() + "</td>\n" +
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
