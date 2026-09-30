package abstractfactory;

import product.irrigation.HydroponicIrrigation;
import product.irrigation.IrrigationSystem;
import product.climate.HydroponicClimateControl;
import product.climate.ClimateControl;
import product.lighting.HydroponicLighting;
import product.lighting.LightingSystem;

public class HydroponicGreenhouseFactory implements GreenhouseFactory {

    @Override
    public IrrigationSystem createIrrigation() {
        return new HydroponicIrrigation();
    }

    @Override
    public ClimateControl createClimateControl() {
        return new HydroponicClimateControl();
    }

    @Override
    public LightingSystem createLighting() {
        return new HydroponicLighting();
    }
}