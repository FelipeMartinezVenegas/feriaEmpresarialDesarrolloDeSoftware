import models.*;
import services.FeriaService;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        FeriaService feria = new FeriaService();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n🌟 Feria Empresarial 🌟");
            System.out.println("1. Registrar Empresa");
            System.out.println("2. Listar Empresas");
            System.out.println("3. Registrar Stand");
            System.out.println("4. Listar Stands");
            System.out.println("5. Registrar Visitante");
            System.out.println("6. Listar Visitantes");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir salto de línea

            switch (opcion) {
                case 1:
                    System.out.print("Nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Sector: ");
                    String sector = scanner.nextLine();
                    System.out.print("Correo: ");
                    String correo = scanner.nextLine();
                    feria.registrarEmpresa(new Empresa(nombre, sector, correo));
                    break;
                case 2:
                    feria.listarEmpresas();
                    break;
                case 7:
                    System.out.println("Saliendo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción inválida.");
            }
        }
    }
}
