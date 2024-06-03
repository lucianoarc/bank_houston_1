
package Tarjetas;

import java.util.Random;


public abstract class CuentaBancaria {
   protected int NumeroDeCuenta;
   protected double saldo; 

    public CuentaBancaria(int NumeroDeCuenta, double saldo) {
        this.NumeroDeCuenta = NumeroDeCuenta;
        this.saldo = saldo;
    }

    public int getNumero() {
        return NumeroDeCuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public abstract double CalcularInteres();
    
    public void generarNumeroCuenta() {
        Random rand = new Random();
        this.NumeroDeCuenta = rand.nextInt(900000000) + 100000000;
    }

    public void depositar(int monto) {
        this.saldo += monto;
    }
    public void depositar() {
        double montoPredeterminado = 10000.0;  
        this.saldo += montoPredeterminado;
    }

    public void girar(int monto) {
        if (monto <= this.saldo) {
            this.saldo -= monto;
        } else {
            System.out.println("Saldo insuficiente.");
        }
    }
}


