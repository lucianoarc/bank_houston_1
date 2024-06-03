
package bank_houston.Menu.Opciones;

import Personas.Clientes;
import Personas.Clientes.compartirdatos;
import Tarjetas.CuentaBancaria;
import bank_houston.Menu.Menu;
import java.util.ArrayList;
import java.util.Scanner;


public class Depositar {
   
    public static void Deposita(Scanner Teclado) {
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
            System.out.println("Seleccione la cuenta a la que desea depositar:");
            int seleccion = Teclado.nextInt();
            if (seleccion > 0 && seleccion <= cuentasCliente.size()) {
                CuentaBancaria cuentaSeleccionada = cuentasCliente.get(seleccion - 1);
                boolean montoValido = false;
                while (!montoValido) {
                    System.out.println("Ingrese el monto a depositar (o presione 0 para depositar el monto predeterminado(10.000)):");
                    int monto = Teclado.nextInt();
                    if (monto < 0) {
                        System.out.println("El monto ingresado no es valido. Por favor, ingrese un monto positivo.");
                    } else {
                        if (monto == 0) {
                            cuentaSeleccionada.depositar();
                        } else {
                            cuentaSeleccionada.depositar(monto);
                        }
                        montoValido = true;
                        System.out.println("Monto depositado exitosamente. Nuevo saldo: " + cuentaSeleccionada.getSaldo());
                    }
                }
            } else {
                System.out.println("Seleccion inválida.");
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
