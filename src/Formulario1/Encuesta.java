package Formulario1;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Year;

public class Encuesta extends JFrame {
    private JTextField textField1; // Nombre
    private JTextField textField2; // Apellido
    private JTextField textField3; // Año de nacimiento
    private JRadioButton hombreRadioButton;
    private JRadioButton mujerRadioButton;
    private JButton verificarEdadButton;
    private JButton limpiarButton;
    private JLabel resultadoLabel;
    private ButtonGroup grupoGenero;

    public Encuesta() {
        setTitle("Formulario Encuesta");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null); // Posicionamiento manual

        // Nombre
        JLabel nombreLabel = new JLabel("Nombre:");
        nombreLabel.setBounds(20, 20, 100, 20);
        add(nombreLabel);

        textField1 = new JTextField();
        textField1.setBounds(120, 20, 200, 20);
        add(textField1);

        // Apellido
        JLabel apellidoLabel = new JLabel("Apellido:");
        apellidoLabel.setBounds(20, 50, 100, 20);
        add(apellidoLabel);

        textField2 = new JTextField();
        textField2.setBounds(120, 50, 200, 20);
        add(textField2);

        // Año de nacimiento
        JLabel anioLabel = new JLabel("Año Nacimiento:");
        anioLabel.setBounds(20, 80, 100, 20);
        add(anioLabel);

        textField3 = new JTextField();
        textField3.setBounds(120, 80, 200, 20);
        add(textField3);

        // Género
        JLabel generoLabel = new JLabel("Género:");
        generoLabel.setBounds(20, 110, 100, 20);
        add(generoLabel);

        hombreRadioButton = new JRadioButton("Hombre");
        hombreRadioButton.setBounds(120, 110, 90, 20);
        add(hombreRadioButton);

        mujerRadioButton = new JRadioButton("Mujer");
        mujerRadioButton.setBounds(210, 110, 90, 20);
        add(mujerRadioButton);

        grupoGenero = new ButtonGroup();
        grupoGenero.add(hombreRadioButton);
        grupoGenero.add(mujerRadioButton);

        // Botón Verificar
        verificarEdadButton = new JButton("Verificar Edad");
        verificarEdadButton.setBounds(50, 150, 130, 30);
        add(verificarEdadButton);

        // Botón Limpiar
        limpiarButton = new JButton("Limpiar");
        limpiarButton.setBounds(200, 150, 100, 30);
        add(limpiarButton);

        // Resultado
        resultadoLabel = new JLabel("");
        resultadoLabel.setBounds(20, 190, 350, 40);
        add(resultadoLabel);

        // Acciones
        verificarEdadButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                verificarEdad();
            }
        });

        limpiarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                limpiarCampos();
            }
        });
    }

    private void verificarEdad() {
        String nombre = textField1.getText();
        String apellido = textField2.getText();
        String anioTexto = textField3.getText();

        if (nombre.isEmpty() || apellido.isEmpty() || anioTexto.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor llena todos los campos.");
            return;
        }

        try {
            int anioNacimiento = Integer.parseInt(anioTexto);
            int anioActual = Year.now().getValue();
            int edad = anioActual - anioNacimiento;

            String resultado = "Nombre: " + nombre + " " + apellido +
                    " - Edad: " + edad + " años → " +
                    (edad >= 18 ? "Mayor de edad" : "Menor de edad");

            resultadoLabel.setText(resultado);

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "El año de nacimiento debe ser numérico.");
        }
    }

    private void limpiarCampos() {
        textField1.setText("");
        textField2.setText("");
        textField3.setText("");
        grupoGenero.clearSelection();
        resultadoLabel.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Encuesta().setVisible(true));
    }
}
