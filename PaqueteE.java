/**
 * @class PaqueteE
 * @brief Representa un paquete con información del destinatario, su estado de entrega y una descripción del estado.
 */
public class PaqueteE {
    private String destinatario;
    private boolean entregado;
    private String estado;

    /**
     * @brief Constructor de la clase PaqueteE.
     * @param destinatario String con el nombre del destinatario del paquete.
     * @param entregado boolean que indica si el paquete ya fue entregado.
     * @param estado String que representa el estado del paquete (ej. "pendiente", "en camino").
     */
    public PaqueteE(String destinatario, boolean entregado, String estado) {
        this.destinatario = destinatario;
        this.entregado = entregado;
        this.estado = estado;
    }

    /**
     * @brief Obtiene el nombre del destinatario del paquete.
     * @return String con el nombre del destinatario.
     */
    public String getDestinatario() {
        return destinatario;
    }

    /**
     * @brief Establece el nombre del destinatario del paquete.
     * @param destinatario String con el nuevo nombre del destinatario.
     */
    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    /**
     * @brief Verifica si el paquete ha sido entregado.
     * @return boolean true si está entregado, false si no.
     */
    public boolean getEntregado() {
        return entregado;
    }

    /**
     * @brief Establece si el paquete ha sido entregado o no.
     * @param entregado boolean con el nuevo estado de entrega.
     */
    public void setEntregado(boolean entregado) {
        this.entregado = entregado;
    }

    /**
     * @brief Obtiene el estado actual del paquete.
     * @return String que representa el estado del paquete.
     */
    public String getEstado() {
        return estado;
    }

    /**
     * @brief Establece el estado del paquete.
     * @param estado String con el nuevo estado (ej. "pendiente", "entregado").
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /*
    // Método comentado: Muestra la información completa del paquete por consola.
    public void informacion () {
        System.out.println("Destinatario: " + destinatario);
        System.out.println("Prioridad: " + prioridad);
        System.out.println("Cantidad: " + cantidad);
    }
    */
}
