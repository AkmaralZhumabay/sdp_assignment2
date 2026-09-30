package product.climate;

public class HydroponicClimateControl implements ClimateControl {

    @Override
    public String family() {
        return "HYDROPONIC";
    }

    @Override
    public double targetTemperature() {
        return 23.0;
    }

    @Override
    public int targetHumidity() {
        return 65;
    }

    @Override
    public String stabilize() {
        return "Holding 23C and 65% humidity for nutrient uptake";
    }
}