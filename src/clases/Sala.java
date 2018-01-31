/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class Sala {
    private String codigo;
    private String nombre;
    private String estado;
    private ArrayList<String> estados;
    private String descripcion;
    private int piso;
    private int numPersonas;

    public Sala() {
        estados = new ArrayList<String>();
        estados.add("ocupado");
        estados.add("desocupado");
        estados.add("en reparaciones");
        estados.add("funcional");
    }

    public Sala(String codigo,String nombre ,String descripcion, int piso, int numPersonas) {
        estados = new ArrayList<String>();
        this.nombre = nombre;
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.piso = piso;
        this.numPersonas = numPersonas;
        estados.add("ocupado");
        estados.add("desocupado");
        estados.add("en reparaciones");
        estados.add("funcional");
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(int opcion) {
        switch (opcion){
            case 1:
                estado = estados.get(0);
                break;
            case 2:
                estado = estados.get(1);
                break;
            case 3:
                estado = estados.get(2);
                break;
            case 4:
                estado = estados.get(3);
        }
    }

    public ArrayList<String> getEstados() {
        return estados;
    }

    public void setEstados(ArrayList<String> estados) {
        this.estados = estados;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getPiso() {
        return piso;
    }

    public void setPiso(int piso) {
        this.piso = piso;
    }

    public int getNumPersonas() {
        return numPersonas;
    }

    public void setNumPersonas(int numPersonas) {
        this.numPersonas = numPersonas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Sala{" + "codigo=" + codigo + ", nombre=" + nombre + ", estado=" + estado + ", estados=" + estados + ", descripcion=" + descripcion + ", piso=" + piso + ", numPersonas=" + numPersonas + '}';
    }
    
}
