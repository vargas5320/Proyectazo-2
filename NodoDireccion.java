public class NodoDireccion {
    // Dirección, siguiente
    private String direccion;
    private NodoDireccion siguiente;

    public NodoDireccion (String direccionP) {
        this.direccion = direccionP;
        this.siguiente = null;
    }

    // Getters y Setters
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public NodoDireccion getSiguiente () {
        return siguiente;
    }
    public void setSiguiente (NodoDireccion siguiente) {
        this.siguiente = siguiente;
    }
}