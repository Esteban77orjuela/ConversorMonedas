import java.io.IOException;
import java.util.Map;

public class ConversorMonedas {
    private APIClient apiClient;
    private Convertidor convertidor;
    private MenuUsuario menuUsuario;

    public ConversorMonedas() {
        this.apiClient = new APIClient();
        this.convertidor = new Convertidor();
        this.menuUsuario = new MenuUsuario();
    }

    public void iniciar() {
        try {
            Map<String, TasaCambio> tasasCambio = apiClient.obtenerTasasCambio();
            convertidor.setTasasCambio(tasasCambio);
            menuUsuario.mostrarMenu(convertidor);
        } catch (IOException | InterruptedException e) {
            System.err.println("Error al iniciar el conversor de monedas:");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ConversorMonedas conversor = new ConversorMonedas();
        conversor.iniciar();
    }
}