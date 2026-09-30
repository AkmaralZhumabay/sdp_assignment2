package selector;

import abstractfactory.AlpineGreenhouseFactory;
import abstractfactory.DesertGreenhouseFactory;
import abstractfactory.GreenhouseFactory;
import abstractfactory.TropicalGreenhouseFactory;

public final class FactorySelector {

    private FactorySelector() {
    }

    public static GreenhouseFactory from(String family) {

        if (family == null) {
            throw new IllegalArgumentException("Family is required");
        }

        return switch (family.trim().toLowerCase()) {
            case "tropical" -> new TropicalGreenhouseFactory();
            case "desert" -> new DesertGreenhouseFactory();
            case "alpine" -> new AlpineGreenhouseFactory();

            default -> throw new IllegalArgumentException(
                    "Unknown family: " + family
            );
        };
    }
}