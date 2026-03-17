package modelo;

public class SensorTemperatura extends Sensor {

    public SensorTemperatura(String id, String nombre) {
        super(id, nombre, "°C");
    }

    @Override
    public void actualizarValor() {
        this.valor = 20 + Math.random() * 10;
    }
}
