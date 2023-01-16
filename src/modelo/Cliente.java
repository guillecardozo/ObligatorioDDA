
package modelo;

public class Cliente {
    private float saldo;
    private String cedula;
    private String nombreCompleto;
    private TipoCliente tipo;

    public Cliente(float saldo, String cedula, String nombreCompleto, TipoCliente unTipo) {
        this.saldo = saldo;
        this.cedula = cedula;
        this.nombreCompleto = nombreCompleto;
        this.tipo = unTipo;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public String getCedula() {
        return cedula;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public TipoCliente getTipo() {
        return tipo;
    }

    @Override
    public String toString() {
        return nombreCompleto;
    }
    
}
