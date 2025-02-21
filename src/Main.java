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

            // Validar entrada para evitar errores
            if (!scanner.hasNextInt()) {
                System.out.println("⚠️ Opción inválida. Debe ingresar un número.");
                scanner.next(); // Limpiar entrada incorrecta
                continue;
            }

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    System.out.print("Nombre de la empresa: ");
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
                case 3:
                    System.out.print("Número del stand: ");
                    int numStand = scanner.nextInt();
                    scanner.nextLine(); // Consumir salto de línea
                    System.out.print("Ubicación: ");
                    String ubicacion = scanner.nextLine();
                    System.out.print("Tamaño (pequeño, mediano, grande): ");
                    String tamaño = scanner.nextLine();
                    feria.registrarStand(new Stand(numStand, ubicacion, tamaño));
                    break;
                case 4:
                    feria.listarStands();
                    break;
                case 5:
                    System.out.print("Nombre del visitante: ");
                    String nombreVisitante = scanner.nextLine();
                    System.out.print("ID (cédula o pasaporte): ");
                    String id = scanner.nextLine();
                    System.out.print("Correo electrónico: ");
                    String emailVisitante = scanner.nextLine();
                    feria.registrarVisitante(new Visitante(nombreVisitante, id, emailVisitante));
                    break;
                case 6:
                    feria.listarVisitantes();
                    break;
                case 7:
                    System.out.println("Saliendo... 👋");
                    scanner.close();
                    return;
                default:
                    System.out.println("⚠️ Opción inválida. Intente de nuevo.");
            }
        }
    }
}
