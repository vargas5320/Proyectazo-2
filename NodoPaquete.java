/**
 * @class NodoPaquete
 * @brief Representa un nodo del árbol binario de paquetes. Contiene un paquete y referencias a los nodos hijo izquierdo y derecho.
 */
public class NodoPaquete {
    private PaqueteE paquete;
    private NodoPaquete izquierda;
    private NodoPaquete derecha;

    /**
     * @brief Constructor de la clase NodoPaquete.
     * @param paquete Objeto PaqueteE que representa el contenido del nodo.
     */
    public NodoPaquete(PaqueteE paquete) {
        this.paquete = paquete;
        this.izquierda = null;
        this.derecha = null;
    }

    /**
     * @brief Obtiene el paquete almacenado en este nodo.
     * @return PaqueteE objeto contenido en el nodo.
     */
    public PaqueteE getPaquete() {
        return paquete;
    }

    /**
     * @brief Establece el paquete contenido en este nodo.
     * @param paquete Objeto PaqueteE a asignar.
     */
    public void setPaquete(PaqueteE paquete) {
        this.paquete = paquete;
    }

    /**
     * @brief Obtiene la referencia al hijo izquierdo del nodo.
     * @return NodoPaquete que representa el subárbol izquierdo.
     */
    public NodoPaquete getIzquierda() {
        return izquierda;
    }

    /**
     * @brief Establece el nodo hijo izquierdo.
     * @param izquierda NodoPaquete que se asignará como hijo izquierdo.
     */
    public void setIzquierda(NodoPaquete izquierda) {
        this.izquierda = izquierda;
    }

    /**
     * @brief Obtiene la referencia al hijo derecho del nodo.
     * @return NodoPaquete que representa el subárbol derecho.
     */
    public NodoPaquete getDerecha() {
        return derecha;
    }

    /**
     * @brief Establece el nodo hijo derecho.
     * @param derecha NodoPaquete que se asignará como hijo derecho.
     */
    public void setDerecha(NodoPaquete derecha) {
        this.derecha = derecha;
    }
}
