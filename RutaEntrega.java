public class RutaEntrega {
    // Metodos: Insertar direccion, quitar direccion, buscardireccion, recorrer, lista enlazada simple
    NodoDireccion primero;
    public RutaEntrega() { // Constructor
        this.primero = null; // Empezar la lista vacía
    }
    public NodoDireccion getPrimero() {
        return this.primero;
    }

    public NodoDireccion buscarDireccion (String direccion) {
        NodoDireccion actual = primero;
        while (actual != null) {
            if(actual.getDireccion() == direccion) {
                return actual;
            }
            actual = actual.getSiguiente();
        }
        return null;
    }

    public void insertarDireccion (String direccion) {
        NodoDireccion insertar = new NodoDireccion(direccion);
        if (this.primero == null) { // Caso base o trivial
            this.primero = insertar;
        } else {
            NodoDireccion actual = primero;
            while (actual.getSiguiente() != null) {
                actual = actual.getSiguiente();
            }
            actual.setSiguiente(insertar);
        }
    }

    public boolean eliminarDireccion (String direccion) {
        if ((this.primero == null) || this.buscarDireccion(direccion) == null) { // Caso bsse o trivial
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

    public void recorrerRuta () {
        NodoDireccion actual = primero;
        while (actual != null) {
            System.out.println("Dirección: " + actual.getDireccion());
            actual = actual.getSiguiente();
        }
    }
}