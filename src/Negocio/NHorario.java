package Negocio;

import Datos.DDia;
import Datos.DHorario;

import java.util.ArrayList;
import java.util.List;

public class NHorario {

    private DHorario o;

    public NHorario() throws Exception{
        this.o = new DHorario();
    }

    public DHorario getInfo(){
        return o;
    }

    public void add(String description, int periodo_id) throws Exception {
        try{
            o.setDescription(description);
            o.setPeriodo_id(periodo_id);
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

    public List<DHorario> getAll() throws Exception{
        List<DHorario> ob = new ArrayList<>();
        List<Object> lista = (List<Object>) this.o.getAll();
        try {
            for (Object objecto : lista) {
                List<Object> obj = (List<Object>) objecto;
                DHorario oo = new DHorario();

                oo.setId(Integer.valueOf(obj.get(0).toString()));
                oo.setPeriodo_id(Integer.valueOf(obj.get(1).toString()));
                oo.setDescription(obj.get(2).toString());

                ob.add(oo);
            }
        } catch (Exception e) {
            throw e;
        }
        return ob;
    }

    public String Mostrar() throws Exception {
        String rx = "GRUPOS \n\n";
        try {
            List<DHorario> lObj = this.getAll();

            rx = "<center><h2>HORARIO</h2></center><br>";
            rx += " <table style=\"width:100%; border-style: outset; text-align: left;\" >" +
                    "             <thead>\n" +
                    "                   <tr >\n" +
                    "                         <th>#</th>\n" +
                    "                         <th>ID PERIODO</th>\n" +
                    "                         <th>DESCRIPCION</th>\n" +
                    "                   </tr>\n" +
                    "             </thead>\n" +
                    "                  <tbody> ";
            for (DHorario obj : lObj) {
                rx = rx +
                        "<tr style=\"\">\n" +
                        "   <td>"+ obj.getId() + "</td>\n" +
                        "   <td>"+ obj.getPeriodo_id() + "</td>\n" +
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
