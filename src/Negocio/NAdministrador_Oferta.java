package Negocio;

import Datos.DAdministrador_Oferta;

import java.util.ArrayList;
import java.util.List;

public class NAdministrador_Oferta {

    private DAdministrador_Oferta o;

    public NAdministrador_Oferta() throws Exception{
        this.o = new DAdministrador_Oferta();
    }

    public void add(int user_id, int oferta_id) throws Exception {
        try{
            o.setUser_id(user_id);
            o.setOferta_id(oferta_id);
            o.add();
        } catch (Exception e) {
            throw e;
        }
    }

    public void update(int id, int user_id, int oferta_id) throws Exception{
        try {
            o.setId(id);
            o.setUser_id(user_id);
            o.setOferta_id(oferta_id);
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

    public List<DAdministrador_Oferta> getAll() throws Exception{
        List<DAdministrador_Oferta> ob = new ArrayList<>();
        List<Object> lista = (List<Object>) this.o.getAll();
        try {
            for (Object objecto : lista) {
                List<Object> obj = (List<Object>) objecto;
                DAdministrador_Oferta oo = new DAdministrador_Oferta();

                oo.setId(Integer.valueOf(obj.get(0).toString()));
                oo.setUser_id(Integer.valueOf(obj.get(1).toString()));
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
        String rx = "Administrador Oferta\n\n";
        try {
            List<DAdministrador_Oferta> lObj = this.getAll();
            for (DAdministrador_Oferta obj : lObj) {
                rx = rx +
                        "Codigo: " + obj.getId()+
                        "\n ID Usuario: " + obj.getUser_id() +
                        "\n ID Oferta: " + obj.getOferta_id() +
                        "\n\n"
                ;
//            if (!objetoX.getDeleted_at().equals(null)) {
//                resultado = resultado +
//                        "\nEstado: Habilitada"+
//                        "\n------------------------------------------------------\n";
//            }else{
//                resultado = resultado +
//                        "\nEstado: No Habilitada"+
//                        "\n------------------------------------------------------\n";
//            }
            }
        } catch (Exception e){
            throw e;
        }
        return rx;
    }


}
