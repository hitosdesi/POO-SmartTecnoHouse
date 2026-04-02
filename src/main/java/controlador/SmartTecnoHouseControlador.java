package controlador;

import modelo.Casa;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class SmartTecnoHouseControlador {

    private Casa casa;

    public SmartTecnoHouseControlador(Casa casa) {
        this.casa = casa;
    }

    public void actualizarSensores() {
        casa.actualizarSensores();
    }

    public void aplicarReglas() {
        casa.aplicarReglas();
    }

    public String getEstado() {
        return casa.getEstadoTexto();
    }

    public void guardarEstado() {
        try {
            File carpeta = new File("data");
            if (!carpeta.exists()) {
                carpeta.mkdir();
            }

            FileWriter writer = new FileWriter("data/estado.txt");
            writer.write(casa.getEstadoTexto());
            writer.close();

        } catch (IOException e) {
            System.out.println("Error al guardar: " + e.getMessage());
        }
    }

}
