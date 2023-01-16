/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.util.ArrayList;
import modelo.Fachada;
import modelo.Llamada;
import modelo.Sector;
import observador.Observable;
import observador.Observador;

public class controladorMonitoreo implements Observador {

    private IvistaMonitoreo vista;
    private Fachada modelo = Fachada.getInstancia();
    
    public controladorMonitoreo(IvistaMonitoreo vista) {
        this.vista = vista;
        mostrarEnLista();
        modelo.agregarObservador(this);
    }

    //Eventos del usuario
    public void salir() {
        modelo.quitarObservador(this);
    }

    private void mostrarEnLista() {
        vista.mostrarEnLista();
    }

    public void mostrarEnTabla() {
        vista.seleccionarSector();
    }

    public void seleccion(Sector unSector) {
        ArrayList<Llamada> llamadasAtendidasPorSector = unSector.detallesLlamadaAtendida(unSector);//Fachada.getInstancia().llamadasAtendidasPorSector(unSector);
        ArrayList<Llamada> todasLasLlamadas = Fachada.getInstancia().getLlamadasTotales();
        if (unSector.getNumero() < 4) {
            vista.mostrarSectoresSeleccionados(llamadasAtendidasPorSector);
        } else {
            vista.mostrarTodosLosSectores(todasLasLlamadas);
        }
    }

    @Override
    public void actualizar(Object evento, Observable origen) {
        if (evento.equals(Fachada.eventos.seAgregoLlamada) || evento.equals(Fachada.eventos.finalizoLlamada)) {
            mostrarEnTabla();
        }
    }

}
