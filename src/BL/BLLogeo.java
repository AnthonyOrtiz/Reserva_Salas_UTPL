/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BL;

import DAT.*;
import clases.Logeo;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Salas
 */
public class BLLogeo {

    DATLogeo ManejoLog = new DATLogeo();
    DATConexion Conexion = new DATConexion();

    public static ArrayList<Logeo> ArrLogeo = new ArrayList<Logeo>();
    
    public ArrayList<Logeo> Consultar() throws ClassNotFoundException, SQLException {
    ResultSet rs;
    rs = ManejoLog.Consultar();
    ResultSetMetaData rm = rs.getMetaData();
    
    int columnCount = rm.getColumnCount();
        ArrayList<String> columns = new ArrayList<>();
        for (int i = 1; i <= columnCount; i++) {
            String columnName = rm.getColumnName(i);
            columns.add(columnName);
        }
        while (rs.next()) 
        {
            Logeo e = new Logeo();
            for (String columnName : columns) 
            {
                String value = rs.getString(columnName);
                if (columnName.equals("USUARIO"))
                    e.setUsuario(value);
                if (columnName.equals("CONTRASENIA"))
                    e.setContrasenia(value);
                if (columnName.equals("CLAVE"))
                    e.setClave(value);
                if (columnName.equals("OCUPACION"))
                    e.setOcupacion(value);
            }
            ArrLogeo.add(e);
        }
        return ArrLogeo;
    }
    
    public Logeo Consultar(String clave) throws ClassNotFoundException, SQLException {
    ResultSet rs;
    rs = ManejoLog.Consultar(clave);
    ResultSetMetaData rm = rs.getMetaData();
    
    int columnCount = rm.getColumnCount();
    ArrayList<String> columns = new ArrayList<>();
    for (int i = 1; i <= columnCount; i++) {
        String columnName = rm.getColumnName(i);
        columns.add(columnName);
    }
    Logeo e = new Logeo();
        while (rs.next()) 
        {
            for (String columnName : columns) 
            {
                String value = rs.getString(columnName);
                if (columnName.equals("USUARIO"))
                    e.setUsuario(value);
                if (columnName.equals("CONTRASENIA"))
                    e.setContrasenia(value);
                if (columnName.equals("CLAVE"))
                    e.setClave(value);
                if (columnName.equals("OCUPACION"))
                    e.setOcupacion(value);
            }
        }
        return e;
    }
    
    public Logeo Consultar(String usuario,String contrasenia) throws ClassNotFoundException, SQLException {
    ResultSet rs;
    rs = ManejoLog.Consultar(usuario,contrasenia);
    ResultSetMetaData rm = rs.getMetaData();
    
    int columnCount = rm.getColumnCount();
    ArrayList<String> columns = new ArrayList<>();
    for (int i = 1; i <= columnCount; i++) {
        String columnName = rm.getColumnName(i);
        columns.add(columnName);
    }
    Logeo e = new Logeo();
        while (rs.next()) 
        {
            for (String columnName : columns) 
            {
                String value = rs.getString(columnName);
                if (columnName.equals("USUARIO"))
                    e.setUsuario(value);
                if (columnName.equals("CONTRASENIA"))
                    e.setContrasenia(value);
                if (columnName.equals("CLAVE"))
                    e.setClave(value);
                if (columnName.equals("OCUPACION"))
                    e.setOcupacion(value);
            }
        }
        return e;
    }
    
    public Logeo ConsultarUsuario(String usuario) throws ClassNotFoundException, SQLException {
    ResultSet rs;
    rs = ManejoLog.ConsultarUsuario(usuario);
    ResultSetMetaData rm = rs.getMetaData();
    
    int columnCount = rm.getColumnCount();
    ArrayList<String> columns = new ArrayList<>();
    for (int i = 1; i <= columnCount; i++) {
        String columnName = rm.getColumnName(i);
        columns.add(columnName);
    }
    Logeo e = new Logeo();
        while (rs.next()) 
        {
            for (String columnName : columns) 
            {
                String value = rs.getString(columnName);
                if (columnName.equals("USUARIO"))
                    e.setUsuario(value);
                if (columnName.equals("CONTRASENIA"))
                    e.setContrasenia(value);
                if (columnName.equals("CLAVE"))
                    e.setClave(value);
                if (columnName.equals("OCUPACION"))
                    e.setOcupacion(value);
            }
        }
        return e;
    }
    
    public int Insertar(Logeo objLogeo) throws SQLException, ClassNotFoundException{
        int retorno=0;
  
        retorno=this.ManejoLog.Insertar(objLogeo.getUsuario(),objLogeo.getContrasenia(),objLogeo.getClave(),objLogeo.getOcupacion());
        
        this.cerrarConexion();
        return retorno;
    }
    
//    public int Modificar(String cedula, String apellidos, String nombres, String direccion, String email,String celular) throws ClassNotFoundException, SQLException{
//        return ManejoLog.Modificar(cedula, apellidos,nombres,direccion,email,celular);
//    }
//    
//    public int Eliminar(String cedula) throws SQLException, ClassNotFoundException {
//        return this.ManejoLog.Eliminar(cedula);
//    }
    
    public void cerrarConexion() throws SQLException{
        Conexion.CerrarConexion();
    }
    
//    public Cliente BuscarCliente(String cedula) throws SQLException, ClassNotFoundException {
//        ResultSet rs;
//        rs = this.ManejoLog.BuscarCliente(cedula);
//        //tranformar el rs a objeto cliente
//
//        ResultSetMetaData rm = rs.getMetaData();
//
//        int columnCount = rm.getColumnCount();
//        ArrayList<String> columns = new ArrayList<>();
//        for (int i = 1; i <= columnCount; i++) {
//            String columnName = rm.getColumnName(i);
//            columns.add(columnName);
//        }
//        
//        Cliente e = new Cliente();
//        
//        while (rs.next()){
//            for (String columnName : columns) {
//                String value = rs.getString(columnName);
//                if (columnName.equals("CEDULA")) {
//                    e.setCedula(value);
//                }
//                if (columnName.equals("APELLIDOS")) {
//                    e.setApellidos(value);
//                }
//                if (columnName.equals("NOMBRES")) {
//                    e.setNombres(value);
//                }
//                if (columnName.equals("DIRECCION")) {
//                    e.setDireccion(value);
//                }
//                if (columnName.equals("MAIL")) {
//                    e.setMail(value);
//                }
//                if (columnName.equals("CELULAR")) {
//                    e.setCelular(value);
//                }
//            }
//        }
//                
//        return e;
//    }

}
