package Formulario3;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class Compras extends JFrame {
    private JPanel panelPrincipal;  // Este es el panel raíz del formulario
    private JLabel labelSubtotal;
    private JTable tableResumen;
    private JButton buttonPagar;
    private JButton buttonLimpiar;
    private JComboBox JComboBoxProductos;
    private JTextField textFieldCantidad;
    private JLabel Producto; // ⚠️ Parece que este no lo necesitas, pero lo dejamos
    private JLabel labelPrecio;
    private JLabel labelIva;
    private JLabel labelDescuento;
    private JLabel labelTotal;

    private HashMap<String, Double> productos = new HashMap<>();
    private DefaultTableModel modeloTabla;

    public Compras() {
        setTitle("Formulario de Compras");
        setContentPane(panelPrincipal);
        setSize(700, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setContentPane(getContentPane()); // importante si estás usando .form

        // Simulación de productos
        productos.put("Martillo", 10.00);
        productos.put("Clavos", 3.50);
        productos.put("Pintura Blanca", 15.00);
        productos.put("Taladro", 50.00);

        // Cargar productos en JComboBox
        JComboBoxProductos.removeAllItems();
        for (String nombre : productos.keySet()) {
            JComboBoxProductos.addItem(nombre);
        }

        // Modelo de la tabla
        modeloTabla = new DefaultTableModel(new String[]{"Producto", "Cantidad", "Precio", "Subtotal", "IVA", "Descuento", "Total"}, 0);
        tableResumen.setModel(modeloTabla);
        setContentPane(panelPrincipal);


        // Mostrar precio al cambiar producto
        JComboBoxProductos.addActionListener(e -> actualizarPrecio());

        // Botón Pagar
        buttonPagar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                procesarCompra();
            }
        });

        // Botón Limpiar
        buttonLimpiar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                limpiarTodo();
            }
        });

        actualizarPrecio();
    }

    private void actualizarPrecio() {
        String productoSeleccionado = (String) JComboBoxProductos.getSelectedItem();
        if (productoSeleccionado != null) {
            double precio = productos.get(productoSeleccionado);
            labelPrecio.setText("$" + String.format("%.2f", precio));
        }
    }

    private void procesarCompra() {
        String producto = (String) JComboBoxProductos.getSelectedItem();
        String cantidadStr = textFieldCantidad.getText();

        if (cantidadStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingresa una cantidad.");
            return;
        }

        try {
            int cantidad = Integer.parseInt(cantidadStr);
            if (cantidad <= 0) throw new NumberFormatException();

            double precio = productos.get(producto);
            double subtotal = precio * cantidad;
            double iva = subtotal * 0.15;
            double descuento = subtotal * 0.20;
            double total = subtotal + iva - descuento;

            // Mostrar resultados
            labelSubtotal.setText("$" + String.format("%.2f", subtotal));
            labelIva.setText("$" + String.format("%.2f", iva));
            labelDescuento.setText("$" + String.format("%.2f", descuento));
            labelTotal.setText("$" + String.format("%.2f", total));

            // Agregar a la tabla
            modeloTabla.addRow(new Object[]{
                    producto,
                    cantidad,
                    "$" + String.format("%.2f", precio),
                    "$" + String.format("%.2f", subtotal),
                    "$" + String.format("%.2f", iva),
                    "$" + String.format("%.2f", descuento),
                    "$" + String.format("%.2f", total)
            });

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Cantidad inválida.");
        }
    }

    private void limpiarTodo() {
        textFieldCantidad.setText("");
        labelPrecio.setText("$0.00");
        labelSubtotal.setText("$0.00");
        labelIva.setText("$0.00");
        labelDescuento.setText("$0.00");
        labelTotal.setText("$0.00");
        modeloTabla.setRowCount(0);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Compras().setVisible(true));
    }
}
