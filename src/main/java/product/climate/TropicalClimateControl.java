package product.climate;

public class TropicalClimateControl implements ClimateControl {

    @Override
    public String family() {
        return "TROPICAL";
    }

    @Override
    public double targetTemperature() {
        return 28.0;
    }

    @Override
    public int targetHumidity() {
        return 80;
    }

    @Override
    public String stabilize() {
        return "Heating to 28C and maintaining 80% humidity";
    }
}