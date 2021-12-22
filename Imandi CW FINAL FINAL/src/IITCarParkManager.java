
import java.util.ArrayList;                                                                                                 //arraylist been imported using this call
import java.util.Scanner;                                                                                                   //in order to use scanner we need to import using this statement


public class IITCarParkManager implements CarParkManager {

    private ArrayList<Vehicle> parkSpots = new ArrayList<Vehicle>();                                                        //parkSpots is an arraylist of vehicles

    static Scanner sc = new Scanner(System.in);

    public ArrayList<Integer> days = new ArrayList<>();                                                                                 //this list is used to store all the days that are been inputted
    public ArrayList<Integer> months = new ArrayList<>();                                                                               //this list is used to store all the months that are been inputted
    public ArrayList<Integer> years = new ArrayList<>();                                                                                //this list is used to store all the years that are been inputted
    private ArrayList<Vehicle> carArray = new ArrayList<Vehicle>();                                                                     //carArray will contain the cars which came to car park
    private ArrayList<Vehicle> minibusArray = new ArrayList<Vehicle>();                                                                 //minibusArray will contain the minibuses which came to car park
    private ArrayList<Vehicle> minilorryArray = new ArrayList<Vehicle>();                                                               //minilorryArray will contain the mini lorries which came to car park
    private ArrayList<Vehicle> motorbikeArray = new ArrayList<Vehicle>();                                                               //motorbikeArray will contain the motorbikes which came to car park
    private ArrayList<Vehicle> vanArray = new ArrayList<Vehicle>();                                                                     //vanArray will contain the vans which came to car park
    public int carCount = 0;                                                                                                            //carCount stores the number of cars in car park
    public int minibusCount = 0;                                                                                                        //minibusCount stores the number of minibuses in car park
    public int miniLorryCount = 0;                                                                                                      //miniLorryCount stores the number of mini lorries in car park
    public int motorBikeCount = 0;                                                                                                      //motorBikeCount stores the number of motorbikes in car park
    public int vanCount = 0;                                                                                                            //vanCount stores the number of vans in car park
    public int totalSpots = 360;                                                                                                        //totalSpots is used to store the number of slots in car park

    public static void main(String[] args) {

        IITCarParkManager carPark = new IITCarParkManager();                                                                            // an object of IITCarParkManager is created here
        System.out.println("Welcome to the IIT Car park manager programmed by Imandi Karunaratne");
        System.out.println("We are happy to have you . Have a good day ");

        while (true) {

            System.out.println(".....................................................\n");

            System.out.println("pick a letter from the list to fulfill your requirement\n");
            System.out.println("To add a new vehicle in the parking space press A");                                                    //adding vehicle
            System.out.println("To delete a vehicle in the parking space  press D");                                                    //removing vehicle
            System.out.println("To print the vehicles currently parked press V");                                                       //carpark list
            System.out.println("To print some statistics of vehicle press the below letters : ");
            System.out.println(" X : To see the longest vehicle which was parked");                                                     //longest vehicle
            System.out.println(" Z : To see the last vehicle which was parked ");                                                       //last vehicle
            System.out.println(" Y : To see the percentage of different types of vehicles currently parked  ");                         //percentage of vehicle types
            System.out.println(" G : To print the list of vehicles, which was entered in the parking space  on a specified day  ");     //specific day , list of vehicles in car park
            System.out.println(" P : To display on screen the parking charges for each customer who parked in car park ");              //parking charges for every customer who parked
            System.out.println("To quit the IIT CarParkManager Program press Q");                                                       //quit program

            System.out.println(".....................................................\n");

            char customerInput = getCustomerInput();                                                                                    //customerInput will be a char of the above letters (A,D,V,X,Z,Y,G,P,Q) if entered correctly
            System.out.println("the customer input is : " + customerInput);                                                             //prints customers choice on screen
            switch (customerInput) {
                case 'A':

                    carPark.addVehicle();                                                                                                 //This calls the  addVehicle()  method to add a vehicle of customer choice
                    break;

                case 'D':

                    System.out.println("\nWe have removed the vehicle.Now the number of occupied slots is  : " + carPark.vehicleOut());   //this calls the vehicleOut()  method to remove a vehicle out of car park
                    break;

                case 'V':
                    carPark.viewCarParkList();                                                                                           //This calls the viewCarParkList()  method to print the vehicle list currently parked
                    break;

                case 'Q':
                    clearManager();                                                                                                    //This calls the clearManager()  method which will stop the IITCarParkManager
                    System.out.println("IIT Car park manager has succesfully been terminated");
                    System.out.println("Thank You for using this program. Hope you enjoyed as much as we did!");
                    System.exit(0);
                    break;

                case 'X':
                    carPark.longestVehicle();                                                                                         //This calls the longestVehicle() method which will give the vehicle which was parked the longest
                    break;

                case 'Y':
                    carPark.printPercentageOfVehicles();                                                                             //This call the printPercentageOfVehicles() method which will print the percentages of each vehicle parked
                    break;

                case 'Z':
                    carPark.lastVehicle();                                                                                          //This calls the lastVehicle() method which will give the vehicle which was entered last to car park
                    break;

                case 'G':
                    carPark.carListPerDay();                                                                                        //This calls the carListPerDay() method which will give the the list of vehicles which entered  the car park  on a specified day
                    break;

                case 'P':
                    carPark.payTicket();                                                                                            //This calls the payTicket() method which will give the pay charge of vehicle
                    break;

                case '~':
                    System.out.println("\nYou have entered an invalid input . Please enter a letter in the range as shown above");
                    break;

                default:
                    System.out.println("\nYou have entered an invalid input . Please enter again to experience our customer service to the fullest");
                    break;

            }


        }
    }


