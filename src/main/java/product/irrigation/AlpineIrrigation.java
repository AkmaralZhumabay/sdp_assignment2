package product.irrigation;

public class AlpineIrrigation implements IrrigationSystem {

    @Override
    public String family() {
        return "ALPINE";
    }

    @Override
    public int water(int liters) {
        return Math.max(1, liters * 3 / 4);
    }

    @Override
    public String method() {
        return "cool root-zone watering";
    }
}