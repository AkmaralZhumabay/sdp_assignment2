package client;

import abstractfactory.GreenhouseFactory;
import product.irrigation.IrrigationSystem;
import product.climate.ClimateControl;
import product.lighting.LightingSystem;

public class GreenhouseController {

 private final IrrigationSystem irrigation;
 private final ClimateControl climate;
 private final LightingSystem lighting;

 public GreenhouseController(GreenhouseFactory factory) {
  if (factory == null) {
   throw new IllegalArgumentException("Factory is required");
  }

  irrigation = factory.createIrrigation();
  climate = factory.createClimateControl();
  lighting = factory.createLighting();
 }

 public String morningPreparation() {
  return climate.stabilize()
          + "; "
          + lighting.illuminate();
 }

 public String growthCycle(int liters) {
  if (liters <= 0) {
   throw new IllegalArgumentException("Liters must be positive");
  }

  return "Cycle: "
          + climate.stabilize()
          + "; "
          + lighting.illuminate()
          + "; delivered "
          + irrigation.water(liters)
          + "L by "
          + irrigation.method();
 }

 public int dailyResourceScore(int liters) {
  if (liters <= 0) {
   throw new IllegalArgumentException("Liters must be positive");
  }

  return irrigation.water(liters)
          + lighting.lightHours()
          + climate.targetHumidity();
 }

 public String family() {
  return irrigation.family();
 }

 public boolean componentsAreCompatible() {
  return irrigation.family().equals(climate.family())
          && climate.family().equals(lighting.family());
 }
}