    public boolean addVehicle() {                                                                                                   //this is the method used to add a vehicle

        boolean isWin = true;                                                                                                       //used to check the car park is full or not

        int bikeTally = 0;                                                                                                          //this is used to get a count of number of motorbikes

        try {
            if (parkSpots.size() < totalParkSpots) {                                                                                //this loop will run until we have reached the maximum number of parking spaces
                System.out.println("........................\n");
                System.out.println("Select the type of vehicle to which your vehicle belongs to : \n");
                System.out.println("For a car press C");
                System.out.println("For a minibus press M");
                System.out.println("For a mini lorry press L");
                System.out.println("For a motorbike press B");
                System.out.println("For a van press V");
                System.out.println("........................\n");

                char typeVehicle = getCustomerInput();                                                                              //this will get the user choice from above vehicle types (C,M,L,B,V)
                System.out.println("........................\n");

                if (typeVehicle == 'C') {                                                                               //if the user chooses to add a car
                    totalSpots = totalSpots - 1;                                                                                    //totalSpots decreases by 1 because a car occupies only a single space
                    System.out.println("\nplease fill the following details of your car\n");

                    System.out.print("Enter your car plate number: ");
                    String vehicleId = sc.nextLine();                                                                               //vehicleId holds the vehicle plate number

                    System.out.print("Enter the name of car owner : ");
                    String name = sc.nextLine();                                                                                    //name holds the vehicle owner's name

                    System.out.println("Enter the current time  (Seconds) part ");
                    int inSec = Integer.parseInt(sc.nextLine());                                                                    //inSec holds the current time's seconds part

                    System.out.println("Enter the current time. (Minutes) part ");
                    int inMin = Integer.parseInt(sc.nextLine());                                                                    //inMin holds the current time's minutes part

                    System.out.println("Enter the current time. (Hours) part ");
                    int inHrs = Integer.parseInt(sc.nextLine());                                                                    //inHrs holds the current time's hours part

                    System.out.print("Enter the year in which u arrived at the car park");
                    int inYear = Integer.parseInt(sc.nextLine());                                                                   //inYear holds the current date's year part
                    years.add(inYear);                                                                                                      //the current date's year is added onto years list

                    System.out.print("Enter the month in which u arrived at the car park");
                    int inMonth = Integer.parseInt(sc.nextLine());                                                                  //inMonth holds the current date's months part
                    months.add(inMonth);                                                                                                    //the current date's month is added onto months list

                    System.out.print("Enter the day in which u arrived at the car park");
                    int inDay = Integer.parseInt(sc.nextLine());                                                                    //inDay holds the current date's day part
                    days.add(inDay);                                                                                                        //the current date's day is added onto days list

                    DateTime timeArrival = new DateTime(inDay, inMonth, inYear, inSec, inMin, inHrs);                               // a DateTime object is created with the current date and time with the above user entered attributes
                    System.out.println("The date you arrived at our car park is: " + timeArrival);

                    System.out.println("Enter the colour of your car : ");
                    String colour = sc.next();                                                                                      //color holds the color of the vehicle

                    System.out.println("Enter the brand of your car : ");
                    String brand = sc.next();                                                                                       //brand holds the brand of the vehicle

                    System.out.println("Does your car have a navigation system? if yes enter true if no enter false");
                    boolean navInput = sc.nextBoolean();                                                                            //navInput will hold a true or false which will indicate if car has a nav system or not

                    char vehicleType = 'C';                                                                                         //the vehicle category is assigned here

                    boolean hasNavTemp = true;                                                                                      //initially hasNavTemp is true

                    if (navInput) {
                        hasNavTemp = true;                                                                                          //if car has a nav system , this will be assigned to true
                        Car carRaw = new Car(vehicleId, name, timeArrival, colour, brand, true, typeVehicle);
                        parkSpots.add(carRaw);                                                                                      // the car will be added to parkSpots arraylist
                        carArray.add(carRaw);                                                                                       // the car will be added to carArray arraylist as well
                        carCount++;                                                                                                 //carCount gets incremented since a car is added
                        System.out.println(parkSpots);


                    } else if (!navInput) {
                        hasNavTemp = false;                                                                                         //if car doesnt have a nav system , this will be assigned to false
                        Car carRaw = new Car(vehicleId, name, timeArrival, colour, brand, false, typeVehicle);
                        parkSpots.add(carRaw);                                                                                      // the car will be added to parkSpots arraylist
                        carArray.add(carRaw);                                                                                       // the car will be added to carArray arraylist as well
                        carCount++;                                                                                                 //carCount gets incremented since a car is added
                        System.out.println(parkSpots);


                    } else System.out.println("\n You have entered an invalid input");                                              //if the navInput wasnt a true or a false this will get displayed



                    System.out.println("\nYour car was parked successfully you may now enter the mall\n");                          //if car was successfully added this message will be printed


                }

                else if (typeVehicle == 'M') {                                                                          //if the user chooses to add a minibus
                    totalSpots = totalSpots - 3;                                                                        //totalSpots decreases by 3 because a minibus occupies only 3 spaces

                    System.out.println("\nplease fill the following details of your minibus\n");

                    System.out.print("Enter your minibus plate number : ");
                    String vehicleId = sc.nextLine();                                                                               //vehicleId holds the vehicle plate number

                    System.out.print("Enter the name of minibus owner : ");
                    String name = sc.nextLine();                                                                                    //name holds the vehicle owner's name

                    System.out.println("Enter the current time (Seconds) part ");
                    int inSec = Integer.parseInt(sc.nextLine());                                                                    //inSec holds the current time's seconds part

                    System.out.println("Enter the current time (Minutes) part ");
                    int inMin = Integer.parseInt(sc.nextLine());                                                                    //inMin holds the current time's minutes part

                    System.out.println("Enter the current time (Hours) part ");
                    int inHrs = Integer.parseInt(sc.nextLine());                                                                    //inHrs holds the current time's hours part

                    System.out.print("Enter the year in which u arrived at the car park");
                    int inYear = Integer.parseInt(sc.nextLine());                                                                   //inYear holds the current date's year part
                    years.add(inYear);                                                                                                  //the current date's year is added onto years list

                    System.out.print("Enter the month in which u arrived at the car park");
                    int inMonth = Integer.parseInt(sc.nextLine());                                                                  //inMonth holds the current date's months part
                    months.add(inMonth);                                                                                                //the current date's month is added onto months list

                    System.out.print("Enter the day in which u arrived at the car park");
                    int inDay = Integer.parseInt(sc.nextLine());                                                                    //inDay holds the current date's day part
                    days.add(inDay);                                                                                                    //the current date's day is added onto days list

                    DateTime timeArrival = new DateTime(inDay, inMonth, inYear, inSec, inMin, inHrs);
                    System.out.println("The date you arrived at our car park is : " + timeArrival);                                 // a DateTime object is created with the current date and time with the above user entered attributes

                    System.out.println("Enter the colour of your minibus : ");
                    String colour = sc.nextLine();                                                                                  //color holds the color of the vehicle

                    System.out.println("Enter the brand of your minibus : ");
                    String brand = sc.nextLine();                                                                                   //brand holds the brand of the vehicle

                    System.out.println("Does your minibus have entry assist handles ? if yes type in true and if no type in  false");
                    boolean entryHandleInput = sc.nextBoolean();                                                                    //entryHandleInput will hold a true or false which will indicate if minibus has entry handles  or not

                    char vehicleType = 'M';                                                                                         //the vehicle catergory is assigned here
                    boolean hasEntryHandle = true;                                                                                  //initially hasEntryHandle is true

                    if (entryHandleInput) {
                        hasEntryHandle = true;                                                                                      //if minibus has entry handles , this will be assigned to true
                        Minibus minibusRaw = new Minibus(vehicleId, name, timeArrival, colour, brand, true,vehicleType);
                        parkSpots.add(minibusRaw);                                                                                  // the minibus will be added to parkSpots arraylist
                        minibusArray.add(minibusRaw);                                                                               // the minibus will be added to minibusArray arraylist as well
                        minibusCount++;                                                                                             //minibusCount gets incremented since a minibus is added
                        System.out.println(parkSpots);


                    } else if (!entryHandleInput) {
                        hasEntryHandle = false;                                                                                     //if minibus doesnt have entry handles , this will be assigned to false
                        Minibus minibusRaw = new Minibus(vehicleId, name, timeArrival, colour, brand, false,vehicleType);
                        parkSpots.add(minibusRaw);                                                                                  // the minibus will be added to parkSpots arraylist
                        minibusArray.add(minibusRaw);                                                                               // the minibus will be added to minibusArray arraylist as well
                        minibusCount++;                                                                                             //minibusCount gets incremented since a minibus is added
                        System.out.println(parkSpots);


                    } else System.out.println("\n You have entered an invalid input");                                              //if the entryHandleInput  wasnt a true or a false this will get displayed


                    System.out.println("\nYour minibus was parked successfully you may now enter the mall\n");                      //if minibus was successfully added this message will be printed


                }

                else if (typeVehicle == 'L') {                                                                          //if the user chooses to add a mini lorry
                    totalSpots = totalSpots - 3;                                                                        //totalSpots decreases by 3 because a mini lorry occupies only 3 spaces

                    System.out.println("\nplease fill the following details of your mini lorry\n");

                    System.out.print("Enter your mini lorry  plate number : ");
                    String vehicleId = sc.nextLine();                                                                               //vehicleId holds vehicle plate number

                    System.out.print("Enter the name of mini lorry owner : ");
                    String name = sc.nextLine();                                                                                    //name holds the vehicle owner's name

                    System.out.println("Enter the current time (Seconds) part ");
                    int inSec = Integer.parseInt(sc.nextLine());                                                                    //inSec holds the current time's seconds part

                    System.out.println("Enter the current time (Minutes) part ");
                    int inMin = Integer.parseInt(sc.nextLine());                                                                    //inMin holds the current time's minutes part

                    System.out.println("Enter the current time (Hours) part ");
                    int inHrs = Integer.parseInt(sc.nextLine());                                                                    //inHrs holds the current time's hours part

                    System.out.print("Enter the year in which u arrived at the car park");
                    int inYear = Integer.parseInt(sc.nextLine());                                                                   //inYear holds the current date's year part
                    years.add(inYear);                                                                                                  //the current date's year is added onto years list

                    System.out.print("Enter the month in which u arrived at the car park");
                    int inMonth = Integer.parseInt(sc.nextLine());                                                                  //inMonth holds the current date's months part
                    months.add(inMonth);                                                                                                //the current date's month is added onto months list

                    System.out.print("Enter the day in which u arrived at the car park");
                    int inDay = Integer.parseInt(sc.nextLine());                                                                    //inDay holds the current date's day part
                    days.add(inDay);                                                                                                    //the current date's day is added onto days list

                    DateTime timeArrival = new DateTime(inDay, inMonth, inYear, inSec, inMin, inHrs);
                    System.out.println("The date you arrived at our car park is: " + timeArrival);                                  // a DateTime object is created with the current date and time with the above user entered attributes

                    System.out.println("Enter the colour of your mini lorry : ");
                    String colour = sc.nextLine();                                                                                  //color holds the color of the vehicle

                    System.out.println("Enter the brand of your mini lorry : ");
                    String brand = sc.nextLine();                                                                                   //brand holds the brand of the vehicle

                    System.out.println("Is your mini lorry auto ?  if yes type in true and if no type in false");
                    boolean autoInput = sc.nextBoolean();                                                                           //autoInput will hold a true or false which will indicate if mini lorry is auto  or not

                    char vehicleType = 'L';                                                                                         //the vehicle catergory is assigned here
                    boolean hasAuto = true;                                                                                         //initially hasAuto is true

                    if (autoInput) {
                        hasAuto = true;                                                                                             //if mini lorry is auto , this will be assigned to true
                        MiniLorry miniLorryRaw = new MiniLorry(vehicleId, name, timeArrival, colour, brand, true,vehicleType);
                        parkSpots.add(miniLorryRaw);                                                                                // the mini lorry will be added to parkSpots arraylist
                        minilorryArray.add(miniLorryRaw);                                                                           // the mini lorry  will be added to minilorryArray arraylist as well
                        miniLorryCount++;                                                                                           //miniLorryCount gets incremented since a mini lorry  is added
                        System.out.println(parkSpots);


                    } else if (!autoInput) {
                        hasAuto = false;                                                                                            //if mini lorry is not  auto , this will be assigned to false
                        MiniLorry miniLorryRaw = new MiniLorry(vehicleId, name, timeArrival, colour, brand, false,vehicleType);
                        parkSpots.add(miniLorryRaw);                                                                                // the mini lorry will be added to parkSpots arraylist
                        minilorryArray.add(miniLorryRaw);                                                                           // the mini lorry  will be added to minilorryArray arraylist as well
                        miniLorryCount++;                                                                                           //miniLorryCount gets incremented since a mini lorry  is added
                        System.out.println(parkSpots);

                    } else System.out.println("\n You have entered an invalid input");                                              //if the autoInput  wasnt a true or a false this will get displayed


                    System.out.println("\nYour mini lorry  was parked successfully you may now enter the mall\n");                  //if mini lorry  was successfully added this message will be printed

                }

                else if (typeVehicle == 'B') {                                                                          //if the user chooses to add a motorbike
//                    bikeTally++;


                    System.out.println("\nplease fill the following details of your motorbike\n");

                    System.out.print("Enter your motorbike plate number : ");
                    String vehicleId = sc.nextLine();                                                                               //vehicleId holds vehicle plate number

                    System.out.print("Enter the name of motorbike owner : ");
                    String name = sc.nextLine();                                                                                    //name holds the vehicle owner's name

                    System.out.println("Enter the current time (Seconds) part ");
                    int inSec = Integer.parseInt(sc.nextLine());                                                                    //inSec holds the current time's seconds part

                    System.out.println("Enter the current time (Minutes) part ");
                    int inMin = Integer.parseInt(sc.nextLine());                                                                    //inMin holds the current time's minutes part

                    System.out.println("Enter the current time (Hours) part");
                    int inHrs = Integer.parseInt(sc.nextLine());                                                                    //inHrs holds the current time's hours part

                    System.out.print("Enter the year in which u arrived at the car park");
                    int inYear = Integer.parseInt(sc.nextLine());                                                                   //inYear holds the current date's year part
                    years.add(inYear);                                                                                                  //the current date's year is added onto years list

                    System.out.print("Enter the month in which u arrived at the car park");
                    int inMonth = Integer.parseInt(sc.nextLine());                                                                  //inMonth holds the current date's months part
                    months.add(inMonth);                                                                                                //the current date's month is added onto months list

                    System.out.print("Enter the day in which u arrived at the car park");
                    int inDay = Integer.parseInt(sc.nextLine());                                                                    //inDay holds the current date's day part
                    days.add(inDay);                                                                                                    //the current date's day is added onto days list

                    DateTime timeArrival = new DateTime(inDay, inMonth, inYear, inSec, inMin, inHrs);
                    System.out.println("The date you arrived at our car park is: " + timeArrival);                                  // a DateTime object is created with the current date and time with the above user entered attributes

                    System.out.println("Enter the colour of your motorbike : ");
                    String colour = sc.nextLine();                                                                                  //color holds the color of the vehicle

                    System.out.println("Enter the brand of your motorbike : ");
                    String brand = sc.nextLine();                                                                                   //brand holds the brand of the vehicle

                    System.out.println("Does your motorbike have liquid cooling ?  if yes type in true and if no type in false");
                    boolean coolingInput = sc.nextBoolean();                                                                        //coolingInput will hold a true or false which will indicate if motorbike has liquid cooling  or not

                    char vehicleType = 'B';                                                                                         //the vehicle catergory is assigned here
                    boolean hasCooling = true;                                                                                      //initially hasCooling is true

                    if (coolingInput) {
                        hasCooling = true;                                                                                          //if motorbike has liquid cooling , this will be assigned to true
                        Motorbike motorbikeRaw = new Motorbike(vehicleId, name, timeArrival, colour, brand, true,vehicleType);
                        parkSpots.add(motorbikeRaw);                                                                                // the motorbike will be added to parkSpots arraylist
                        motorbikeArray.add(motorbikeRaw);                                                                           // the motorbike  will be added to motorbikeArray arraylist as well
                        motorBikeCount++;                                                                                           //motorBikeCount gets incremented since a motorbike is added
                        System.out.println(parkSpots);


                    } else if (!coolingInput) {
                        hasCooling = false;                                                                                         //if motorbike does not have liquid cooling , this will be assigned to false
                        Motorbike motorbikeRaw = new Motorbike(vehicleId, name, timeArrival, colour, brand, false,vehicleType);
                        parkSpots.add(motorbikeRaw);                                                                                // the motorbike will be added to parkSpots arraylist
                        motorbikeArray.add(motorbikeRaw);                                                                           // the motorbike  will be added to motorbikeArray arraylist as well
                        motorBikeCount++;                                                                                           //motorBikeCount gets incremented since a motorbike is added
                        System.out.println(parkSpots);

                    } else System.out.println("\n You have entered an invalid input");                                              //if the coolingInput  wasnt a true or a false this will get displayed


                    System.out.println("\nYour motorbike was parked successfully you may now enter the mall\n");                    //if motorbike  was successfully added this message will be printed

                    if (motorBikeCount % 3 == 0) {                                                                                 //if the motorbike count is exactly divisible by three
                        totalSpots = totalSpots - 1;                                                                               //we remove one car park space from totalSpots
                    }


                }

                else if (typeVehicle == 'V') {                                                                          //if the user chooses to add a van

                    totalSpots = totalSpots - 2;                                                                        //totalSpots decreases by 2 because a van occupies only 2 spaces

                    System.out.println("\nplease fill the following details of your Van\n");

                    System.out.print("Enter your van plate number : ");
                    String vehicleId = sc.nextLine();                                                                               //vehicleId holds vehicle plate number

                    System.out.print("Enter the name of van owner : ");
                    String name = sc.nextLine();                                                                                    //name holds the vehicle owner's name

                    System.out.println("Enter the current time (Seconds) part ");
                    int inSec = Integer.parseInt(sc.nextLine());                                                                    //inSec holds the current time's seconds part

                    System.out.println("Enter the current time (Minutes) part ");
                    int inMin = Integer.parseInt(sc.nextLine());                                                                    //inMin holds the current time's minutes part

                    System.out.println("Enter the current time (Hours) part ");
                    int inHrs = Integer.parseInt(sc.nextLine());                                                                    //inHrs holds the current time's hours part

                    System.out.print("Enter the year in which u arrived at the car park");
                    int inYear = Integer.parseInt(sc.nextLine());                                                                   //inYear holds the current date's year part
                    years.add(inYear);                                                                                                  //the current date's year is added onto years list

                    System.out.print("Enter the month in which u arrived at the car park");
                    int inMonth = Integer.parseInt(sc.nextLine());                                                                  //inMonth holds the current date's months part
                    months.add(inMonth);                                                                                                //the current date's month is added onto months list

                    System.out.print("Enter the day in which u arrived at the car park");
                    int inDay = Integer.parseInt(sc.nextLine());                                                                    //inDay holds the current date's day part
                    days.add(inDay);                                                                                                    //the current date's day is added onto days list

                    DateTime timeArrival = new DateTime(inDay, inMonth, inYear, inSec, inMin, inHrs);
                    System.out.println("The date you arrived at our car park is: " + timeArrival);                                  // a DateTime object is created with the current date and time with the above user entered attributes

                    System.out.println("Enter the colour of your van : ");
                    String colour = sc.nextLine();                                                                                  //color holds the color of the vehicle

                    System.out.println("Enter the brand of your van : ");
                    String brand = sc.nextLine();                                                                                   //brand holds the brand of the vehicle

                    System.out.println("Does your van have a curb side aisle ?  if yes type in true and if type in false");
                    boolean curbAisleInput = sc.nextBoolean();                                                                      //curbAisleInput will hold a true or false which will indicate if the van  has a curb side aisle  or not

                    char vehicleType = 'V';                                                                                         //the vehicle catergory is assigned here
                    boolean hasCurbAisle = true;                                                                                    //initially hasCurbAisle is true

                    if (curbAisleInput) {
                        hasCurbAisle = true;                                                                                        //if van  has a curb side aisle , this will be assigned to true
                        Van vanRaw = new Van(vehicleId, name, timeArrival, colour, brand, true,vehicleType);
                        parkSpots.add(vanRaw);                                                                                      // the van will be added to parkSpots arraylist
                        vanArray.add(vanRaw);                                                                                       // the van will be added to vanArray arraylist as well
                        vanCount++;                                                                                                 //vanCount gets incremented since a van is added
                        System.out.println(parkSpots);


                    } else if (!curbAisleInput) {
                        hasCurbAisle = false;                                                                                       //if van does not have  a curb side aisle , this will be assigned to false
                        Van vanRaw = new Van(vehicleId, name, timeArrival, colour, brand, false,vehicleType);
                        parkSpots.add(vanRaw);                                                                                      // the van will be added to parkSpots arraylist
                        vanArray.add(vanRaw);                                                                                       // the van will be added to vanArray arraylist as well
                        vanCount++;                                                                                                 //vanCount gets incremented since a van is added
                        System.out.println(parkSpots);

                    } else System.out.println("\n You have entered an invalid input");                                              //if the curbAisleInput  wasnt a true or a false this will get displayed


                    System.out.println("\nYour van was parked successfully you may now enter the mall\n");                          //if van  was successfully added this message will be printed


                } else System.out.println("\n You have entered an invalid input");                                                  //if you havent entered a valid letter from [C,M,L,B,V]  for the vehicle type this will be printed


                System.out.println("The number of free slots left in the car park is: " + totalSpots);                  //totalSpots has the number of free spots remaining
                System.out.println("The days list is: ");
                System.out.println(days);                                                                               //this will print the days list
                System.out.println("The months list is: ");
                System.out.println(months);                                                                             //this will print the months list
                System.out.println("The years list is; ");
                System.out.println(years);                                                                              //this will print the years list

                System.out.println("car count: " + carCount);                                                           //this will show how many cars are there
                System.out.println("minibus count: " + minibusCount);                                                   //this will show how many minibuses are there
                System.out.println("minilorry count: " + miniLorryCount);                                               //this will show how many minilorries are there
                System.out.println("motorbike count: " + motorBikeCount);                                               //this will show how many motorbikes are there
                System.out.println("van count: " + vanCount);                                                           //this will show how many vans  are there


            } else {
                System.out.println("........................\n");
                System.out.println("We are very sorry to inform you that our car park is full at the moment");          //this message will be displayed if there arent any free parking slots left
                isWin = false;                                                                                          //isWin will be initialised to false to indicate that the car park was full
            }


        } catch (Exception e) {                                                                                         //if there were any errors this will prevent the code from crashing

        }
        return isWin;                                                                                                   //according to this we can see if car park is full or not
    }




//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------



