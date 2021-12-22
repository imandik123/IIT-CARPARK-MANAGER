public class Motorbike extends Vehicle{

    private Boolean liquidCooling;                                                                                      //this is the attribute of motorbike
    public final static int Motorbike_SLOT_SPACE = 1/3;                                                                 //this shows how much space a motorbike occupies and this is final because it doesnt change at anytime

    public Motorbike(String vehiclePlate, String vehicleOwner, DateTime startVehicleTime,                               //this is the constructor of motorbike class
                     String color, String vehicleBrand, Boolean liquidCooling, Character vehicleType) {
        super(vehiclePlate, vehicleOwner, startVehicleTime,color, vehicleBrand, vehicleType);                                        //this calls the super class constructor and the super class attributes are initiallised
        this.liquidCooling = liquidCooling;
    }

    public boolean getLiquidCooling() {                                                                                 //this is the getter method of liquidCooling
        return liquidCooling;
    }


    public static int getMotorbike_SLOT_SPACE() {                                                                       //this method is used to obtain the space taken up by a motorbike
        return Motorbike_SLOT_SPACE;
    }


    public String hasCooling() {                                                                                        //this method is used to see whether or not the motorbike has cooling
        if (liquidCooling == true) {
            return "The motorbike has liquid cooling";                                                                  //if the motorbike has cooling this statement will be returned
        }else {
            return "The motorbike has no liquid cooling";                                                               //this statement will be returned if the motorbike doesnt have cooling
        }
    }



    @Override
    public String toString() {                                                                                          //the toString method is used to dsplay contents of the motorbike object in an understandable format
        return "Motorbike [liquidCooling=" + getLiquidCooling() + ", getVehiclePlate()=" + getVehiclePlate() + ", getStartVehicleTime()=" +
                getStartVehicleTime() +", getEndVehicleTime()="+ getEndVehicleTime() + ", getColor()=" + getColor() +"]";
    }




    //the below overridden methods are methods  from other classes

    @Override
    public boolean getCurbSideAisle() {                                                                                 //this method is taken from van class
        return false;
    }



    @Override
    public boolean getNavSystem() {                                                                                     //this method is taken from car class
        return false;
    }

    @Override
    public boolean getEntryAssistHandles() {                                                                            //this method is taken minibus class
        return false;
    }

    @Override
    public boolean getAuto() {                                                                                          //this method is taken from mini lorry class
        return false;
    }



}

