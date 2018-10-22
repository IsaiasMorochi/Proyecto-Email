package Data;

import Data.Connections;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public abstract class Template {
    
    public int autoincrement=0;
    
    protected abstract String registrar();
    protected abstract String modificar();
    protected abstract String borrar();
    protected abstract String listado();
    protected abstract int cantidadAtributos();

    
    public boolean consultar(String consulta){
//        consulta = "insert into usuario(id_persona, correo,password,created_at) values(1,'correo@gmail.com','pass','12-05-2018')";
      boolean  resultado =true;
        try {
            Connection conn = Connections.getConnection();
            PreparedStatement st = conn.prepareStatement(consulta,Statement.RETURN_GENERATED_KEYS);
           resultado = !st.execute();          
            ResultSet auto = st.getGeneratedKeys();
            if (auto.next() && auto.isFirst()) {
                autoincrement = auto.getInt(1);
            }
            st.close();
            return resultado;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return resultado;
        }
     
    }
    
    public List<Object> listar(){
        List<Object> lista = new ArrayList<>();
        try {
            Connection con = Connections.getConnection();
            Statement consulta = con.createStatement();
            ResultSet resultado = consulta.executeQuery(listado());
            while (resultado.next()) {
                List<Object> tupla = new ArrayList<>();
                for (int i = 1; i <= cantidadAtributos(); i++) {
                    tupla.add(resultado.getObject(i));
                }
                lista.add(tupla);
            }
            return lista;
        } catch (SQLException e) {
            return null;
        }
    }
    
    public List<Object> buscar(String consultaSql){
        List<Object> lista = new ArrayList<>();
        try {
            Connection con = Connections.getConnection();
            Statement consulta = con.createStatement();
            ResultSet resultado = consulta.executeQuery(consultaSql);
            while (resultado.next()) {
                //List<Object> tupla = new ArrayList<>();
                for (int i = 1; i <= cantidadAtributos(); i++) {
                    lista.add(resultado.getObject(i));
                }
                //lista.add(tupla);
            }
            return lista;
        } catch (SQLException e) {
            return null;
        }
    }
    
    public boolean insertar(){
        return consultar(registrar());
    }
    
    public boolean actualizar(){
        return consultar(modificar());
    }
    
    public boolean eliminar(){
        return consultar(borrar());
    }
    
    public ResultSet consultarDatos(String consulta){
        Connection conn = Connections.getConnection();
        ResultSet result = null;
        try {
            Statement st = conn.createStatement();
            result = st.executeQuery(consulta);
            //st.close();
        } catch (SQLException e) {
            System.out.println(e);            
        }
        return result;
    }
    
}
