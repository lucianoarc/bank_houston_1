
package Personas;

import Tarjetas.CuentaBancaria;
import Tarjetas.Cuentas.CuentaAhorro;
import Tarjetas.Cuentas.CuentaCorriente;
import Tarjetas.Cuentas.CuentaInversiones;
import java.util.ArrayList;

public class Clientes implements InfoClientes{
    private String Rut;    
    private String Nombre;
    private String Apellido;
    private ArrayList<CuentaBancaria> cuentas;

public Clientes(String Rut, String Nombre, String Apellido) {
        this.Rut = Rut;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.cuentas = new ArrayList<>();
    }
 public static boolean validarRut(String Rut) {                                   
         return Rut.matches("\\d{1,2}\\.\\d{3}\\.\\d{3}-[\\dkK]");
    }
       public String getRut() {
        return Rut;
    }
    public void setRut(String Rut) {
       if (validarRut(Rut)) {
       this.Rut = Rut;
       } else {
       throw new IllegalArgumentException("RUT inválido");
        }
    }

    public static boolean validarNombre(String nombre) {                          
    return !nombre.isEmpty();
}
    
    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public static boolean validarApellido(String Apellido) {                    
        return !Apellido.isEmpty();
    }
    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }
    public void agregarCuenta(CuentaBancaria cuenta) {
        this.cuentas.add(cuenta);
    }
    public ArrayList<CuentaBancaria> getCuentas() {
    return this.cuentas;
}

    public class compartirdatos {
    public static ArrayList<Clientes> clientesList = new ArrayList<>();
}
    
     @Override
    public void mostrarInformacionCliente() {
        System.out.println("RUT: " + Rut);
        System.out.println("Nombre: " + Nombre);
        System.out.println("Apellido: " + Apellido);

        if (!cuentas.isEmpty()) {
            System.out.println("Cuentas asociadas:");
            for (CuentaBancaria cuenta : cuentas) {
                System.out.println("--------------------");
                if (cuenta instanceof CuentaCorriente) {
                    System.out.println("Tipo de Cuenta: Cuenta Corriente");
                } else if (cuenta instanceof CuentaAhorro) {
                    System.out.println("Tipo de Cuenta: Cuenta de Ahorro");
                } else if (cuenta instanceof CuentaInversiones) {
                    System.out.println("Tipo de Cuenta: Cuenta de Inversiones");
                }
                System.out.println("Numero de Cuenta: " + cuenta.getNumero());
                System.out.println("Saldo: " + cuenta.getSaldo() + " pesos");
                System.out.println("Interes Calculado: " + cuenta.CalcularInteres() + " pesos");
            }
            System.out.println("--------------------");
        } else {
            System.out.println("El cliente no tiene cuentas asociadas.");
        }
    }
}
    
        
    



