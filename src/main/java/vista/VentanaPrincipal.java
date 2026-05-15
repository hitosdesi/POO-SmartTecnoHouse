package vista;

import controlador.SmartTecnoHouseControlador;
import modelo.Casa;

import javax.swing.*;
import java.awt.*;

public class VentanaPrincipal extends JFrame {

    private SmartTecnoHouseControlador controlador;
    private JTextArea areaTexto;

    public VentanaPrincipal(Casa casa) {
        this.controlador = new SmartTecnoHouseControlador(casa);

        setTitle("Smart TecnoHouse");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        areaTexto = new JTextArea();
        areaTexto.setEditable(false);

        JScrollPane scroll = new JScrollPane(areaTexto);
        add(scroll, BorderLayout.CENTER);

        JPanel panelBotones = new JPanel();

        JButton btnActualizar = new JButton("Actualizar sensores");
        JButton btnReglas = new JButton("Aplicar reglas");
        JButton btnGuardar = new JButton("Guardar estado");

        panelBotones.add(btnActualizar);
        panelBotones.add(btnReglas);
        panelBotones.add(btnGuardar);

        add(panelBotones, BorderLayout.SOUTH);

        btnActualizar.addActionListener(e -> {
            controlador.actualizarSensores();
            mostrarEstado();
        });

        btnReglas.addActionListener(e -> {
            controlador.aplicarReglas();
            mostrarEstado();
        });

        btnGuardar.addActionListener(e -> {
            controlador.guardarEstado();
            JOptionPane.showMessageDialog(this, "Estado guardado correctamente.");
        });

        mostrarEstado();
        setVisible(true);
    }

    private void mostrarEstado() {
        areaTexto.setText(controlador.getEstado());
    }

}
