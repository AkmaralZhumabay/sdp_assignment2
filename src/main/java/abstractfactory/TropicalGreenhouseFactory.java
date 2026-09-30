package abstractfactory;

import product.irrigation.IrrigationSystem;
import product.irrigation.TropicalIrrigation;
import product.climate.ClimateControl;
import product.climate.TropicalClimateControl;
import product.lighting.LightingSystem;
import product.lighting.TropicalLighting;

public class TropicalGreenhouseFactory implements GreenhouseFactory {

    @Override
    public IrrigationSystem createIrrigation() {
        return new TropicalIrrigation();
    }

    @Override
    public ClimateControl createClimateControl() {
        return new TropicalClimateControl();
    }

    @Override
    public LightingSystem createLighting() {
        return new TropicalLighting();
    }
}