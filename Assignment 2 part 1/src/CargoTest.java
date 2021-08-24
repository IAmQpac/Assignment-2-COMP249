/*
Christian Jerjian
ID: 40031909
COMP 249
Assignment 2 part 1
 */

import java.util.Random;
import Package.*;

/**
 * The driver class
 */
public class CargoTest {
    /**
     * The main methods which will start the program
     * @param args Arguments to read
     */
    public static void main(String[] args) {


        System.out.println("------Program Starts------");
        System.out.println();

        Truck t = new Truck("Jerome", "Montreal", "Toronto", 1000, 0, "kg");
        System.out.println("New Truck Initiated - Information Disclosure");

        System.out.println("\t a. Driver Name: " + t.getDriverName());
        System.out.println("\t b. Unload Weight: " + t.getUnloadedWeight() + " " + t.getWeightClass());
        System.out.println("\t c. Originating city: " + t.getOriginatingCity());
        System.out.println("\t d. Destination city: " + t.getDestinationCity());

        System.out.println();


        //Generating random integer for tracking Number
        Random random = new Random();

        //Although it is a random Tracking Number. We will always have the appropriate Least Significant Digit
        //Because Package.Package Constructor assures us of that
        MetalCrate mc = new MetalCrate(random.nextInt(1000), 100);
        WoodCrate wc = new WoodCrate(random.nextInt(1000), 80);
        Letter l = new Letter(random.nextInt(1000), 30);
        Box b = new Box(random.nextInt(1000), 38);

        System.out.println("Trying to load the truck with 201 Packages...");
        for (int i = 0; i < 201; i++) {
            switch (i % 4) {
                case 0:
                    t.load(mc);
                    break;
                case 1:
                    t.load(wc);
                    break;
                case 2:
                    t.load(l);
                    break;
                case 3:
                    t.load(b);
                    break;
            }
        }


        System.out.println("---Gross Income---");
        System.out.println("The gross income of the truck is : " + t.getGrossIncome() + "$");

        System.out.println("---Weight---");
        System.out.println("The truck's Unloaded weight is the same at: " + t.getUnloadedWeight() + " " + t.getWeightClass()
                + "\nHowever the truck's loaded weight is : " + t.getGrossWeigth() + " " + t.getWeightClass());

        System.out.println("---Driver and Truck Information---");
        System.out.println("The Truck (driven by " + t.getDriverName() + ") will Drive from " + t.getOriginatingCity() + " to " + t.getDestinationCity() + ".");

        System.out.println("---Unload Truck---");
        for (int i = 0; i < t.getPackages().length; i++) {
            t.unload(t.getPackages(), t.getPackages()[i]);
        }

        System.out.println("\nNow the gross weight and unloaded weight are the same");
        System.out.println("Gross Weight: " + t.getGrossWeigth() + " " +  t.getWeightClass());
        System.out.println("Unloaded Weight: " + t.getUnloadedWeight() + " " + t.getWeightClass());

    }
}
