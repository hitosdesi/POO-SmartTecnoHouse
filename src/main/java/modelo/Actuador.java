package modelo;

public abstract class Actuador implements Dispositivo {

    protected String id;
    protected String nombre;
    protected String estado;

    public Actuador(String id, String nombre, String estado) {
        this.id = id;
        this.nombre = nombre;
        this.estado = estado;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public String getEstado() {
        return estado;
    }

    public abstract void ejecutarAccion(String accion);

}
