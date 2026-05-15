package modelo;

import java.util.ArrayList;

public class ReglaVentilacion implements Regla {

    @Override
    public void aplicar(ArrayList<Sensor> sensores, ArrayList<Actuador> actuadores) {

        for (Sensor sensor : sensores) {
            if (sensor instanceof SensorTemperatura) {

                if (sensor.getValor() > 25) {
                    for (Actuador actuador : actuadores) {
                        if (actuador instanceof Ventilador) {
                            actuador.ejecutarAccion("HIGH");
                        }
                    }
                }

            }
        }

    }

}
