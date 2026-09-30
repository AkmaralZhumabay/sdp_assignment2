package product.lighting;

public class AlpineLighting implements LightingSystem {

    @Override
    public String family() {
        return "ALPINE";
    }

    @Override
    public int lightHours() {
        return 12;
    }

    @Override
    public int intensityPercent() {
        return 60;
    }

    @Override
    public String illuminate() {
        return "Cool alpine daylight for 12 hours at 60%";
    }
}