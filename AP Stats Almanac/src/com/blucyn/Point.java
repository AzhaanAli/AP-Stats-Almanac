package com.blucyn;

// Class represents a point on a graph.
/*
    A point has:
    - x value
    - y value
 */
public class Point {
    /******************************************************************************************************************/
    // Reserve name for instance variables.
    public double x;
    public double y;

    /*****************************************************************************************************************/
    // Constructor.

    // No param.
    public Point(){
        this.x = 0;
        this.y = 0;
    }
    // Two param.
    public Point(double x, double y){
        this.x = x;
        this.y = y;
    }

    /*****************************************************************************************************************/
    // Mutator Methods.

    // Changes x and y.
    public void setX(double x) {
        this.x = x;

    }
    public void setY(double y) {
        this.y = y;

    }

}
