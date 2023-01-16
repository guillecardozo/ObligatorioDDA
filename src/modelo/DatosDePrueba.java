package modelo;

public class DatosDePrueba {

    public static float costoFijoLlamada = 1;
    public static int cantidadMaxLlamadas = 5;

    public static void cargar() {

        Fachada logica = Fachada.getInstancia();

        /**
         * * TIPO CLIENTES **
         */
        Exonerado exonerado = new Exonerado("Exonerado");
        ConCosto conCosto = new ConCosto("Con Costo");
        Gestor gestor = new Gestor("Gestor");

        logica.agregarTipo(exonerado);
        logica.agregarTipo(conCosto);
        logica.agregarTipo(gestor);

        /**
         * * CLIENTES **
         */
        Cliente guillermo = new Cliente(0, "47050208", "Guillermo Cardozo", exonerado);
        Cliente juan = new Cliente(0, "53339857", "Juan Pablo Gagliardi", conCosto);
        Cliente lucas = new Cliente(0, "39687895", "Lucas Rodriguez", gestor);
        Cliente prueba = new Cliente(0, "1", "Prueba", gestor);

        logica.agregarCliente(guillermo);
        logica.agregarCliente(juan);
        logica.agregarCliente(lucas);
        logica.agregarCliente(prueba);

        /**
         * * SECTORES **
         */
        Sector ventas = new Sector("Ventas", 1, 5);
        Sector atencionAlCliente = new Sector("Atencion al cliente", 2, 5);
        Sector recursosHumanos = new Sector("Recursos Humanos", 3, 5);

        logica.agregarSector(ventas);
        logica.agregarSector(atencionAlCliente);
        logica.agregarSector(recursosHumanos);

        /**
         * * PUESTOS **
         */
        Puesto puesto1 = new Puesto(1, true, null, 0, 0, null);
        Puesto puesto2 = new Puesto(2, true, null, 0, 0, null);
        Puesto puesto3 = new Puesto(3, true, null, 0, 0, null);
        Puesto puesto4 = new Puesto(4, true, null, 0, 0, null);
        Puesto puesto5 = new Puesto(5, true, null, 0, 0, null);
        Puesto puesto6 = new Puesto(6, true, null, 0, 0, null);
        Puesto puesto7 = new Puesto(7, true, null, 0, 0, null);
        Puesto puesto8 = new Puesto(8, true, null, 0, 0, null);
        Puesto puesto9 = new Puesto(9, true, null, 0, 0, null);
        Puesto puesto10 = new Puesto(10, true, null, 0, 0, null);
        Puesto puesto11 = new Puesto(11, true, null, 0, 0, null);
        Puesto puesto12 = new Puesto(12, true, null, 0, 0, null);
        Puesto puesto13 = new Puesto(13, true, null, 0, 0, null);
        Puesto puesto14 = new Puesto(14, true, null, 0, 0, null);
        Puesto puesto15 = new Puesto(15, true, null, 0, 0, null);

        Puesto puesto16 = new Puesto(16, true, null, 0, 0, null);

        logica.agregarPuesto(puesto1);
        logica.agregarPuesto(puesto2);
        logica.agregarPuesto(puesto3);
        logica.agregarPuesto(puesto4);
        logica.agregarPuesto(puesto5);
        logica.agregarPuesto(puesto6);
        logica.agregarPuesto(puesto7);
        logica.agregarPuesto(puesto8);
        logica.agregarPuesto(puesto9);
        logica.agregarPuesto(puesto10);
        logica.agregarPuesto(puesto11);
        logica.agregarPuesto(puesto12);
        logica.agregarPuesto(puesto13);
        logica.agregarPuesto(puesto14);
        logica.agregarPuesto(puesto15);

        logica.agregarPuesto(puesto16);

        /**
         * * TRABAJADORES **
         */
        Trabajador bentancur = new Trabajador("39875201", "Rodrigo Bentancur", "Rodri123", ventas, null, false, true);
        Trabajador deLaCruz = new Trabajador("98547982", "Nicolas De la Cruz", "Nico123", ventas, null, false, true);
        Trabajador valverde = new Trabajador("69552287", "Federico Valverde", "Fede123", ventas, null, false, true);
        Trabajador suarez = new Trabajador("39855338", "Luis Suarez", "Lucho123", ventas, null, false, true);
        Trabajador cavani = new Trabajador("47799662", "Edinson Cavani", "Edi123", ventas, null, false, true);

        Trabajador darwin = new Trabajador("59876302", "Darwin Nunez", "Darwin123", atencionAlCliente, null, false, true);
        Trabajador torres = new Trabajador("66998877", "Facundo Torres", "Facu123", atencionAlCliente, null, false, true);
        Trabajador deArrascaeta = new Trabajador("35554210", "Giorgian De Arrascaeta", "Gio123", atencionAlCliente, null, false, true);
        Trabajador rochet = new Trabajador("99663355", "Sergio Rochet", "Chino123", atencionAlCliente, null, false, true);
        Trabajador araujo = new Trabajador("66883246", "Ronald Araujo", "Ron123", atencionAlCliente, null, false, true);

        Trabajador olivera = new Trabajador("80569855", "Matias Olivera", "Mati123123", recursosHumanos, null, false, true);
        Trabajador coates = new Trabajador("63332291", "Sebastian Coates", "Seba123", recursosHumanos, null, false, true);
        Trabajador muslera = new Trabajador("45599999", "Fernando Muslera", "Nando123", recursosHumanos, null, false, true);
        Trabajador varela = new Trabajador("32365989", "Guillermo Varela", "Guille123", recursosHumanos, null, false, true);
        Trabajador godin = new Trabajador("48777993", "Diego Godin", "Diego123", recursosHumanos, null, false, true);

        Trabajador a = new Trabajador("a", "Prueba", "a", recursosHumanos, null, false, true);

        logica.agregarTrabajador(bentancur);
        logica.agregarTrabajador(deLaCruz);
        logica.agregarTrabajador(valverde);
        logica.agregarTrabajador(suarez);
        logica.agregarTrabajador(cavani);
        logica.agregarTrabajador(darwin);
        logica.agregarTrabajador(torres);
        logica.agregarTrabajador(deArrascaeta);
        logica.agregarTrabajador(rochet);
        logica.agregarTrabajador(araujo);
        logica.agregarTrabajador(olivera);
        logica.agregarTrabajador(coates);
        logica.agregarTrabajador(muslera);
        logica.agregarTrabajador(varela);
        logica.agregarTrabajador(godin);

        logica.agregarTrabajador(a);

    }

}