    public int vehicleOut() {                                                                                                       //this is the method to delete a vehicle
        System.out.print("Enter your vehicle plate number: ");
        String vehicleRegNo = sc.nextLine();                                                                                        //this will let the customer to enter his vehicle plate number so that he can move his vehicle out

        for (int index = 0; index < parkSpots.size(); index++) {
            Vehicle sample = parkSpots.get(index);                                                                                  //goes in a for loop assigning sample to each vehicle object in parkSpots

            char vehicleType = sample.getVehicleType();                                                                                //vehicleType contains the type of vehicle

            int  bikeTally = 0;                                                                                                     //bikeTally is initially 0 (used to get a count on the motorbikes )



            if (sample.getVehiclePlate().equals(vehicleRegNo)) {                                                                    //checks if sample's vehicle plate is same as the one entered by the customer
                System.out.println("\nThe " + sample.getClass().toString().substring(sample.getClass().toString().
                        lastIndexOf(" ") + 1) + " is moving out of the car park.\n");                                           //if sample vehicle plate number is same as the one customer enters this message will be printed
                System.out.println("The date and time the vehicle entered to car park is:" + sample.getStartVehicleTime());        //this will get the date and time the vehicle which is moving out entered the car park
                parkSpots.remove(sample);                                                                                          //this will remove that vehicle from the parkSpots arraylist

                if (vehicleType == 'C')
                    totalSpots++;                                                                                                   //if its a car only one space will be incremented from car park (when u remove a vehicle , a space becomes free)
                else if (vehicleType == 'B') {
                    bikeTally++;                                                                                                   //if its a bike , the bike tally will be incremented
                    if (bikeTally % 3 == 0) {                                                                                      //if number of bikes is exactly divisible by 3 , we can add a spot back in the car park
                        totalSpots =  + 1 ;                                                                                        //this will add a spot back in the car park since it got free
                    }

                }else if (vehicleType == 'L' || vehicleType == 'M') {
                    totalSpots = totalSpots + 3;                                                                                    //if its a mini lorry or minibus , three spaces will be added to  totalSpots
                }else if (vehicleType == 'V'){
                    totalSpots = totalSpots + 2;                                                                                     //if its a van only two spaces will be added to totalSpots
                }
            }
        }

        return totalSpots;                                                                                                          //this will return the updated totalSpots after deleting the vehicle
    }




//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------



