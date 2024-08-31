public class CuentaCorriente extends CuentaDeBanco {
    // Credito de 1000 
    private static final double credito = -1000.0;

    public CuentaCorriente(String numeroCuenta, String titular, double saldoInicial) {
        super(numeroCuenta, titular, saldoInicial);
    }

    @Override
    public void retirar(double monto) {
        if (monto > 0 && (saldo - monto) >= credito) {
            saldo -= monto; // se actualiza el saldo
            RegistrarTransaccion("Hubo un retiro de " + monto + " El nuevo saldo es de: " + saldo);
        } else {
            RegistrarTransaccion("El monto "  + monto +  " es invalido, retiro rechazado.");
        }
    }
}
