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

        ReglaVentilacion regla1 = new ReglaVentilacion();
        ReglaIluminacion regla2 = new ReglaIluminacion();

        casa.agregarSensor(temp);
        casa.agregarSensor(luz);
        casa.agregarSensor(presencia);
        casa.agregarSensor(humedad);

        casa.agregarActuador(bombilla);
        casa.agregarActuador(ventilador);
        casa.agregarActuador(persiana);

        casa.agregarRegla(regla1);
        casa.agregarRegla(regla2);

        casa.actualizarSensores();

        System.out.println("Antes de aplicar reglas:");
        casa.mostrarEstado();

        casa.aplicarReglas();

        System.out.println();
        System.out.println("Despues de aplicar reglas:");
        casa.mostrarEstado();
    }

}
