import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;

public class APIClient {
    private static final String API_KEY = "a1988466fff3c657f9250f9f";
    private static final String API_URL = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/latest/USD";

    public Map<String, TasaCambio> obtenerTasasCambio() throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(API_URL))
                .build();

        System.out.println("Realizando solicitud a: " + API_URL);
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println("Código de estado: " + response.statusCode());

        if (response.statusCode() == 200) {
            return procesarRespuesta(response.body());
        } else {
            throw new RuntimeException("Error al obtener las tasas de cambio. Código de estado: " + response.statusCode());
        }
    }

    private Map<String, TasaCambio> procesarRespuesta(String responseBody) {
        Gson gson = new Gson();
        JsonObject jsonObject = gson.fromJson(responseBody, JsonObject.class);
        String result = jsonObject.get("result").getAsString();

        if ("success".equals(result)) {
            JsonObject rates = jsonObject.getAsJsonObject("conversion_rates");
            Map<String, TasaCambio> tasasCambio = new HashMap<>();

            tasasCambio.put("ARS", new TasaCambio("ARS", rates.get("ARS").getAsDouble()));
            tasasCambio.put("BOB", new TasaCambio("BOB", rates.get("BOB").getAsDouble()));
            tasasCambio.put("BRL", new TasaCambio("BRL", rates.get("BRL").getAsDouble()));
            tasasCambio.put("CLP", new TasaCambio("CLP", rates.get("CLP").getAsDouble()));
            tasasCambio.put("COP", new TasaCambio("COP", rates.get("COP").getAsDouble()));
            tasasCambio.put("USD", new TasaCambio("USD", 1.0));

            System.out.println("Tasas de cambio obtenidas con éxito.");
            return tasasCambio;
        } else {
            throw new RuntimeException("La API respondió con un resultado no exitoso: " + result);
        }
    }
}

// Pregunta si ese debe ser el orden usual para crear apis