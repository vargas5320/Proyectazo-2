/**
 * @class ArbolPaquete
 * @brief Representa un árbol binario de búsqueda para almacenar paquetes ordenados por destinatario.
 */
public class ArbolPaquete {
    private NodoPaquete raiz;

    /**
     * @brief Constructor del árbol. Inicializa el árbol con la raíz en null.
     */
    public ArbolPaquete() {
        this.raiz = null;
    }

    /**
     * @brief Inserta un paquete en el árbol.
     * @param paquete Objeto de tipo PaqueteE que se desea insertar.
     */
    public void insertar(PaqueteE paquete){
        raiz = insertarRecorrido(raiz, paquete);
    }

    /**
     * @brief Método recursivo para insertar un paquete en el árbol respetando el orden alfabético del destinatario.
     * @param nodo NodoPaquete actual desde el cual se evalúa la inserción.
     * @param paquete PaqueteE que se va a insertar.
     * @return NodoPaquete El nodo actualizado del árbol.
     */
    public NodoPaquete insertarRecorrido (NodoPaquete nodo, PaqueteE paquete) {
        if (nodo == null) {
            return new NodoPaquete(paquete);
        }
        if (paquete.getDestinatario().compareTo(nodo.getPaquete().getDestinatario()) < 0)
            nodo.setIzquierda(insertarRecorrido(nodo.getIzquierda(), paquete));
        else {
            nodo.setDerecha(insertarRecorrido(nodo.getDerecha(), paquete));
        }

        return nodo;
    }

    /**
     * @brief Inicia el recorrido inorden del árbol para mostrar los paquetes en orden alfabético.
     */
    public void recorridoOrden() {
        ordenRec(raiz);
    }

    /**
     * @brief Método recursivo para realizar el recorrido inorden del árbol.
     * @param nodo NodoPaquete actual del recorrido.
     */
    private void ordenRec(NodoPaquete nodo) {
        if (nodo != null) {
            ordenRec(nodo.getIzquierda());
            nodo.getPaquete();
            ordenRec(nodo.getDerecha());
        }
    }

    /**
     * @brief Inicia el recorrido preorden del árbol para mostrar los paquetes en orden jerárquico.
     */
    public void recorridoPreOrden() {
        preOrdenRec(raiz);
    }

    /**
     * @brief Método recursivo para realizar el recorrido preorden del árbol.
     * @param nodo NodoPaquete actual del recorrido.
     */
    private void preOrdenRec(NodoPaquete nodo) {
        if (nodo != null) {
            nodo.getPaquete();
            preOrdenRec(nodo.getIzquierda());
            preOrdenRec(nodo.getDerecha());
        }
    }

    /**
     * @brief Devuelve una representación textual del árbol, utilizada para mostrar en el GUI.
     * @return String con el contenido del árbol ordenado.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        construirTexto(raiz, sb);
        return sb.toString();
    }

    /**
     * @brief Método recursivo que construye el texto representando el árbol en recorrido inorden.
     * @param nodo NodoPaquete actual del recorrido.
     * @param sb StringBuilder utilizado para acumular el texto.
     */
    private void construirTexto(NodoPaquete nodo, StringBuilder sb) {
        if (nodo != null) {
            construirTexto(nodo.getIzquierda(), sb);
            PaqueteE p = nodo.getPaquete();
            sb.append("  - ").append(p.getDestinatario())
              .append(" estado: ").append(p.getEstado())
              .append(")\n");
            construirTexto(nodo.getDerecha(), sb);
        }
    }
}
