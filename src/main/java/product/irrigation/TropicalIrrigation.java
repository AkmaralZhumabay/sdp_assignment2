package product.irrigation;

public class TropicalIrrigation implements IrrigationSystem {

    @Override
    public String family() {
        return "TROPICAL";
    }

    @Override
    public int water(int liters) {
        return liters;
    }

    @Override
    public String method() {
        return "fine mist and frequent watering";
    }
}