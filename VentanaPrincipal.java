import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class VentanaPrincipal extends JFrame {

    private Camion camion;
    private JTextArea areaDirecciones;
    private JTextArea areaPaquetes;
    private JButton btnAgregarPaquete;
    private JButton btnMostrarRuta;
    private JTextField campoDireccion;
    private JButton btnAgregarDireccion;

    public VentanaPrincipal() {
        super("Sistema de Entregas - Ruta del Camión");

        camion = new Camion();
        
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Panel principal
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        // Panel superior - Formulario
        JPanel panelTop = new JPanel(new FlowLayout());
        campoDireccion = new JTextField(15);
        btnAgregarDireccion = new JButton("Agregar");
        panelTop.add(btnAgregarDireccion);

        
        panelTop.add(new JLabel("Nueva Dirección:"));
        panelTop.add(campoDireccion);
        

        // Panel central - Áreas de texto
        JPanel panelCentro = new JPanel(new GridLayout(1, 2));
        areaDirecciones = new JTextArea();
        areaDirecciones.setEditable(false);
        areaDirecciones.setBorder(BorderFactory.createTitledBorder("Lista de direcciones"));

        areaPaquetes = new JTextArea();
        areaPaquetes.setEditable(false);
        areaPaquetes.setBorder(BorderFactory.createTitledBorder("Ruta de de entrega"));

        panelCentro.add(new JScrollPane(areaDirecciones));
        panelCentro.add(new JScrollPane(areaPaquetes));

        // Panel inferior - Botón mostrar
        JPanel panelBottom = new JPanel(new FlowLayout());
        btnMostrarRuta = new JButton("Actualizar Ruta");
        panelBottom.add(btnMostrarRuta);
        btnAgregarPaquete = new JButton("Nuevo Paquete");
        panelBottom.add(btnAgregarPaquete);

        // Agregar paneles al contenedor principal
        panel.add(panelTop, BorderLayout.NORTH);
        panel.add(panelCentro, BorderLayout.CENTER);
        panel.add(panelBottom, BorderLayout.SOUTH);

        add(panel);

        // Listeners
        btnAgregarPaquete.addActionListener(e -> {
            new VentanaAgregar(this, camion.getRuta()).setVisible(true);
            
        });

        btnAgregarDireccion.addActionListener(e -> {
            String dir = campoDireccion.getText().trim();
            if (!dir.isEmpty()) {
                camion.agregarDireccion(dir);
                campoDireccion.setText("");
                actualizarDirecciones();
            }
        });

        btnMostrarRuta.addActionListener(e -> mostrarEntregas());

        // Mostrar datos de ejemplo al iniciar
        actualizarDirecciones();
    }

    private void actualizarDirecciones() {
        areaDirecciones.setText("");
        NodoDireccion actual = camion.getRuta().getPrimero();
        while (actual != null) {
            areaDirecciones.append(actual.getDireccion() + "\n");
            actual = actual.getSiguiente();
        }
    }

    private void mostrarEntregas() {
        areaPaquetes.setText("");
        NodoDireccion actual = camion.getRuta().getPrimero();
        while (actual != null) {
            areaPaquetes.append("📍 " + actual.getDireccion() + ":\n");
            areaPaquetes.append(actual.getArbolPaquete().toString() + "\n");
            actual = actual.getSiguiente();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new VentanaPrincipal().setVisible(true);
        });
    }

    public void agregarPaqueteDesdeOtraVentana(String direccion, String destinatario) {
    PaqueteE paquete = new PaqueteE(destinatario, false,"pendiente"); 
    camion.agregarPaquete(direccion, paquete);
    actualizarDirecciones();
    }
}
