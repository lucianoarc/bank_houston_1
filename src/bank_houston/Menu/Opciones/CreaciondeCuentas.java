
package bank_houston.Menu.Opciones;

import Personas.Clientes;
import Personas.Clientes.compartirdatos;
import Tarjetas.CuentaBancaria;
import Tarjetas.Cuentas.CuentaAhorro;
import Tarjetas.Cuentas.CuentaCorriente;
import Tarjetas.Cuentas.CuentaInversiones;
import bank_houston.Menu.Menu;
import java.util.ArrayList;
import java.util.Scanner;


public class CreaciondeCuentas {
    
 static ArrayList<CuentaBancaria> Cuentaslist = new ArrayList<>();
    
    
public static void Creacion_de_cuentas(Scanner Teclado) {
    int opciones = 0;
    do{
    System.out.println(" Que tipo de cuenta necesitas ");
    System.out.println("1.- Cuenta corriente");
    System.out.println("2.- Cuenta de ahorro");
    System.out.println("3.- Cuenta Inversiones");
    System.out.println("4.- Volver al inicio");
    opciones = Teclado.nextInt();
    System.out.println("");
    switch (opciones) {
        case 1:
            crearCuenta(Teclado, "corriente");
            break;
        case 2:
            crearCuenta(Teclado, "ahorro");
            break;
        case 3:
            crearCuenta(Teclado, "Inversiones");
            break;
        case 4:
            Menu.Menu();
            break;
        default:
            System.out.println("!!Opcion invalida!!");
            break;
    }
} while(opciones<1||opciones>4);
}
public static void crearCuenta(Scanner Teclado, String tipoCuenta) {
    System.out.println("Ingrese su RUT:");
    String rutCliente = Teclado.next();
    Teclado.nextLine();

    Clientes clienteAsociado = null;
    // Buscar el cliente correspondiente en la lista de clientes
    for (Clientes cliente : compartirdatos.clientesList) {
        if (cliente.getRut().equals(rutCliente)) {
            clienteAsociado = cliente;
            break;
        }
    }

    if (clienteAsociado != null) {
        
        CuentaBancaria nuevaCuenta = null;
        switch (tipoCuenta) {
            case "corriente":
                nuevaCuenta = new CuentaCorriente(0, 0);
                break;
            case "ahorro":
                nuevaCuenta = new CuentaAhorro(0, 0);
                break;
            case "Inversiones":
                nuevaCuenta = new CuentaInversiones(0, 0);
                break;
            default:
                System.out.println("Tipo de cuenta invalido");
                break;
        }

        if (nuevaCuenta != null) {
            nuevaCuenta.generarNumeroCuenta();
            Cuentaslist.add(nuevaCuenta);
            clienteAsociado.agregarCuenta(nuevaCuenta);
            System.out.println("Cuenta creada exitosamente para el cliente con RUT: " + rutCliente);
        }
    } else {
        System.out.println("Cliente con RUT " + rutCliente + " no encontrado.");
    }

    System.out.println("");
    Menu.Menu();
}
}
