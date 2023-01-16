
package modelo;


public class ConCosto extends TipoCliente {

    public ConCosto(String tipo) {
        super(tipo);
    }

    @Override
    public float costo(Llamada unaLlamada) {
        float resultado;
        float tiempoEnEspera = Fachada.getInstancia().tiempoEnEspera(unaLlamada);
        if (tiempoEnEspera < 60) {
            resultado = DatosDePrueba.costoFijoLlamada;
        } else {
            resultado = DatosDePrueba.costoFijoLlamada / 2;
        }
        return resultado;
    }

}
