public class ArbolPaquete {
    private NodoPaquete raiz;

    public ArbolPaquete() {
        this.raiz = null;
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
            nodo.getPaquete().informacion();
            ordenRec(nodo.getDerecha());
        }
    }

    public void recorridoPreOrden() {
        preOrdenRec(raiz);
    }

    private void preOrdenRec(NodoPaquete nodo) {
        if (nodo != null) {
            nodo.getPaquete().informacion();
            preOrdenRec(nodo.getIzquierda());
            preOrdenRec(nodo.getDerecha());
        }
    }
}

