
package modelo;


public class Exonerado extends TipoCliente {

    public Exonerado(String tipo) {
        super(tipo);
    }

    @Override
    public float costo(Llamada unaLlamada) {
        return 0;
    }
    
}
