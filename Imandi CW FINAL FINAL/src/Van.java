public class Van extends Vehicle{

    private Boolean curbSideAisle;                                                                                      //this is the attribute of van class
    public final static int VAN_SLOT_SPACE = 2;                                                                         //this shows how much space is occupied by van and since for every van it will be the same this value will not be changed

    public Van(String vehiclePlate, String vehicleOwner, DateTime startVehicleTime,                                     //this is the van class constructor
               String color, String vehicleBrand, Boolean curbSideAisle, Character vehicleType) {
        super(vehiclePlate, vehicleOwner, startVehicleTime,color, vehicleBrand, vehicleType);                                        //this calls the super class constructor and initialises the super class attributes
        this.curbSideAisle = curbSideAisle;
    }

    public boolean getCurbSideAisle() {                                                                                 //getter method for attribute of van class
        return curbSideAisle;
    }

    public static int getVanSlotSpace() {                                                                               //this method is used to obtain the the van slot space
        return VAN_SLOT_SPACE;
    }

    public String hasCurbAisle() {                                                                                      //method used to check if van has a curb side aisle or not
        if (curbSideAisle == true) {
            return "This van has a curb side aisle";                                                                    //this statement will be returned if vsn has  a curb side aisle
        }else {
            return "This van does not have a curb side aisle";                                                          //this statement will be returned if van doesnt have a curb side aisle
        }
    }

    @Override
    public String toString() {                                                                                          //the toString() method allows the details of van to be printed in a way that the user can understand
        return "Van [curbSideAisle=" + getCurbSideAisle() + ", getVehiclePlate()=" + getVehiclePlate()
                + ", getStartVehicleTime()=" + getStartVehicleTime() +", getEndVehicleTime()="+ getEndVehicleTime()
                + ", getColor()=" + getColor() +"]";
    }





//these are overridden methods which are been used by other classes

    @Override
    public boolean getNavSystem() {                                                                                     //this method is from car class
        return false;
    }

    @Override
    public boolean getEntryAssistHandles() {                                                                            //this method is from minibus class
        return false;
    }

    @Override
    public boolean getAuto() {                                                                                          //this method is from mini lorry class
        return false;
    }

    @Override
    public boolean getLiquidCooling() {                                                                                 //this method is from motorbike class
        return false;
    }









}