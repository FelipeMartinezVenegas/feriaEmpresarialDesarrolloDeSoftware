package models;
import java.util.Date;

public class Comentario {
    private String visitante;
    private String comentario;
    private int calificacion;
    private Date fecha;

    public Comentario(String visitante, String comentario, int calificacion) {
        this.visitante = visitante;
        this.comentario = comentario;
        this.calificacion = calificacion;
        this.fecha = new Date();
    }

    @Override
    public String toString() {
        return "Comentario de " + visitante + " (" + fecha + "): " + comentario + " | 🌟 " + calificacion + "/5";
    }
}
