package Negocio;

import Datos.DUsuario;

import java.util.ArrayList;
import java.util.List;

public class NUsuario {

    private DUsuario o;

    public NUsuario() throws Exception{
        this.o = new DUsuario();
    }

    public DUsuario getInfo(){
        return o;
    }

    public void add(String name, String email, String password, String type, String speciality, String about_me, String phone, int grupo_id) throws Exception{
        try{
            o.setName(name);
            o.setEmail(email);
            o.setPassword(password);
            o.setType(type);
            o.setSpeciality(speciality);
            o.setAbout_me(about_me);
            o.setPhone(phone);
            o.setGrupo_id(grupo_id);
            o.add();
        } catch (Exception e){
            throw e;
        }
    }

    public void update(String name, String email, String password, String type, String speciality, String about_me, String phone) throws Exception {
        try{
            o.setName(name);
            o.setEmail(email);
            o.setPassword(password);
            o.setType(type);
            o.setSpeciality(speciality);
            o.setAbout_me(about_me);
            o.setPhone(phone);
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

    private List<DUsuario> getAll() throws Exception{
        List<DUsuario> ob = new ArrayList<>();
        List<Object> lista = (List<Object>) this.o.getAll();
        try {
            for (Object objecto : lista) {
                List<Object> obj = (List<Object>) objecto;
                DUsuario oo = new DUsuario();

                oo.setId(Integer.valueOf(obj.get(0).toString()));
                oo.setName(obj.get(1).toString());
                oo.setEmail(obj.get(2).toString());
                oo.setPassword(obj.get(3).toString());
                oo.setType(obj.get(4).toString());
                oo.setSpeciality(obj.get(5).toString());
                oo.setAbout_me(obj.get(6).toString());
                oo.setPhone(obj.get(7).toString());
                oo.setGrupo_id(Integer.valueOf(obj.get(8).toString()));

                ob.add(oo);
            }
        } catch (Exception e) {
            throw e;
        }
        return ob;
    }

    public String Mostrar() throws Exception {
        String rx = "TIPO \n\n";
        try {
            List<DUsuario> lObj = this.getAll();
            for (DUsuario obj : lObj) {
                rx = rx +
                        "Codigo: " + obj.getId() +
                        "\nNombre: " + obj.getName() +
                        "\nEmail: " + obj.getEmail() +
                        "\nPassword: " + obj.getPassword() +
                        "\nTipo: " + obj.getType() +
                        "\nEspecialidad: " + obj.getSpeciality() +
                        "\nAcerca de: " + obj.getAbout_me() +
                        "\nTelefono: " + obj.getPhone() +
                        "\nGrupo: " + obj.getGrupo_id() +
                        "\n\n"
                ;
            }
        } catch (Exception e){
            throw e;
        }
        return rx;
    }
}
