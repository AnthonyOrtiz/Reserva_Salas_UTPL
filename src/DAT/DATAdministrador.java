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
public class DATAdministrador {
     DATConexion c = new DATConexion();
     
    public ResultSet Consultar() throws ClassNotFoundException, SQLException {
        Statement st = c.AbrirConexion().createStatement();
        String Sentencia = "SELECT * FROM administradores";
        ResultSet rs = st.executeQuery(Sentencia);
        return rs;
    }
    public ResultSet buscarAdministrador(String clave) throws ClassNotFoundException, SQLException
    {
        Statement st = c.AbrirConexion().createStatement();
        String Sentencia = "SELECT NOMBRES, APELLIDOS,CEDULA, DIRECCION, MAIL, DELEGACION FROM administradores WHERE CEDULA ="+"'"+clave+"'";
        ResultSet rs = st.executeQuery(Sentencia);
        return rs;
    }
    //Aquí debe implementar los métodos de INSERCION, ACTUALIZACION Y BORRADO
//    public int Insertar(String nombres, String apellidos, String cedula, String direccion, String mail, String carrera,String ciclo, String modalidad) throws SQLException, ClassNotFoundException{
//        int intRetorno=0;
//        Statement st = c.AbrirConexion().createStatement();
//        String Sentencia = "INSERT INTO estudiantes (NOMBRES, APELLIDOS, CEDULA, DIRECCION, MAIL, CARRERA, CICLO, MODALIDAD)  VALUES ( " 
//                +"'" +nombres +"'"  + "," 
//                +"'" +apellidos +"'" + "," 
//                +"'" +cedula +"'"+ ","
//                +"'" +direccion +"'" + "," 
//                +"'" +mail +"'" + "," 
//                +"'" +carrera +"'" + "," 
//                +"'" +ciclo +"'"+","
//                +"'" +modalidad +"'" + ")" ;
//        intRetorno = st.executeUpdate(Sentencia);
//        return intRetorno;
//    }
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

}
