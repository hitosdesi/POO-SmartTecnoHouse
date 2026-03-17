package modelo;

public class SensorLuz extends Sensor {

    public SensorLuz() {
        super("light", "Sensor luz", "%");
    }

    @Override
    public void actualizarValor() {
        valor = Math.random() * 100;
    }

}
