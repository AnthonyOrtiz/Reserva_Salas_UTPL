/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JTextField;

/**
 *
 * @author Salas
 */
public class Expresiones {

    public boolean validarMail(String email) {

        Pattern pat= Pattern.compile("^[\\w-]+(\\.[\\w-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
                
//        if (email.length() == 20) {
//            
//        }
            Matcher mat = pat.matcher(email);

            if (mat.find()) {

                return true;

            } else {

                return false;

            }

    }

    public boolean validarNumeros(String celular) {
        boolean t = false;
        Pattern pat = Pattern.compile("[0-9]{10}");

        if (celular.length() == 10) {
            Matcher mat = pat.matcher(celular);

            if (mat.find()) {
                t = true;

            } else {

                t = false;
            }
        }

        return t;
    }
    
}
