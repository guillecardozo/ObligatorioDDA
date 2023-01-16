/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import modelo.Fachada;
import modelo.Llamada;
import modelo.Trabajador;
import observador.Observable;
import observador.Observador;

public class controladorAtenderLlamada implements Observador {

    private IvistaAtenderLlamadas vista;
    private Fachada modelo = Fachada.getInstancia();
    private Trabajador trabajador;
    private Llamada llamada;

    public controladorAtenderLlamada(IvistaAtenderLlamadas vista, Trabajador trabajador) {
        this.trabajador = trabajador;
        this.vista = vista;
        mostrarDetalles(trabajador);
        modelo.agregarObservador(this);
    }

    public void salir() {
        if (llamada != null) {
            vista.mostrarDialogo();
        }else{
            vista.mostrarDialogoDeConfirmacion();
            desloguear();
        }
    }

    public void salirYAvisar() {
        modelo.salir(trabajador);
    }

    public void desloguear() {
        modelo.logout(trabajador);
        modelo.quitarPuestoOcupado(trabajador.getPuesto());
    }

    public void finalizarLlamada() {
        if (llamada != null) {
            vista.agregarDescripcion(llamada);
            modelo.finalizarLlamada(llamada);
        }
    }

    
    private void mostrarDetalles(Trabajador unTrabajador) {
        vista.mostrarDetalles(unTrabajador);
        if (unTrabajador.getPuesto() != null) {
            vista.mostrarDetallesTrabajadorConPuesto(unTrabajador);
            Llamada llamadaActual = unTrabajador.getPuesto().getLlamadaActual();
            llamada = llamadaActual;
            if (llamadaActual != null) {
                vista.mostrarLlamadaEnCurso(llamadaActual);
            } else {
                if (modelo.cantidadLlamadasEnEspera() > 0) {
                    llamadaActual = modelo.obtenerLlamadaEnEspera();
                    llamada = llamadaActual;
                    if (llamadaActual.getTrabajador() != null) {
                        vista.mostrarLlamadaEnCurso(llamadaActual);
                        modelo.avisar(Fachada.eventos.actualizarSimulador);
                    }
                } else {
                    if (!modelo.llamadasAtendidasPorTrabajador(unTrabajador.getPuesto()).isEmpty()) {//Validacion para que cuando se abra la ventana de atender
                        vista.finalizarLlamada();                                                    //llamadas por primera vez, no aparezca "Llamada finalizada"
                    }
                }
            }
        }
    }
    
    @Override
    public void actualizar(Object evento, Observable origen
    ) {
        if (evento.equals(Fachada.eventos.seAgregoLlamada) || evento.equals(Fachada.eventos.finalizoLlamada)) {
            mostrarDetalles(trabajador);
        }
    }

}
