# Assignment 2 — Factory Method & Abstract Factory

**Student:** Akmaral Zhumabay  
**Group:** SE-2517  
**Domain:** Smart Greenhouse Management System

## 1. Project Overview

This project demonstrates the **Factory Method** and **Abstract Factory** design patterns using a Smart Greenhouse Management System.

The system contains three product types:

- `IrrigationSystem`
- `ClimateControl`
- `LightingSystem`

The original system contains three product families:

- Tropical
- Desert
- Alpine

A fourth family, **Hydroponic**, was added later to demonstrate extensibility.

---

## 2. Part A — Initial Version Without Factories

The project first contains a legacy implementation where concrete products are created directly.

This approach demonstrates several design problems:

1. The client depends directly on concrete classes.
2. Object creation requires `if/else` logic.
3. Adding another family requires modifying existing creation code.
4. Creation logic can become duplicated.
5. Products from different families can accidentally be combined.

This initial implementation is preserved in the `legacy` package and in the Git history.

---

## 3. Factory Method

The Factory Method pattern is used for the irrigation workflow.

`IrrigationCreator` defines a factory method for creating an `IrrigationSystem`.

Concrete creators decide which irrigation implementation should be created.

The creator also contains business logic for performing an irrigation operation, so its responsibility is not limited to simply creating an object.

### Why is this Factory Method?

It uses **inheritance and polymorphism**.

The base creator defines the workflow, while subclasses override the factory method to determine which concrete product is used.

Therefore, object creation is delegated to subclasses instead of being handled by one static factory method.

---

## 4. Abstract Factory

`GreenhouseFactory` is the Abstract Factory.

It provides methods for creating three related products:

- `IrrigationSystem`
- `ClimateControl`
- `LightingSystem`

The original concrete factories are:

- `TropicalGreenhouseFactory`
- `DesertGreenhouseFactory`
- `AlpineGreenhouseFactory`

Each factory produces products belonging to the same greenhouse family.

The fourth factory added later is:

- `HydroponicGreenhouseFactory`

---

## 5. Product Family Compatibility

Products belonging to the same family are designed to work together.

For example:

```text
Tropical Irrigation
        +
Tropical Climate Control
        +
Tropical Lighting
        =
Compatible Tropical Greenhouse
```

The `GreenhouseController` receives only one `GreenhouseFactory`.

It then obtains irrigation, climate control, and lighting from that same factory.

Because the client does not independently choose the three concrete products, normal business code cannot accidentally create combinations such as:

```text
Tropical Irrigation
+ Desert Climate Control
+ Alpine Lighting
```

This guarantees family consistency through the architecture instead of checking the family afterward with an exception.

---

## 6. Runtime Factory Selection

The greenhouse family is selected at runtime through `FactorySelector`.

The application can select:

```text
tropical
desert
alpine
hydroponic
```

After the factory has been selected, the main business logic works through the `GreenhouseFactory` abstraction.

It does not need to know which concrete family is currently being used.

---

## 7. Business Operations

`GreenhouseController` contains realistic operations that coordinate multiple greenhouse products.

### Morning Preparation

Coordinates climate control and lighting to prepare the greenhouse for daytime operation.

### Growth Cycle

Coordinates climate control, lighting, and irrigation during the plant growth process.

### Daily Resource Score

Uses information from the greenhouse systems to calculate an operational resource score.

These operations demonstrate collaboration between products instead of simply calling individual `show()` methods.

---

## 8. Adding the Fourth Family

The fourth product family is **Hydroponic**.

The extension adds Hydroponic implementations for:

- Irrigation
- Climate Control
- Lighting

It also adds:

- `HydroponicGreenhouseFactory`

The runtime selector was extended so that `hydroponic` can be selected.

The existing `GreenhouseController` and its business operations did **not** need to be rewritten.

This demonstrates that the architecture is extensible and follows the Open/Closed Principle.

---

## 9. Automated Tests

The project contains **19 JUnit 5 automated tests**.

The tests cover:

- Tropical family creation
- Desert family creation
- Alpine family creation
- Hydroponic family creation
- Correct concrete product creation
- Product-family compatibility
- Runtime factory selection
- Factory Method behavior
- Business operations
- Negative scenarios
- Fourth-family extension
- Client use through abstractions

The tests verify behavior rather than testing only constructors or getters.

---

## 10. Project Structure

```text
src/
├── main/
│   └── java/
│       ├── legacy/
│       ├── product/
│       │   ├── climate/
│       │   ├── irrigation/
│       │   └── lighting/
│       ├── factorymethod/
│       ├── abstractfactory/
│       ├── client/
│       ├── selector/
│       └── Main.java
│
└── test/
    └── java/
        └── automated tests

README.md
UML.puml
pom.xml
```

---

## 11. Git Development History

The project was developed incrementally:

1. Initial greenhouse system without factories
2. Product abstractions and original greenhouse families
3. Factory Method for irrigation workflows
4. Abstract Factory for greenhouse families
5. Greenhouse business operations
6. Runtime greenhouse family selection
7. Compatibility and business behavior tests
8. Hydroponic product family extension
9. Hydroponic automated tests
10. UML diagram and project documentation

This history demonstrates the transition from direct object creation to Factory Method and Abstract Factory, followed by the addition of a new product family.