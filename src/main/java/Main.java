import modelo.*;

public class Main {

    public static void main(String[] args) {

        SmartTecnoHouse casa = new SmartTecnoHouse();

        // Crear sensores
        SensorTemperatura temp = new SensorTemperatura("temp", "Sensor de Temperatura");
        SensorLuz luz = new SensorLuz("light", "Sensor de Luz");
        SensorPresencia pir = new SensorPresencia("pir", "Sensor de Presencia");

        // Crear actuadores
        ActuadorBombilla bombilla = new ActuadorBombilla("bulb", "Bombilla");
        ActuadorVentilador ventilador = new ActuadorVentilador("fan", "Ventilador");

        // Agregar dispositivos al sistema
        casa.agregarSensor(temp);
        casa.agregarSensor(luz);
        casa.agregarSensor(pir);

        casa.agregarActuador(bombilla);
        casa.agregarActuador(ventilador);

        // Actualizar sensores
        casa.actualizarSensores();

        // Mostrar estado
        casa.mostrarEstadoSistema();

        // Simular acciones
        bombilla.ejecutarAccion("ON");
        ventilador.ejecutarAccion("HIGH");

        System.out.println("\n=== ESTADO TRAS ACCIONES ===");

        casa.mostrarEstadoSistema();
    }
}
