package Negocio;

import Datos.DOferta;

import java.util.ArrayList;
import java.util.List;

public class NOferta {

    private DOferta o;

    public NOferta() throws Exception{
        this.o = new DOferta();
    }

    public DOferta getInfo() {
        return o;
    }

    public void add(String name, String description, double price, String type_id) throws Exception {
        try{
            o.setName(name);
            o.setDescription(description);
            o.setPrice(price);
            o.setType_id(type_id);
            o.add();
        } catch (Exception e){
            throw e;
        }
    }

    public void update(int id, String name, String description, Double price) throws Exception {
        try{
            o.setId(id);
            o.setName(name);
            o.setDescription(description);
            o.setPrice(price);
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

    private List<DOferta> getAll() throws Exception{
        List<DOferta> ob = new ArrayList<>();
        List<Object> lista = (List<Object>) this.o.getAll();
        try {
            for (Object objecto : lista) {
                List<Object> obj = (List<Object>) objecto;
                DOferta oo = new DOferta();

                oo.setId(Integer.valueOf(obj.get(0).toString()));
                oo.setName(obj.get(1).toString());
                oo.setDescription(obj.get(2).toString());
                oo.setPrice(Double.valueOf(obj.get(3).toString()));
                oo.setType_id(obj.get(4).toString());

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
            List<DOferta> lObj = this.getAll();

            rx = " <table style=\"width:100%; border-style: outset; text-align: left;\" >" +
                    "             <thead>\n" +
                    "                   <tr >\n" +
                    "                         <th>#</th>\n" +
                    "                         <th>NOMBRE</th>\n" +
                    "                         <th>DESCRIPCION</th>\n" +
                    "                         <th>PRECIO (BS)</th>\n" +
                    "                         <th>TIPO</th>\n" +
                    "                   </tr>\n" +
                    "             </thead>\n" +
                    "                  <tbody> ";
            for (DOferta obj : lObj) {
                rx = rx +
                        "<tr style=\"\">\n" +
                        "   <td>"+ obj.getId() + "</td>\n" +
                        "   <td>"+ obj.getName() + "</td>\n" +
                        "   <td>"+ obj.getDescription() + "</td>\n" +
                        "   <td>"+ obj.getPrice() + "</td>\n" +
                        "   <td>"+ obj.getType_id() + "</td>\n" +
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
