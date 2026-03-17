package modelo;

public class SensorPresencia extends Sensor {

    public SensorPresencia() {
        super("pir", "Sensor presencia", "");
    }

    @Override
    public void actualizarValor() {
        if (Math.random() > 0.5) {
            valor = 1;
        } else {
            valor = 0;
        }
    }

    @Override
    public String getEstado() {
        if (valor == 1) {
            return "Hay presencia";
        } else {
            return "No hay presencia";
        }
    }

}
