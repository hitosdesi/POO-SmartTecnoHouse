package modelo;

import java.util.ArrayList;

public interface Regla {

    void aplicar(ArrayList<Sensor> sensores, ArrayList<Actuador> actuadores);

}
