package modelo;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class GestorJSON {

    private static final String RUTA = "data/estado.json";
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public static void guardar(ArrayList<Actuador> actuadores) {
        try {
            JsonObject root = new JsonObject();
            JsonArray array = new JsonArray();
            for (Actuador a : actuadores) {
                JsonObject obj = new JsonObject();
                obj.addProperty("id", a.getId());
                obj.addProperty("nombre", a.getNombre());
                obj.addProperty("estado", a.getEstado());
                array.add(obj);
            }
            root.add("actuadores", array);
            FileWriter writer = new FileWriter(RUTA);
            gson.toJson(root, writer);
            writer.close();
        } catch (IOException e) {
            System.out.println("Error al guardar JSON: " + e.getMessage());
        }
    }

    public static void cargar(ArrayList<Actuador> actuadores) {
        try {
            FileReader reader = new FileReader(RUTA);
            JsonObject root = gson.fromJson(reader, JsonObject.class);
            reader.close();
            if (root == null || !root.has("actuadores")) {
                return;
            }
            JsonArray array = root.getAsJsonArray("actuadores");
            for (int i = 0; i < array.size(); i++) {
                JsonObject obj = array.get(i).getAsJsonObject();
                String id = obj.get("id").getAsString();
                String estado = obj.get("estado").getAsString();
                for (Actuador a : actuadores) {
                    if (a.getId().equals(id)) {
                        a.ejecutarAccion(estado);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("No se encontro estado.json, iniciando con valores por defecto.");
        }
    }

}
