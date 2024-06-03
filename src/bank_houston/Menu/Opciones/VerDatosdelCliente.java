
package bank_houston.Menu.Opciones;

import Personas.Clientes;
import Personas.Clientes.compartirdatos;
import bank_houston.Menu.Menu;
import java.util.Scanner;




public class VerDatosdelCliente {
public static void Ver_Datos_Del_Cliente(Scanner Teclado) {
        System.out.println("Ingrese el RUT del cliente:");
        String rutBusqueda = Teclado.next();
        boolean encontrado = false;

        for (Clientes cliente : compartirdatos.clientesList) {
            if (cliente.getRut().equals(rutBusqueda)) {
                encontrado = true;
                System.out.println("Datos del cliente:");
                cliente.mostrarInformacionCliente();
                break;
            }
        }

        if (!encontrado) {
            System.out.println("Cliente no encontrado.");
        }

        System.out.println("");
        Menu.Menu();
    }
}

