/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package controlador;

import modelo.Llamada;
import modelo.Puesto;

/**
 *
 * @author Guille
 */
public interface IvistaSimularLlamada {

    public void mostrarError();

    public void digitarCedula();

    public void cedulaYaDigitada();

    public void errorClienteNoExiste();

    public void digitarSector();

    public void mensajeSectorNoDisponible();

    public void mostrarMensajeLlamadaEnEspera(Puesto puesto);

    public void mostrarMensajeLlamadaEnCurso(Llamada unaLlamada);

    public void mostrarErrorSectorNoValido();

    public void mostrarDetallesLlamadaFinalizada(Llamada llamadaEnCurso);

    public void mostrarMensajeLlamadaFinalizada();

    public String obtenerCedulaDigitada();

    public void mostrarDialogo();

    public void cerrarVentana();

    public void mostrarDialogoConfirmacion();

}
