import abstractfactory.*;
import client.GreenhouseController;
import factorymethod.*;
import product.irrigation.*;
import product.climate.*;
import product.lighting.*;
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
  assertTrue(
          new GreenhouseController(
                  new TropicalGreenhouseFactory()
          ).componentsAreCompatible()
  );
 }

 @Test
 void desertProductsCompatible() {
  assertTrue(
          new GreenhouseController(
                  new DesertGreenhouseFactory()
          ).componentsAreCompatible()
  );
 }

 @Test
 void alpineProductsCompatible() {
  assertTrue(
          new GreenhouseController(
                  new AlpineGreenhouseFactory()
          ).componentsAreCompatible()
  );
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
          new GreenhouseController(
                  new TropicalGreenhouseFactory()
          ).morningPreparation();

  assertTrue(
          result.contains("humidity")
                  && result.contains("light")
  );
 }

 @Test
 void growthCycleUsesAllThreeProducts() {
  String result =
          new GreenhouseController(
                  new DesertGreenhouseFactory()
          ).growthCycle(20);

  assertTrue(result.contains("30%"));
  assertTrue(result.contains("16 hours"));
  assertTrue(result.contains("10L"));
 }

 @Test
 void resourceScoreReflectsFamilyBehavior() {
  assertEquals(
          56,
          new GreenhouseController(
                  new DesertGreenhouseFactory()
          ).dailyResourceScore(20)
  );
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

  assertTrue(
          result.contains("Orchid Zone")
                  && result.contains("20L")
  );
 }

 @Test
 void factoryMethodRejectsBlankZone() {
  assertThrows(
          IllegalArgumentException.class,
          () -> new DesertIrrigationCreator()
                  .runWateringJob("", 20)
  );
 }

 // Part G - fourth product family
 @Test
 void fourthHydroponicFamilyWorks() {
  GreenhouseController app =
          new GreenhouseController(
                  new HydroponicGreenhouseFactory()
          );

  assertTrue(app.componentsAreCompatible());
  assertEquals("HYDROPONIC", app.family());
  assertTrue(app.growthCycle(10).contains("20L"));
 }

 // Part G - runtime selection of fourth family
 @Test
 void runtimeSelectsFourthFamily() {
  assertInstanceOf(
          HydroponicGreenhouseFactory.class,
          FactorySelector.from("hydroponic")
  );
 }

 @Test
 void clientDependsOnAbstraction() {
  GreenhouseFactory factory =
          new TropicalGreenhouseFactory();

  GreenhouseController client =
          new GreenhouseController(factory);

  assertEquals("TROPICAL", client.family());
 }
}