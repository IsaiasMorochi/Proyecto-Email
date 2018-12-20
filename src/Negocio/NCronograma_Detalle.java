package Negocio;

import Datos.DCronograma;
import Datos.DCronograma_Detalle;

import java.util.ArrayList;
import java.util.List;

public class NCronograma_Detalle {

    private DCronograma_Detalle o;

    public NCronograma_Detalle() throws Exception{
        this.o = new DCronograma_Detalle();
    }

    public DCronograma_Detalle getInfo(){
        return o;
    }

    public void add(int cronograma_id, int oferta_id) throws Exception{
        try {
            o.setCronograma_id(cronograma_id);
            o.setOferta_id(oferta_id);
            o.add();
        } catch (Exception e) {
            throw e;
        }
    }

//    public void update( ) throws Exception {
////
////    }

    public void delete(int id) throws Exception {
        try{
            o.setId(id);
            o.delete();
        } catch (Exception e){
            throw e;
        }
    }


    private List<DCronograma_Detalle> getAll() throws Exception{
        List<DCronograma_Detalle> ob = new ArrayList<>();
        List<Object> lista = (List<Object>) this.o.getAll();
        try {
            for (Object objecto : lista) {
                List<Object> obj = (List<Object>) objecto;
                DCronograma_Detalle oo = new DCronograma_Detalle();

                oo.setId(Integer.valueOf(obj.get(0).toString()));
                oo.setCronograma_id(Integer.valueOf(obj.get(1).toString()));
                oo.setOferta_id(Integer.valueOf(obj.get(2).toString()));

                ob.add(oo);
            }
        } catch (Exception e) {
            System.out.println("Excepcion en la capa de estudiante Negocio select");
            throw e;
        }
        return ob;
    }

    public String Mostrar() throws Exception {
        String rx = "";
        try {
            List<DCronograma_Detalle> lObj = this.getAll();

            rx = "<center><h2>DETALLE DE CRONOGRAMA</h2></center><br>";
            rx += " <table style=\"width:100%; border-style: outset; text-align: left;\" >" +
                    "             <thead>\n" +
                    "                   <tr >\n" +
                    "                         <th>#</th>\n" +
                    "                         <th>ID CRONOGRAMA</th>\n" +
                    "                         <th>ID OFERTA</th>\n" +
                    "                   </tr>\n" +
                    "             </thead>\n" +
                    "                  <tbody> ";
            for (DCronograma_Detalle obj : lObj) {
                rx = rx +
                        "<tr style=\"\">\n" +
                        "   <td>"+ obj.getId() + "</td>\n" +
                        "   <td>"+ obj.getCronograma_id() + "</td>\n" +
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
