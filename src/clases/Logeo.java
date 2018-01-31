/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

/**
 *
 * @author Usuario
 */
public class Logeo {
    private String usuario;
    private String contrasenia;
    private String clave;
    private String ocupacion;
    
    public Logeo() {
    }

    public Logeo(String usuario, String contrasenia, String clave, String ocupacion) {
        this.usuario = usuario;
        this.contrasenia = contrasenia;
        this.clave = clave;
        this.ocupacion = ocupacion;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    @Override
    public String toString() {
        return "Logeo{" + "usuario=" + usuario + ", contrasenia=" + contrasenia + ", clave=" + clave + ", ocupacion=" + ocupacion + '}';
    }
    
    
}
