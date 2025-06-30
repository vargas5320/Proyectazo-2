public class NodoPaquete {
    private PaqueteE paquete;
    private NodoPaquete izquierda;
    private NodoPaquete derecha;

    public NodoPaquete (PaqueteE paquete) { // Constructor
        this.paquete = paquete;
        this.izquierda = null;
        this.derecha = null;
    }

    public PaqueteE getPaquete() {
        return paquete;
    }
    public void setPaquete(PaqueteE paquete) {
        this.paquete = paquete;
    }

    public NodoPaquete getIzquierda() {
        return izquierda;
    }
    public void setIzquierda(NodoPaquete izquierda) {
        this.izquierda = izquierda;
    }

    public NodoPaquete getDerecha() {
        return derecha;
    }
    public void setDerecha(NodoPaquete derecha) {
        this.derecha = derecha;
    }

}
