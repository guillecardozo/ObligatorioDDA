package modelo;

import java.util.ArrayList;
import java.util.Date;
import observador.Observable;

public class Sector extends Observable {

    private String nombre;
    private int numero;

    private ArrayList<Llamada> llamadasAtendidas = new ArrayList();
    private ArrayList<Llamada> llamadasEnEspera = new ArrayList();
    private ArrayList<Puesto> puestosLibres = new ArrayList();
    private ArrayList<Puesto> puestosOcupados = new ArrayList();
    private ArrayList<Trabajador> trabajadores = new ArrayList();
    private int cantidadPuestos;

    public Sector(String nombre, int numero, int cantidadPuestos) {
        this.nombre = nombre;
        this.numero = numero;
        this.cantidadPuestos = cantidadPuestos;
    }

    public Sector() {

    }

    public String getNombre() {
        return nombre;
    }

    public int getNumero() {
        return numero;
    }

    public int getCantidadPuestos() {
        return cantidadPuestos;
    }

    public ArrayList<Llamada> getLlamadasAtendidas() {
        return llamadasAtendidas;
    }

    public ArrayList<Llamada> getLlamadasEnEspera() {
        return llamadasEnEspera;
    }

    public ArrayList<Puesto> getPuestosLibres() {
        return puestosLibres;
    }

    public ArrayList<Puesto> getPuestosOcupados() {
        return puestosOcupados;
    }

    public void setPuestosOcupados(ArrayList<Puesto> puestosOcupados) {
        this.puestosOcupados = puestosOcupados;
    }

    public ArrayList<Trabajador> getTrabajadores() {
        return trabajadores;
    }

    public ArrayList<Llamada> llamadasAtendidasPorTrabajador(Puesto puesto) {
        ArrayList<Llamada> vacio = new ArrayList();
        for (Puesto unPuesto : puestosOcupados) {
            if (puesto.equals(unPuesto)) {
                return unPuesto.getLlamadasAtendidasPorTrabajador();
            }
        }
        return vacio;
    }

    public boolean agregarPuesto(Puesto puesto) {
        return puestosLibres.add(puesto);
    }

    public boolean agregarTrabajador(Trabajador trabajador) {
        return trabajadores.add(trabajador);
    }

    public Trabajador login(String cedula, String pwd) throws TelefoniaException {
        for (Trabajador unTrabajador : trabajadores) {
            if (unTrabajador.getCedula().equals(cedula) && unTrabajador.getPassword().equals(pwd) && !unTrabajador.getLogueado()) {
                unTrabajador.setLogueado(true);
                unTrabajador.setDisponible(true);

                return unTrabajador;
            }
        }
        throw new TelefoniaException("Acceso denegado");
    }

    public boolean asignarPuestoLibre(Trabajador unT) throws TelefoniaException {
        for (Puesto unPuesto : puestosLibres) {
            if (unPuesto.getEstaLibre()) {
                puestosLibres.remove(unPuesto);
                puestosOcupados.add(unPuesto);
                unT.setPuesto(unPuesto);
                unPuesto.setTrabajador(unT);
                return true;
            }
        }
        throw new TelefoniaException("Sector no disponible");
    }

    private Puesto asignarPuestoLibreALlamada() {
        for (Puesto unPuesto : puestosLibres) {
            if (unPuesto.getEstaLibre()) {
                puestosLibres.remove(unPuesto);
                puestosOcupados.add(unPuesto);
                return unPuesto;
            }
        }
        return null;
    }

