package Negocio;

import Datos.DPago;

import java.util.ArrayList;
import java.util.List;

public class NPago {

    private DPago o;

    public NPago() throws Exception{
        this.o = new DPago();
    }

    public DPago getInfo(){
        return o;
    }

    public void add(Double monto, String type) throws Exception {
        try{
            o.setMonto(monto);
            o.setType(type);
            o.add();
        } catch (Exception e){
            throw e;
        }
    }

    public void update(int id, Double monto, String type) throws Exception {
        try{
            o.setId(id);
            o.setMonto(monto);
            o.setType(type);
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

    private List<DPago> getAll() throws Exception{
        List<DPago> ob = new ArrayList<>();
        List<Object> lista = (List<Object>) this.o.getAll();
        try {
            for (Object objecto : lista) {
                List<Object> obj = (List<Object>) objecto;
                DPago oo = new DPago();

                oo.setId(Integer.valueOf(obj.get(0).toString()));
                oo.setMonto(Double.valueOf(obj.get(1).toString()));
                oo.setType(obj.get(2).toString());

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
            List<DPago> lObj = this.getAll();

            rx = " <table style=\"width:100%; border-style: outset; text-align: left;\" >" +
                    "             <thead>\n" +
                    "                   <tr >\n" +
                    "                         <th>#</th>\n" +
                    "                         <th>MONTO</th>\n" +
                    "                         <th>TIPO</th>\n" +
                    "                   </tr>\n" +
                    "             </thead>\n" +
                    "                  <tbody> ";
            for (DPago obj : lObj) {
                rx = rx +
                        "<tr style=\"\">\n" +
                        "   <td>"+ obj.getId() + "</td>\n" +
                        "   <td>"+ obj.getMonto() + "</td>\n" +
                        "   <td>"+ obj.getType() + "</td>\n" +
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
