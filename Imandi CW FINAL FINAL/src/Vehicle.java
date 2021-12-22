public abstract class Vehicle {
    private String vehiclePlate;                                                                                        //this is the vehicles plate number
    private String vehicleOwner;                                                                                        //this will store the name of the owner of the vehicle
    private DateTime startVehicleTime;                                                                                  //this will have the time and date the vehicle will arrive in the car park
    private DateTime endVehicleTime;                                                                                    //this will store the time and date the vehicle leaves car park
    private String color;                                                                                               //stores the color of the vehicle
    private String vehicleBrand;                                                                                        //stores the brand of vehicle
    private char vehicleType;




    public Vehicle(String vehiclePlate, String vehicleOwner, DateTime startVehicleTime,                                 //this is the constructor for the vehicle class
                   String color, String vehicleBrand, char vehicleType){
        this.vehiclePlate = vehiclePlate;                                                                               //initialises the vehicle plate
        this.vehicleOwner = vehicleOwner;                                                                               //initialises the vehicle owner  
        this.startVehicleTime = startVehicleTime;                                                                       //initialises the starting time and date of vehicle 

        this.color = color;                                                                                             //initialises the color of vehicle 
        this.vehicleBrand = vehicleBrand;                                                                               //initialises the vehicle brand
        this.vehicleType = vehicleType;
    }

    public void setEndVehicleTime(DateTime endVehicleTime) {                                                            //below are the setters and getter methods for the attributes of vehicle class
        this.endVehicleTime = endVehicleTime;                                 
    }

    public String getVehiclePlate() {                                                                                   //getter method for vehicle plate attribute 
        return vehiclePlate;
    }

    public String getVehicleOwner() {                                                                                   //getter method for vehicle owner  attribute                                                                           
        return vehicleOwner;
    }

    public DateTime getStartVehicleTime() {                                                                             //getter method for starting time and date  of vehicle 
        return startVehicleTime;
    }

    public DateTime getEndVehicleTime() {                                                                               //getter method for leaving date and time of vehicle                                                                          
        return endVehicleTime;
    }

    public String getColor() {                                                                                          //getter method for color 
        return color;
    }

    public String getVehicleBrand() {                                                                                   //getter method for vehicle brand 
        return vehicleBrand;
    }

    public char getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(char vehicleType) {
        this.vehicleType = vehicleType;
    }

    @Override
    public String toString() {                                                                                          //this is the string method used to produce an understandable statement so user can understand
        return "Vehicle{" +
                "vehiclePlate='" + vehiclePlate + '\'' +
                ", vehicleOwner='" + vehicleOwner + '\'' +
                ", startVehicleTime=" + startVehicleTime + '\'' +
                ", endVehicleTime=" + endVehicleTime + '\'' +
                ", color='" + color + '\'' +
                ", vehicleBrand='" + vehicleBrand + '\'' +
                ", vehicleType='" + vehicleType + '\'' +
                '}';
    }




    public abstract boolean getNavSystem();                                                                             //abstarct method from car class

    public abstract boolean getEntryAssistHandles();                                                                    //abstract method from minibus class

    public abstract boolean getAuto();                                                                                  //abstract method from mini lorry class

    public abstract boolean getLiquidCooling();                                                                         //abstract method from motorbike class

    public abstract boolean getCurbSideAisle();                                                                         //abstrcact method from van  class


}

