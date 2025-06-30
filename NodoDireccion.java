public class NodoDireccion {
    // Dirección, siguiente
    private String direccion;
    private NodoDireccion siguiente;
    private ArbolPaquete arbolPaquete;

    public NodoDireccion (String direccionP) {
        this.direccion = direccionP;
        this.siguiente = null;
        this.arbolPaquete = new ArbolPaquete(); // Cada dirección posee su propio árbol
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
    public ArbolPaquete getArbolPaquete() {
        return arbolPaquete;
    }
    public void setArbolPaquete(ArbolPaquete arbolPaquete) {
        this.arbolPaquete = arbolPaquete;
    }
}