import javax.swing.*;           // JFrame, JButton, JLabel, JTextField, JComboBox, JOptionPane
import java.awt.*;              // GridBagLayout, GridBagConstraints, Insets, Layouts
import java.awt.event.*;        // Eventos como ActionListener

/**
 * @class VentanaAgregar
 * @brief Ventana secundaria que permite al usuario agregar un nuevo paquete a una dirección existente.
 */
public class VentanaAgregar extends JFrame {
    private JComboBox<String> comboDirecciones;
    private JTextField campoDestinatario;
    private JButton btnAgregar;
    private VentanaPrincipal ventanaPrincipal;

    /**
     * @brief Constructor que inicializa y configura la ventana de ingreso de paquetes.
     * @param principal Referencia a la VentanaPrincipal que gestiona el sistema.
     * @param rutaEntrega RutaEntrega actual que contiene la lista de direcciones disponibles.
     */
    public VentanaAgregar(VentanaPrincipal principal, RutaEntrega rutaEntrega) {
        super("Agregar paquete");
        this.ventanaPrincipal = principal;

        setSize(350, 200);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Etiqueta y combo para dirección
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(new JLabel("Dirección:"), gbc);

        comboDirecciones = new JComboBox<>();
        NodoDireccion actual = rutaEntrega.getPrimero();
        while (actual != null) {
            comboDirecciones.addItem(actual.getDireccion());
            actual = actual.getSiguiente();
        }

        gbc.gridx = 1;
        gbc.gridy = 0;
        add(comboDirecciones, gbc);

        // Etiqueta y campo para destinatario
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(new JLabel("Destinatario:"), gbc);

        campoDestinatario = new JTextField(15);
        gbc.gridx = 1;
        gbc.gridy = 1;
        add(campoDestinatario, gbc);

        // Botón aceptar
        btnAgregar = new JButton("Agregar");
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        add(btnAgregar, gbc);

        /**
         * @brief Listener que valida la entrada del usuario, agrega el paquete a la dirección seleccionada
         *        y cierra la ventana actual.
         */
        btnAgregar.addActionListener(e -> {
            String direccion = (String) comboDirecciones.getSelectedItem();
            String destinatario = campoDestinatario.getText().trim();

            if (direccion == null || direccion.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Seleccione una dirección.");
                return;
            }

            if (destinatario.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Ingrese el nombre del destinatario.");
                return;
            }

            try {
                if (destinatario.matches(".*\\d.*")) {
                    throw new IllegalArgumentException("El nombre no debe contener números.");
                }

                // Llamamos al método de ventana principal para agregar paquete
                ventanaPrincipal.agregarPaqueteDesdeOtraVentana(direccion, destinatario);
                dispose();

            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        });
    }
}
