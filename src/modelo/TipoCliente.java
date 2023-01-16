
package modelo;


public abstract class TipoCliente {
    private String tipo;

    public TipoCliente(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public abstract float costo(Llamada unaLlamada);
}
