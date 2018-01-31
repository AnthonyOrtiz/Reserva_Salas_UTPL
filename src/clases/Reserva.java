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
public class Reserva {
    private String horarioReserva;
    private String fechaReserva;
    private Estudiante objEstudiante;
    private Sala objSala;

    public Reserva() {
    }

    public Reserva(String horarioReserva, String fechaReserva, Estudiante objEstudiante, Sala objSala) {
        this.horarioReserva = horarioReserva;
        this.fechaReserva = fechaReserva;
        this.objEstudiante = objEstudiante;
        this.objSala = objSala;
    }

    public String getHorarioReserva() {
        return horarioReserva;
    }

    public void setHorarioReserva(String horarioReserva) {
        this.horarioReserva = horarioReserva;
    }

    public String getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(String fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    public Estudiante getObjEstudiante() {
        return objEstudiante;
    }

    public void setObjEstudiante(Estudiante objEstudiante) {
        this.objEstudiante = objEstudiante;
    }

    public Sala getObjSala() {
        return objSala;
    }

    public void setObjSala(Sala objSala) {
        this.objSala = objSala;
    }

    @Override
    public String toString() {
        return "Reserva{" + "horarioReserva=" + horarioReserva + ", fechaReserva=" + fechaReserva + ", objEstudiante=" + objEstudiante + ", objSala=" + objSala + '}';
    }
    
    
}
