/**
 * @class NodoDireccion
 * @brief Representa un nodo de la lista enlazada de direcciones.
 *        Contiene el nombre de la dirección, una referencia al siguiente nodo
 *        y un árbol de paquetes asociado a esa dirección.
 */
public class NodoDireccion {
    private String direccion;
    private NodoDireccion siguiente;
    private ArbolPaquete arbolPaquete;

    /**
     * @brief Constructor que inicializa el nodo con una dirección específica.
     * @param direccionP String con el nombre de la dirección.
     */
    public NodoDireccion(String direccionP) {
        this.direccion = direccionP;
        this.siguiente = null;
        this.arbolPaquete = new ArbolPaquete(); // Cada dirección posee su propio árbol
    }

    /**
     * @brief Obtiene el nombre de la dirección.
     * @return String con el nombre de la dirección.
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @brief Establece o modifica el nombre de la dirección.
     * @param direccion String con el nuevo nombre de la dirección.
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * @brief Obtiene la referencia al siguiente nodo en la lista.
     * @return NodoDireccion siguiente nodo enlazado.
     */
    public NodoDireccion getSiguiente() {
        return siguiente;
    }

    /**
     * @brief Establece el nodo siguiente en la lista enlazada.
     * @param siguiente NodoDireccion que será el siguiente en la lista.
     */
    public void setSiguiente(NodoDireccion siguiente) {
        this.siguiente = siguiente;
    }

    /**
     * @brief Obtiene el árbol de paquetes asociado a esta dirección.
     * @return ArbolPaquete correspondiente al nodo.
     */
    public ArbolPaquete getArbolPaquete() {
        return arbolPaquete;
    }

    /**
     * @brief Establece un nuevo árbol de paquetes para esta dirección.
     * @param arbolPaquete ArbolPaquete que se asignará al nodo.
     */
    public void setArbolPaquete(ArbolPaquete arbolPaquete) {
        this.arbolPaquete = arbolPaquete;
    }
}
