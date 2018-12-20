package Negocio;

import Datos.DOferta;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class NReporte {


    private DOferta evento;

    public NReporte() throws Exception {
        this.evento = new DOferta();

    }

    public List<ResultSet> mostrarReporte(){
        List<ResultSet> datos = new ArrayList<>();
        datos.add(evento.obtenerReporte());
        return datos;
    }


}
