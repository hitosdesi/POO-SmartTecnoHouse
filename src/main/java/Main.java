import modelo.*;

public class Main {

    public static void main(String[] args) {

        Casa casa = new Casa();

        SensorTemperatura temp = new SensorTemperatura();
        SensorLuz luz = new SensorLuz();
        SensorPresencia presencia = new SensorPresencia();
        SensorHumedad humedad = new SensorHumedad();

        Bombilla bombilla = new Bombilla();
        Ventilador ventilador = new Ventilador();
        Persiana persiana = new Persiana();

        casa.agregarSensor(temp);
        casa.agregarSensor(luz);
        casa.agregarSensor(presencia);
        casa.agregarSensor(humedad);

        casa.agregarActuador(bombilla);
        casa.agregarActuador(ventilador);
        casa.agregarActuador(persiana);

        casa.actualizarSensores();
        casa.mostrarEstado();

        bombilla.ejecutarAccion("ON");
        ventilador.ejecutarAccion("HIGH");
        persiana.ejecutarAccion("ABIERTA");

        System.out.println();
        System.out.println("Despues de activar actuadores:");
        casa.mostrarEstado();
    }

}