    private static char getCustomerInput() {                                                                                        //this is the method in order to obtain a user input for the requirement to get necessary service  and vehicle type when adding a vehicle
        System.out.println("Enter your choice: ");

        char upperInput = ' ';                                                                                                      //this will be initially a blank
        int counter = 0;                                                                                                            // we used a counter in order to see if our program was able to go inside the try and catch statements
        try {
            counter = counter + 1;                                                                                                  //if counter is 1 at the end , that means we have successfully gone inside the try statement
            char customerData = sc.nextLine().trim().charAt(0);                                                                     //this will get a one char input from the user
            upperInput = Character.toUpperCase(customerData);                                                                       //this will convert that char input to upper

        } catch (Exception e) {
            System.out.println("\nYour input wasn't valid");                                                                        //if we have entered a wrong input this message will be displayed
            System.out.println(counter);                                                                                            //if counter when printed remains at 0 that means we have gone inside the exception

        }
        return upperInput;                                                                                                          //this will return a valid input from customer


    }


//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------



    private static void printDetails(Vehicle temp) {                                                                                          //this is an extra method which im using to print the vehicles attributes
        System.out.println("Vehicle type : " + temp.getClass().toString().substring(temp.getClass().toString().lastIndexOf(" ") + 1));    //this will get the vehicle type
        System.out.println("The brand of the vehicle : " + temp.getVehicleBrand());                                                          //this will get the brand
        System.out.println("The date and time  the vehicle entered : " + temp.getStartVehicleTime());                                        //this will get the vehicle date and time entered

    }

