/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BL;

import DAT.*;
import clases.Estudiante;
import clases.Horario;
import clases.Reserva;
import clases.Sala;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Salas
 */
public class BLReserva {

    DATReserva ManejoReserva = new DATReserva();
    DATConexion Conexion = new DATConexion();
    BLSala manejoSala = new BLSala();
    BLEstudiante manejoEstudiante = new BLEstudiante();

    public static ArrayList<Reserva> arrReservas = new ArrayList<Reserva>();

    public ArrayList<Reserva> Consultar() throws ClassNotFoundException, SQLException {
        Estudiante objEstudiante = new Estudiante();
        Sala objSala = new Sala();
        ResultSet rs;

        rs = ManejoReserva.Consultar();
        ResultSetMetaData rm = rs.getMetaData();
        ArrayList<Reserva> arrReservas = new ArrayList<Reserva>();
        int columnCount = rm.getColumnCount();
        ArrayList<String> columns = new ArrayList<>();
        for (int i = 1; i <= columnCount; i++) {
            String columnName = rm.getColumnName(i);
            columns.add(columnName);
        }

        while (rs.next()) {
            Reserva e = new Reserva();
            ArrayList<String> horas = new ArrayList<String>();
            for (String columnName : columns) {
                String value = rs.getString(columnName);
                if (columnName.equals("HORARIORESERVA")) {
                    e.setHorarioReserva(value);
                } else if (columnName.equals("FECHARESERVA")) {
                    e.setFechaReserva(value);
                } else if (columnName.equals("ESTUDIANTE")) {
                    objEstudiante = manejoEstudiante.buscarEstudiante(value);
                    e.setObjEstudiante(objEstudiante);
                } else if (columnName.equals("SALA")) {
                    objSala = manejoSala.buscarSala(value);
                    e.setObjSala(objSala);
                }
            }
            arrReservas.add(e);
        }
        return arrReservas;
    }

    public Reserva buscarReserva(String estudiante) throws ClassNotFoundException, SQLException {
        ResultSet rs;
        rs = ManejoReserva.buscarReserva(estudiante);

        Estudiante objEstudiante = new Estudiante();
        Sala objSala = new Sala();
        ResultSetMetaData rm = rs.getMetaData();

        int columnCount = rm.getColumnCount();
        ArrayList<String> columns = new ArrayList<>();
        for (int i = 1; i <= columnCount; i++) {
            String columnName = rm.getColumnName(i);
            columns.add(columnName);
        }

        Reserva e = new Reserva();

        while (rs.next()) {

            for (String columnName : columns) {
                String value = rs.getString(columnName);
                if (columnName.equals("HORARIORESERVA")) {
                    e.setHorarioReserva(value);
                } else if (columnName.equals("FECHARESERVA")) {
                    e.setFechaReserva(value);
                } else if (columnName.equals("ESTUDIANTE")) {
                    objEstudiante = manejoEstudiante.buscarEstudiante(value);
                    e.setObjEstudiante(objEstudiante);
                } else if (columnName.equals("SALA")) {
                    objSala = manejoSala.buscarSala(value);
                    e.setObjSala(objSala);
                }
            }
        }
        return e;
    }

    public ArrayList<Reserva> buscarReservas(String estudiante) throws ClassNotFoundException, SQLException {
        ResultSet rs;
        rs = ManejoReserva.buscarReservas(estudiante);

        Estudiante objEstudiante = new Estudiante();
        Sala objSala = new Sala();
        ResultSetMetaData rm = rs.getMetaData();

        int columnCount = rm.getColumnCount();
        ArrayList<String> columns = new ArrayList<>();
        for (int i = 1; i <= columnCount; i++) {
            String columnName = rm.getColumnName(i);
            columns.add(columnName);
        }

        ArrayList<Reserva> arrReservas = new ArrayList<Reserva>();
        while (rs.next()) {
            Reserva e = new Reserva();
            for (String columnName : columns) {
                String value = rs.getString(columnName);
                if (columnName.equals("HORARIORESERVA")) {
                    e.setHorarioReserva(value);
                } else if (columnName.equals("FECHARESERVA")) {
                    e.setFechaReserva(value);
                } else if (columnName.equals("ESTUDIANTE")) {
                    objEstudiante = manejoEstudiante.buscarEstudiante(value);
                    e.setObjEstudiante(objEstudiante);
                } else if (columnName.equals("SALA")) {
                    objSala = manejoSala.buscarSala(value);
                    e.setObjSala(objSala);

                }
            }
            arrReservas.add(e);
        }
        return arrReservas;
    }

    public int Insertar(Reserva objReserva) throws SQLException, ClassNotFoundException {
        int retorno = 0;

        retorno = this.ManejoReserva.Insertar(objReserva.getHorarioReserva(), objReserva.getFechaReserva(), objReserva.getObjEstudiante().getCedula(), objReserva.getObjSala().getCodigo());

        this.cerrarConexion();
        return retorno;
    }

    public int InsertarHistorial(Reserva objReserva) throws SQLException, ClassNotFoundException {
        int retorno = 0;

        retorno = this.ManejoReserva.InsertarHistorial(objReserva.getHorarioReserva(), objReserva.getFechaReserva(), objReserva.getObjEstudiante().getCedula(), objReserva.getObjSala().getCodigo());

        this.cerrarConexion();
        return retorno;
    }

//    public int Modificar(String id, String horario) throws ClassNotFoundException, SQLException{
//        return ManejoReserva.ocuparSala(id, horario);
//    }
//    
    public int Eliminar(String sala) throws SQLException, ClassNotFoundException {
        return this.ManejoReserva.Eliminar(sala);
    }

    public int EliminarReservas(int salas[]) throws SQLException, ClassNotFoundException {
        int retorno = 0;
        for (int aux : salas) {
            retorno = ManejoReserva.Eliminar(String.valueOf(aux + 1));
        }
        return retorno;
    }

    public void cerrarConexion() throws SQLException {
        Conexion.CerrarConexion();
    }

    public Reserva crearReserva(String cabecera[], int horario[], Estudiante objEstudiante, String codigoSala) {
        Reserva objReserva = new Reserva();
        BLSala manejoSala = new BLSala();
        Sala objSala = new Sala();
        
        Date now = new Date(System.currentTimeMillis());
        SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
        
        
        String horarioRserva = "";

        horarioRserva = cabecera[horario[0]];
        for (int i = 1; i < horario.length; i++) {
            horarioRserva += " - " + cabecera[horario[i]];
        }
        
        try {
            objSala = manejoSala.buscarSala(codigoSala);
            if (objSala.getCodigo() != null) {
                objReserva.setFechaReserva(String.valueOf(date.format(now)));
                objReserva.setHorarioReserva(horarioRserva);
                objReserva.setObjEstudiante(objEstudiante);
                objReserva.setObjSala(objSala);
            }else{
                objReserva = null;
            }
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BLReserva.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(BLReserva.class.getName()).log(Level.SEVERE, null, ex);
        }
        return objReserva;
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
