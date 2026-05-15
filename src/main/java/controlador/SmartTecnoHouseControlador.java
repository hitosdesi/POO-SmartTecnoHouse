package controlador;

import modelo.Actuador;
import modelo.Casa;
import modelo.GestorJSON;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SmartTecnoHouseControlador {

    private Casa casa;
    private static final String LOG_PATH = "data/actuators.log";
    private static final String ESTADO_PATH = "data/estado.txt";
    private static final DateTimeFormatter FORMATO = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public SmartTecnoHouseControlador(Casa casa) {
        this.casa = casa;
        crearCarpetaData();
        GestorJSON.cargar(casa.getActuadores());
    }

    public void actualizarSensores() {
        casa.actualizarSensores();
    }

    public void aplicarReglas() {
        String estadoAntes = capturarEstadoActuadores();
        casa.aplicarReglas();
        String estadoDespues = capturarEstadoActuadores();
        if (!estadoAntes.equals(estadoDespues)) {
            registrarLog("Reglas aplicadas - cambios detectados en actuadores");
            for (Actuador a : casa.getActuadores()) {
                registrarLog(a.getNombre() + " -> " + a.getEstado());
            }
        }
    }

    public String getEstado() {
        return casa.getEstadoTexto();
    }

    public void guardarEstado() {
        try {
            FileWriter writer = new FileWriter(ESTADO_PATH);
            writer.write(casa.getEstadoTexto());
            writer.close();
        } catch (IOException e) {
            System.out.println("Error al guardar estado: " + e.getMessage());
        }
        GestorJSON.guardar(casa.getActuadores());
        registrarLog("Estado guardado en TXT y JSON");
    }

    private void crearCarpetaData() {
        java.io.File carpeta = new java.io.File("data");
        if (!carpeta.exists()) {
            carpeta.mkdir();
        }
    }

    private String capturarEstadoActuadores() {
        String estado = "";
        for (Actuador a : casa.getActuadores()) {
            estado += a.getId() + "=" + a.getEstado() + ";";
        }
        return estado;
    }

    private void registrarLog(String mensaje) {
        try {
            FileWriter writer = new FileWriter(LOG_PATH, true);
            String linea = "[" + LocalDateTime.now().format(FORMATO) + "] " + mensaje;
            writer.write(linea + "\n");
            writer.close();
            System.out.println(linea);
        } catch (IOException e) {
            System.out.println("Error al escribir log: " + e.getMessage());
        }
    }

}
