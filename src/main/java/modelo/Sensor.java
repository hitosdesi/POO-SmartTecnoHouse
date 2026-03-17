package modelo;

public abstract class Sensor implements IDispositivo {

    protected String id;
    protected String nombre;
    protected String unidadMedida;
    protected double valor;

    public Sensor(String id, String nombre, String unidadMedida) {
        this.id = id;
        this.nombre = nombre;
        this.unidadMedida = unidadMedida;
        this.valor = 0.0;
    }

    @Override
    public String getID() {
        return id;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    public double getValor() {
        return valor;
    }

    @Override
    public String getEstadoActual() {
        return valor + " " + unidadMedida;
    }

    public abstract void actualizarValor();
}
