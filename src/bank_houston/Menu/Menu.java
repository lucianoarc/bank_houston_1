
package bank_houston.Menu;

import bank_houston.Menu.Opciones.ConsultaDeSaldo;
import bank_houston.Menu.Opciones.CreacionDelCliente;
import bank_houston.Menu.Opciones.CreaciondeCuentas;
import bank_houston.Menu.Opciones.Depositar;
import bank_houston.Menu.Opciones.Girar;
import bank_houston.Menu.Opciones.VerDatosdelCliente;
import java.util.Scanner;


public class Menu {
    
    public static void Menu(){                                                  
    Scanner Teclado=new Scanner(System.in);
    int opciones=0;
        do{
            System.out.println("1.- Creacion Del Cliente");
            System.out.println("2.- Ver Datos Del Cliente");
            System.out.println("3.- Creacion De Cuentas");
            System.out.println("4.- Depositar");
            System.out.println("5.- Girar");
            System.out.println("6.- Consultar saldo");
            System.out.println("7.- Salir");
            opciones=Teclado.nextInt();
                switch (opciones){
                case 1:
                    CreacionDelCliente.Registro_Del_Cliente(Teclado);
                    break;
                case 2:
                    VerDatosdelCliente.Ver_Datos_Del_Cliente(Teclado);
                    break;
                case 3:
                    CreaciondeCuentas.Creacion_de_cuentas(Teclado);
                    break;
                case 4:
                    Depositar.Deposita(Teclado);
                    break;
                case 5:
                    Girar.Gira(Teclado);
                    break;
                case 6:
                    ConsultaDeSaldo.ConsultarSaldo(Teclado);
                    break;
                case 7:
                    System.out.println("!! Hasta luego que tengas un buen dia !!");
                    break;
                default:
                    System.out.println("Opcion invalida");
                    System.out.println("");
                    break;
                    }
        } while(opciones<1||opciones>7);                                        
        
    }
}
