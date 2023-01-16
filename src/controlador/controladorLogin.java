/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import modelo.Fachada;
import modelo.TelefoniaException;
import modelo.Trabajador;

public class controladorLogin {
    
    private IvistaLogin vista;

    public controladorLogin(IvistaLogin vista) {
        this.vista = vista;
    }
    
    public void login(String cedula, String pwd){
        try {
            Trabajador unTrabajador = Fachada.getInstancia().login(cedula, pwd);
            boolean asignoPuesto = Fachada.getInstancia().asignarPuesto(unTrabajador);
            if (asignoPuesto) {
                vista.proximoCasoDeUso(unTrabajador);
            }
        } catch (TelefoniaException ex) {
            vista.error(ex.getMessage());
        }
    }
    
}
