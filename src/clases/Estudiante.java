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
public class Estudiante extends Persona{
    private String carrera;
    private String ciclo;
    private String modalidad;

    public Estudiante() {
    }

    public Estudiante(String nombre, String cedula, String direccion, String mail, String carrera, String ciclo, String modalidad) {
        super.setNombres(nombre);
        super.setCedula(cedula);
        super.setDireccion(direccion); 
        super.setMail(mail);
        this.carrera = carrera;
        this.ciclo = ciclo;
        this.modalidad = modalidad;
    }

    public Estudiante(String carrera, String ciclo, String modalidad, String nombres, String apellidos, String cedula, String direccion, String mail) {
        super(nombres, apellidos, cedula, direccion, mail);
        this.carrera = carrera;
        this.ciclo = ciclo;
        this.modalidad = modalidad;
    }
    
    

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getCiclo() {
        return ciclo;
    }

    public void setCiclo(String ciclo) {
        this.ciclo = ciclo;
    }

    public String getModalidad() {
        return modalidad;
    }

    public void setModalidad(String modalidad) {
        this.modalidad = modalidad;
    }

    @Override
    public String toString() {
        return "Estudiante{" + "nombre=" + super.getNombres() + ", cedula=" + super.getCedula() + ", direccion=" + super.getDireccion() + ", mail=" + super.getMail() + ", carrera=" + carrera + ", ciclo=" + ciclo + ", modalidad=" + modalidad + '}';
    }
    
    
}
