public class ArbolPaquete {
    private NodoPaquete raiz;

    public ArbolPaquete() {
        this.raiz = null;
    }

    public void insertar(PaqueteE paquete){
        raiz = insertarRecorrido(raiz, paquete);
    }

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

    public void recorridoOrden() {
        ordenRec(raiz);
    }

    private void ordenRec(NodoPaquete nodo) {
        if (nodo != null) {
            ordenRec(nodo.getIzquierda());
            nodo.getPaquete();
            ordenRec(nodo.getDerecha());
        }
    }

    public void recorridoPreOrden() {
        preOrdenRec(raiz);
    }

    private void preOrdenRec(NodoPaquete nodo) {
        if (nodo != null) {
            nodo.getPaquete();
            preOrdenRec(nodo.getIzquierda());
            preOrdenRec(nodo.getDerecha());
        }
    }

    // método para mostrar en GUI
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        construirTexto(raiz, sb);
        return sb.toString();
    }

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
