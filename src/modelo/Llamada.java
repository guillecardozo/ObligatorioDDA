package modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

public class Llamada {

    private Date fechaHoraAtendida;
    private Date fechaHoraInicio;
    private Date fechaHoraFin;
    private String descripcion;
    private int id;
    private static final AtomicInteger count = new AtomicInteger(0);
    private Trabajador trabajador;
    private Cliente cliente;
    private Puesto puesto;//Representa el puesto actual de la llamada
    private Sector sector;
    private boolean estado;
    private float costo;

    public Llamada(Date fechaHoraInicio, Date fechaHoraFin, Date fechaHoraAtendida, String descripcion, Trabajador trabajador, Cliente cliente, Puesto puesto, Sector sector, boolean estado) {
        this.fechaHoraInicio = fechaHoraInicio;
        this.fechaHoraFin = fechaHoraFin;
        this.fechaHoraAtendida = fechaHoraAtendida;
        this.descripcion = descripcion;
        this.trabajador = trabajador;
        this.cliente = cliente;
        this.puesto = puesto;
        this.sector = sector;
        this.estado = false;
        this.costo = 0;
    }

    public Llamada() {
        this.id = count.incrementAndGet();//Autoincremental
    }

    public Date getFechaHoraAtendida() {
        return fechaHoraAtendida;
    }

    public void setFechaHoraAtendida(Date fechaHoraAtendida) {
        this.fechaHoraAtendida = fechaHoraAtendida;
    }

    public Date getFechaHoraInicio() {
        return fechaHoraInicio;
    }

    public void setFechaHoraInicio(Date fechaHoraInicio) {
        this.fechaHoraInicio = fechaHoraInicio;
    }

    public Date getFechaHoraFin() {
        return fechaHoraFin;
    }

    public void setFechaHoraFin(Date fechaHoraFin) {
        this.fechaHoraFin = fechaHoraFin;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Sector getSector() {
        return sector;
    }

    public void setSector(Sector sector) {
        this.sector = sector;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public Trabajador getTrabajador() {
        return trabajador;
    }

    public void setTrabajador(Trabajador trabajador) {
        this.trabajador = trabajador;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Puesto getPuesto() {
        return puesto;
    }

    public void setPuesto(Puesto puesto) {
        this.puesto = puesto;
    }

    public float getCosto() {
        return costo;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }

    public String cambiarEstado() {
        if (this.estado) {
            return "En curso";
        } else {
            return "Finalizada";
        }
    }

    public float tiempoEnEspera() {
        if (fechaHoraAtendida == null || fechaHoraInicio == null) {
            return 0;
        }
        return tiempoDiff(this.fechaHoraInicio, this.fechaHoraAtendida);
    }
    
    public float tiempoDeEsperaDelSector(Date fechaInicio, Date fechaActual){
        return tiempoDiffMinutos(this.fechaHoraInicio, new Date());
    }

    public float tiempoLlamada() {
        if (fechaHoraAtendida == null || fechaHoraFin == null) {
            return 0;
        }
        return tiempoDiff(this.fechaHoraAtendida, this.fechaHoraFin);
    }

    //Metodo que calcula la fecha en segundos
    private float tiempoDiff(Date fechaInicio, Date fechaTermino) {
        float segundos = (float) ((fechaTermino.getTime() / 1000) - (fechaInicio.getTime() / 1000));

        if (segundos < 60) {
            return segundos;
        }
        return segundos / 60;
    }
    
    private float tiempoDiffMinutos(Date fechaInicio, Date fechaTermino){
        float minutos = tiempoDiff(fechaInicio, fechaTermino) / 60;
        return minutos;
    }

    public Trabajador asignarTrabajador(Sector unSector) {
        ArrayList<Trabajador> trabajadores = unSector.getTrabajadores();
        for (Trabajador unTrabajador : trabajadores) {
            if (unTrabajador.getDisponible()) {
                return unTrabajador;
            }
        }
        return null;
    }
}
