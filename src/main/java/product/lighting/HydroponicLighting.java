package product.lighting;

public class HydroponicLighting implements LightingSystem {

    @Override
    public String family() {
        return "HYDROPONIC";
    }

    @Override
    public int lightHours() {
        return 18;
    }

    @Override
    public int intensityPercent() {
        return 85;
    }

    @Override
    public String illuminate() {
        return "LED grow spectrum for 18 hours at 85%";
    }
}