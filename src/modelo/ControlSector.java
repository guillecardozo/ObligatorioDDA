
package modelo;

import java.util.ArrayList;

public class ControlSector {

    private ArrayList<Sector> sectores = new ArrayList();

    public ArrayList<Sector> getSectores() {
        return sectores;
    }

    public boolean agregarSector(Sector sector) {
        return sectores.add(sector);
    }

    public Sector buscarSector(int numEntero) {
        for (Sector unSector : sectores) {
            if(unSector.getNumero() == numEntero){
                return unSector;
            }
        }
        return null;
    }
}
