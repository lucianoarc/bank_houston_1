
package Tarjetas.Cuentas;

import Tarjetas.CuentaBancaria;


public class CuentaAhorro extends CuentaBancaria{

    public CuentaAhorro(int NumeroDeCuenta, double saldo) {
        super(NumeroDeCuenta, saldo);
        
    }
 
   @Override
   //el interes de la cuenta de ahorro es del 2% anual
    public double CalcularInteres() {
        return saldo * 0.02;
    }
    
}