    public void viewCarParkList() {                                                                                                         //this method is used to print the current vehicles in car park list
        System.out.println("........................\n");
        for (int x = 0; x < parkSpots.size(); x++) {                                                                                        //this will go in a for loop printing each vehicle details
            printDetails(parkSpots.get(x));
            System.out.println("");                                                                                                         //this will print a space between each vehicle so that it will look more neat
        }
        if (parkSpots.size() == 0)                                                                                                          //if there are no vehicles in parking space
            System.out.println("There are no vehicles in the car park . You are the first");                                                //this message will be printed
    }



//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------


    public static void clearManager() {                                                                                                     //this method is used to quit the IITCarParkManager
        System.out.println("\033[H\033[2J");                                                                                                //when entering something like this , it will clear the terminal
        System.out.flush();                                                                                                                 //this will help to clear the terminal
    }


//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------




    public void longestVehicle() {                                                                                                          //this method is used to find the longest vehicle parked in car park


        if (parkSpots.size() == 0)
            System.out.println("There are no vehicles in the car park . You are the first");                                                //if there are no vehicles , there wont be a longest vehicle so it will print this message
        else {
            System.out.println("The  vehicle parked for the longest time in the car park is: ");
            System.out.println(parkSpots.get(0));                                                                                           //the vehicle parked the longest will be the vehicle which arrived first in the car park
        }
    }

//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    public void lastVehicle() {
        if (parkSpots.size() == 0)
            System.out.println("There are no vehicles in the car park . You are the first");                                                //if there are no vehicles there isnt a last vehicle so this message will be printed
        else {
            int carParkSize = parkSpots.size();                                                                                             //this will get the current size of parkSpots
            System.out.println("this is the current size of car park : " + carParkSize);                                                    //this will print the current size

            System.out.println("The last vehicle that was parked is: ");
            System.out.println(parkSpots.get(carParkSize - 1));                                                                             //so if carParkSize contains the size of parSpost the last index of parkSpots should have the last vehicle which arrived
        }                                                                                                                                   //we subtract one here because a list starts from 0 so for example if size is 3 , the index we must access is 2 (one less than the current size of parkSpots)


    }


