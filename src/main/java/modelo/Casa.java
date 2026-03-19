package modelo;

import java.util.ArrayList;

public class Casa {

    private ArrayList<Sensor> sensores;
    private ArrayList<Actuador> actuadores;
    private ArrayList<Regla> reglas;

    public Casa() {
        sensores = new ArrayList<>();
        actuadores = new ArrayList<>();
        reglas = new ArrayList<>();
    }

    public void agregarSensor(Sensor sensor) {
        sensores.add(sensor);
    }

    public void agregarActuador(Actuador actuador) {
        actuadores.add(actuador);
    }

    public void agregarRegla(Regla regla) {
        reglas.add(regla);
    }

    public void actualizarSensores() {
        for (Sensor sensor : sensores) {
            sensor.actualizarValor();
        }
    }

    public void aplicarReglas() {
        for (Regla regla : reglas) {
            regla.aplicar(sensores, actuadores);
        }
    }

    public void mostrarEstado() {
        System.out.println("Sensores:");
        for (Sensor sensor : sensores) {
            System.out.println(sensor.getNombre() + ": " + sensor.getEstado());
        }

        System.out.println();
        System.out.println("Actuadores:");
        for (Actuador actuador : actuadores) {
            System.out.println(actuador.getNombre() + ": " + actuador.getEstado());
        }
    }

}
