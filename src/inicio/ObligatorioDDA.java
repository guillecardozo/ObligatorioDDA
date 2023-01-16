
package inicio;

import vistaEscritorio.AplicacionTesting;
import modelo.DatosDePrueba;


public class ObligatorioDDA {

    public static void main(String[] args) throws Exception {
        DatosDePrueba.cargar();
        new AplicacionTesting().setVisible(true);
    }
    
}
