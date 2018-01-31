/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAT;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Salas
 */
public class DATReserva {
     DATConexion c = new DATConexion();
     
    public ResultSet Consultar() throws ClassNotFoundException, SQLException
    {
        Statement st = c.AbrirConexion().createStatement();
        String Sentencia = "SELECT * FROM reservas";
        ResultSet rs = st.executeQuery(Sentencia);
        return rs;
    }
    public ResultSet buscarReserva(String estudiante) throws ClassNotFoundException, SQLException
    {
        Statement st = c.AbrirConexion().createStatement();
        String Sentencia = "SELECT HORARIORESERVA, FECHARESERVA, ESTUDIANTE, SALA FROM reservas WHERE ESTUDIANTE ="+"'"+estudiante+"'";
        ResultSet rs = st.executeQuery(Sentencia);
        return rs;
    }
    public ResultSet buscarReservas(String estudiante) throws ClassNotFoundException, SQLException
    {
        Statement st = c.AbrirConexion().createStatement();
        String Sentencia = "SELECT HORARIORESERVA, FECHARESERVA, ESTUDIANTE, SALA FROM historialreserva WHERE ESTUDIANTE ="+"'"+estudiante+"'";
        ResultSet rs = st.executeQuery(Sentencia);
        return rs;
    }
    //Aquí debe implementar los métodos de INSERCION, ACTUALIZACION Y BORRADO

    public int Insertar(String horarioReserva, String fechaReserva, String estudiante, String sala) throws SQLException, ClassNotFoundException{
        int intRetorno=0;
        Statement st = c.AbrirConexion().createStatement();
        String Sentencia = "INSERT INTO reservas (HORARIORESERVA, FECHARESERVA, ESTUDIANTE, SALA)  VALUES ( " 
                +"'" +horarioReserva +"'"  + "," 
                +"'" +fechaReserva +"'" + "," 
                +"'" +estudiante +"'"+ ","
                +"'" +sala +"'"+ ")" ;
        intRetorno = st.executeUpdate(Sentencia);
        return intRetorno;
    }
    public int InsertarHistorial(String horarioReserva, String fechaReserva, String estudiante, String sala) throws SQLException, ClassNotFoundException{
        int intRetorno=0;
        Statement st = c.AbrirConexion().createStatement();
        String Sentencia = "INSERT INTO historialreserva (HORARIORESERVA, FECHARESERVA, ESTUDIANTE, SALA)  VALUES ( " 
                +"'" +horarioReserva +"'"  + "," 
                +"'" +fechaReserva +"'" + "," 
                +"'" +estudiante +"'"+ ","
                +"'" +sala +"'"+ ")" ;
        intRetorno = st.executeUpdate(Sentencia);
        return intRetorno;
    }
//    public int ocuparSala(String id, String hora) throws ClassNotFoundException, SQLException{
//         int Retorno=0;
//         //String a = hora+"= -";
//         Statement st=c.AbrirConexion().createStatement();
//         String sentencia="UPDATE horarios SET "+hora+"="+"'"+"-"+"'"+"WHERE ID ="+id;
//         //UPDATE `horarios` SET `h1`="0" WHERE `ID`=1
//         System.out.println(sentencia);
//         Retorno=st.executeUpdate(sentencia);
//         c.CerrarConexion();
//         return Retorno;
//    }
//    
    public int Eliminar(String sala) throws SQLException, ClassNotFoundException{
        int intRetorno=0;//declarmos
        Statement st = c.AbrirConexion().createStatement();
        String Sentencia = "DELETE FROM reservas WHERE SALA="+"'"+sala+"'";//"'" porque es de tipo String se cierra entre comllias
        intRetorno = st.executeUpdate(Sentencia);
        c.CerrarConexion();
        return intRetorno;
    }

}