//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------



    public void printPercentageOfVehicles() {                                                                                               //this method is used to get the percentage of each vehicle type in car park
        System.out.println("........................\n");

        System.out.println("Hi below are the percentages of vehicles in the car park");
        double carPerc = 0.0;                                                                                                               //initially carPerc will be 0.0 since its a double
        double vanPerc = 0.0;                                                                                                               //initially vanPerc will be 0.0 since its a double
        double busPerc = 0.0;                                                                                                               //initially busPerc will be 0.0 since its a double
        double lorPerc = 0.0;                                                                                                               //initially lorPerc will be 0.0 since its a double
        double bikePerc = 0.0;                                                                                                              //initially bikePerc will be 0.0 since its a double

        if (carCount != 0) {
            carPerc = (carCount / (parkSpots.size())) * 100;                                                                                //if carCount isnt 0 this will obtain the percentage of cars
        } else {
            carPerc = 0;                                                                                                                    //if carCount is 0 this will assign the carPerc value as 0
        }

        if (vanCount != 0) {
            vanPerc = (vanCount / (parkSpots.size())) * 100;                                                                                //if vanCount isnt 0 this will obtain the percentage of vans
        } else {
            vanPerc = 0;                                                                                                                    //if vanCount is 0 this will assign the vanPerc value as 0
        }

        if (minibusCount != 0) {
            busPerc = (minibusCount / (parkSpots.size())) * 100;                                                                            //if minibusCount isnt 0 this will obtain the percentage of minibuses
        } else {
            busPerc = 0;                                                                                                                    //if minibusCount is 0 this will assign the busPerc value as 0
        }

        if (miniLorryCount != 0) {
            lorPerc = (miniLorryCount / (parkSpots.size())) * 100;                                                                          //if miniLorryCount isnt 0 this will obtain the percentage of mini lorries
        } else {
            lorPerc = 0;                                                                                                                    //if miniLorryCount is 0 this will assign the lorPerc value as 0
        }

        if (motorBikeCount != 0) {
            bikePerc = (motorBikeCount / (parkSpots.size())) * 100;                                                                         //if motorBikeCount isnt 0 this will obtain the percentage of motorbikes
        } else {
            bikePerc = 0;                                                                                                                   //if motorBikeCount is 0 this will assign the bikePerc value as 0
        }

        System.out.println("The percentage of cars  in the car park is: " + carPerc + "%");                                                 //displays the percentage of cars
        System.out.println("The percentage of vans  in the car park is: " + vanPerc + "%");                                                 //displays the percentage of vans
        System.out.println("The percentage of lorry  in the car park is: " + lorPerc + "%");                                                //displays the percentage of mini lorries
        System.out.println("The percentage of bike  in the car park is: " + bikePerc + "%");                                                //displays the percentage of motorbikes
        System.out.println("The percentage of bus  in the car park is: " + busPerc + "%");                                                  //displays the percentage of minibuses
    }



