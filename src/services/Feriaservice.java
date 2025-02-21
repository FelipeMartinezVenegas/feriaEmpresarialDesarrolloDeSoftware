package services;

import models.Empresa;
import models.Stand;
import models.Visitante;
import models.Comentario;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FeriaService {
    private List<Empresa> empresas = new ArrayList<>();
    private List<Stand> stands = new ArrayList<>();
    private List<Visitante> visitantes = new ArrayList<>();
    private List<Comentario> comentarios = new ArrayList<>();

    private static final String EMPRESAS_FILE = "empresas.csv";
    private static final String STANDS_FILE = "stands.csv";
    private static final String VISITANTES_FILE = "visitantes.csv";

    public FeriaService() {
        cargarEmpresas();
        cargarStands();
        cargarVisitantes();
    }

    // Métodos para gestionar empresas
    public void registrarEmpresa(Empresa empresa) {
        empresas.add(empresa);
        guardarEmpresas();
    }

    public void listarEmpresas() {
        for (Empresa e : empresas) {
            System.out.println(e);
        }
    }

    private void guardarEmpresas() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(EMPRESAS_FILE))) {
            for (Empresa e : empresas) {
                writer.println(e.getNombre() + "," + e.getSector() + "," + e.getCorreo());
            }
        } catch (IOException e) {
            System.out.println("Error guardando empresas: " + e.getMessage());
        }
    }

    private void cargarEmpresas() {
        File file = new File(EMPRESAS_FILE);
        if (!file.exists()) return;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] datos = line.split(",");
                if (datos.length == 3) {
                    empresas.add(new Empresa(datos[0], datos[1], datos[2]));
                }
            }
        } catch (IOException e) {
            System.out.println("Error cargando empresas: " + e.getMessage());
        }
    }

    // Métodos para gestionar stands
    public void registrarStand(Stand stand) {
        stands.add(stand);
        guardarStands();
    }

    public void listarStands() {
        for (Stand s : stands) {
            System.out.println(s);
        }
    }

    private void guardarStands() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(STANDS_FILE))) {
            for (Stand s : stands) {
                writer.println(s.getNumero() + "," + s.getUbicacion() + "," + s.getTamaño());
            }
        } catch (IOException e) {
            System.out.println("Error guardando stands: " + e.getMessage());
        }
    }

    private void cargarStands() {
        File file = new File(STANDS_FILE);
        if (!file.exists()) return;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] datos = line.split(",");
                if (datos.length == 3) {
                    stands.add(new Stand(Integer.parseInt(datos[0]), datos[1], datos[2]));
                }
            }
        } catch (IOException e) {
            System.out.println("Error cargando stands: " + e.getMessage());
        }
    }

    // Métodos para gestionar visitantes
    public void registrarVisitante(Visitante visitante) {
        visitantes.add(visitante);
        guardarVisitantes();
    }

    public void listarVisitantes() {
        for (Visitante v : visitantes) {
            System.out.println(v);
        }
    }

    private void guardarVisitantes() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(VISITANTES_FILE))) {
            for (Visitante v : visitantes) {
                writer.println(v.getNombre() + "," + v.getIdentificacion() + "," + v.getCorreo());
            }
        } catch (IOException e) {
            System.out.println("Error guardando visitantes: " + e.getMessage());
        }
    }

    private void cargarVisitantes() {
        File file = new File(VISITANTES_FILE);
        if (!file.exists()) return;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] datos = line.split(",");
                if (datos.length == 3) {
                    visitantes.add(new Visitante(datos[0], datos[1], datos[2]));
                }
            }
        } catch (IOException e) {
            System.out.println("Error cargando visitantes: " + e.getMessage());
        }
    }

    // Método para agregar comentarios
    public void agregarComentario(Comentario comentario) {
        comentarios.add(comentario);
    }

    public void listarComentarios() {
        for (Comentario c : comentarios) {
            System.out.println(c);
        }
    }
}
