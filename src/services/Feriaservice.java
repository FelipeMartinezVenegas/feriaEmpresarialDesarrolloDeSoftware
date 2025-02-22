package services;
import models.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class FeriaService {
    private List<Empresa> empresas = new ArrayList<>();
    private List<Stand> stands = new ArrayList<>();
    private List<Visitante> visitantes = new ArrayList<>();
    private List<Comentario> comentarios = new ArrayList<>();

    // Métodos para gestionar empresas
    public void registrarEmpresa(Empresa empresa) {
        empresas.add(empresa);
        guardarEmpresasEnArchivo();
    }

    public void listarEmpresas() {
        for (Empresa e : empresas) {
            System.out.println(e);
        }
    }

    // Métodos para gestionar stands
    public void registrarStand(Stand stand) {
        stands.add(stand);
        guardarStandsEnArchivo();
    }

    public void listarStands() {
        for (Stand s : stands) {
            System.out.println(s);
        }
    }

    // Métodos para gestionar visitantes
    public void registrarVisitante(Visitante visitante) {
        visitantes.add(visitante);
        guardarVisitantesEnArchivo();
    }

    public void listarVisitantes() {
        for (Visitante v : visitantes) {
            System.out.println(v);
        }
    }

    // Métodos para gestionar comentarios
    public void agregarComentario(Comentario comentario) {
        comentarios.add(comentario);
        guardarComentariosEnArchivo();
    }

    public void listarComentarios() {
        if (comentarios.isEmpty()) {
            System.out.println("No hay comentarios aún.");
        } else {
            for (Comentario c : comentarios) {
                System.out.println(c);
            }
        }
    }

    // Guardar empresas en un archivo CSV
    private void guardarEmpresasEnArchivo() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("empresas.csv"))) {
            for (Empresa e : empresas) {
                writer.println(e.getNombre());
            }
        } catch (IOException e) {
            System.out.println("Error al guardar empresas: " + e.getMessage());
        }
    }

    // Guardar stands en un archivo CSV
    private void guardarStandsEnArchivo() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("stands.csv"))) {
            for (Stand s : stands) {
                writer.println(s.getNumero());
            }
        } catch (IOException e) {
            System.out.println("Error al guardar stands: " + e.getMessage());
        }
    }

    // Guardar visitantes en un archivo CSV
    private void guardarVisitantesEnArchivo() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("visitantes.csv"))) {
            for (Visitante v : visitantes) {
                writer.println(v.getNombre());
            }
        } catch (IOException e) {
            System.out.println("Error al guardar visitantes: " + e.getMessage());
        }
    }

    // Guardar comentarios en un archivo CSV
    private void guardarComentariosEnArchivo() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("comentarios.csv"))) {
            for (Comentario c : comentarios) {
                writer.println(c.getVisitante().getNombre() + "," + c.getStand().getNumero() + "," +
                               c.getCalificacion() + "," + c.getMensaje());
            }
        } catch (IOException e) {
            System.out.println("Error al guardar comentarios: " + e.getMessage());
        }
    }
}