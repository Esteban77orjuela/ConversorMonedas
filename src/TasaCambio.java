public class TasaCambio {
    private String moneda;
    private double tasa;

    public TasaCambio(String moneda, double tasa) {
        this.moneda = moneda;
        this.tasa = tasa;
    }

    public String getMoneda() {
        return moneda;
    }

    public double getTasa() {
        return tasa;
    }
}