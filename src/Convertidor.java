import java.util.Map;

public class Convertidor {
    private Map<String, TasaCambio> tasasCambio;

    public void setTasasCambio(Map<String, TasaCambio> tasasCambio) {
        this.tasasCambio = tasasCambio;
    }

    public double convertir(String monedaOrigen, String monedaDestino, double cantidad) {
        double tasaOrigen = tasasCambio.get(monedaOrigen).getTasa();
        double tasaDestino = tasasCambio.get(monedaDestino).getTasa();
        return (cantidad / tasaOrigen) * tasaDestino;
    }
}