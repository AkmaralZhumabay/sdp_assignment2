package factorymethod;

import product.irrigation.IrrigationSystem;

public abstract class IrrigationCreator {

 protected abstract IrrigationSystem createIrrigationSystem();

 public String runWateringJob(String zone, int liters) {

  if (zone == null || zone.isBlank()) {
   throw new IllegalArgumentException("Zone is required");
  }

  if (liters <= 0) {
   throw new IllegalArgumentException("Liters must be positive");
  }

  IrrigationSystem system = createIrrigationSystem();
  int delivered = system.water(liters);

  return system.family()
          + " watering for "
          + zone
          + ": "
          + delivered
          + "L using "
          + system.method();
 }
}