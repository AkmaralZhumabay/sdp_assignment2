package product.irrigation;

public class HydroponicIrrigation implements IrrigationSystem {

    @Override
    public String family() {
        return "HYDROPONIC";
    }

    @Override
    public int water(int liters) {
        return liters * 2;
    }

    @Override
    public String method() {
        return "recirculating nutrient solution";
    }
}