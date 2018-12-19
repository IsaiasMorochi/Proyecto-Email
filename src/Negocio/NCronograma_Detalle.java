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
        String rx = "Cronograma \n\n";
        try {
            List<DCronograma_Detalle> lObj = this.getAll();
            for (DCronograma_Detalle obj : lObj) {
                rx = rx +
                        "Codigo: " + obj.getId()+
                        "\nID Cronograma: " + obj.getCronograma_id() +
                        "\nID Oferta: " + obj.getOferta_id() +
                        "\n\n"
                ;
            }
        } catch (Exception e){
            throw e;
        }
        return rx;
    }
}