//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------



    public void carListPerDay() {                                                                                                           //this method is used to print the list of vehicles, which entered the car park on a specified day:
        System.out.print("Enter the year which you want to search the car park");
        int searchYear = sc.nextInt();                                                                                                      //this is the year entered by the user to search for

        System.out.print("Enter the month in which you want to search the car park");
        int searchMonth = sc.nextInt();                                                                                                     //this is the month entered by the user to search for

        System.out.print("Enter the day in which you want to search the car park");
        int searchDay = sc.nextInt();                                                                                                       //this is the day entered by the user to search for

        System.out.println("Enter the current time (Seconds) part ");
        int inSec = sc.nextInt();                                                                                                           //this is the current time seconds part

        System.out.println("Enter the current time (Minutes) part ");
        int inMin = sc.nextInt();                                                                                                           //this is the current time minutes part

        System.out.println("Enter the current time (Hours) part ");
        int inHrs = sc.nextInt();                                                                                                           //this is the current time hours part

                                                                                                                                            //although the time details arent important i have added them because  my DateTime class constructor gets the time as well

        DateTime searchDate = new DateTime(searchDay, searchMonth, searchYear, inSec, inMin, inHrs);                                        //this will have the final search date
        System.out.print("Looking for vehicles parked at " + searchDate + ":");
        System.out.println("");
        int isPrinted = 0;                                                                                                                  //here we are having isPrinted because when we traverse through the for loop we can prevent it from printing the dates which are not valid
        for (int element = 0; element < parkSpots.size(); element++) {                                                                      //we go in a for loop checking each parkSpots index

            if (days.get(element) == searchDay && months.get(element) == searchMonth && years.get(element) == searchYear) {                 //here we check if day, month, year which are of each element is equal to the searchDay,searchMonth and searchYear
                printDetails(parkSpots.get(element));                                                                                       //this will print the details of each vehicle if its date is same as search date
                isPrinted++;                                                                                                                //isPrinted gets incremented each time we find an element in parkSpots with a date similar to the search date

            }
            if (isPrinted == 0) {                                                                                                           //if isPrinted is still zero which means the date entered by user isnt valid
                System.out.println("This is an invalid search date .");                                                                     //this message will be printed
            }

        }
    }



