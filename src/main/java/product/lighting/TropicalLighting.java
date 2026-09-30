package product.lighting;

public class TropicalLighting implements LightingSystem {

    @Override
    public String family() {
        return "TROPICAL";
    }

    @Override
    public int lightHours() {
        return 14;
    }

    @Override
    public int intensityPercent() {
        return 75;
    }

    @Override
    public String illuminate() {
        return "Warm full-spectrum light for 14 hours at 75%";
    }
}