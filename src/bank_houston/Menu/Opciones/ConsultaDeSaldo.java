
package bank_houston.Menu.Opciones;

import Personas.Clientes;
import Personas.Clientes.compartirdatos;
import Tarjetas.CuentaBancaria;
import bank_houston.Menu.Menu;
import java.util.ArrayList;
import java.util.Scanner;


public class ConsultaDeSaldo {
    
    public static void ConsultarSaldo(Scanner Teclado) {
    System.out.println("Ingrese el RUT del cliente:");
    String rutCliente = Teclado.next();
    Clientes clienteAsociado = null;
    for (Clientes cliente : compartirdatos.clientesList) {
        if (cliente.getRut().equals(rutCliente)) {
            clienteAsociado = cliente;
            break;
        }
    }
    if (clienteAsociado != null) {
        ArrayList<CuentaBancaria> cuentasCliente = clienteAsociado.getCuentas();
        if (!cuentasCliente.isEmpty()) {
            System.out.println("Cuentas asociadas:");
            for (int i = 0; i < cuentasCliente.size(); i++) {
                CuentaBancaria cuenta = cuentasCliente.get(i);
                System.out.println((i + 1) + ". Numero de Cuenta: " + cuenta.getNumero() + " - Saldo: " + cuenta.getSaldo() + " pesos");
            }
            System.out.println("Seleccione la cuenta para consultar el saldo:");
            int seleccion = Teclado.nextInt();
            if (seleccion > 0 && seleccion <= cuentasCliente.size()) {
                CuentaBancaria cuentaSeleccionada = cuentasCliente.get(seleccion - 1);
                System.out.println("Saldo de la cuenta: " + cuentaSeleccionada.getSaldo());
            } else {
                System.out.println("Seleccion invalida.");
            }
        } else {
            System.out.println("El cliente no tiene cuentas asociadas.");
        }
    } else {
        System.out.println("Cliente no encontrado.");
    }
    System.out.println("");
    Menu.Menu();
}
}
