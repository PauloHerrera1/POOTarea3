public class CuentaAhorro extends CuentaDeBanco {
    // 2,5 de interes
    private static final double tasa = 0.025; 

    public CuentaAhorro(String numeroCuenta, String titular, double saldoInicial) {
        super(numeroCuenta, titular, saldoInicial);
    }

    @Override
    public void depositar(double monto) {
        if (monto > 0) {
            double montoConInteres = monto + (monto * tasa);
            saldo += montoConInteres; // se actualiza el saldo 
            RegistrarTransaccion("Hubo un deposito de " + monto + " El nuevo saldo incluyendo el interes es de: " + saldo);
        } else {
            RegistrarTransaccion("El monto "  + monto +  " es invalido, deposito rechazado.");
        }
    }
}
