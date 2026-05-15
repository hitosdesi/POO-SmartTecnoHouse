package modelo;

import java.util.ArrayList;

public class ReglaIluminacion implements Regla {

    @Override
    public void aplicar(ArrayList<Sensor> sensores, ArrayList<Actuador> actuadores) {

        for (Sensor sensor : sensores) {
            if (sensor instanceof SensorLuz) {

                if (sensor.getValor() < 40) {
                    for (Actuador actuador : actuadores) {
                        if (actuador instanceof Bombilla) {
                            actuador.ejecutarAccion("ON");
                        }
                    }
                }

            }
        }

    }

}
