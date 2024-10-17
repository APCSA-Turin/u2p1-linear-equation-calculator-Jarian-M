package com.example.project;
public class LinearCalculator{
    //INSTANCE VARIABLES 
    //4 INTEGER variables (name them: x1,x2,y1,y2) 
    private int x1 = 0;
    private int x2 = 0;
    private int y1 = 0;
    private int y2 = 0;


    //CONSTRUCTOR
    //1 constructor with 2 String parameters. Each parameter represents a coordinate. 
    //For example, "(1,2)" and "(3,4)" would be two parameter values 
    //You will have to parse the string into 4 integers, representing the 2 points.
    public LinearCalculator(String coord1, String coord2){ // <--add 2 string parameters to this constructor
        String coord1P1 = coord1.substring(1,3);
        String coord1P2 = coord1.substring(3);
        String coord2P1 = coord2.substring(1,3);
        String coord2P2 = coord2.substring(3);
        int ind1P1 = coord1P1.indexOf("-");
        int ind1P2 = coord1P2.indexOf("-");
        int ind2P1 = coord2P1.indexOf("-");
        int ind2P2 = coord2P2.indexOf("-");

        this.x1 = Integer.valueOf(coord1.substring(1,2)); //parsing the string into the first integer, which represents x1//
        this.x2 = Integer.valueOf(coord2.substring(1,2)); //parsing the string into the second integer, which represents x2//
        this.y1 = Integer.valueOf(coord1.substring(3,4)); //parsing the string into the third integer, which represents y1//
        this.y2 = Integer.valueOf(coord2.substring(3,4)); //parsing the string into the fourth integer, which represents y2//

        if(ind1P1 != -1) {
            this.x1 = Integer.valueOf(coord1.substring(ind1P1, ind1P1 + 2)); //parsing the string into the first integer, which represents x1//
        }
        if(ind2P1 != -1) {
            this.x1 = Integer.valueOf(coord2.substring(ind2P1, ind2P1 + 2)); //parsing the string into the second integer, which represents x2//
        }
        if(ind1P2 != -1) {
            this.y1 = Integer.valueOf(coord1.substring(ind1P2, ind1P2 + 2)); //parsing the string into the third integer, which represents y1//
        }
        if(ind2P2 != -1) {
            this.y1 = Integer.valueOf(coord2.substring(ind2P2, ind2P2 + 2)); //parsing the string into the fourth integer, which represents y2//
        }
    }



    //METHODS
    //getters and setters for the 4 instance variables (8 methods total) 
    public int getX1() {
        return x1;
    }
    public int getY1() {
        return y1;
    }
    public int getX2() {
        return x2;
    }
    public int getY2() {
        return y2;
    }
    public void setX1(int newX1) {
        this.x1 = newX1;
    }
    public void setY1(int newY1) {
        this.y1 = newY1;
    }
    public void setX2(int newX2) {
        this.x2 = newX2;
    }
    public void setY2(int newY2) {
        this.y2 = newY2;
    }


    //distance() -> returns a double. 
    //calculates the distance between the two points to the nearest HUNDREDTH and returns the value.
    public double distance() {
        double ptDist = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        double roundedDist = Math.round(ptDist * 100.0) / 100.0;
        return roundedDist;
    }

    //yInt() -> returns a double.
    //calculates the y intercept of the equation and returns the value to the nearest HUNDREDTH
    //if y-int if undefined, should return -999.99
    public double yInt(){

        return 0.0;
    }

    //slope() -> returns a double. 
    //calculates the slope of the equations and returns the value to the nearest HUNDREDTH
    //if slope is undefined, should return -999.99
    public double slope(){
        double ptSlope = (y2 - y1) / (x2 - x1);
        double roundedSlope = Math.round(ptSlope * 100.0) / 100.0;
        if((x2-x1) == 0) {
            roundedSlope = -999.99;
            return roundedSlope;
        } else {
            return roundedSlope;
        }
    }

    //equations() -> returns a String.
    //calculates the final equation in y=mx+b form and returns the string
    //if the equation has no slope, the equation should return -> "undefined"
    //HINT: You may need other custom methods to decrease the amount of code in the equations() method
    public String equation(){
        return "";
    }


    //roundedToHundredth(double x)-> returns double
    //calculates the input to the nearest hundredth and returns that value
    public double roundedToHundredth(double x){
        double rounded = Math.round(x * 100.0) / 100.0;
        return rounded;
    }

    //printInfo() -> returns a string of information
    //this method is tested but you can also call it in your main method if gradle tests are 
    //not working. 
    public String printInfo(){
        String str = "The two points are: (" + x1 + "," + y1 + ")";
        str += " and " + "(" + x2 + "," + y2 + ")";
        str += "\nThe equation of the line between these points is: " ;
        str += "\nThe slope of this line is: " + slope();
        str += "\nThe y-intercept of the line is: ";
        str += "\nThe distance between the two points is: " + distance();
 
        return str;
    }



}