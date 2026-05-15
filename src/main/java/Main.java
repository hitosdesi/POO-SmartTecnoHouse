import modelo.*;
import vista.VentanaPrincipal;

public class Main {

    public static void main(String[] args) {

        Casa casa = Casa.getInstancia();

        casa.agregarSensor(new SensorTemperatura());
        casa.agregarSensor(new SensorLuz());
        casa.agregarSensor(new SensorPresencia());
        casa.agregarSensor(new SensorHumedad());

        casa.agregarActuador(new Bombilla());
        casa.agregarActuador(new Ventilador());
        casa.agregarActuador(new Persiana());

        casa.agregarRegla(new ReglaVentilacion());
        casa.agregarRegla(new ReglaIluminacion());

        new VentanaPrincipal(casa);

    }

}
