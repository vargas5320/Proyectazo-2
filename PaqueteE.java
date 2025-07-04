public class PaqueteE {
    private String destinatario;
    private boolean entregado;
    private String estado;
    

    public PaqueteE (String destinatario, boolean entregado, String estado) { //Constructor 
        this.destinatario = destinatario;
        this.entregado = entregado;
        this.estado = estado;
        
    }

    //Set y gets
    public String getDestinatario() {
        return destinatario;
    }
    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }
    public boolean getEntregado() {
        return entregado;
    }
    public void setEntregado(boolean entregado) {
        this.entregado= entregado;
    }
    public  String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado= estado;
    }

    public String asingarEstado (){
        if(entregado){
            estado = "entregado";
        }
        else {
            estado= "pendiente";
        }
        return estado;
    }
   
    //public void informacion () {
        //System.out.println("Destinatario: " + destinatario);
        //System.out.println("Prioridad: " + prioridad);
        //System.out.println("Cantidad: " + cantidad);
    //}
}
