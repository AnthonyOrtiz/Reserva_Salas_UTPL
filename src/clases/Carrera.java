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
public class Carrera {
    private String nombre;
    private int ciclos;
    private int anios;

    public Carrera() {
    }

    public Carrera(String nombre, int ciclos, int anios) {
        this.nombre = nombre;
        this.ciclos = ciclos;
        this.anios = anios;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCiclos() {
        return ciclos;
    }

    public void setCiclos(int ciclos) {
        this.ciclos = ciclos;
    }

    public int getAnios() {
        return anios;
    }

    public void setAnios(int anios) {
        this.anios = anios;
    }

    @Override
    public String toString() {
        return "Carreras{" + "nombre=" + nombre + ", ciclos=" + ciclos + ", anios=" + anios + '}';
    }
    
    
}
