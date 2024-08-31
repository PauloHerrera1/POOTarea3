public class Main {
    public static void main(String[] args) {
        Banco banco = new Banco();

    
        banco.crearCuentaAhorro("000000001", "cristian", 5000);
        banco.crearCuentaAhorro("000000002", "Baniso", 3000);
        banco.crearCuentaCorriente("000000003", "Ariana", 2000);
        banco.crearCuentaCorriente("000000004", "Jafeth", 1000);
        banco.crearCuentaAhorro("000000005", "JP", 7000);

       
        System.out.println("listado Inicial de Cuentas");
        banco.listarCuentas();


    
        banco.buscarCuenta("000000001").depositar(1000); 
        banco.buscarCuenta("000000003").depositar(500); 
        banco.buscarCuenta("000000005").depositar(2000); 

     
 
        banco.buscarCuenta("000000002").retirar(1500);  
        banco.buscarCuenta("000000004").retirar(2000);   

   
        banco.transferir("000000001", "000000002", 500); 
        banco.transferir("000000004", "000000001", 100); 

        System.out.println("Listado de Cuentas despues de Operaciones ");
        banco.listarCuentas();

    
        System.out.println("Registro de transacciones para la cuenta de cristian: ");
        banco.buscarCuenta("000000001").VerRegistroTransacciones();

        System.out.println("Registro de transacciones para la cuenta de baniso: ");
        banco.buscarCuenta("000000002").VerRegistroTransacciones();

        System.out.println("Registro de transacciones para la cuenta de ariana: ");
        banco.buscarCuenta("000000003").VerRegistroTransacciones();

        System.out.println("Registro de transacciones para la cuenta de jafeth: ");
        banco.buscarCuenta("000000004").VerRegistroTransacciones();

        System.out.println("Registro de transacciones para la cuenta de jp: ");
        banco.buscarCuenta("000000005").VerRegistroTransacciones();

        
        System.out.println("Eliminamos la cuenta 000000003: ");
        banco.eliminarCuenta("000000003");

     
        System.out.println("Listado de Cuentas despues de eliminar");
        banco.listarCuentas();
    }
}
