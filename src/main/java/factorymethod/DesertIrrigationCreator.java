package factorymethod;

import product.irrigation.DesertIrrigation;
import product.irrigation.IrrigationSystem;

public class DesertIrrigationCreator extends IrrigationCreator {

    @Override
    protected IrrigationSystem createIrrigationSystem() {
        return new DesertIrrigation();
    }
}