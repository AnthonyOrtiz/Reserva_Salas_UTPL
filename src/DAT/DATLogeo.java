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
public class DATLogeo {
     DATConexion c = new DATConexion();
     
    public ResultSet Consultar() throws ClassNotFoundException, SQLException
    {
        Statement st = c.AbrirConexion().createStatement();
        String Sentencia = "SELECT * FROM logeos";
        ResultSet rs = st.executeQuery(Sentencia);
        return rs;
    }
    
    public ResultSet Consultar(String clave) throws ClassNotFoundException, SQLException
    {
        Statement st = c.AbrirConexion().createStatement();
        String Sentencia = "SELECT * FROM logeos WHERE CLAVE = " +"'"+clave+"'";
        ResultSet rs = st.executeQuery(Sentencia);
        return rs;
    }
    public ResultSet Consultar(String usuario, String contrasenia) throws ClassNotFoundException, SQLException
    {
        Statement st = c.AbrirConexion().createStatement();
        String Sentencia = "SELECT * FROM logeos WHERE USUARIO = " +"'"+usuario+"'"+"AND CONTRASENIA = "+"'"+contrasenia+"'";
        ResultSet rs = st.executeQuery(Sentencia);
        return rs;
    }
    
    public ResultSet ConsultarUsuario(String usuario) throws ClassNotFoundException, SQLException
    {
        Statement st = c.AbrirConexion().createStatement();
        String Sentencia = "SELECT * FROM logeos WHERE USUARIO = " +"'"+usuario+"'" ;
        ResultSet rs = st.executeQuery(Sentencia);
        return rs;
    }
    
    //Aquí debe implementar los métodos de INSERCION, ACTUALIZACION Y BORRADO
    public int Insertar(String usuario, String contrasenia, String clave, String ocupacion) throws SQLException, ClassNotFoundException{
        int intRetorno=0;
        Statement st = c.AbrirConexion().createStatement();
        String Sentencia = "INSERT INTO logeos (USUARIO, CONTRASENIA, CLAVE, OCUPACION)  VALUES ( " 
                +"'" +usuario +"'"  + "," 
                +"'" +contrasenia +"'" + "," 
                +"'" +clave +"'"+ ","
                +"'" +ocupacion +"'"+ ")" ;
        intRetorno = st.executeUpdate(Sentencia);
        return intRetorno;
    }
//    public int Modificar(String cedula, String apellidos, String nombres, String direccion, String email,String celular) throws ClassNotFoundException, SQLException{
//         int Retorno=0;
//         Statement st=c.AbrirConexion().createStatement();
//         String sentencia="UPDATE clientes SET CEDULA="+"'"+cedula+"'"+","+"APELLIDOS="+"'"+apellidos+"'"+","+"NOMBRES="+"'"+nombres+"'"
//                 +","+"DIRECCION="+"'"+direccion+"'"+","+"MAIL="+"'"+email+"'"+","+"CELULAR="+"'"+celular+"'"+"WHERE CEDULA="+"'"+cedula+"'";
//         Retorno=st.executeUpdate(sentencia);
//         c.CerrarConexion();
//         return Retorno;
//    }
//    
//    public int Eliminar(String cedula) throws SQLException, ClassNotFoundException{
//        int intRetorno=0;//declarmos
//        Statement st = c.AbrirConexion().createStatement();
//        String Sentencia = "DELETE FROM clientes WHERE CEDULA="+"'"+cedula+"'";//"'" porque es de tipo String se cierra entre comllias
//        intRetorno = st.executeUpdate(Sentencia);
//        c.CerrarConexion();
//        return intRetorno;
//    }
//    public ResultSet BuscarCliente(String Cedula) throws ClassNotFoundException, SQLException
//    {
//        Statement st = c.AbrirConexion().createStatement();
//        String Sentencia = "SELECT CEDULA, APELLIDOS, NOMBRES, DIRECCION, MAIL, CELULAR FROM clientes WHERE CEDULA ="+"'"+Cedula+"'";
//        ResultSet rs = st.executeQuery(Sentencia);
//        //System.out.println(Sentencia);
//        return rs;
//    }
}