    public boolean asignarLlamadaEnEspera(Sector unSector) {
        Puesto unPuesto = asignarPuestoLibreALlamada();
        if (llamadasEnEspera != null) {
            for (Llamada unaLlamada : llamadasEnEspera) {
                if (unaLlamada.getSector().equals(unSector)) {
                    unaLlamada.setPuesto(unPuesto);
                    llamadasEnEspera.remove(unaLlamada);
                    Fachada.getInstancia().avisar(Fachada.eventos.seActualizoListaDeEspera);
                    llamadasAtendidas.add(unaLlamada);
                    Fachada.getInstancia().avisar(Fachada.eventos.seAgregoLlamada);
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return nombre;
    }

    public ArrayList<Llamada> detallesLlamadaAtendida(Sector unSector) {
        ArrayList<Llamada> resultado = new ArrayList();
        for (Llamada unaLlamada : this.getLlamadasAtendidas()) {
            if (unaLlamada.getSector().equals(unSector)) {
                resultado.add(unaLlamada);
            }
        }
        return resultado;
    }

    public Llamada iniciarLlamada(Cliente unCliente, Sector unSector) {
        Llamada unaLlamada = new Llamada();
        if (llamadasAtendidas.size() >= DatosDePrueba.cantidadMaxLlamadas && llamadasEnEspera.size() < DatosDePrueba.cantidadMaxLlamadas) {
            llamadasEnEspera.add(unaLlamada);
        } else if (llamadasAtendidas.size() >= DatosDePrueba.cantidadMaxLlamadas && llamadasEnEspera.size() >= DatosDePrueba.cantidadMaxLlamadas) {
            return null;
        } else {
            unaLlamada.setFechaHoraInicio(new Date());
            unaLlamada.setCliente(unCliente);
            unaLlamada.setSector(unSector);
            unaLlamada.setCliente(unCliente);
            unaLlamada.setTrabajador(asignarTrabajador(unSector,unaLlamada));
        }
        return unaLlamada;
    }

    public boolean validarCantidadLlamadasEnEspera() {
        return llamadasEnEspera.size() < DatosDePrueba.cantidadMaxLlamadas;
    }

    public boolean validarCantidadLlamadasEnCurso() {
        return llamadasAtendidas.size() < DatosDePrueba.cantidadMaxLlamadas;
    }

    ArrayList<Trabajador> trabajadoresLogueados = new ArrayList();

    public boolean hayTrabajadoresLogueados(Sector unSector) {
        for (Trabajador unTrabajador : trabajadores) {
            if (unTrabajador.getLogueado() && unTrabajador.getSector().equals(unSector)) {
                trabajadoresLogueados.add(unTrabajador);
                return true;
            }
        }
        return false;
    }

    private Trabajador asignarTrabajador(Sector unSector,Llamada unaLlamada) {
        for (Trabajador unTrabajador : trabajadoresLogueados) {
            if (unTrabajador.getSector().equals(unSector) && unTrabajador.getDisponible() && unTrabajador.getLogueado()) {
                unaLlamada.setTrabajador(unTrabajador);
                unaLlamada.setFechaHoraAtendida(new Date());
                unTrabajador.setDisponible(false);
                unaLlamada.setPuesto(unTrabajador.getPuesto());
                unaLlamada.setEstado(true);
                unTrabajador.getPuesto().setLlamadaActual(unaLlamada);
                llamadasAtendidas.add(unaLlamada);
                unTrabajador.getPuesto().aumentarCantidadLlamadasDelTrabajador(unaLlamada);
                Fachada.getInstancia().avisar(Fachada.eventos.seAgregoLlamada);
                return unTrabajador;
            }
        }
        if(unaLlamada.getSector().equals(unSector) && unaLlamada.getTrabajador() == null){
            llamadasEnEspera.add(unaLlamada);
        }
        return null;
    }

    public int cantidadLlamadasEnEspera() {
        return llamadasEnEspera.size();
    }

    public int cantidadLlamadasAtendidas() {
        return llamadasAtendidas.size();
    }

    public float promedioDeTiempoPorPuesto() {
        float promedio = 0;
        float totalSegundos = 0;
        if (!llamadasAtendidas.isEmpty()) {
            for (Llamada llamada : llamadasAtendidas) {
                totalSegundos += llamada.tiempoLlamada();
            }
            promedio = totalSegundos / cantidadLlamadasAtendidas();
        }
        return promedio;
    }
    
    public float tiempoPromedioPorSector(){
        float promedio = 0;
        float totalSegundos = 0;
        for (Llamada llamada : llamadasEnEspera) {
            totalSegundos += llamada.tiempoDeEsperaDelSector(llamada.getFechaHoraInicio(), new Date());
        }
        promedio = totalSegundos / llamadasAtendidas.size();
        return promedio;
    }

    public float esperaEstimada(){
        float esperaEstimada = tiempoPromedioPorSector() * llamadasEnEspera.size();
        return esperaEstimada;
    }

    public boolean finalizarLlamada(Llamada llamadaEnCurso) {
        if (llamadaEnCurso != null) {
            if (llamadaEnCurso.getEstado()) {
                llamadaEnCurso.setFechaHoraFin(new Date());
                llamadaEnCurso.setEstado(false);
                if (llamadaEnCurso.getTrabajador() != null || llamadaEnCurso.getTrabajador().getPuesto() != null) {//Controla que la llamada era en curso
                    asignarCosto(llamadaEnCurso);
                    asignarSaldo(llamadaEnCurso);
                    llamadaEnCurso.getTrabajador().setDisponible(true);
                    llamadaEnCurso.getTrabajador().getPuesto().setTiempoDeLlamada(promedioDeTiempoPorPuesto());
                    llamadaEnCurso.getPuesto().setLlamadaActual(null);
                    llamadaEnCurso.setPuesto(null);
                    puestosLibres.add(llamadaEnCurso.getPuesto());
                    puestosOcupados.remove(llamadaEnCurso.getPuesto());
                }
                Fachada.getInstancia().avisar(Fachada.eventos.finalizoLlamada);
                return true;
            }
            llamadasEnEspera.remove(llamadaEnCurso);
            Fachada.getInstancia().avisar(Fachada.eventos.seActualizoListaDeEspera);
            return false;
        }
        return false;
    }

    private void asignarSaldo(Llamada unaLlamada) {
        float saldoAcumulado = unaLlamada.getCliente().getSaldo() + (unaLlamada.getCliente().getTipo().costo(unaLlamada) * -1);
        unaLlamada.getCliente().setSaldo(saldoAcumulado);
    }

    private void asignarCosto(Llamada unaLlamada) {
        if (unaLlamada.getCliente().getTipo().costo(unaLlamada) < 0) {
            unaLlamada.setCosto(0);
        } else {
            unaLlamada.setCosto(unaLlamada.getCliente().getTipo().costo(unaLlamada));
        }
    }

    public float tiempoEnEspera(Llamada llamada) {
        for (Llamada unaLlamada : llamadasEnEspera) {
            if (llamada.equals(unaLlamada)) {
                return unaLlamada.tiempoEnEspera();
            }
        }
        return 0;
    }

    public float tiempoLlamada(Llamada llamada) {
        for (Llamada unaLlamada : llamadasAtendidas) {
            if (llamada.equals(unaLlamada)) {
                return unaLlamada.tiempoLlamada();
            }
        }
        return 0;
    }

    public Llamada obtenerLlamadaEnEspera() {
        if (!llamadasEnEspera.isEmpty()) {
            for (Llamada unaLlamada : llamadasEnEspera) {
                llamadasEnEspera.remove(unaLlamada);
                Fachada.getInstancia().avisar(Fachada.eventos.seActualizoListaDeEspera);
                unaLlamada.setTrabajador(asignarTrabajador(unaLlamada.getSector(),unaLlamada));
                return unaLlamada;
            }
        }
        return null;
    }

    public boolean salir(Trabajador unTrabajador) {
        unTrabajador.getPuesto().getLlamadaActual().setFechaHoraFin(new Date());
        unTrabajador.getPuesto().getLlamadaActual().setEstado(false);
        unTrabajador.getPuesto().setLlamadaActual(null);
        unTrabajador.setPuesto(null);
        unTrabajador.setDisponible(false);
        unTrabajador.setLogueado(false);
        puestosLibres.add(unTrabajador.getPuesto());
        puestosOcupados.remove(unTrabajador.getPuesto());
        trabajadoresLogueados.remove(unTrabajador);
        Fachada.getInstancia().avisar(Fachada.eventos.finalizoLlamada);
        return true;
    }
    
    public void quitarPuestoOcupado(Puesto unPuesto) {
        for (Puesto puesto : puestosOcupados) {
            if (puesto.equals(unPuesto)) {
                puestosOcupados.remove(unPuesto);
                puestosLibres.add(unPuesto);
                break;
            }
        }
    }
    
    public void logout(Trabajador unTrabajador){
        unTrabajador.setLogueado(false);
    }

    

}
