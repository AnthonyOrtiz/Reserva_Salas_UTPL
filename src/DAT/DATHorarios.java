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
public class DATHorarios {
     DATConexion c = new DATConexion();
     
    public ResultSet Consultar() throws ClassNotFoundException, SQLException
    {
        Statement st = c.AbrirConexion().createStatement();
        String Sentencia = "SELECT * FROM horarios";
        ResultSet rs = st.executeQuery(Sentencia);
        return rs;
    }
    
    public ResultSet consultarHora(String id) throws ClassNotFoundException, SQLException
    {
        Statement st = c.AbrirConexion().createStatement();
        String Sentencia = "SELECT * FROM horarios WHERE ID = " + id ;
        ResultSet rs = st.executeQuery(Sentencia);
        return rs;
    }
    
    //Aquí debe implementar los métodos de INSERCION, ACTUALIZACION Y BORRADO
//    public int Insertar(String strCedula, String strApellido, String strNombres, String strDir, String strMail, String strCel) throws SQLException, ClassNotFoundException{
//        int intRetorno=0;
//        Statement st = c.AbrirConexion().createStatement();
//        String Sentencia = "INSERT INTO clientes (CEDULA, APELLIDOS, NOMBRES, DIRECCION, MAIL, CELULAR)  VALUES ( " 
//                +"'" +strCedula +"'"  + "," 
//                +"'" +strApellido +"'" + "," 
//                +"'" +strNombres +"'"+ ","
//                +"'" +strDir +"'" + "," 
//                +"'" +strMail +"'" + ","
//                +"'" +strCel +"'"+ ")" ;
//        intRetorno = st.executeUpdate(Sentencia);
//        return intRetorno;
//    }
    public int ocuparHorario(String id, String hora) throws ClassNotFoundException, SQLException{
         int Retorno=0;
         //String a = hora+"= -";
         Statement st=c.AbrirConexion().createStatement();
         String sentencia="UPDATE horarios SET "+hora+"="+"'"+"-"+"'"+"WHERE ID ="+id;
         //UPDATE `horarios` SET `h1`="0" WHERE `ID`=1
         Retorno=st.executeUpdate(sentencia);
         c.CerrarConexion();
         return Retorno;
    }
    
    public int actualizarHorarios(String id, String hora) throws ClassNotFoundException, SQLException{
         int Retorno=0;
         //String a = hora+"= -";
         Statement st=c.AbrirConexion().createStatement();
         String sentencia="UPDATE horarios SET "+hora+"="+"'"+"0"+"'"+"WHERE ID ="+id;
         //UPDATE `horarios` SET `h1`="0" WHERE `ID`=1
         Retorno=st.executeUpdate(sentencia);
         c.CerrarConexion();
         return Retorno;
    }
    
     public int actualizarHorariosReparacion(String id, String hora) throws ClassNotFoundException, SQLException{
         int Retorno=0;
         //String a = hora+"= -";
         Statement st=c.AbrirConexion().createStatement();
         String sentencia="UPDATE horarios SET "+hora+"="+"'"+"D"+"'"+"WHERE ID ="+id;
         //UPDATE `horarios` SET `h1`="0" WHERE `ID`=1
         Retorno=st.executeUpdate(sentencia);
         c.CerrarConexion();
         return Retorno;
    }

//    
//    public int Eliminar(String cedula) throws SQLException, ClassNotFoundException{
//        int intRetorno=0;//declarmos
//        Statement st = c.AbrirConexion().createStatement();
//        String Sentencia = "DELETE FROM clientes WHERE CEDULA="+"'"+cedula+"'";//"'" porque es de tipo String se cierra entre comllias
//        intRetorno = st.executeUpdate(Sentencia);
//        c.CerrarConexion();
//        return intRetorno;
//    }

}
