package modelo;

public class SensorTemperatura extends Sensor {

    public SensorTemperatura() {
        super("temp", "Sensor temperatura", "°C");
    }

    @Override
    public void actualizarValor() {
        valor = 20 + Math.random() * 10;
    }

}
