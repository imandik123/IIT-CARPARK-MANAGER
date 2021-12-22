public class Minibus extends Vehicle{                                                                                   //minibus class extends from abstract class vehicle

    private Boolean entryAssistHandles;                                                                                 //attribute of minibus

    public final static int Minibus_SLOT_SPACE = 3;                                                                     // a minibus occupies three spaces and this doesnt change so we can assib=gn it as final

    public Minibus(String vehiclePlate, String vehicleOwner, DateTime startVehicleTime, String color,                   //this is the minibus constructor
                   String vehicleBrand, Boolean entryAssistHandles, Character vehicleType) {
        super(vehiclePlate, vehicleOwner, startVehicleTime, color, vehicleBrand, vehicleType);
        this.entryAssistHandles = entryAssistHandles;
    }

    public boolean getEntryAssistHandles() {                                                                            //this is the getter method for the attribute of minibus
        return entryAssistHandles;
    }



    //below are the methods overridden from other classes

    @Override
    public boolean getAuto() {                                                                                          //overriden method from mini lorry class
        return false;
    }

    @Override
    public boolean getLiquidCooling() {                                                                                 //overridden method from motorbike class
        return false;
    }

    @Override
    public boolean getCurbSideAisle() {                                                                                 //overriden method from van class
        return false;
    }



    @Override
    public boolean getNavSystem() {                                                                                     //overridden method from car class
        return false;
    }



    public static int getMinibus_SLOT_SPACE() {                                                                         //method used to obtain the space taken up by minibus in car park
        return Minibus_SLOT_SPACE;
    }

    public String hasEntryHandles() {                                                                                   //hasEntryHandles() method used to check if the minibus has entry handles or not
        if (entryAssistHandles == true) {
            return "The minibus has entry assist handles";
        }else {
            return "The minibus does not have entry assist handles";
        }
    }

    @Override
    public String toString() {                                                                                           //the toString() method is used to display the object created in a way that the user understands what object represent
        return "Minibus [entryAssistHandles=" + getEntryAssistHandles() + ", getVehiclePlate()=" +
                getVehiclePlate() + ", getStartVehicleTime()=" +
                getStartVehicleTime() +", getEndVehicleTime()="+ getEndVehicleTime()
                + ", getColor()=" + getColor() +"]";
    }




}
