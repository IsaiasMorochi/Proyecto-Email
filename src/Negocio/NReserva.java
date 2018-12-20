package Negocio;

import Datos.DReserva;
import com.sun.org.apache.bcel.internal.generic.DREM;

import java.util.ArrayList;
import java.util.List;

public class NReserva {

    private DReserva o;

    public NReserva() throws Exception{
        this.o = new DReserva();
    }

    public DReserva getInfo(){
        return o;
    }

    public void add(String date, String description, int user_id, int oferta_id) throws Exception {
        try{
            o.setDate(date);
            o.setDescription(description);
            o.setUser_id(user_id);
            o.setOferta_id(oferta_id);
            o.add();
        } catch (Exception e){
            throw e;
        }
    }

    public void update(int id, String date, String description) throws Exception {
        try{
            o.setId(id);
            o.setDate(date);
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

    private List<DReserva> getAll() throws Exception{
        List<DReserva> ob = new ArrayList<>();
        List<Object> lista = (List<Object>) this.o.getAll();
        try {
            for (Object objecto : lista) {
                List<Object> obj = (List<Object>) objecto;
                DReserva oo = new DReserva();

                oo.setId(Integer.valueOf(obj.get(0).toString()));
                oo.setDate(obj.get(1).toString());
                oo.setDescription(obj.get(2).toString());
                oo.setUser_id(Integer.valueOf(obj.get(3).toString()));
                oo.setOferta_id(Integer.valueOf(obj.get(4).toString()));

                ob.add(oo);
            }
        } catch (Exception e) {
            throw e;
        }
        return ob;
    }

    public String Mostrar() throws Exception {
        String rx = "RESERVA \n\n";
        try {
            List<DReserva> lObj = this.getAll();

            rx = "<center><h2>RESERVAS</h2></center><br>";
            rx += " <table style=\"width:100%; border-style: outset; text-align: left;\" >" +
                    "             <thead>\n" +
                    "                   <tr >\n" +
                    "                         <th>#</th>\n" +
                    "                         <th>FECHA</th>\n" +
                    "                         <th>DESCRIPCION</th>\n" +
                    "                         <th>ID CLIENTE</th>\n" +
                    "                         <th>ID OFERTA</th>\n" +
                    "                   </tr>\n" +
                    "             </thead>\n" +
                    "                  <tbody> ";
            for (DReserva obj : lObj) {
                rx = rx +
                        "<tr style=\"\">\n" +
                        "   <td>"+ obj.getId() + "</td>\n" +
                        "   <td>"+ obj.getDate() + "</td>\n" +
                        "   <td>"+ obj.getDescription() + "</td>\n" +
                        "   <td>"+ obj.getUser_id() + "</td>\n" +
                        "   <td>"+ obj.getOferta_id() + "</td>\n" +
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
