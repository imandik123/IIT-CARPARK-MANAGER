public class Car extends Vehicle{                                                                                       //car class extends from abstract class vehicle

                                                                                                                        //attribute of car
    private Boolean navSystem;

    public final static int CAR_SLOT_SPACE = 1;                                                                         // a car takes only one car slot space and this doesnt change so we put it as final

    public Car(String vehiclePlate, String vehicleOwner, DateTime startVehicleTime,  String color,                      //car class constructor
               String vehicleBrand, Boolean navSystem, char vehicleType) {
        super(vehiclePlate, vehicleOwner, startVehicleTime, color, vehicleBrand, vehicleType);                                       //the super class constructor(bvehicle class constructor)
        this.navSystem = navSystem;

    }

    public boolean getNavSystem() {                                                                                     //this is the getter for the navigation system attribute of car
        return navSystem;
    }




    //below are the methods overriden from other classes

    @Override                                                                                                           //override method from minibus class
    public boolean getEntryAssistHandles() {
        return false;
    }

    @Override                                                                                                           //override method from mini lorry class
    public boolean getAuto() {
        return false;
    }

    @Override                                                                                                           //override method from motorbike class
    public boolean getLiquidCooling() {
        return false;
    }

    @Override                                                                                                           //override method from van class
    public boolean getCurbSideAisle() {
        return false;
    }


    public static int getCarSlotSpace() {                                                                               //getter method to obtain car slot space
        return CAR_SLOT_SPACE;
    }

    public String hasNav() {                                                                                            //this method is used to see if the car has or doesnt have a navigation system
        if (navSystem == true) {
            return "This car has a navigation system";                                                                  // hasNav() method will return this statement if car has a nav system
        } else {
            return "This car does not have a navigation system";                                                        // hasNav() method will return this statement if car does not have a nav system
        }
    }


    //toString overriden method to produce the car object in an understandable format to the user
    @Override
    public String toString() {
        return "Car [navSystem=" + getNavSystem() + ", getVehiclePlate()=" + getVehiclePlate() + ", getStartVehicleTime()=" +
                getStartVehicleTime() +", getEndVehicleTime()="+ getEndVehicleTime() + ", getColor()=" + getColor() +"]";
    }




}

