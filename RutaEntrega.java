/**
 * @class RutaEntrega
 * @brief Representa una lista enlazada simple de direcciones de entrega.
 *        Cada nodo de la lista contiene una dirección y un árbol de paquetes.
 */
public class RutaEntrega {
    NodoDireccion primero;

    /**
     * @brief Constructor. Inicializa la lista enlazada de direcciones como vacía.
     */
    public RutaEntrega() {
        this.primero = null;
    }

    /**
     * @brief Devuelve el primer nodo de la lista de direcciones.
     * @return NodoDireccion el primer nodo de la lista.
     */
    public NodoDireccion getPrimero() {
        return this.primero;
    }

    /**
     * @brief Busca una dirección específica en la lista enlazada.
     * @param direccion String con el nombre de la dirección a buscar.
     * @return NodoDireccion que contiene la dirección, o null si no se encuentra.
     */
    public NodoDireccion buscarDireccion(String direccion) {
        NodoDireccion actual = primero;
        while (actual != null) {
            if (actual.getDireccion() == direccion) { // Nota: se recomienda usar equals()
                return actual;
            }
            actual = actual.getSiguiente();
        }
        return null;
    }

    /**
     * @brief Inserta una nueva dirección al final de la lista enlazada.
     * @param direccion String con el nombre de la dirección a insertar.
     */
    public void insertarDireccion(String direccion) {
        NodoDireccion insertar = new NodoDireccion(direccion);
        if (this.primero == null) {
            this.primero = insertar;
        } else {
            NodoDireccion actual = primero;
            while (actual.getSiguiente() != null) {
                actual = actual.getSiguiente();
            }
            actual.setSiguiente(insertar);
        }
    }

    /**
     * @brief Elimina una dirección específica de la lista enlazada.
     * @param direccion String con el nombre de la dirección a eliminar.
     * @return boolean true si se eliminó con éxito, false si no se encontró.
     */
    public boolean eliminarDireccion(String direccion) {
        if ((this.primero == null) || this.buscarDireccion(direccion) == null) {
            return false;
        }
        if (this.primero.getDireccion() == direccion) {
            this.primero = this.primero.getSiguiente();
            return true;
        }
        NodoDireccion anterior = this.primero;
        NodoDireccion actual = this.primero.getSiguiente();

        while (actual != null) {
            if (actual.getDireccion() == direccion) {
                anterior.setSiguiente(actual.getSiguiente());
                return true;
            }
            anterior = actual;
            actual.getSiguiente();
        }
        return false;
    }

    /**
     * @brief Recorre e imprime todas las direcciones de la lista enlazada.
     */
    public void recorrerRuta() {
        NodoDireccion actual = primero;
        while (actual != null) {
            System.out.println("Dirección: " + actual.getDireccion());
            actual = actual.getSiguiente();
        }
    }
}
