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
                oo.setType(obj.get(5).toString());

                ob.add(oo);
            }
        } catch (Exception e) {
            throw e;
        }
        return ob;
    }

    public String Mostrar() throws Exception {
        String rx = "METODOLOGIA \n\n";
        try {
            List<DPago> lObj = this.getAll();
            for (DPago obj : lObj) {
                rx = rx +
                        "Codigo: " + obj.getId()+
                        "\nMonto: " + obj.getMonto() +
                        "\nTipo: " + obj.getType() +
                        "\n\n"
                ;
            }
        } catch (Exception e){
            throw e;
        }
        return rx;
    }

}
