
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BL;

import DAT.*;
import clases.Administrador;
import clases.Estudiante;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Salas
 */
public class BLAdministrador {

    DATAdministrador ManejoAdministrador = new DATAdministrador ();
    DATConexion Conexion = new DATConexion();

    public static ArrayList<Administrador > ArrAdministrador = new ArrayList<Administrador>();
    
    public ArrayList<Administrador> Consultar() throws ClassNotFoundException, SQLException {
    ResultSet rs;
    rs = ManejoAdministrador.Consultar();
    ResultSetMetaData rm = rs.getMetaData();
    
    int columnCount = rm.getColumnCount();
        ArrayList<String> columns = new ArrayList<>();
        for (int i = 1; i <= columnCount; i++) {
            String columnName = rm.getColumnName(i);
            columns.add(columnName);
        }
        while (rs.next()) 
        {
            Administrador e = new Administrador();
            for (String columnName : columns) 
            {
                String value = rs.getString(columnName);
                if (columnName.equals("NOMBRES"))
                    e.setNombres(value);
                if (columnName.equals("APELLIDOS")) 
                    e.setApellidos(value);
                if (columnName.equals("CEDULA"))
                    e.setCedula(value);
                if (columnName.equals("DIRECCION"))
                    e.setDireccion(value);
                if (columnName.equals("MAIL"))
                    e.setMail(value);
                if (columnName.equals("DELEGACION"))
                    e.setDelegacion(value);

            }
            ArrAdministrador.add(e);
        }
        return ArrAdministrador;
    }
    
    public Administrador buscarAdministrador(String clave) throws ClassNotFoundException, SQLException {
        ResultSet rs;
        rs = this.ManejoAdministrador.buscarAdministrador(clave);
        //tranformar el rs a objeto cliente

        ResultSetMetaData rm = rs.getMetaData();

        int columnCount = rm.getColumnCount();
        ArrayList<String> columns = new ArrayList<>();
        for (int i = 1; i <= columnCount; i++) {
            String columnName = rm.getColumnName(i);
            columns.add(columnName);
        }
        
        Administrador e = new Administrador();
        
        while (rs.next()){
            for (String columnName : columns) {
                String value = rs.getString(columnName);
                if (columnName.equals("NOMBRES"))
                    e.setNombres(value);
                if (columnName.equals("APELLIDOS")) 
                    e.setApellidos(value);
                if (columnName.equals("CEDULA"))
                    e.setCedula(value);
                if (columnName.equals("DIRECCION"))
                    e.setDireccion(value);
                if (columnName.equals("MAIL"))
                    e.setMail(value);
                if (columnName.equals("DELEGACION"))
                    e.setDelegacion(value);
            }
        }
        return e;
    }
//    public int Insertar(Estudiante objEstudiante) throws SQLException, ClassNotFoundException{
//        int retorno=0;
//  
//        retorno = this.ManejoEstudiante.Insertar(objEstudiante.getNombres(),objEstudiante.getApellidos(),objEstudiante.getCedula()
//        ,objEstudiante.getDireccion(),objEstudiante.getMail(),objEstudiante.getCarrera(),objEstudiante.getCiclo(),objEstudiante.getModalidad());
//        
//        this.cerrarConexion();
//        return retorno;
//    }
    
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
