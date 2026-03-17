package modelo;

public class Ventilador extends Actuador {

    public Ventilador() {
        super("fan", "Ventilador", "OFF");
    }

    @Override
    public void ejecutarAccion(String accion) {
        if (accion.equals("OFF") || accion.equals("LOW") || accion.equals("HIGH")) {
            estado = accion;
        }
    }

}
