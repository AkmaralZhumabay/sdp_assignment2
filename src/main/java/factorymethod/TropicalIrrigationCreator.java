package factorymethod;

import product.irrigation.IrrigationSystem;
import product.irrigation.TropicalIrrigation;

public class TropicalIrrigationCreator extends IrrigationCreator {

    @Override
    protected IrrigationSystem createIrrigationSystem() {
        return new TropicalIrrigation();
    }
}