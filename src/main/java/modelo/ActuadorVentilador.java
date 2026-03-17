package modelo;

public class ActuadorVentilador extends Actuador {

    public ActuadorVentilador(String id, String nombre) {
        super(id, nombre, "OFF");
    }

    @Override
    public void ejecutarAccion(String accion) {
        if (accion.equals("OFF") || accion.equals("LOW") || accion.equals("HIGH")) {
            this.estado = accion;
        }
    }

    @Override
    public String[] getAccionesPosibles() {
        return new String[]{"OFF", "LOW", "HIGH"};
    }
}
