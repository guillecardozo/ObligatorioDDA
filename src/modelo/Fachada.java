package modelo;

import java.util.ArrayList;
import observador.Observable;

public class Fachada extends Observable {

    private ControlCliente controlCliente = new ControlCliente();
    private ControlSector controlSector = new ControlSector();
    private Sector sector = new Sector();

    //Singleton
    private static Fachada instancia = new Fachada();

    public static Fachada getInstancia() {
        return instancia;
    }

    private Fachada() {
    }

    //Eventos para Observadores
    public enum eventos {
        seAgregoLlamada, finalizoLlamada, seActualizoListaDeEspera, actualizarSimulador
    };

    public boolean agregarCliente(Cliente cliente) {
        return controlCliente.agregarCliente(cliente);
    }

    public boolean agregarTrabajador(Trabajador trabajador) {
        return sector.agregarTrabajador(trabajador);
    }

    public boolean agregarSector(Sector sector) {
        return controlSector.agregarSector(sector);
    }

    public boolean agregarTipo(TipoCliente tipo) {
        return controlCliente.agregarTipo(tipo);
    }

    public boolean agregarPuesto(Puesto puesto) {
        return sector.agregarPuesto(puesto);
    }

    public ArrayList<Sector> getSectores() {
        return controlSector.getSectores();
    }

    public ArrayList<Llamada> getLlamadasTotales() {
        return sector.getLlamadasAtendidas();
    }

    public ArrayList<Llamada> llamadasAtendidasPorSector(Sector unSector) {
        return sector.detallesLlamadaAtendida(unSector);
    }

    public ArrayList<Llamada> getLlamadasEnEspera() {
        return sector.getLlamadasEnEspera();
    }

    public ArrayList<Cliente> getClientes() {
        return controlCliente.getClientes();
    }
    
    public ArrayList<Llamada> llamadasAtendidasPorTrabajador(Puesto unPuesto){
        return sector.llamadasAtendidasPorTrabajador(unPuesto);
    }

    public Trabajador login(String cedula, String pwd) throws TelefoniaException {
        return sector.login(cedula, pwd);
    }

    public boolean asignarPuesto(Trabajador t) throws TelefoniaException {
        return sector.asignarPuestoLibre(t);
    }

    public float esperaEstimada(){
        return sector.esperaEstimada();
    }

    public float tiempoLlamada(Llamada unaLlamada) {
        return sector.tiempoLlamada(unaLlamada);
    }

    public float tiempoEnEspera(Llamada unaLlamada) {
        return sector.tiempoEnEspera(unaLlamada);
    }

    public Llamada iniciarLlamada(Cliente unCliente, Sector unSector) {
        return sector.iniciarLlamada(unCliente, unSector);
    }

    public boolean finalizarLlamada(Llamada llamadaEnCurso) {
        return sector.finalizarLlamada(llamadaEnCurso);
    }

    public boolean validarCantidadLlamadasEnEspera() {
        return sector.validarCantidadLlamadasEnEspera();
    }
    
    public boolean validarCantidadLlamadasEnCurso() {
        return sector.validarCantidadLlamadasEnCurso();
    }

    public Sector buscarSector(int numEntero) {
        return controlSector.buscarSector(numEntero);
    }

    public Cliente obtenerCliente(String cedulaDigitada) {
        return controlCliente.obtenerCliente(cedulaDigitada);
    }

    public boolean hayTrabajadoresLogueados(Sector unSector) {
        return sector.hayTrabajadoresLogueados(unSector);
    }

    public int cantidadLlamadasEnEspera() {
        return sector.cantidadLlamadasEnEspera();
    }

    public Llamada obtenerLlamadaEnEspera() {
        return sector.obtenerLlamadaEnEspera();
    }

    public boolean salir(Trabajador unTrabajador) {
        return sector.salir(unTrabajador);
    }
    
    public void quitarPuestoOcupado(Puesto unPuesto){
        sector.quitarPuestoOcupado(unPuesto);
    }
    
    public void logout(Trabajador unTrabajador){
        sector.logout(unTrabajador);
    }
}
