
package Tarjetas.Cuentas;

import Tarjetas.CuentaBancaria;


public class CuentaCorriente extends CuentaBancaria {

    public CuentaCorriente(int NumeroDeCuenta, double saldo) {
        super(NumeroDeCuenta, saldo);
    }

    @Override
    public double CalcularInteres() {
        //no genera interes
        return 0.0;
    }
}

