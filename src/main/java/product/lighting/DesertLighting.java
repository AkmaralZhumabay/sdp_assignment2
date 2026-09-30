package product.lighting;

public class DesertLighting implements LightingSystem {

    @Override
    public String family() {
        return "DESERT";
    }

    @Override
    public int lightHours() {
        return 16;
    }

    @Override
    public int intensityPercent() {
        return 95;
    }

    @Override
    public String illuminate() {
        return "High-intensity desert light for 16 hours at 95%";
    }
}