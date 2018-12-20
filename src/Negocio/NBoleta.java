package Negocio;

import Datos.DBoleta;

import java.util.ArrayList;
import java.util.List;

public class NBoleta {

    private DBoleta o;

    public NBoleta() throws Exception{
        this.o = new DBoleta();
    }

    public DBoleta getInfo(){
        return o;
    }

    public void add(double monto, int pago_id) throws Exception {
        try{
            o.setMonto(monto);
            o.setPago_id(pago_id);
            o.add();
        } catch (Exception e){
            throw e;
        }
    }

    public void update(int id, double monto) throws Exception {
        try{
            o.setId(id);
            o.setMonto(monto);
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

    private List<DBoleta> getAll() throws Exception {
        List<DBoleta> ob = new ArrayList<>();
        List<Object> lista = (List<Object>) this.o.getAll();
        try {
            for (Object objecto : lista) {
                List<Object> obj = (List<Object>) objecto;
                DBoleta oo = new DBoleta();

                oo.setId(Integer.valueOf(obj.get(0).toString()));
                oo.setMonto(Double.valueOf(obj.get(1).toString()));
                oo.setPago_id(Integer.valueOf(obj.get(2).toString()));

                ob.add(oo);
            }
        } catch (Exception e) {
            System.out.println("Excepcion en la capa de estudiante Negocio select");
            throw e;
        }
        return ob;
    }

    public String Mostrar() throws Exception {
        String rx = "Boletas\n\n";
        try {
            List<DBoleta> lObj = this.getAll();

            rx = " <table style=\"width:100%; border-style: outset; text-align: left;\" >" +
                    "             <thead>\n" +
                    "                   <tr >\n" +
                    "                         <th>#</th>\n" +
                    "                         <th>MONTO</th>\n" +
                    "                         <th>ID PAGO</th>\n" +
                    "                   </tr>\n" +
                    "             </thead>\n" +
                    "                  <tbody> ";
            for (DBoleta obj : lObj) {
                rx = rx +
                        "<tr style=\"\">\n" +
                        "   <td>"+ obj.getId() + "</td>\n" +
                        "   <td>"+ obj.getMonto() + "</td>\n" +
                        "   <td>"+ obj.getPago_id() + "</td>\n" +
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
