/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package controlador;

import java.util.ArrayList;
import modelo.Llamada;


public interface IvistaMonitoreo {
    void mostrarEnLista();

    public void mostrarTodosLosSectores(ArrayList<Llamada> todasLasLlamadas);

    public void mostrarSectoresSeleccionados(ArrayList<Llamada> llamadasAtendidasPorSector);

    public void seleccionarSector();
}
