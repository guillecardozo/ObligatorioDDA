package modelo;

public class Trabajador {

    private String cedula;
    private String nombreCompleto;
    private String password;
    private Sector sector;
    private Puesto puesto;
    private boolean logueado;
    private boolean disponible;

    public Trabajador(String cedula, String nombreCompleto, String password, Sector sector, Puesto puesto, boolean logueado, boolean disponible) {
        this.cedula = cedula;
        this.nombreCompleto = nombreCompleto;
        this.password = password;
        this.sector = sector;
        this.puesto = puesto;
        this.logueado = logueado;
        this.disponible = disponible;
    }

    public String getCedula() {
        return cedula;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public String getPassword() {
        return password;
    }

    public boolean getLogueado() {
        return logueado;
    }

    public void setLogueado(boolean logueado) {
        this.logueado = logueado;
    }

    public Sector getSector() {
        return sector;
    }

    public Puesto getPuesto() {
        return puesto;
    }

    public void setPuesto(Puesto puesto) {
        this.puesto = puesto;
    }

    public boolean getDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    @Override
    public String toString() {
        return nombreCompleto;
    }

    public String hayPuesto() {
        if (puesto == null) {
            return "Sin asignar";
        }
        return puesto.toString();
    }
}
