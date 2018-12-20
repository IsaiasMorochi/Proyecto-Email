package Negocio;

import Datos.DVenta;

import java.util.ArrayList;
import java.util.List;

public class NVenta {

    private DVenta o;

    public NVenta() throws Exception{
        this.o = new DVenta();
    }

    public DVenta getInfo(){
        return o;
    }

    public void add(double total, int user_id) throws Exception{
        try{
            o.setTotal(total);
            o.setUser_id(user_id);
            o.add();
        } catch (Exception e){
            throw e;
        }
    }

    public void update(int id, double total) throws Exception{
        try{
            o.setId(id);
            o.setTotal(total);
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

    private List<DVenta> getAll() throws Exception{
        List<DVenta> ob = new ArrayList<>();
        List<Object> lista = (List<Object>) this.o.getAll();
        try {
            for (Object objecto : lista) {
                List<Object> obj = (List<Object>) objecto;
                DVenta oo = new DVenta();

                oo.setId(Integer.valueOf(obj.get(0).toString()));
                oo.setTotal(Double.valueOf(obj.get(1).toString()));
                oo.setUser_id(Integer.valueOf(obj.get(2).toString()));

                ob.add(oo);
            }
        } catch (Exception e) {
            throw e;
        }
        return ob;
    }

    public String Mostrar() throws Exception {
        String rx = "TIPO \n\n";
        try {
            List<DVenta> lObj = this.getAll();

            rx = "<center><h2>VENTAS</h2></center><br>";
            rx += " <table style=\"width:100%; border-style: outset; text-align: left;\" >" +
                    "             <thead>\n" +
                    "                   <tr >\n" +
                    "                         <th>#</th>\n" +
                    "                         <th>TOTAL</th>\n" +
                    "                         <th>ID USER</th>\n" +

                    "                   </tr>\n" +
                    "             </thead>\n" +
                    "                  <tbody> ";
            for (DVenta obj : lObj) {
                rx = rx +
                        "<tr style=\"\">\n" +
                        "   <td>"+ obj.getId() + "</td>\n" +
                        "   <td>"+ obj.getTotal() + "</td>\n" +
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
