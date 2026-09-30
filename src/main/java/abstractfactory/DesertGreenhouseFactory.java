package abstractfactory;

import product.irrigation.DesertIrrigation;
import product.irrigation.IrrigationSystem;
import product.climate.DesertClimateControl;
import product.climate.ClimateControl;
import product.lighting.DesertLighting;
import product.lighting.LightingSystem;

public class DesertGreenhouseFactory implements GreenhouseFactory {

    @Override
    public IrrigationSystem createIrrigation() {
        return new DesertIrrigation();
    }

    @Override
    public ClimateControl createClimateControl() {
        return new DesertClimateControl();
    }

    @Override
    public LightingSystem createLighting() {
        return new DesertLighting();
    }
}