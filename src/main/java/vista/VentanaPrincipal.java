package vista;

import modelo.*;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class VentanaPrincipal extends JFrame {

    private Casa casa;
    private JTextArea areaTexto;

    public VentanaPrincipal(Casa casa) {
        this.casa = casa;

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
            casa.actualizarSensores();
            mostrarEstado();
        });

        btnReglas.addActionListener(e -> {
            casa.aplicarReglas();
            mostrarEstado();
        });

        btnGuardar.addActionListener(e -> {
            guardarEstado();
        });

        mostrarEstado();
        setVisible(true);
    }

    private void mostrarEstado() {
        areaTexto.setText(casa.getEstadoTexto());
    }

    private void guardarEstado() {
        try {
            File archivo = new File("data/estado.txt");

            if (!archivo.getParentFile().exists()) {
                archivo = new File("../../../data/estado.txt");
            }

            FileWriter writer = new FileWriter(archivo);
            writer.write(casa.getEstadoTexto());
            writer.close();

            JOptionPane.showMessageDialog(this, "Estado guardado en " + archivo.getPath());

        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error al guardar el archivo");
        }
    }
}
