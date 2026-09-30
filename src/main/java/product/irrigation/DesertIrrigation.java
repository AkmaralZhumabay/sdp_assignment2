package product.irrigation;

public class DesertIrrigation implements IrrigationSystem {

    @Override
    public String family() {
        return "DESERT";
    }

    @Override
    public int water(int liters) {
        return Math.max(1, liters / 2);
    }

    @Override
    public String method() {
        return "slow drip with water conservation";
    }
}