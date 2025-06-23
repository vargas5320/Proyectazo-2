public class PaqueteE {
    private String destinatario;
    private int prioridad;
    private int cantidad;

    public PaqueteE (String destinatario, int prioridad, int cantidad) { //Constructor
        this.destinatario = destinatario;
        this.prioridad = prioridad;
        this.cantidad = cantidad;
    }

    //Set y gets
    public String getDestinatario() {
        return destinatario;
    }
    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }
    public int getPrioridad() {
        return prioridad;
    }
    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }
    public int getCantidad() {
        return cantidad;
    }
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void informacion () {
        System.out.println("Destinatario: " + destinatario);
        System.out.println("Prioridad: " + prioridad);
        System.out.println("Cantidad: " + cantidad);
    }
}
