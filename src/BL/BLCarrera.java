/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BL;

import DAT.*;
import clases.Carrera;
import clases.Estudiante;
import clases.Sala;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Salas
 */
public class BLCarrera {

    DATCarrera actualizarSala = new DATCarrera();
    DATConexion Conexion = new DATConexion();

    public static ArrayList<Carrera> arrSalas = new ArrayList<Carrera>();
    
    public ArrayList<Carrera> Consultar() throws ClassNotFoundException, SQLException {
        ResultSet rs;
        rs = actualizarSala.Consultar();
        ResultSetMetaData rm = rs.getMetaData();
        int ciclos = 0;
        int anios = 0;
        int columnCount = rm.getColumnCount();
        ArrayList<String> columns = new ArrayList<>();
        for (int i = 1; i <= columnCount; i++) {
            String columnName = rm.getColumnName(i);
            columns.add(columnName);
        }
        while (rs.next()) 
        {
            Carrera e = new Carrera();
            for (String columnName : columns) 
            {
                String value = rs.getString(columnName);
                if (columnName.equals("NOMBRE"))
                    e.setNombre(value);
                if (columnName.equals("CICLOS")){
                    ciclos = Integer.parseInt(value);
                    e.setCiclos(ciclos);
                }  
                if (columnName.equals("ANIOS")){
                    anios = Integer.parseInt(value);
                    e.setAnios(anios);
                }     
            }
           arrSalas.add(e);  
        }
        return arrSalas;
    }
    
//    public Sala buscarSala(String codigo) throws ClassNotFoundException, SQLException {
//        ResultSet rs;
//        rs = this.actualizarSala.buscarSala(codigo);
//        int piso = 0;
//        int numPersonas = 0;
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
//        Sala e = new Sala();
//        
//        while (rs.next()){
//            for (String columnName : columns) {
//                String value = rs.getString(columnName);
//                if (columnName.equals("CODIGO"))
//                    e.setCodigo(value);
//                if (columnName.equals("ESTADO")){
//                    String estado = value;
//                    if (!estado.equals("en reparaciones")) {
//                        e.setEstado(4);
//                    }else{
//                        e.setEstado(3);
//                    }                    
//                } 
//                if (columnName.equals("DESCRIPCION"))
//                    e.setDescripcion(value);
//                if (columnName.equals("PISO")){
//                    piso = Integer.parseInt(value);
//                    e.setPiso(piso);
//                }
//                if (columnName.equals("NUMPERSONAS")){
//                    numPersonas = Integer.parseInt(value);
//                    e.setNumPersonas(numPersonas);
//                }
//            }
//        }
//        return e;
//    }
    
//    public int Insertar(Cliente objCliente) throws SQLException, ClassNotFoundException{
//        int retorno=0;
//  
//        retorno=this.ManejoLog.Insertar(objCliente.getCedula(),objCliente.getApellidos(),
//                    objCliente.getNombres(),objCliente.getDireccion(),
//                    objCliente.getMail(),objCliente.getCelular());
//        
//        this.cerrarConexion();
//        return retorno;
//    }
    
//    public int actualizarSala(String codigo) throws ClassNotFoundException, SQLException{
//        return actualizarSala.actualizarSala(codigo);
//    }
//    
//    public int actualizarSalas(int codigos[]) throws ClassNotFoundException, SQLException{
//        int retorno = 0;
//        for (int aux:codigos) {
//                retorno = actualizarSala.actualizarSala(String.valueOf(aux+1));     
//        }
//       return retorno;
//    }
//    
//    public int actualizarEstadoSala(String codigo, String estado, String descripcion) throws ClassNotFoundException, SQLException{
//        return actualizarSala.actualizarEstadoSala(codigo,estado,descripcion);
//    }
//    
//    public int Eliminar(String cedula) throws SQLException, ClassNotFoundException {
//        return this.ManejoLog.Eliminar(cedula);
//    }
    
//    public void cerrarConexion() throws SQLException{
//        Conexion.CerrarConexion();
//    }
    
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
