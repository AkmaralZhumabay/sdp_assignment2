package product.climate;

public class AlpineClimateControl implements ClimateControl {

    @Override
    public String family() {
        return "ALPINE";
    }

    @Override
    public double targetTemperature() {
        return 15.0;
    }

    @Override
    public int targetHumidity() {
        return 55;
    }

    @Override
    public String stabilize() {
        return "Cooling to 15C and maintaining 55% humidity";
    }
}