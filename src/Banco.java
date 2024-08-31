import java.util.LinkedList;

public class Banco {
    private LinkedList<CuentaDeBanco> Registrodecuentas;

    public Banco() {
        Registrodecuentas = new LinkedList<>();
    }

    // metodo de cuenta de ahorro
    public void crearCuentaAhorro(String numeroCuenta, String titular, double saldoInicial) {
        CuentaDeBanco nuevaCuenta = new CuentaAhorro(numeroCuenta, titular, saldoInicial);
        Registrodecuentas.add(nuevaCuenta);
        System.out.println("La cuenta de ahorro numero: " + numeroCuenta + "fue creada. ");
    }

    // metodo de cuenta corriente
    public void crearCuentaCorriente(String numeroCuenta, String titular, double saldoInicial) {
        CuentaDeBanco nuevaCuenta = new CuentaCorriente(numeroCuenta, titular, saldoInicial);
        Registrodecuentas.add(nuevaCuenta);
        System.out.println("La cuenta corriente numero: " + numeroCuenta + "fue creada. ");
    }

    // metodo para eliminar cuentas
    public void eliminarCuenta(String numeroCuenta) {
        CuentaDeBanco Eliminada = buscarCuenta(numeroCuenta);
        if (Eliminada != null) {
            Registrodecuentas.remove(Eliminada);
            System.out.println("Cuenta eliminada: " + numeroCuenta);
        }
    }

    // Metodo para bbuscar y devolver una cuenta dado su número de cuenta, lanza una excepción si no se encuentra
    public CuentaDeBanco buscarCuenta(String numeroCuenta) {
        for (CuentaDeBanco cuenta : Registrodecuentas) {
            if (cuenta.getNumeroCuenta().equals(numeroCuenta)) {
                return cuenta;
            }
        }
        throw new IllegalArgumentException("No existe la cuenta con el numero: " + numeroCuenta);
    }

    // metodo para listar todas las cuentas
    public void listarCuentas() {
        if (Registrodecuentas.isEmpty()) {
            System.out.println("No hay cuentas existentes.");
        } else {
            for (CuentaDeBanco cuenta : Registrodecuentas) {
                System.out.println("Numero de Cuenta: " + cuenta.getNumeroCuenta() + ", Titular: " + cuenta.getTitular() + ", Saldo: " + cuenta.getSaldo());
            }
        }
    }

    public void transferir(String NcuentaOrigen, String NcuentaDestino, double monto) {
    CuentaDeBanco origen = buscarCuenta(NcuentaOrigen);
    CuentaDeBanco destino = buscarCuenta(NcuentaDestino);

    if (origen != null && destino != null) {
        double saldoOrigenAnterior = origen.getSaldo();
        origen.retirar(monto); 

        
        if (origen.getSaldo() < saldoOrigenAnterior) {
            destino.depositar(monto);
            System.out.println("transferencia de " + NcuentaOrigen + " a " + NcuentaDestino + " , por un total de: " + monto);

            
            origen.RegistrarTransaccion("transferencia hacia la cuenta" + NcuentaDestino + " por un total de " + monto);
            destino.RegistrarTransaccion("transferencia recibida desde la cuenta " + NcuentaOrigen + " por un total " + monto);
        } else {
            System.out.println("transferencia fallida. fondos invalidos.");
        }
    } else {
        System.out.println("una de las cuentas no existe");
    }
}
}

