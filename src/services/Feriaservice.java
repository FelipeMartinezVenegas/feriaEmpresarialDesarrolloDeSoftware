package services;
import models.Empresa;
import models.Stand;
import models.Visitante;
import models.Comentario;
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
