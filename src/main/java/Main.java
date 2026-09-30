import client.GreenhouseController;
import selector.FactorySelector;

public class Main {

    public static void main(String[] args) {

        String family = args.length > 0 ? args[0] : "tropical";

        GreenhouseController app =
                new GreenhouseController(FactorySelector.from(family));

        System.out.println("Selected family: " + app.family());
        System.out.println(app.morningPreparation());
        System.out.println(app.growthCycle(20));
        System.out.println("Resource score: " + app.dailyResourceScore(20));
    }
}