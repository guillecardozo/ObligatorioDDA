/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import modelo.Cliente;
import modelo.Fachada;
import modelo.Llamada;
import modelo.Sector;
import observador.Observable;
import observador.Observador;

public class controladorSimularLlamada implements Observador {

    private IvistaSimularLlamada vista;
    private Fachada modelo = Fachada.getInstancia();
    private Llamada llamadaEnCurso = null;

    public controladorSimularLlamada(IvistaSimularLlamada vista) {
        this.vista = vista;
        modelo.agregarObservador(this);
    }

    public void iniciarLlamada() {
        boolean validoCantidadLlamadasEnEspera = modelo.validarCantidadLlamadasEnEspera();
        boolean validoCantidadLlamadasEnCurso = modelo.validarCantidadLlamadasEnCurso();
        if (!validoCantidadLlamadasEnEspera || !validoCantidadLlamadasEnCurso) {
            vista.mostrarError();
        } else {
            vista.digitarCedula();
        }
    }

    public Cliente existeCliente() {
        Cliente unCliente = Fachada.getInstancia().obtenerCliente(vista.obtenerCedulaDigitada());
        if (unCliente != null) {
            vista.cedulaYaDigitada();
            return unCliente;
        }
        return null;
    }

    public void elegirSector(Cliente unCliente) {
        if (unCliente != null) {
            vista.digitarSector();
        } else {
            vista.errorClienteNoExiste();
        }
    }

    public void llamarASector(String sector) {
        Cliente unCliente = existeCliente();
        int numEntero = Integer.parseInt(sector);
        Sector unSector = Fachada.getInstancia().buscarSector(numEntero);
        if (unSector != null) {
            boolean hayTrabajadorLogueado = Fachada.getInstancia().hayTrabajadoresLogueados(unSector);
            if (!hayTrabajadorLogueado) {
                vista.mensajeSectorNoDisponible();
            } else {
                Llamada unaLlamada = Fachada.getInstancia().iniciarLlamada(unCliente, unSector);
                llamadaEnCurso = unaLlamada;
                if (unaLlamada.getTrabajador() == null) {
                    mostrarDetallesLlamadaEnEspera();
                } else {
                    vista.mostrarMensajeLlamadaEnCurso(unaLlamada);
                }
            }
        } else {
            vista.mostrarErrorSectorNoValido();
        }
    }

    private void mostrarDetallesLlamadaEnEspera() {
        if (llamadaEnCurso.getTrabajador() == null) {//Validacion para que no se actualice el mensaje tambien en la llamada en curso
            vista.mostrarMensajeLlamadaEnEspera(llamadaEnCurso.getPuesto());
        }
    }
    
    public void finalizarLlamada() {
        boolean llamadaFinalizada = Fachada.getInstancia().finalizarLlamada(llamadaEnCurso);
        if (llamadaFinalizada) {
            vista.mostrarDetallesLlamadaFinalizada(llamadaEnCurso);
        } else {
            vista.mostrarMensajeLlamadaFinalizada();
        }
        modelo.quitarObservador(this);
    }
    
    
    public void mostrarMensajeLlamadaEnCurso(Llamada unaLlamada){
        if(unaLlamada.getTrabajador() != null){
            vista.mostrarMensajeLlamadaEnCurso(unaLlamada);
        }
    }
    
    public void salir() {
        if (llamadaEnCurso != null) {
            vista.mostrarDialogo();
        }else{
            vista.mostrarDialogoConfirmacion();
        }
    }
    
    public void salirYAvisar() {
        modelo.finalizarLlamada(llamadaEnCurso);
    }
    
    @Override
    public void actualizar(Object evento, Observable origen) {
        if (evento.equals(Fachada.eventos.seActualizoListaDeEspera)) {
            mostrarDetallesLlamadaEnEspera();
        }
        if (evento.equals(Fachada.eventos.actualizarSimulador)) {
            mostrarMensajeLlamadaEnCurso(llamadaEnCurso);
        }
    }

}
