package models;

public class Stand {
    private int numero;
    private String ubicacion;
    private String tamaño;

    public Stand(int numero, String ubicacion, String tamaño) {
        this.numero = numero;
        this.ubicacion = ubicacion;
        this.tamaño = tamaño;
    }

    // Getters y Setters
    public int getNumero() { return numero; }
    public void setNumero(int numero) { this.numero = numero; }

    public String getUbicacion() { return ubicacion; }
    public void setUbicacion(String ubicacion) { this.ubicacion = ubicacion; }

    public String getTamaño() { return tamaño; }
    public void setTamaño(String tamaño) { this.tamaño = tamaño; }

    @Override
    public String toString() {
        return "Stand #" + numero + " | Ubicación: " + ubicacion + " | Tamaño: " + tamaño;
    }
}
