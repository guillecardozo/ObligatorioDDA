/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package controlador;

import modelo.Llamada;
import modelo.Trabajador;

/**
 *
 * @author Guille
 */
public interface IvistaAtenderLlamadas {
    void mostrarDetalles(Trabajador unTrabajador);
    void finalizarLlamada();
    void mostrarDetallesTrabajadorConPuesto(Trabajador unTrabajador);

    public void mostrarLlamadaEnCurso(Llamada llamadaActual);

    public void agregarDescripcion(Llamada llamada);

    public void mostrarDialogo();

    public void cerrarVentana();

    public void mostrarDialogoDeConfirmacion();

}
