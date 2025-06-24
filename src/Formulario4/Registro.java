package Formulario4;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Registro extends JFrame {
    private JTextField textFieldNombre;
    private JTextField textFieldApellido;
    private JTextField textFieldEdad;
    private JTextField textFieldTelefono;
    private JRadioButton radioHombre;
    private JRadioButton radioMujer;
    private JCheckBox checkFutbol;
    private JCheckBox checkBasquet;
    private JCheckBox checkTenis;
    private JCheckBox checkNatacion;
    private JComboBox comboBarrio;
    private JButton buttonRegistrar;
    private JButton buttonLimpiar;
    private JTable tableRegistro;
    private JLabel telefonoLabel;
    private JPanel panelPrincipal;  // lo enlazas al root del .form

    private DefaultTableModel modelo;

    public Registro() {
        setTitle("Registro de Personas");
        setSize(800, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setContentPane(panelPrincipal);

        modelo = new DefaultTableModel(new String[]{"Nombre", "Apellido", "Edad", "Teléfono", "Género", "Deportes", "Barrio"}, 0);
        tableRegistro.setModel(modelo);
        setContentPane(panelPrincipal);


        // Agrupar radios
        ButtonGroup grupoGenero = new ButtonGroup();
        grupoGenero.add(radioHombre);
        grupoGenero.add(radioMujer);

        buttonRegistrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                registrarPersona();
            }
        });

        buttonLimpiar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                limpiarCampos();
            }
        });
    }

    private void registrarPersona() {
        String nombre = textFieldNombre.getText();
        String apellido = textFieldApellido.getText();
        String edad = textFieldEdad.getText();
        String telefono = textFieldTelefono.getText();

        String genero = radioHombre.isSelected() ? "Hombre" : (radioMujer.isSelected() ? "Mujer" : "");

        String deportes = "";
        if (checkFutbol.isSelected()) deportes += "Fútbol ";
        if (checkBasquet.isSelected()) deportes += "Básquet ";
        if (checkTenis.isSelected()) deportes += "Tenis ";
        if (checkNatacion.isSelected()) deportes += "Natación ";

        String barrio = (String) comboBarrio.getSelectedItem();

        // Validación mínima
        if (nombre.isEmpty() || apellido.isEmpty() || edad.isEmpty() || telefono.isEmpty() || genero.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, llena todos los campos.");
            return;
        }

        modelo.addRow(new Object[]{nombre, apellido, edad, telefono, genero, deportes.trim(), barrio});
    }

    private void limpiarCampos() {
        textFieldNombre.setText("");
        textFieldApellido.setText("");
        textFieldEdad.setText("");
        textFieldTelefono.setText("");

        radioHombre.setSelected(false);
        radioMujer.setSelected(false);

        checkFutbol.setSelected(false);
        checkBasquet.setSelected(false);
        checkTenis.setSelected(false);
        checkNatacion.setSelected(false);

        comboBarrio.setSelectedIndex(0);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Registro().setVisible(true));
    }
}
