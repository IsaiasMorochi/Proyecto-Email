package Negocio;

import Dato.DUsuario;
import Dato.DZona;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Saulo
 * @version 1.0
 * @created 16-may-2018 12:48:29
 */
public class NZona {
    private DZona zona;
    
    public NZona(){
        zona = new DZona();
    }

    public DZona getZona() {
        return zona;
    }
    
    public boolean registrar(String nombre) {
        this.zona.setNombre(nombre);
        this.zona.setEstado(true);
        return this.zona.insertar();
    }

    public boolean modificar(int id, String nombre) {
        this.zona.setId(id);
        this.zona.setNombre(nombre);
        return zona.actualizar();
    }

    public boolean borrar(int idZona,String correo) {
        DUsuario usuario = new DUsuario();
        usuario = usuario.buscarPorCorreo(correo);
        if (usuario.getTipo()==3) {
            this.zona.setEstado(false);
            this.zona.setId(idZona);
            return this.zona.eliminar();
        }
        return false;
    }

    private List<DZona> listar() {
        List<Object> lista=(List<Object>)this.zona.listar();
        List<DZona> listaServicio=new ArrayList<>();
        for (Object objectZona : lista) {
            List<Object> zonaX = (List<Object>)objectZona;
            this.zona=new DZona();
            this.zona.setId(Integer.valueOf(zonaX.get(0).toString()));
            this.zona.setNombre(zonaX.get(1).toString());
            this.zona.setEstado(Boolean.valueOf(zonaX.get(2).toString()));
            listaServicio.add(zona);
        }
        return listaServicio;
    }
    
    public String MostrarZonas() {
        List<DZona> listaZona=this.listar();
        String resultado="Zonas\n\n";
        for (DZona zonaX : listaZona) {
            resultado = resultado +
                    "Codigo: "+zonaX.getId()+
                    "\nNombre: "+zonaX.getNombre()
                    ;
            if (zonaX.getEstado()) {
                resultado = resultado + 
                        "\nEstado: Habilitada"+
                        "\n------------------------------------------------------\n";
            }else{
                resultado = resultado + 
                        "\nEstado: No Habilitada"+
                        "\n------------------------------------------------------\n";
            }
        }
        return resultado;
    }
    
}