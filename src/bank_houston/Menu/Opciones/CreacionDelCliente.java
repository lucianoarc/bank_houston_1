
package bank_houston.Menu.Opciones;

import Personas.Clientes;
import Personas.Clientes.compartirdatos;
import bank_houston.Menu.Menu;
import java.util.ArrayList;
import java.util.Scanner;


public class CreacionDelCliente {
    
    
    public static void Registro_Del_Cliente(Scanner Teclado){                        
                                                                     
        String Rut;
        String Nombre;
        String Apellido;
    
do {
    System.out.println("Ingrese su RUT (EJ: 12.345.678-9)");
    Rut= Teclado.next();
    Teclado.nextLine();

    if (!Clientes.validarRut(Rut)) {                                            
        System.out.println("El RUT ingresado es invalido. Por favor, ingrese un RUT valido.");
        System.out.println("");
    }
} while (!Clientes.validarRut(Rut));

    boolean nombreValido = false;
do {
        System.out.println("Ingrese su Nombre");
        Nombre = Teclado.nextLine();
        nombreValido = Clientes.validarNombre(Nombre);
    if (!nombreValido) {
        System.out.println("El nombre no puede estar vacio. Por favor, intentelo de nuevo.");
        System.out.println("");
    }
} while (!nombreValido);

    boolean apellidoValido = false;

do {
        System.out.println("Ingrese su Apellido ");
        Apellido = Teclado.nextLine();
        apellidoValido = Clientes.validarApellido(Apellido);
    if (!apellidoValido) {
        System.out.println("El apellido no puede estar vacio. Por favor, intentelo de nuevo.");
        System.out.println("");
    }
} while (!apellidoValido);

    Clientes clienteNuevo = new Clientes(Rut, Nombre, Apellido);
    compartirdatos.clientesList.add(clienteNuevo);                                           
    System.out.println("Cliente registrado exitosamente");
    System.out.println("");
    Menu.Menu();
}
}
