package Negocio;

import Datos.DHorario_Dia;

import java.util.ArrayList;
import java.util.List;

public class NHorario_Dia {

    private DHorario_Dia o;

    public NHorario_Dia() throws Exception {
        this.o = new DHorario_Dia();
    }

    public DHorario_Dia getInfo(){
        return o;
    }

    public void add(int horario_id, int dia_id) throws Exception {
        try{
            o.setHorario_id(horario_id);
            o.setDia_id(dia_id);
            o.add();
        } catch (Exception e){
            throw e;
        }
    }

//    public void update() throws Exception {
//        try{
//
//        } catch (Exception e){
//            throw e;
//        }
//    }

    public void delete(int id) throws Exception {
        try{
            o.setId(id);
            o.delete();
        } catch (Exception e){
            throw e;
        }
    }

    private List<DHorario_Dia> getAll() throws Exception{
        List<DHorario_Dia> ob = new ArrayList<>();
        List<Object> lista = (List<Object>) this.o.getAll();
        try {
            for (Object objecto : lista) {
                List<Object> obj = (List<Object>) objecto;
                DHorario_Dia oo = new DHorario_Dia();

                oo.setId(Integer.valueOf(obj.get(0).toString()));
                oo.setHorario_id(Integer.valueOf(obj.get(1).toString()));
                oo.setDia_id(Integer.valueOf(obj.get(2).toString()));

                ob.add(oo);
            }
        } catch (Exception e) {
            throw e;
        }
        return ob;
    }

    public String Mostrar() throws Exception {
        String rx = "HORARIO_DIA \n\n";
        try {
            List<DHorario_Dia> lObj = this.getAll();
            for (DHorario_Dia obj : lObj) {
                rx = rx +
                        "Codigo: " + obj.getId()+
                        "\nID Horario: " + obj.getHorario_id() +
                        "\nID Dia: " + obj.getDia_id() +
                        "\n\n"
                ;
            }
        } catch (Exception e){
            throw e;
        }
        return rx;
    }
}
