package modelo;

public class ActuadorPersiana extends Actuador {

    public ActuadorPersiana(String id, String nombre) {
        super(id, nombre, "CERRADA");
    }

    @Override
    public void ejecutarAccion(String accion) {

        if (accion.equals("ABIERTA") || accion.equals("CERRADA")) {
            this.estado = accion;
        }
    }

    @Override
    public String[] getAccionesPosibles() {
        return new String[]{"ABIERTA", "CERRADA"};
    }
}
