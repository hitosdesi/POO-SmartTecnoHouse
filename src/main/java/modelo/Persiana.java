package modelo;

public class Persiana extends Actuador {

    public Persiana() {
        super("blind", "Persiana", "CERRADA");
    }

    @Override
    public void ejecutarAccion(String accion) {
        if (accion.equals("ABIERTA") || accion.equals("CERRADA")) {
            estado = accion;
        }
    }

}
