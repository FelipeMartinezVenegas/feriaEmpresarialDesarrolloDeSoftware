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
    }

    public void listarEmpresas() {
        for (Empresa e : empresas) {
            System.out.println(e);
        }
    }

    // Métodos para gestionar stands
    public void registrarStand(Stand stand) {
        stands.add(stand);
    }

    public void listarStands() {
        for (Stand s : stands) {
            System.out.println(s);
        }
    }

    // Métodos para gestionar visitantes
    public void registrarVisitante(Visitante visitante) {
        visitantes.add(visitante);
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
