import java.util.Scanner;
import java.util.InputMismatchException;

public class MenuUsuario {
    private Scanner scanner;

    public MenuUsuario() {
        this.scanner = new Scanner(System.in);
    }

    public void mostrarMenu(Convertidor convertidor) {
        while (true) {
            mostrarOpciones();

            int opcionOrigen = obtenerOpcionValida("Seleccione la moneda de origen (0-6): ");
            if (opcionOrigen == 0) break;

            int opcionDestino = obtenerOpcionValida("Seleccione la moneda de destino (1-6): ");

            double cantidad = obtenerCantidadValida();

            String monedaOrigen = obtenerCodigoMoneda(opcionOrigen);
            String monedaDestino = obtenerCodigoMoneda(opcionDestino);

            double resultado = convertidor.convertir(monedaOrigen, monedaDestino, cantidad);
            System.out.printf("%.2f %s = %.2f %s%n", cantidad, monedaOrigen, resultado, monedaDestino);
        }
    }

    private void mostrarOpciones() {
        System.out.println("\n--- Conversor de Monedas ---");
        System.out.println("1. ARS - Peso argentino");
        System.out.println("2. BOB - Boliviano");
        System.out.println("3. BRL - Real brasileño");
        System.out.println("4. CLP - Peso chileno");
        System.out.println("5. COP - Peso colombiano");
        System.out.println("6. USD - Dólar estadounidense");
        System.out.println("0. Salir");
    }

    private int obtenerOpcionValida(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                int opcion = scanner.nextInt();
                if (opcion >= 0 && opcion <= 6) {
                    return opcion;
                } else {
                    System.out.println("Error: Por favor ingrese un número entre 0 y 6.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Por favor ingrese un número válido.");
                scanner.next(); // Limpiar el buffer del scanner
            }
        }
    }

    private double obtenerCantidadValida() {
        while (true) {
            try {
                System.out.print("Ingrese la cantidad a convertir: ");
                double cantidad = scanner.nextDouble();
                if (cantidad > 0) {
                    return cantidad;
                } else {
                    System.out.println("Error: Por favor ingrese una cantidad positiva.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Por favor ingrese un número válido.");
                scanner.next(); // Limpiar el buffer del scanner
            }
        }
    }

    private String obtenerCodigoMoneda(int opcion) {
        switch (opcion) {
            case 1: return "ARS";
            case 2: return "BOB";
            case 3: return "BRL";
            case 4: return "CLP";
            case 5: return "COP";
            case 6: return "USD";
            default: throw new IllegalArgumentException("Opción inválida");
        }
    }
}