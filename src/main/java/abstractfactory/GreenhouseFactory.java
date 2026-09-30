package abstractfactory;

import product.irrigation.IrrigationSystem;
import product.climate.ClimateControl;
import product.lighting.LightingSystem;

public interface GreenhouseFactory {

    IrrigationSystem createIrrigation();

    ClimateControl createClimateControl();

    LightingSystem createLighting();
}