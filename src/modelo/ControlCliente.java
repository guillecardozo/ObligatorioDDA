
package modelo;

import java.util.ArrayList;

public class ControlCliente {
    private ArrayList<Cliente> clientes = new ArrayList();
    private ArrayList<TipoCliente> tipos = new ArrayList();
    
    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public ArrayList<TipoCliente> getTipos() {
        return tipos;
    }
    
    public boolean agregarCliente(Cliente cliente) {
        return clientes.add(cliente);
    }
    
    public boolean agregarTipo(TipoCliente tipo){
        return tipos.add(tipo);
    }
    
    public Cliente obtenerCliente(String cedulaDigitada){
        for (Cliente unCliente : clientes) {
            if(unCliente.getCedula().equals(cedulaDigitada)){
                return unCliente;
            }
        }
        return null;
    } 
}


