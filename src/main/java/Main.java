import modelo.*;

public class Main {

    public static void main(String[] args) {

        Casa casa = new Casa();

        SensorTemperatura temp = new SensorTemperatura();
        SensorLuz luz = new SensorLuz();
        SensorPresencia presencia = new SensorPresencia();

        Bombilla bombilla = new Bombilla();
        Ventilador ventilador = new Ventilador();

        casa.agregarSensor(temp);
        casa.agregarSensor(luz);
        casa.agregarSensor(presencia);

        casa.agregarActuador(bombilla);
        casa.agregarActuador(ventilador);

        casa.actualizarSensores();
        casa.mostrarEstado();

        bombilla.ejecutarAccion("ON");
        ventilador.ejecutarAccion("HIGH");

        System.out.println();
        System.out.println("Despues de activar actuadores:");
        casa.mostrarEstado();
    }

}
