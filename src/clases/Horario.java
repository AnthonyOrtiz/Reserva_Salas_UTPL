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
public class Horario {
    private String id;
    private ArrayList<String> horas;

    public Horario() {
    }

    public Horario(String id, ArrayList<String> horas) {
        this.id = id;
        this.horas = horas;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ArrayList<String> getHoras() {
        return horas;
    }

    public void setHoras(ArrayList<String> horas) {
        this.horas = horas;
    }

    @Override
    public String toString() {
        return "Horario{" + "id=" + id + ", horas=" + horas + '}';
    }
    
}
