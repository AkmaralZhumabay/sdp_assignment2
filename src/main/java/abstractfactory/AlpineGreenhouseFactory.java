package abstractfactory;

import product.irrigation.AlpineIrrigation;
import product.irrigation.IrrigationSystem;
import product.climate.AlpineClimateControl;
import product.climate.ClimateControl;
import product.lighting.AlpineLighting;
import product.lighting.LightingSystem;

public class AlpineGreenhouseFactory implements GreenhouseFactory {

    @Override
    public IrrigationSystem createIrrigation() {
        return new AlpineIrrigation();
    }

    @Override
    public ClimateControl createClimateControl() {
        return new AlpineClimateControl();
    }

    @Override
    public LightingSystem createLighting() {
        return new AlpineLighting();
    }
}