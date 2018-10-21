package Dato;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Antonio saulo
 */
public abstract class Plantilla {
    
    public int autoincrement=0;
    
    protected abstract String registrar();
    protected abstract String modificar();
    protected abstract String borrar();
    protected abstract String listado();
    protected abstract int cantidadAtributos();
    //protected abstract Object[] columnas();
    
    
    public boolean consultar(String consulta){
      boolean  resultado =true;
        try {
            Connection conn = Conexion.getConnection();
            PreparedStatement st = conn.prepareStatement(consulta,Statement.RETURN_GENERATED_KEYS);              
           resultado = !st.execute();          
            ResultSet auto = st.getGeneratedKeys();
            if (auto.next() && auto.isFirst()) {
                autoincrement = auto.getInt(1);
            }
            st.close();
            return resultado;
        } catch (SQLException e) {
            return resultado;
        }
     
    }
    
    public List<Object> listar(){
        List<Object> lista = new ArrayList<>();
        try {
            Connection con = Conexion.getConnection();
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
            Connection con = Conexion.getConnection();
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
        Connection conn = Conexion.getConnection();
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
