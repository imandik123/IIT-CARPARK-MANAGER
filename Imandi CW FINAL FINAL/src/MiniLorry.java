public class MiniLorry extends Vehicle{

    private Boolean auto;                                                                                               //this attribute belongs to the mini lorry class
    public final static int MiniLorry_SLOT_SPACE = 3;                                                                   //a mini lorry occupies 3 spaces and this is final because it doesnt change

    public MiniLorry(String vehiclePlate, String vehicleOwner, DateTime startVehicleTime, String color,                 //this is the mini lorry constructor
                     String vehicleBrand, Boolean auto, Character vehicleType) {
        super(vehiclePlate, vehicleOwner, startVehicleTime,color, vehicleBrand,vehicleType);                                        //this is the superclass constructor
        this.auto = auto;
    }



    public boolean getAuto() {                                                                                          //this is the getter method for the attribute auto in mini lorry
        return auto;
    }


    public String isAuto() {
        if (auto == true) {
            return "The mini lorry is auto";                                                                             //if the isAuto method is true this statement will be printed
        }else {
            return "The mini lorry isn't auto ";                                                                        //this will be printed if the isAuto method is false
        }
    }

    public static int getMiniLorry_SLOT_SPACE() {                                                                       //this is to obtain the space taken up by mini lorry
        return MiniLorry_SLOT_SPACE;
    }



    @Override
    public String toString() {                                                                                          //this is the toString() method which is used to display the mini lorry object content in a readable format
        return "MiniLorry [auto=" + getAuto() + ", getVehiclePlate()=" + getVehiclePlate() +
                ", getStartVehicleTime()=" + getStartVehicleTime() +", getEndVehicleTime()="+ getEndVehicleTime()
                + ", getColor()=" + getColor() +"]";
    }



    //below methods are overridden methods from other classes

    @Override
    public boolean getLiquidCooling() {                                                                                 //this overridden method is from motorbike class
        return false;
    }

    @Override
    public boolean getCurbSideAisle() {                                                                                 //this method is from the van class
        return false;
    }



    @Override
    public boolean getNavSystem() {                                                                                     //this method is from the car class
        return false;
    }

    @Override
    public boolean getEntryAssistHandles() {                                                                            //this method is from the minibus class
        return false;
    }


}

