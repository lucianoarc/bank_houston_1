
package Tarjetas.Cuentas;

import Tarjetas.CuentaBancaria;


public class CuentaInversiones extends CuentaBancaria{

    public CuentaInversiones(int NumeroDeCuenta, double saldo) {
        super(NumeroDeCuenta, saldo);
    }
    
     @Override
    public double CalcularInteres() {
        //el interes de la cuenta de inversiones es del 5% anual
        return saldo * 0.05;
    }
}
