package models;

public class Comentario {
    private Visitante visitante;
    private Stand stand;
    private int calificacion;
    private String mensaje;

    public Comentario(Visitante visitante, Stand stand, int calificacion, String mensaje) {
        this.visitante = visitante;
        this.stand = stand;
        this.calificacion = calificacion;
        this.mensaje = mensaje;
    }

    public Visitante getVisitante() {
        return visitante;
    }

    public Stand getStand() {
        return stand;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public String getMensaje() {
        return mensaje;
    }

    @Override
    public String toString() {
        return "📝 " + visitante.getNombre() + " calificó el Stand " + stand.getNumero() +
               " con " + calificacion + " estrellas: " + mensaje;
    }
}
