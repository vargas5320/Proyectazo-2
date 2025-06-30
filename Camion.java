public class Camion {
    private RutaEntrega ruta;

    public Camion() {
        this.ruta = new RutaEntrega();
    }

    public void agregarDireccion(String direccion) {
        ruta.insertarDireccion(direccion);
    }

    public void agregarPaquete(String direccion, PaqueteE paquete) {
        NodoDireccion nodo = ruta.buscarDireccion(direccion);
        if (nodo != null) {
            nodo.getArbolPaquete().insertar(paquete);
        } else {
            System.out.println("Dirección no encontrada.");
        }
    }

    public void mostrarEntregas() {
        ruta.recorrerRuta(); // imprime direcciones
        NodoDireccion actual = ruta.getPrimero(); // método que podemos crear
        while (actual != null) {
            System.out.println("Paquetes en: " + actual.getDireccion());
            actual.getArbolPaquete().recorridoOrden();
            actual = actual.getSiguiente();
        }
    }

    public boolean eliminarDireccion(String direccion) {
        return ruta.eliminarDireccion(direccion);
    }
}
