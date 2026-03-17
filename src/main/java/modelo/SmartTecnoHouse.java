package modelo;

import java.util.ArrayList;
import java.util.List;

public class SmartTecnoHouse {

    private List<Sensor> sensores;
    private List<Actuador> actuadores;

    public SmartTecnoHouse() {
        sensores = new ArrayList<>();
        actuadores = new ArrayList<>();
    }

    public void agregarSensor(Sensor sensor) {
        sensores.add(sensor);
    }

    public void agregarActuador(Actuador actuador) {
        actuadores.add(actuador);
    }

    public List<Sensor> getSensores() {
        return sensores;
    }

    public List<Actuador> getActuadores() {
        return actuadores;
    }

    public void actualizarSensores() {
        for (Sensor sensor : sensores) {
            sensor.actualizarValor();
        }
    }

    public void mostrarEstadoSistema() {

        System.out.println("=== SENSORES ===");

        for (Sensor sensor : sensores) {
            System.out.println(sensor.getNombre() + ": " + sensor.getEstadoActual());
        }

        System.out.println("\n=== ACTUADORES ===");

        for (Actuador actuador : actuadores) {
            System.out.println(actuador.getNombre() + ": " + actuador.getEstadoActual());
        }
    }
}
