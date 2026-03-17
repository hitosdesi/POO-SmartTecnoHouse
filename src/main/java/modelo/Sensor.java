package modelo;

public abstract class Sensor implements Dispositivo {

    protected String id;
    protected String nombre;
    protected String unidad;
    protected double valor;

    public Sensor(String id, String nombre, String unidad) {
        this.id = id;
        this.nombre = nombre;
        this.unidad = unidad;
        valor = 0;
    }

    @Override
    public String getId() {
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
    public String getEstado() {
        return valor + " " + unidad;
    }

    public abstract void actualizarValor();

}
