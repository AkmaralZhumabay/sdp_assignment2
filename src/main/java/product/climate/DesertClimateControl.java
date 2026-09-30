package product.climate;

public class DesertClimateControl implements ClimateControl {

    @Override
    public String family() {
        return "DESERT";
    }

    @Override
    public double targetTemperature() {
        return 32.0;
    }

    @Override
    public int targetHumidity() {
        return 30;
    }

    @Override
    public String stabilize() {
        return "Heating to 32C and maintaining dry 30% humidity";
    }
}