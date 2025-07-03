import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class VentanaPrincipal extends JFrame {

    private Camion camion;
    private JTextArea areaDirecciones;
    private JTextArea areaPaquetes;
    private JTextField campoDireccion;
    private JButton btnAgregarDireccion;
    private JButton btnMostrarRuta;

    public VentanaPrincipal() {
        super("Sistema de Entregas - Ruta del Camión");

        camion = new Camion();

        // Ejemplo de ejecución
        camion.agregarDireccion("San José");
        camion.agregarDireccion("Cartago");
        camion.agregarDireccion("Heredia");

        camion.agregarPaquete("San José", new PaqueteE("Luis", 2, 10));
        camion.agregarPaquete("San José", new PaqueteE("Ana", 1, 5));
        camion.agregarPaquete("Cartago", new PaqueteE("Carlos", 3, 7));
        camion.agregarPaquete("Heredia", new PaqueteE("Diego", 1, 8));
    

        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Panel principal
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        // Panel superior - Formulario
        JPanel panelTop = new JPanel(new FlowLayout());
        campoDireccion = new JTextField(15);
        btnAgregarDireccion = new JButton("Agregar Dirección");
        panelTop.add(new JLabel("Dirección:"));
        panelTop.add(campoDireccion);
        panelTop.add(btnAgregarDireccion);

        // Panel central - Áreas de texto
        JPanel panelCentro = new JPanel(new GridLayout(1, 2));
        areaDirecciones = new JTextArea();
        areaDirecciones.setEditable(false);
        areaDirecciones.setBorder(BorderFactory.createTitledBorder("Ruta del Camión"));

        areaPaquetes = new JTextArea();
        areaPaquetes.setEditable(false);
        areaPaquetes.setBorder(BorderFactory.createTitledBorder("Paquetes por Dirección"));

        panelCentro.add(new JScrollPane(areaDirecciones));
        panelCentro.add(new JScrollPane(areaPaquetes));

        // Panel inferior - Botón mostrar
        JPanel panelBottom = new JPanel(new FlowLayout());
        btnMostrarRuta = new JButton("Mostrar Entregas");
        panelBottom.add(btnMostrarRuta);

        // Agregar paneles al contenedor principal
        panel.add(panelTop, BorderLayout.NORTH);
        panel.add(panelCentro, BorderLayout.CENTER);
        panel.add(panelBottom, BorderLayout.SOUTH);

        add(panel);

        // Listeners
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
}
