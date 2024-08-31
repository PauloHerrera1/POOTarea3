import java.util.LinkedList;

public class CuentaDeBanco {
    private String numeroCuenta;
    private String titular;
    protected double saldo;
    private LinkedList<String> registroTransacciones;

    public CuentaDeBanco(String numeroCuenta, String titular, double saldoInicial) {
        this.numeroCuenta = numeroCuenta;
        this.titular = titular;
        this.saldo = saldoInicial;
        this.registroTransacciones = new LinkedList<>();
        RegistrarTransaccion("La cuenta fue creada. su saldo inicial es de: " + saldoInicial);
    }
    
    //metodo de deposito
    public void depositar(double monto) {
        if (monto > 0) {
            saldo += monto;
            RegistrarTransaccion("Hubo un deposito de " + monto + " El nuevo saldo es de: " + saldo);
        } else {
            RegistrarTransaccion("El monto " + monto + " es invalido, deposito rechazado.");
        }
    }
    //metodo de retiro de dinero
    public void retirar(double monto) {
        if (monto > 0 && monto <= saldo) {
            saldo -= monto;
            RegistrarTransaccion("Hubo un retiro de " + monto + ". El nuevo saldo es de: " + saldo);
        } else {
            RegistrarTransaccion("El monto " + monto + " es invalido, retiro rechazado.");
        }
    }
    
    // metodo para revisar las transacciones
    public void VerRegistroTransacciones() {
        for (String transaccion : registroTransacciones) {
            System.out.println(transaccion);
        }
    }
    //metodo para registrar una transaccion
    public void RegistrarTransaccion(String descripcion) {
        registroTransacciones.add(descripcion);
    }
    
    
     public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public String getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }
}
