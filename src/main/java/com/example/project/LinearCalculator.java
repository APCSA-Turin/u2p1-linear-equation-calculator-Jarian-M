package com.example.project;
public class LinearCalculator{
    //INSTANCE VARIABLES 
    //4 INTEGER variables (name them: x1,x2,y1,y2) 
    private int x1;
    private int x2;
    private int y1;
    private int y2;


    //CONSTRUCTOR
    //1 constructor with 2 String parameters. Each parameter represents a coordinate. 
    //For example, "(1,2)" and "(3,4)" would be two parameter values 
    //You will have to parse the string into 4 integers, representing the 2 points.
    public LinearCalculator(String coord1, String coord2){ // <--add 2 string parameters to this constructor

        int parenthesis1 = coord1.indexOf(")");
        int parenthesis2 = coord2.indexOf(")");
        String newPt1 = coord1.substring(1, parenthesis1);
        String newPt2 = coord2.substring(1, parenthesis2);

        String[] pt = newPt1.split(",");
        x1 = Integer.parseInt(pt[0]);
        y1 = Integer.parseInt(pt[1]);
        String[] pt2 = newPt2.split(",");
        x2 = Integer.parseInt(pt2[0]);
        y2 = Integer.parseInt(pt2[1]);
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
        double roundedDist = roundedToHundredth(ptDist);
        return roundedDist;
    }

    //yInt() -> returns a double.
    //calculates the y intercept of the equation and returns the value to the nearest HUNDREDTH
    //if y-int if undefined, should return -999.99
    public double yInt(){
        double slope = slope();
        if(slope == -999.99) {
            return -999.99;
        } else {
            double intercept = y1 - (slope * x1);
            intercept = roundedToHundredth(intercept);
            return intercept;
        }
    }

    //slope() -> returns a double. 
    //calculates the slope of the equations and returns the value to the nearest HUNDREDTH
    //if slope is undefined, should return -999.99
    public double slope(){
        double roundedSlope;
        if((x2-x1) == 0) {
            roundedSlope = -999.99;
            return roundedSlope;
        }
        roundedSlope = (double) (y2 - y1) / (x2 - x1); //You need to cast one of the dividends to a double in order to prevent int division and returning the incorrect slope
        roundedSlope = roundedToHundredth(roundedSlope);
        return roundedSlope;
    }

    //equations() -> returns a String.
    //calculates the final equation in y=mx+b form and returns the string
    //if the equation has no slope, the equation should return -> "undefined"
    //HINT: You may need other custom methods to decrease the amount of code in the equations() method
    public String equation(){
        String finalEq;
        if(yInt() == 0) {
            finalEq = "y=" + slope() + "x";
        } else {
            if(slope() == -999.99) {
                finalEq = "undefined";
            } else {
                if(slope() == 0) {
                    finalEq = "y=" + yInt();
                } else {
                    if(yInt() < 0) {
                        finalEq = "y=" + slope() + "x" + yInt();
                    } else {
                        finalEq = "y=" + slope() + "x+" + yInt();
                    }
                }
            }
        }
        return finalEq;
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
        str += "\nThe equation of the line between these points is: " + equation();
        str += "\nThe slope of this line is: " + slope();
        str += "\nThe y-intercept of the line is: " + yInt();
        str += "\nThe distance between the two points is: " + distance();
 
        return str;
    }



}