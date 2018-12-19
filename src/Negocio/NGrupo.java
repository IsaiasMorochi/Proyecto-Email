package Negocio;

import Datos.DGrupo;

import java.util.ArrayList;
import java.util.List;

public class NGrupo {

    private DGrupo o;

    public NGrupo() throws Exception{
        this.o = new DGrupo();
    }

    public DGrupo getInfo(){
        return o;
    }

    public void add(String name, String description, int role_id) throws Exception {
        try{
            o.setName(name);
            o.setDescription(description);
            o.setRole_id(role_id);
            o.add();
        } catch (Exception e){
            throw e;
        }
    }

    public void update(int id, String name, String description) throws Exception {
        try{
            o.setId(id);
            o.setName(name);
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

    public List<DGrupo> getAll() throws Exception{
        List<DGrupo> ob = new ArrayList<>();
        List<Object> lista = (List<Object>) this.o.getAll();
        try {
            for (Object objecto : lista) {
                List<Object> obj = (List<Object>) objecto;
                DGrupo oo = new DGrupo();

                oo.setId(Integer.valueOf(obj.get(0).toString()));
                oo.setName(obj.get(1).toString());
                oo.setDescription(obj.get(2).toString());
                oo.setRole_id(Integer.valueOf(obj.get(6).toString()));

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
            List<DGrupo> lObj = this.getAll();
            for (DGrupo obj : lObj) {
                rx = rx +
                        "Codigo: " + obj.getId()+
                        "\nNombre: " + obj.getName() +
                        "\nDescripcion: " + obj.getDescription() +
                        "\nID Role: " + obj.getRole_id() +
                        "\n\n"
                ;
            }
        } catch (Exception e){
            throw e;
        }
        return rx;
    }
}
