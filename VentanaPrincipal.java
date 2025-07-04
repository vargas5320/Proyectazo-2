/**
 * @class VentanaPrincipal
 * @brief Interfaz gráfica principal del sistema de entregas. Permite agregar direcciones, agregar paquetes y visualizar la ruta de entrega.
 */
public class VentanaPrincipal extends JFrame {

    private Camion camion;
    private JTextArea areaDirecciones;
    private JTextArea areaPaquetes;
    private JButton btnAgregarPaquete;
    private JButton btnMostrarRuta;
    private JTextField campoDireccion;
    private JButton btnAgregarDireccion;

    /**
     * @brief Constructor que inicializa y configura todos los componentes gráficos de la ventana principal.
     */
    public VentanaPrincipal() {
        super("Sistema de Entregas - Ruta del Camión");

        camion = new Camion();
        
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JPanel panelTop = new JPanel(new FlowLayout());
        campoDireccion = new JTextField(15);
        btnAgregarDireccion = new JButton("Agregar");
        panelTop.add(btnAgregarDireccion);

        panelTop.add(new JLabel("Nueva Dirección:"));
        panelTop.add(campoDireccion);

        JPanel panelCentro = new JPanel(new GridLayout(1, 2));
        areaDirecciones = new JTextArea();
        areaDirecciones.setEditable(false);
        areaDirecciones.setBorder(BorderFactory.createTitledBorder("Lista de direcciones"));

        areaPaquetes = new JTextArea();
        areaPaquetes.setEditable(false);
        areaPaquetes.setBorder(BorderFactory.createTitledBorder("Ruta de de entrega"));

        panelCentro.add(new JScrollPane(areaDirecciones));
        panelCentro.add(new JScrollPane(areaPaquetes));

        JPanel panelBottom = new JPanel(new FlowLayout());
        btnMostrarRuta = new JButton("Actualizar Ruta");
        panelBottom.add(btnMostrarRuta);
        btnAgregarPaquete = new JButton("Nuevo Paquete");
        panelBottom.add(btnAgregarPaquete);

        panel.add(panelTop, BorderLayout.NORTH);
        panel.add(panelCentro, BorderLayout.CENTER);
        panel.add(panelBottom, BorderLayout.SOUTH);

        add(panel);

        // Listener para abrir ventana de ingreso de paquetes
        btnAgregarPaquete.addActionListener(e -> {
            new VentanaAgregar(this, camion.getRuta()).setVisible(true);
        });

        // Listener para agregar una nueva dirección a la ruta
        btnAgregarDireccion.addActionListener(e -> {
            String dir = campoDireccion.getText().trim();
            if (!dir.isEmpty()) {
                camion.agregarDireccion(dir);
                campoDireccion.setText("");
                actualizarDirecciones();
            }
        });

        // Listener para mostrar entregas
        btnMostrarRuta.addActionListener(e -> mostrarEntregas());

        actualizarDirecciones();
    }

    /**
     * @brief Actualiza el área de texto con la lista actual de direcciones en la ruta del camión.
     */
    private void actualizarDirecciones() {
        areaDirecciones.setText("");
        NodoDireccion actual = camion.getRuta().getPrimero();
        while (actual != null) {
            areaDirecciones.append(actual.getDireccion() + "\n");
            actual = actual.getSiguiente();
        }
    }

    /**
     * @brief Muestra en el área de texto los paquetes agrupados por dirección.
     *        Utiliza el método toString() del árbol de paquetes.
     */
    private void mostrarEntregas() {
        areaPaquetes.setText("");
        NodoDireccion actual = camion.getRuta().getPrimero();
        while (actual != null) {
            areaPaquetes.append("📍 " + actual.getDireccion() + ":\n");
            areaPaquetes.append(actual.getArbolPaquete().toString() + "\n");
            actual = actual.getSiguiente();
        }
    }

    /**
     * @brief Método principal que lanza la ventana del sistema de entregas.
     * @param args Array de argumentos (no se utiliza).
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new VentanaPrincipal().setVisible(true);
        });
    }

    /**
     * @brief Método público que permite a otras ventanas agregar un paquete a una dirección existente.
     * @param direccion String con el nombre de la dirección.
     * @param destinatario String con el nombre del destinatario del paquete.
     */
    public void agregarPaqueteDesdeOtraVentana(String direccion, String destinatario) {
        PaqueteE paquete = new PaqueteE(destinatario, false, "pendiente"); 
        camion.agregarPaquete(direccion, paquete);
        actualizarDirecciones();
    }
}
