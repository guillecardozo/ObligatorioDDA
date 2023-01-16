package modelo;

import java.util.ArrayList;

public class Puesto {

    private int numero;
    private boolean estaLibre;
    private Trabajador trabajador;
    private float tiempoDeAtencion;
    private float tiempoDeLlamada;
    private Llamada llamadaActual;
    private ArrayList<Llamada> llamadasAtendidasPorTrabajador = new ArrayList();

    public Puesto(int numero, boolean estaLibre, Trabajador trabajador, float tiempoDeAtencion, float tiempoDeLlamada, Llamada llamadaActual) {
        this.numero = numero;
        this.estaLibre = estaLibre;
        this.trabajador = trabajador;
        this.tiempoDeAtencion = tiempoDeAtencion;
        this.tiempoDeLlamada = tiempoDeLlamada;
        this.llamadaActual = llamadaActual;
    }

    public int getNumero() {
        return numero;
    }

    public boolean getEstaLibre() {
        return estaLibre;
    }

    public void setEstaLibre(boolean estaLibre) {
        this.estaLibre = estaLibre;
    }

    public Trabajador getTrabajador() {
        return trabajador;
    }

    public void setTrabajador(Trabajador trabajador) {
        this.trabajador = trabajador;
    }

    public float getTiempoDeAtencion() {
        return tiempoDeAtencion;
    }

    public float getTiempoDeLlamada() {
        return tiempoDeLlamada;
    }

    public void setTiempoDeLlamada(float tiempoDeLlamada) {
        this.tiempoDeLlamada = tiempoDeLlamada;
    }

    public ArrayList<Llamada> getLlamadasAtendidasPorTrabajador() {
        return llamadasAtendidasPorTrabajador;
    }

    public void setLlamadasAtendidasPorTrabajador(ArrayList<Llamada> llamadasAtendidasPorTrabajador) {
        this.llamadasAtendidasPorTrabajador = llamadasAtendidasPorTrabajador;
    }

    public int cantidadLlamadasAtendidasPorTrabajador() {
        return llamadasAtendidasPorTrabajador.size();
    }

    public Llamada getLlamadaActual() {
        return llamadaActual;
    }

    public void setLlamadaActual(Llamada llamadaActual) {
        this.llamadaActual = llamadaActual;
    }
    
    public void aumentarCantidadLlamadasDelTrabajador(Llamada unaLlamada){
        llamadasAtendidasPorTrabajador.add(unaLlamada);
    }
    
    
    @Override
    public String toString() {
        return String.valueOf(numero);
    }

}
