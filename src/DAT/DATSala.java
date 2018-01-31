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
public class DATSala {
     DATConexion c = new DATConexion();
     
    public ResultSet Consultar() throws ClassNotFoundException, SQLException
    {
        Statement st = c.AbrirConexion().createStatement();
        String Sentencia = "SELECT * FROM salas";
        ResultSet rs = st.executeQuery(Sentencia);
        return rs;
    }
    public ResultSet buscarSala(String codigo) throws ClassNotFoundException, SQLException
    {
        Statement st = c.AbrirConexion().createStatement();
        String Sentencia = "SELECT CODIGO, NOMBRE, ESTADO, DESCRIPCION, PISO, NUMPERSONAS FROM salas WHERE CODIGO ="+"'"+codigo+"'";
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
    public int actualizarSala(String codigo) throws ClassNotFoundException, SQLException{
         int Retorno=0;
         Statement st=c.AbrirConexion().createStatement();
         String sentencia="UPDATE salas SET ESTADO = "+"'"+"funcional"+"'"+"WHERE CODIGO="+"'"+codigo+"'";
         Retorno=st.executeUpdate(sentencia);
         c.CerrarConexion();
         return Retorno;
    }
    
    public int actualizarEstadoSala(String codigo, String estado, String descripcion) throws ClassNotFoundException, SQLException{
         int Retorno=0;
         Statement st=c.AbrirConexion().createStatement();
         String sentencia="UPDATE salas SET ESTADO = "+"'"+estado+"'"+","+"DESCRIPCION = "+"'"+descripcion+"'"+"WHERE CODIGO = "+"'"+codigo+"'";
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
