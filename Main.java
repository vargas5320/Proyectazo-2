public class Main {
    public static void main(String[] args) {
        Camion camion = new Camion();

        // Agregamos direcciones
        camion.agregarDireccion("San José");
        camion.agregarDireccion("Cartago");
        camion.agregarDireccion("Heredia");

        // Agregamos paquetes a direcciones específicas
        camion.agregarPaquete("San José", new PaqueteE("Luis", 2, 10));
        camion.agregarPaquete("San José", new PaqueteE("Ana", 1, 5));
        camion.agregarPaquete("Cartago", new PaqueteE("Carlos", 3, 7));
        camion.agregarPaquete("Heredia", new PaqueteE("Diego", 1, 8));

        // Mostrar entregas organizadas por dirección
        System.out.println("\nEntregas por dirección:");
        camion.mostrarEntregas();

        // Eliminar una dirección
        System.out.println("\nEliminando dirección Cartago...");
        if (camion.eliminarDireccion("Cartago")) {
            System.out.println("Dirección eliminada.");
        } else {
            System.out.println("No se pudo eliminar la dirección.");
        }

        // Mostrar nuevamente las entregas después de eliminar
        System.out.println("\nEntregas actualizadas:");
        camion.mostrarEntregas();
    }
}