package factorymethod;

import product.irrigation.AlpineIrrigation;
import product.irrigation.IrrigationSystem;

public class AlpineIrrigationCreator extends IrrigationCreator {

    @Override
    protected IrrigationSystem createIrrigationSystem() {
        return new AlpineIrrigation();
    }
}