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
public class Administrador extends Persona{
    private String delegacion;

    public Administrador() {
    }

    public Administrador(String delegacion, String nombres, String apellidos, String cedula, String direccion, String mail) {
        super(nombres, apellidos, cedula, direccion, mail);
        this.delegacion = delegacion;
    }

    public String getDelegacion() {
        return delegacion;
    }

    public void setDelegacion(String delegacion) {
        this.delegacion = delegacion;
    }
    
    
}
