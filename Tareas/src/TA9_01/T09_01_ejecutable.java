package TA9_01;

public class T09_01_ejecutable {
    public static void main(String[] args) {
        T09_01_Electrodomestico[] electrodomesticos = new T09_01_Electrodomestico[10];

        // Assign objects to the array
        electrodomesticos[0] = new T09_01_Electrodomestico(100.0, "blanco", 'A', 20.0);
        electrodomesticos[1] = new T09_01_Lavadora(200.0, "gris", 'B', 30.0, 10.0);
        electrodomesticos[2] = new T09_01_Television(300.0, "negro", 'C', 40.0, 50.0, true);
        electrodomesticos[3] = new T09_01_Electrodomestico(150.0, "rojo", 'D', 25.0);
        electrodomesticos[4] = new T09_01_Lavadora(250.0, "azul", 'E', 35.0, 15.0);
        electrodomesticos[5] = new T09_01_Television(350.0, "verde", 'F', 45.0, 60.0, false);
        electrodomesticos[6] = new T09_01_Electrodomestico(120.0, "amarillo", 'A', 22.0);
        electrodomesticos[7] = new T09_01_Lavadora(220.0, "morado", 'B', 32.0, 12.0);
        electrodomesticos[8] = new T09_01_Television(320.0, "naranja", 'C', 42.0, 55.0, true);
        electrodomesticos[9] = new T09_01_Electrodomestico(180.0, "rosa", 'D', 28.0);

        double totalElectrodomesticos = 0;
        double totalLavadoras = 0;
        double totalTelevisiones = 0;

        // Iterate through the array and calculate the final price
        for (T09_01_Electrodomestico electrodomestico : electrodomesticos) {
            double precioFinal = electrodomestico.precioFinal(electrodomestico.comprobarConsumoEnergetico(), electrodomestico.getPeso());
            totalElectrodomesticos += precioFinal;

            if (electrodomestico instanceof T09_01_Lavadora) {
                totalLavadoras += precioFinal;
            } else if (electrodomestico instanceof T09_01_Television) {
                totalTelevisiones += precioFinal;
            }
        }

        // Print the results
        System.out.println("Total price of all Electrodomesticos: " + totalElectrodomesticos);
        System.out.println("Total price of all Lavadoras: " + totalLavadoras);
        System.out.println("Total price of all Televisiones: " + totalTelevisiones);
    }
}

}
