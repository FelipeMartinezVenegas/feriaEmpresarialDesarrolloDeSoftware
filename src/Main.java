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
            System.out.println("7. Dejar Comentario en un Stand");
            System.out.println("8. Listar Comentarios");
            System.out.println("9. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir salto de línea

            switch (opcion) {
                case 1:
                    System.out.print("Nombre de la empresa: ");
                    String nombreEmpresa = scanner.nextLine();
                    System.out.print("Sector: ");
                    String sector = scanner.nextLine();
                    System.out.print("Correo: ");
                    String correo = scanner.nextLine();
                    feria.registrarEmpresa(new Empresa(nombreEmpresa, sector, correo));
                    break;
                case 2:
                    feria.listarEmpresas();
                    break;
                case 3:
                    System.out.print("Número de Stand: ");
                    int numeroStand = scanner.nextInt();
                    scanner.nextLine(); // Consumir salto de línea
                    System.out.print("Ubicación: ");
                    String ubicacion = scanner.nextLine();
                    System.out.print("Tamaño (pequeño, mediano, grande): ");
                    String tamaño = scanner.nextLine();
                    feria.registrarStand(new Stand(numeroStand, ubicacion, tamaño));
                    break;
                case 4:
                    feria.listarStands();
                    break;
                case 5:
                    System.out.print("Nombre del visitante: ");
                    String nombreVisitante = scanner.nextLine();
                    System.out.print("Identificación: ");
                    String identificacion = scanner.nextLine();
                    System.out.print("Correo: ");
                    String correoVisitante = scanner.nextLine();
                    feria.registrarVisitante(new Visitante(nombreVisitante, identificacion, correoVisitante));
                    break;
                case 6:
                    feria.listarVisitantes();
                    break;
                case 7:
                    System.out.print("Nombre del visitante: ");
                    String visitanteNombre = scanner.nextLine();
                    System.out.print("Número del Stand: ");
                    int standNumero = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Calificación (1-5): ");
                    int calificacion = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Comentario: ");
                    String mensaje = scanner.nextLine();
                    feria.agregarComentario(new Comentario(new Visitante(visitanteNombre, "", ""), new Stand(standNumero, "", ""), calificacion, mensaje));
                    break;
                case 8:
                    feria.listarComentarios();
                    break;
                case 9:
                    System.out.println("Saliendo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción inválida.");
            }
        }
    }
}
