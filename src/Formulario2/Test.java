package Formulario2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Test extends JFrame {

    // Variables ya declaradas
    private JRadioButton opcionAbutton;
    private JRadioButton opcionBbutton;
    private JRadioButton opcionCbutton;
    private JRadioButton privateRadioButton;
    private JRadioButton publicRadioButton;
    private JRadioButton defaultRadioButton;
    private JRadioButton verdaderoRadioButton;
    private JRadioButton falsoRadioButton;
    private JButton verResultadoButton;
    private JButton inactivarButton;
    private JButton limpiarButton;

    // Extra
    private ButtonGroup grupo1, grupo2, grupo3;
    private JLabel resultadoLabel;

    public Test() {
        setTitle("Test Java POO");
        setSize(500, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        // Pregunta 1
        JLabel p1 = new JLabel("1. ¿Qué es el polimorfismo en Java?");
        p1.setBounds(20, 20, 400, 20);
        add(p1);

        opcionAbutton = new JRadioButton("A) La capacidad de sobrecargar variables");
        opcionAbutton.setBounds(40, 45, 350, 20);
        add(opcionAbutton);

        opcionBbutton = new JRadioButton("B) La capacidad de una clase de comportarse de múltiples formas");
        opcionBbutton.setBounds(40, 70, 400, 20);
        add(opcionBbutton);

        opcionCbutton = new JRadioButton("C) Usar múltiples clases en un solo archivo");
        opcionCbutton.setBounds(40, 95, 300, 20);
        add(opcionCbutton);

        grupo1 = new ButtonGroup();
        grupo1.add(opcionAbutton);
        grupo1.add(opcionBbutton);
        grupo1.add(opcionCbutton);

        // Pregunta 2
        JLabel p2 = new JLabel("2. ¿Cuál es el modificador de acceso que permite visibilidad en todo el paquete?");
        p2.setBounds(20, 130, 460, 20);
        add(p2);

        privateRadioButton = new JRadioButton("A) private");
        privateRadioButton.setBounds(40, 155, 200, 20);
        add(privateRadioButton);

        publicRadioButton = new JRadioButton("B) public");
        publicRadioButton.setBounds(40, 180, 200, 20);
        add(publicRadioButton);

        defaultRadioButton = new JRadioButton("C) default");
        defaultRadioButton.setBounds(40, 205, 200, 20);
        add(defaultRadioButton);

        grupo2 = new ButtonGroup();
        grupo2.add(privateRadioButton);
        grupo2.add(publicRadioButton);
        grupo2.add(defaultRadioButton);

        // Pregunta 3
        JLabel p3 = new JLabel("3. Una clase abstracta puede tener métodos con cuerpo.");
        p3.setBounds(20, 240, 400, 20);
        add(p3);

        verdaderoRadioButton = new JRadioButton("Verdadero");
        verdaderoRadioButton.setBounds(40, 265, 100, 20);
        add(verdaderoRadioButton);

        falsoRadioButton = new JRadioButton("Falso");
        falsoRadioButton.setBounds(160, 265, 100, 20);
        add(falsoRadioButton);

        grupo3 = new ButtonGroup();
        grupo3.add(verdaderoRadioButton);
        grupo3.add(falsoRadioButton);

        // Botones
        verResultadoButton = new JButton("Ver Resultado");
        verResultadoButton.setBounds(30, 310, 130, 30);
        add(verResultadoButton);

        inactivarButton = new JButton("Inactivar");
        inactivarButton.setBounds(180, 310, 100, 30);
        add(inactivarButton);

        limpiarButton = new JButton("Limpiar");
        limpiarButton.setBounds(300, 310, 100, 30);
        add(limpiarButton);

        // Resultado
        resultadoLabel = new JLabel("");
        resultadoLabel.setBounds(30, 350, 400, 30);
        add(resultadoLabel);

        // Acción: Ver Resultado
        verResultadoButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int puntaje = 0;
                if (opcionBbutton.isSelected()) puntaje += 5;
                if (defaultRadioButton.isSelected()) puntaje += 5;
                if (verdaderoRadioButton.isSelected()) puntaje += 5;

                resultadoLabel.setText("Puntaje total: " + puntaje + " / 15");
            }
        });

        // Acción: Inactivar
        inactivarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setRespuestasActivas(false);
            }
        });

        // Acción: Limpiar
        limpiarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                grupo1.clearSelection();
                grupo2.clearSelection();
                grupo3.clearSelection();
                resultadoLabel.setText("");
                setRespuestasActivas(true);
            }
        });
    }

    private void setRespuestasActivas(boolean activo) {
        opcionAbutton.setEnabled(activo);
        opcionBbutton.setEnabled(activo);
        opcionCbutton.setEnabled(activo);

        privateRadioButton.setEnabled(activo);
        publicRadioButton.setEnabled(activo);
        defaultRadioButton.setEnabled(activo);

        verdaderoRadioButton.setEnabled(activo);
        falsoRadioButton.setEnabled(activo);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Test().setVisible(true));
    }
}
