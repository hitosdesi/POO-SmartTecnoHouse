package modelo;

public class Bombilla extends Actuador {

    public Bombilla() {
        super("bulb", "Bombilla", "OFF");
    }

    @Override
    public void ejecutarAccion(String accion) {
        if (accion.equals("ON") || accion.equals("OFF")) {
            estado = accion;
        }
    }

}
