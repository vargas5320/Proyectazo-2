//Esta clase pretende crear los nodos del tipo paquete con los atributos y métodos establecidos en "PaqueteE", los cuales van formar el arbol
public class NodoPaquete {
    PaqueteE paquete; // tipo de variable almacenada en el nodo
    //Atributos
    NodoPaquete izquierdo;
    NodoPaquete derecho; 

    //constructor

    public NodoPaquete(PaqueteE paquete){
        this.paquete = paquete;
        this.izquierda = null;
        this.derecha = null;
    }
}