//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------



//The car park charges LKR 300 per space per hour for the first three hours.
// The car park charges an additional LKR 100 per hour per space after the first three hours.
// The maximum charge for any 24 hours period is LKR 3000. Display on the screen the parking charges for each customer who parked in the car park.


    public void payTicket() {                                                                                           //this is the method used to display on the screen the parking charges for each customer who parked in the car park

        System.out.println("Please enter the current time(Please rounded off to hours in 24hr format)");
        int currentHrs = sc.nextInt();                                                                                  //currentHrs contains the time in 24hr format

        System.out.println("Please enter the current day.");
        int currentDay = sc.nextInt();                                                                                  //this will have current day

        System.out.println("Please enter the current month.");
        int currentMonth = sc.nextInt();                                                                                //this will have current month

        System.out.println("Please enter the current year.");
        int currentYear = sc.nextInt();                                                                                 //this will have current year

        boolean displayFinshed = false;                                                                                 //when displayFinished becomes true all the details of parking charges will be printed
        int parkingSpots = 0;                                                                                           //parkingSpots will be used to access each index of parkSpots arraylist
        int initialHrs = 0;
        int initialMin = 0;
        int initialSec = 0;
        Vehicle temp;                                                                                                   //temp is a vehicle object

        while (displayFinshed == false) {                                                                               //loop will run until all the parking charges are displayed

            temp = parkSpots.get(parkingSpots);                                                                         //temp has the current vehicle object (this maybe of any vehicle type)
            DateTime initialTime = temp.getStartVehicleTime();                                                          //initialTime is a DateTime object which will store the starting vehicle time of the current vehicle object

            int initialDay = initialTime.getDay();                                                                      //inital day is found here
            int initialMonth = initialTime.getMonth();                                                                  //initial month is found here
            int initialYear = initialTime.getYear();                                                                    //initial year is found here

            initialSec = initialTime.getSec();                                                                          //this will have the initialSec
            initialMin = initialTime.getMin();                                                                          //initialMin is found here
            initialHrs = initialTime.getHrs();                                                                          //initialHrs is found here

            if (initialSec > 30) {                                                                                      //here im assuming that if the initial seconds are more than 30 that is equal to 1 min
                initialMin++;                                                                                           //that is why here im incrementing initialMin
            }
            if (initialMin > 30) {                                                                                      //here im assuming that if the initial minutes are more than 30 that is equal to 1 Hr
                initialHrs++;                                                                                           //so same like minutes , that is why here im incrementing initialHrs
            }



            //(currentHrs - initialHrs ) - 3 =  here we substract by 3 the difference in current and initial
            // because we get the extra number of hours the vehicle is kept for

            //((currentHrs - initialHrs ) - 3) * 100) = here we multiply by 100 because every additional hour gets charged 100
            //((((currentHrs - initialHrs) - 3) * 100) + 900) = here we add 900 because for the first 3hrs it says its 300 per hour per space
            //((currentDay - initialDay) * 3000) = this part is because they say for every 24hr period its 3000
            //((currentMonth - initialMonth) * (3000 * 30)) = this part will give the price for a month (1 month = 30 days assumption)
            //((currentYear - initialYear) * (3000 * 365)) = this part gives the price for a year (1 year = 365 days assumption)


            int totalPerVehiclePerSpace = ((((currentHrs - initialHrs) - 3) * 100) + 900) + ((currentDay - initialDay) * 3000) +            //this is the calculation which im used to obtain the price per vehicle per space
                    ((currentMonth - initialMonth) * (3000 * 30)) + ((currentYear - initialYear) * (3000 * 365));

            String plateNumber = temp.getVehiclePlate();                                                                           //this will get veehicle the plate number

            Character vehicleType = temp.getVehicleType();                                                                         //this will get the type of vehicle

            int finalPrice = 0;                                                                                                    //final price will have the final price for each vehicle

            if (vehicleType == 'C') {
                finalPrice  = totalPerVehiclePerSpace ;                                                                                  //if its car the total price per vehicle will be the same because car occupies 1 space
            } else if (vehicleType == 'B') {
                finalPrice  = totalPerVehiclePerSpace/3;                                                                                //3 bikes occupy one space so total price per vehucle is divided by three
            } else if (vehicleType == 'L' || vehicleType == 'M') {
                finalPrice = totalPerVehiclePerSpace * 3;                                                                               //both a mini lorry and minibus occupy three spaces each so total price per vehicle is multiplied by three
            } else if (vehicleType == 'V') {
                finalPrice = totalPerVehiclePerSpace * 2;                                                                              //van aoocupies two spaces so total price per vehicle is multiplied by two
            }



            System.out.println("The parking charge for vehicle bearing  " + plateNumber + " is " + finalPrice);              //this will print the vehicle charges for each vehicle

            parkingSpots++;                                                                                                       //parkingSpots get incremented here
            if (parkingSpots == parkSpots.size()) {                                                                               //if the parkingSpots is same as the size then we have printed all the details
                displayFinshed = true;                                                                                           //displayFinished will be assigned true then
            }
        }
    }
    }





