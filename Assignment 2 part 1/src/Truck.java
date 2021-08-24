/*
Christian Jerjian
ID: 40031909
COMP 249
Assignment 2 part 1
 */

import Package.Package;

/**
 *
 */
public class Truck {
//    Assign driver, loaded()  weighted before and after loading, driven and unloaded
    /**
     * Driver's name
     */
    private String driverName;
    /**
     * City of departure
     */
    private String originatingCity;
    /**
     * City of destination
     */
    private String destinationCity;
    /**
     * Weight with packages
     */
    private double grossWeigth;
    /**
     *Weight without packages
     */
    private double unloadedWeight;
    /**
     * Weight class
     */
    private String weightClass;
    /**
     * Number of Packages
     */
    private int nbrPackage;
    /**
     * Maximum amount of package per truck
     */
    private final int MAXPACKAGE = 200;
    /**
     * Package array for truck
     */
    private Package[] packages;
    /**
     * Gross income per loaded truck
     */
    private double grossIncome; //equal to the total shipping costs of the packages


    /**
     * parameterized constructor
     * @param driverName Driver's name
     * @param originatingCity City of departure
     * @param destinationCity city of arival
     * @param unloadedWeight weight without any packages
     * @param nbrPackage number of packages
     * @param weightClass weight class
     */
    public Truck(String driverName, String originatingCity,
                 String destinationCity,
                 double unloadedWeight, int nbrPackage, String weightClass)
    {
        this.driverName = driverName;
        this.originatingCity = originatingCity;
        this.destinationCity = destinationCity;
        this.unloadedWeight = unloadedWeight;
        this.grossWeigth = unloadedWeight;
        this.nbrPackage = nbrPackage;
        this.packages = new Package[MAXPACKAGE];
        this.grossIncome = 0;
        this.weightClass = weightClass;
    }

    /**
     * This class will load the truck with the passed package
     * @param aPackage the passed package
     */
    public void load(Package aPackage){
            try{
                if (aPackage.getWeight() > aPackage.getMaxWeight())
                    throw new PackageTooHeavyException(aPackage);

                if (aPackage.getTrackingNumber() % 10 != 0 &&
                        aPackage.getTrackingNumber() % 10 != 1 &&
                        aPackage.getTrackingNumber() % 10 != 2 &&
                        aPackage.getTrackingNumber() % 10 != 3){
                    throw new PackageNotAllowedException(aPackage);
                }

                if (nbrPackage >= MAXPACKAGE){
                    throw new TruckIsFullException(aPackage);
                }

               //This means that the package can get into the truck, we increase nbr package, gross weight and gross income
               //System.out.println("Loaded " + aPackage.getClass().getName() + " into the truck");
                nbrPackage++;
                grossWeigth += aPackage.toKilogram();
                grossIncome += aPackage.getShippingCost();


                //load aPackage in packages in the latest position
                for (int i = 0; i < packages.length; i++) {
                    if (packages[i] == null){
                        packages[i] = aPackage;
                        break;
                    }
                }

            } catch (PackageTooHeavyException | PackageNotAllowedException | TruckIsFullException e) {
                e.printStackTrace();
            }
    }

    /**
     * Unloading the truck
     * @param packages Package array
     * @param aPackage unloading the package from package array
     */
    //I did the unload this way because maybe they want to unload a specific package from an array of package
    public void unload(Package[] packages , Package aPackage){
        for (int i = 0; i < packages.length; i++) {
            if (aPackage == packages[i]){
                System.out.println("Unloading Package.Package: \t " + aPackage);
                nbrPackage--;
                System.out.println("aPackage weigt = " + aPackage.getWeight());
                grossWeigth -= aPackage.toKilogram();
                packages[i] = null;
                break;
            }
        }
    }

    /**
     * Converting truck weight to kilogram
     * @param weight weight of truck
     */
    public void truckToKilograms(double weight){
        if (this.weightClass.equals("lb")){
            System.out.println("The current weight of the Truck is " + this.getGrossWeigth() + "lb");
            this.setWeightClass("kg");
            this.setGrossWeigth(weight/2.205);
            System.out.println("The new weight of the Truck is " + this.getGrossWeigth() + "kg");
        }else {
            System.out.println("The Truck is already in kg, No need for conversion");
        }
    }

