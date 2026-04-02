package modelo;

import java.util.ArrayList;

public class Casa {

    private static Casa instancia;

    private ArrayList<Sensor> sensores;
    private ArrayList<Actuador> actuadores;
    private ArrayList<Regla> reglas;

    private Casa() {
        sensores = new ArrayList<>();
        actuadores = new ArrayList<>();
        reglas = new ArrayList<>();
    }

    public static Casa getInstancia() {
        if (instancia == null) {
            instancia = new Casa();
        }
        return instancia;
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

    public String getEstadoTexto() {
        String texto = "";
        texto += "Sensores:\n";
        for (Sensor sensor : sensores) {
            texto += sensor.getNombre() + ": " + sensor.getEstado() + "\n";
        }
        texto += "\nActuadores:\n";
        for (Actuador actuador : actuadores) {
            texto += actuador.getNombre() + ": " + actuador.getEstado() + "\n";
        }
        return texto;
    }

    public ArrayList<Sensor> getSensores() {
        return sensores;
    }

    public ArrayList<Actuador> getActuadores() {
        return actuadores;
    }

}
