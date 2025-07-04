/**
 * @class Camion
 * @brief Representa un camión que realiza entregas. Mantiene una lista enlazada de direcciones,
 *        cada una con su propio árbol de paquetes.
 */
public class Camion {
    private RutaEntrega ruta;

    /**
     * @brief Constructor que inicializa el camión con una nueva ruta vacía.
     */
    public Camion() {
        this.ruta = new RutaEntrega();
    }

    /**
     * @brief Agrega una nueva dirección a la ruta del camión.
     * @param direccion String que representa la dirección a agregar.
     */
    public void agregarDireccion(String direccion) {
        ruta.insertarDireccion(direccion);
    }

    /**
     * @brief Agrega un paquete a una dirección específica de la ruta.
     * @param direccion String con el nombre de la dirección donde se entregará el paquete.
     * @param paquete Objeto de tipo PaqueteE que representa el paquete a entregar.
     */
    public void agregarPaquete(String direccion, PaqueteE paquete) {
        NodoDireccion nodo = ruta.buscarDireccion(direccion);
        if (nodo != null) {
            nodo.getArbolPaquete().insertar(paquete);
        } else {
            System.out.println("Dirección no encontrada.");
        }
    }

    /**
     * @brief Muestra todas las entregas organizadas por dirección,
     *        recorriendo la lista de direcciones y el árbol de paquetes de cada una.
     */
    public void mostrarEntregas() {
        ruta.recorrerRuta(); // imprime direcciones
        NodoDireccion actual = ruta.getPrimero(); // método que podemos crear
        while (actual != null) {
            System.out.println("Paquetes en: " + actual.getDireccion());
            actual.getArbolPaquete().recorridoOrden();
            actual = actual.getSiguiente();
        }
    }

    /**
     * @brief Elimina una dirección de la ruta del camión.
     * @param direccion String con el nombre de la dirección a eliminar.
     * @return boolean true si la dirección fue eliminada, false si no se encontró.
     */
    public boolean eliminarDireccion(String direccion) {
        return ruta.eliminarDireccion(direccion);
    }

    /**
     * @brief Retorna la ruta de entrega actual del camión.
     * @return RutaEntrega objeto que representa la lista enlazada de direcciones.
     */
    public RutaEntrega getRuta() {
        return ruta;
    }
}
