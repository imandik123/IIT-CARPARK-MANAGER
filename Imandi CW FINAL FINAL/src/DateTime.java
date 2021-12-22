public class DateTime {
    private int sec;               //attributes of DateTime class
    private int min;
    private int hrs;
    private int day;
    private int month;
    private int year;
    private String time;




    public int getSec() {                                        //getter method for sec attribute
        return sec;
    }

    public void setSec(int sec) {                               //setter method for sec attribute
        this.sec = sec;
    }

    public int getMin() {                                      //getter method for min attribute
        return min;
    }

    public void setMin(int min) {                              //setter method for min attribute
        this.min = min;
    }

    public int getHrs() {                                      //getter method for hours
        return hrs;
    }

    public void setHrs(int hrs) {                              //setter method for hours
        this.hrs = hrs;
    }


    public DateTime(int day, int month, int year, int sec, int min, int hrs) {    //this is the constructor
        this.day = day;
        this.month = month;
        this.year = year;

        this.sec = sec;
        this.min = min;
        this.hrs = hrs;


    }

    public void Date(int day, int month, int year) {   //this is the date method
        this.day = day;
        this.month = month;
        this.year = year;

    }



    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }


    @Override                                       //this is the toString() method
    public String toString() {
        return "DateTime{" +
                "day=" + day +
                ", month=" + month +
                ", year=" + year +
                ", time='" + time + '\'' +
                '}';
    }

    public String getDate() {                   //this is to validate the date

        String date = "";
        if (this.getDay() < 10){
            date+= "0";
        }

        date += this.getDay() + "/" ;

        if (this.getMonth() < 10 ) {
            date+= "0";
        }

        date+= this.getMonth() + "/";

        if (this.getYear()<10) {
            date+="000";

        } else if (this.getYear()<100){
            date+="00";
        } else if (this.getYear()<1000){
            date+="0";
        }
        date+=this.getYear();
        return date;
    }


}
