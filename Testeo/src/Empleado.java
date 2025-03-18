import java.util.HashMap;
import java.util.ArrayList;

public class Empleado {
    public static void main(String[] args) {
        HashMap<String, HashMap<String, Object>> personas = new HashMap<>();

        HashMap<String, Object> datosJuan = new HashMap<>();
        datosJuan.put("Edad", 25);
        datosJuan.put("Altura", 1.75);
        personas.put("Juan", datosJuan);

        HashMap<String, Object> datosMaria = new HashMap<>();
        datosMaria.put("Edad", 30);
        datosMaria.put("Altura", 1.65);
        personas.put("María", datosMaria);

        for (String nombre : personas.keySet()) {
            System.out.println(nombre + " -> " + personas.get(nombre));
        }
    }
}