package modelo;

public class SensorHumedad extends Sensor {

    public SensorHumedad() {
        super("hum", "Sensor humedad", "%");
    }

    @Override
    public void actualizarValor() {
        valor = 30 + Math.random() * 50;
    }

}
