import javax.swing.*;
import java.awt.*;
import java.util.List;

public class VentanaAgregar extends JFrame{
    private JComboBox<String> comboDirecciones;
    private JTextField campoDestinatario;
    private JButton btnAgregar;
    private VentanaPrincipal ventanaPrincipal;


    public VentanaAgregar(VentanaPrincipal principal, RutaEntrega rutaEntrega) {
        super("Agregar paquete");
        this.ventanaPrincipal = principal;


        setSize(350, 200);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5,5,5,5);
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

            // Llamamos al método de ventana principal para agregar paquete
            ventanaPrincipal.agregarPaqueteDesdeOtraVentana(direccion, destinatario);

            dispose();
        });
    } 


}