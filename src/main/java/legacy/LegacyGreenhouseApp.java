package legacy;

import product.irrigation.*;
import product.climate.*;
import product.lighting.*;

public class LegacyGreenhouseApp {

 public String run(String family) {
  IrrigationSystem irrigation;
  ClimateControl climate;
  LightingSystem lighting;

  if ("tropical".equalsIgnoreCase(family)) {
   irrigation = new TropicalIrrigation();
   climate = new TropicalClimateControl();
   lighting = new TropicalLighting();

  } else if ("desert".equalsIgnoreCase(family)) {
   irrigation = new DesertIrrigation();
   climate = new DesertClimateControl();
   lighting = new DesertLighting();

  } else if ("alpine".equalsIgnoreCase(family)) {
   irrigation = new AlpineIrrigation();
   climate = new AlpineClimateControl();
   lighting = new AlpineLighting();

  } else {
   throw new IllegalArgumentException("Unknown family: " + family);
  }

  return climate.stabilize()
          + "; "
          + lighting.illuminate()
          + "; "
          + irrigation.water(20)
          + "L";
 }

    /* Problems: Client directly depends on concrete product classes;
    Large if/else is required to select a family.
    Adding a new family requires modifying this class.
    Creation logic can easily be duplicated.
    Products from different families could accidentally be mixed. */
}