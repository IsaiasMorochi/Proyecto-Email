package Dato;

import java.util.List;


/**
 * @author Saulo
 * @version 1.0
 * @created 16-may-2018 12:48:09
 */
public class DFoto extends Plantilla{

    private int id;
    private String url;
    private String fechaSubida;
    private int idEvento;

    public DFoto(){

    }

    public int getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }

    public String getFechaSubida() {
        return fechaSubida;
    }

    public int getIdEvento() {
        return idEvento;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setFechaSubida(String fechaSubida) {
        this.fechaSubida = fechaSubida;
    }

    public void setIdEvento(int idEvento) {
        this.idEvento = idEvento;
    }

    @Override
    protected String registrar() {
        return "insert into Foto(url,fechaSubida,idEvento) values("
                +"'"+url+ "',"
                +"CURRENT_DATE,"
                +idEvento
                + ")";
    }

    @Override
    protected String modificar() {
        return "update Foto set "
                +"url =" +"'"+url+ "',"
                + " where id=" +id;
    }

    @Override
    protected String borrar() {
        return "delete from Foto where id = "+id;
    }

    @Override
    protected String listado() {
        return "select * from Foto where idEvento="+idEvento;
    }

    @Override
    protected int cantidadAtributos() {
        return 4;
    }
    
    public DFoto buscar(int idFoto) {
        List<Object> evento =(List<Object>) buscar("select * from Foto where id="+idFoto);
        if (evento!=null && !(evento.isEmpty())) {
            DFoto dFoto=new DFoto();
            dFoto.setId(Integer.valueOf(evento.get(0).toString()));
            dFoto.setUrl(evento.get(1).toString());
            dFoto.setFechaSubida(evento.get(2).toString());
            dFoto.setIdEvento(Integer.valueOf(evento.get(3).toString()));
            return dFoto;
        }
        return null;
    }
}