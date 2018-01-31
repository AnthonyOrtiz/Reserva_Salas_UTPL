/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BL;

import DAT.*;
import clases.Estudiante;
import clases.Horario;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Salas
 */
public class BLHorarios {

    DATHorarios manejoHorarios = new DATHorarios();
    DATConexion Conexion = new DATConexion();

    public static ArrayList<Horario> ArrEstudiante;

    public ArrayList<Horario> Consultar() throws ClassNotFoundException, SQLException {
        ArrEstudiante = new ArrayList<Horario>();
        ResultSet rs;
        rs = manejoHorarios.Consultar();
        ResultSetMetaData rm = rs.getMetaData();

        int columnCount = rm.getColumnCount();
        ArrayList<String> columns = new ArrayList<>();
        for (int i = 1; i <= columnCount; i++) {
            String columnName = rm.getColumnName(i);
            columns.add(columnName);
        }
        while (rs.next()) {
            Horario e = new Horario();
            ArrayList<String> horas = new ArrayList<String>();
            for (String columnName : columns) {
                String value = rs.getString(columnName);
                if (columnName.equals("ID")) {
                    e.setId(value);
                } else {
                    horas.add(value);
                }
            }
            e.setHoras(horas);
            ArrEstudiante.add(e);
        }
        return ArrEstudiante;
    }

    public Horario consultarHorario(String id) throws ClassNotFoundException, SQLException {
        ResultSet rs;
        rs = this.manejoHorarios.consultarHora(id);
        //tranformar el rs a objeto cliente

        ResultSetMetaData rm = rs.getMetaData();

        int columnCount = rm.getColumnCount();
        ArrayList<String> columns = new ArrayList<>();
        for (int i = 1; i <= columnCount; i++) {
            String columnName = rm.getColumnName(i);
            columns.add(columnName);
        }

        Horario e = new Horario();

        while (rs.next()) {
            ArrayList<String> horas = new ArrayList<String>();
            for (String columnName : columns) {
                String value = rs.getString(columnName);
                if (columnName.equals("ID")) {
                    e.setId(value);
                } else {
                    horas.add(value);
                }
            }
            e.setHoras(horas);
        }
        return e;
    }
//    public String consultarHora(String hora,String id) throws ClassNotFoundException, SQLException {
//        ResultSet rs;
//        rs = this.ManejoHorario.consultarHora(hora,id);
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
//        Horario e = new Horario();
//        
//        String horaConsultada = "";
//        
//        while (rs.next()){
//            for (String columnName : columns) {
//                String value = rs.getString(columnName);
//                horaConsultada = value;
//            }
//        }
//        return horaConsultada;
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
    public int ocuparHorario(String id, String horario) throws ClassNotFoundException, SQLException {
        return manejoHorarios.ocuparHorario(id, horario);
    }

    public int ocuparHorarios(String id, int horarios[]) throws ClassNotFoundException, SQLException {
        int retorno = 0;

        for (int i = 0; i < horarios.length; i++) {
            String horario = "h" + (horarios[i]);

            retorno = ocuparHorario(id, horario);
        }

        return retorno;
    }

    public int actualizarHorarios(int ids[]) throws ClassNotFoundException, SQLException {
        int retorno = 0;
        for (int aux : ids) {
            for (int i = 1; i < 27; i++) {
                String horario = "h" + i;
                retorno = manejoHorarios.actualizarHorarios(String.valueOf(aux + 1), horario);
            }
        }
        return retorno;
    }

    public int actualizarHorarioReparacion(String id) throws ClassNotFoundException, SQLException {
        int retorno = 0;

        for (int i = 1; i < 27; i++) {
            String horario = "h" + i;
            retorno = manejoHorarios.actualizarHorariosReparacion(id, horario);
        }

        return retorno;
    }

    public int actualizarHorarioFuncional(String id) throws ClassNotFoundException, SQLException {
        int retorno = 0;

        for (int i = 1; i < 27; i++) {
            String horario = "h" + i;
            retorno = manejoHorarios.actualizarHorarios(id, horario);
        }

        return retorno;
    }
//    
//    public int Eliminar(String cedula) throws SQLException, ClassNotFoundException {
//        return this.ManejoLog.Eliminar(cedula);
//    }

    public void cerrarConexion() throws SQLException {
        Conexion.CerrarConexion();
    }

    public int revisarHorario(ArrayList<String> horarios, int elecciones[]) {
        int opcion = 0;

        for (int i = 0; i < elecciones.length; i++) {
            int num = elecciones[i] - 1;
            if (horarios.get(num).equals("-")) {
                opcion = 1;
                break;
            } else if (horarios.get(num).equals("D")) {
                opcion = 2;
                break;
            }
        }

        return opcion;
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
