import abstractfactory.AlpineGreenhouseFactory;
import abstractfactory.DesertGreenhouseFactory;
import abstractfactory.GreenhouseFactory;
import abstractfactory.TropicalGreenhouseFactory;

import client.GreenhouseController;

import factorymethod.DesertIrrigationCreator;
import factorymethod.TropicalIrrigationCreator;

import product.irrigation.AlpineIrrigation;
import product.irrigation.DesertIrrigation;
import product.irrigation.TropicalIrrigation;

import product.climate.AlpineClimateControl;
import product.climate.DesertClimateControl;
import product.climate.TropicalClimateControl;

import product.lighting.AlpineLighting;
import product.lighting.DesertLighting;
import product.lighting.TropicalLighting;

import selector.FactorySelector;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GreenhouseTest {

 @Test
 void tropicalFamilyCreatesCorrectProducts() {
  var factory = new TropicalGreenhouseFactory();

  assertInstanceOf(TropicalIrrigation.class, factory.createIrrigation());
  assertInstanceOf(TropicalClimateControl.class, factory.createClimateControl());
  assertInstanceOf(TropicalLighting.class, factory.createLighting());
 }

 @Test
 void desertFamilyCreatesCorrectProducts() {
  var factory = new DesertGreenhouseFactory();

  assertInstanceOf(DesertIrrigation.class, factory.createIrrigation());
  assertInstanceOf(DesertClimateControl.class, factory.createClimateControl());
  assertInstanceOf(DesertLighting.class, factory.createLighting());
 }

 @Test
 void alpineFamilyCreatesCorrectProducts() {
  var factory = new AlpineGreenhouseFactory();

  assertInstanceOf(AlpineIrrigation.class, factory.createIrrigation());
  assertInstanceOf(AlpineClimateControl.class, factory.createClimateControl());
  assertInstanceOf(AlpineLighting.class, factory.createLighting());
 }

 @Test
 void tropicalProductsCompatible() {
  GreenhouseController app =
          new GreenhouseController(new TropicalGreenhouseFactory());

  assertTrue(app.componentsAreCompatible());
 }

 @Test
 void desertProductsCompatible() {
  GreenhouseController app =
          new GreenhouseController(new DesertGreenhouseFactory());

  assertTrue(app.componentsAreCompatible());
 }

 @Test
 void alpineProductsCompatible() {
  GreenhouseController app =
          new GreenhouseController(new AlpineGreenhouseFactory());

  assertTrue(app.componentsAreCompatible());
 }

 @Test
 void runtimeSelectsTropical() {
  assertInstanceOf(
          TropicalGreenhouseFactory.class,
          FactorySelector.from("tropical")
  );
 }

 @Test
 void runtimeSelectsDesertIgnoringCase() {
  assertInstanceOf(
          DesertGreenhouseFactory.class,
          FactorySelector.from("DESERT")
  );
 }

 @Test
 void runtimeSelectsAlpine() {
  assertInstanceOf(
          AlpineGreenhouseFactory.class,
          FactorySelector.from("alpine")
  );
 }

 @Test
 void morningPreparationUsesMultipleProducts() {
  String result =
          new GreenhouseController(new TropicalGreenhouseFactory())
                  .morningPreparation();

  assertTrue(result.contains("humidity"));
  assertTrue(result.contains("light"));
 }

 @Test
 void growthCycleUsesAllThreeProducts() {
  String result =
          new GreenhouseController(new DesertGreenhouseFactory())
                  .growthCycle(20);

  assertTrue(result.contains("30%"));
  assertTrue(result.contains("16 hours"));
  assertTrue(result.contains("10L"));
 }

 @Test
 void resourceScoreReflectsFamilyBehavior() {
  int score =
          new GreenhouseController(new DesertGreenhouseFactory())
                  .dailyResourceScore(20);

  assertEquals(56, score);
 }

 @Test
 void unknownRuntimeFamilyRejected() {
  assertThrows(
          IllegalArgumentException.class,
          () -> FactorySelector.from("ocean")
  );
 }

 @Test
 void invalidWaterAmountRejected() {
  assertThrows(
          IllegalArgumentException.class,
          () -> new GreenhouseController(
                  new AlpineGreenhouseFactory()
          ).growthCycle(0)
  );
 }

 @Test
 void factoryMethodRunsBusinessWorkflow() {
  String result =
          new TropicalIrrigationCreator()
                  .runWateringJob("Orchid Zone", 20);

  assertTrue(result.contains("Orchid Zone"));
  assertTrue(result.contains("20L"));
 }

 @Test
 void factoryMethodRejectsBlankZone() {
  assertThrows(
          IllegalArgumentException.class,
          () -> new DesertIrrigationCreator()
                  .runWateringJob("", 20)
  );
 }

 @Test
 void clientDependsOnAbstraction() {
  GreenhouseFactory factory = new TropicalGreenhouseFactory();

  GreenhouseController client =
          new GreenhouseController(factory);

  assertEquals("TROPICAL", client.family());
 }
}