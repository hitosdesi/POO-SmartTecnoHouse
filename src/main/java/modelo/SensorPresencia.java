package modelo;

public class SensorPresencia extends Sensor {

    public SensorPresencia(String id, String nombre) {
        super(id, nombre, "detecciones");
    }

    @Override
    public void actualizarValor() {
        this.valor = Math.random() > 0.5 ? 1 : 0;
    }

    @Override
    public String getEstadoActual() {
        return valor == 1 ? "Presencia detectada" : "Sin presencia";
    }
}

