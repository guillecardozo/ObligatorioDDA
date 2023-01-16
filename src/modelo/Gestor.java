
package modelo;


public class Gestor extends TipoCliente {

    public Gestor(String tipo) {
        super(tipo);
    }

    @Override
    public float costo(Llamada unaLlamada) {
        float tiempoEnCurso = Fachada.getInstancia().tiempoLlamada(unaLlamada);
        float resultado = (tiempoEnCurso*DatosDePrueba.costoFijoLlamada) / 2;
        if (tiempoEnCurso > 180) {
            resultado = resultado + tiempoEnCurso;
        } else {
            resultado =  (tiempoEnCurso  / 2) - 1;
        }
        return resultado;
    }
}