    /**
     * Converting truck to pounds
     * @param a Weight of truck
     */
    public void truckToPounds(double a){
        if (this.weightClass.equals("kg")){
            System.out.println("The current weight of the Truck is " + this.getGrossWeigth() + "kg");
            this.setWeightClass("lb");
            this.setGrossWeigth(a*2.205);
            System.out.println("The new weight of the Truck is " + this.getGrossWeigth() + "lb");
        }else {
            System.out.println("The Truck is already in lb, No need for conversion");
        }

    }

//    GETTERS AND SETTERS

    /**
     * get driver name
     * @return driver name
     */
    public String getDriverName() {
        return driverName;
    }

    /**
     * set driver name
     * @param driverName name of driver
     */
    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    /**
     * get city of origin
     * @return return original city
     */
    public String getOriginatingCity() {
        return originatingCity;
    }

    /**
     * set origin city
     * @param originatingCity original city
     */
    public void setOriginatingCity(String originatingCity) {
        this.originatingCity = originatingCity;
    }

    /**
     *  get destination city
     * @return return destination city
     */
    public String getDestinationCity() {
        return destinationCity;
    }

    /**
     * set Destinating city
     * @param destinationCity city of destination
     */
    public void setDestinationCity(String destinationCity) {
        this.destinationCity = destinationCity;
    }

    /**
     * get gross weight
     * @return gross weight
     */
    public double getGrossWeigth() {
        return grossWeigth;
    }

    /**
     * set Gross Weight
     * @param grossWeigth gross weight
     */
    public void setGrossWeigth(double grossWeigth) {
        this.grossWeigth = grossWeigth;
    }

    /**
     * get unlaoded weight
     * @return unloaded weight
     */
    public double getUnloadedWeight() {
        return unloadedWeight;
    }

    /**
     * set empty truck weight
     * @param unloadedWeight unloaded weight
     */
    public void setUnloadedWeight(double unloadedWeight) {
        this.unloadedWeight = unloadedWeight;
    }

    /**
     * Number of packages
     * @return number of packegs
     */
    public int getNbrPackage() {
        return nbrPackage;
    }

    /**
     * set number of packages
     * @param nbrPackage number of packages
     */
    public void setNbrPackage(int nbrPackage) {
        this.nbrPackage = nbrPackage;
    }

    /**
     * Get maximum packages
     * @return max package number
     */
    public int getMAXPACKAGE() {
        return MAXPACKAGE;
    }

    /**
     * get package array
     * @return package array
     */
    public Package[] getPackages() {
        return packages;
    }

    /**
     * set package array
     * @param packages package array
     */
    public void setPackages(Package[] packages) {
        this.packages = packages;
    }

    /**
     * Get gross income
     * @return gross income
     */
    public double getGrossIncome() {
        return grossIncome;
    }

    /**
     * Set gross income
     * @param grossIncome Gross income
     */
    public void setGrossIncome(double grossIncome) {
        this.grossIncome = grossIncome;
    }

    /**
     * get Weight Class
     * @return weight class
     */
    public String getWeightClass() {
        return weightClass;
    }

    /**
     * Set weight class
     * @param weightClass weight class
     */
    public void setWeightClass(String weightClass) {
        this.weightClass = weightClass;
    }
}


/**
 * Package exception
 */
class PackageException extends Exception{
    /**
     * Constructor
     */
    public PackageException() {
    }
}

/**
 * Package is too heavy
 */
class PackageTooHeavyException extends PackageException{

    /**
     * Parameterized Constructor
     * @param aPackage Heavy package
     */
    public PackageTooHeavyException(Package aPackage) {
        System.err.println("This package is too heavy. " +
                "\n Package.Package Information: " + aPackage);
    }

}

/**
 * Package is not allwoed
 */
class PackageNotAllowedException extends PackageException{
    /**
     * Parameterized constructor
     * @param aPackage Package that is not allowed
     */
    public PackageNotAllowedException(Package aPackage) {
        System.err.println("This package is not allowed (Serial Number does not match Package Class). " +
                "\n Package.Package Information: " + aPackage);
    }
}

/**
 * Truck is full exception
 */
class TruckIsFullException extends PackageException{
    /**
     * Parameterized constructor
     * @param aPackage Package that will not fit the truck
     */
    public TruckIsFullException(Package aPackage) {
        System.err.println("The truck is full." +
                "\n Package.Package Information: " + aPackage);
    }
}


