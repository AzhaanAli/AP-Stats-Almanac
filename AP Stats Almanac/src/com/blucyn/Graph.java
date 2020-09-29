package com.blucyn;

import java.util.ArrayList;

// Class represents a collection of points on a graph.
/*
    Class should be able to output:
    - Slope of best fit line
    - Y Intercept of best fit line
 */
public class Graph {
    /******************************************************************************************************************/
    // Reserve name for points dataset.
    ArrayList<Point> dataset;

    /*****************************************************************************************************************/
    // Constructor.

    // No Param.
    public Graph(){
        this.dataset = new ArrayList<>();

    }
    // One Param.
    public Graph(ArrayList<Point> dataset){
        this.initDataset(dataset);

    }
    // Two Param.
    public Graph(double[] x, double[] y){
        this.initDataset(x, y);

    }

    /*****************************************************************************************************************/
    // Higher Level Methods.

    // Prints the linear equation of the line based off the given data.
    public void printLinearEquation(){
        // Initialize needed variables.
        double numerator = 0;
        double denominator = 0;

        double meanX = this.getMeanX();
        double meanY = this.getMeanY();

        // Iterate through data and update numerator and denominator.
        for(Point point : this.dataset){
            double x = point.x - meanX;

            numerator += x * (point.y - meanY);
            denominator += Math.pow(x, 2);
        }

        // Variables for the finished product.
        double m = numerator / denominator;
        double b = -1 * (m * meanX - meanY);

        // Round variables.
        m = Math.round(m * 10000) / 10000.0;
        b = Math.round(b * 10000) / 10000.0;

        if(b >= 0){
            System.out.println("y = " + m + "x + " + b);
        }else{
            System.out.println("y = " + m + "x - "  + Math.abs(b));
        }
    }

    /*****************************************************************************************************************/
    // Methods.

    // Mean methods.
    public double getMeanX(){
        double total = 0;

        for (Point point : this.dataset) {
            total += point.x;
        }

        return total / this.dataset.size();
    }
    public double getMeanY(){
        double total = 0;

        for (Point point : this.dataset) {
            total += point.y;
        }

        return total / this.dataset.size();
    }

    /*****************************************************************************************************************/
    // Loss Functions.

    // Ignores outliers.
    public double getAbsLoss(double slope, double yInt){
        // Primitives to keep track of total and average data.
        double total = 0;
        int count = 0;

        // Loop through all points to get each-s error.
        for(Point point : dataset){
            // Get the error for the input.
            double x = point.x;
            double outcome = point.y;
            double guess = (x * slope) + yInt;
            double error = Math.abs(outcome - guess);

            // Increment primitives.
            total += error;
            count++;
        }

        // Return an average of the total error.
        return total / count;
    }
    // Puts outliers more into account.
    public double getSquLoss(double slope, double yInt){
        // Primitives to keep track of total and average data.
        double total = 0;
        int count = 0;

        // Loop through all points to get each-s error.
        for(Point point : dataset){
            // Get the error for the input.
            double x = point.x;
            double outcome = point.y;
            double guess = (x * slope) + yInt;
            double error = Math.pow(outcome - guess, 2);

            // Increment primitives.
            total += error;
            count++;
        }

        // Return an average of the total error.
        return Math.sqrt(total / count);
    }

    /*****************************************************************************************************************/
    // Initializer Methods.

    // Sets the dataset to pre-existing data.
    public void initDataset(ArrayList<Point> dataset){
        this.dataset = dataset;

    }
    public void initDataset(double[] x, double[] y){
        this.dataset = new ArrayList<>();

        // If an error will be caused, return early.
        if(x.length != y.length){
            return;
        }

        // Since they're the same length, go and add points to dataset.
        for(int i = 0; i < x.length; i++){
            this.dataset.add(new Point(x[i], y[i]));
        }
    }
}
