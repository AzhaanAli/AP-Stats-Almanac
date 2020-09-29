package com.blucyn;

import java.util.ArrayList;

// Class is dedicated to creating visualizations from an array / Arraylist.
/* Plots may include:
    - Dot
    - Leaf
 */
public class StatPlotter {
    /******************************************************************************************************************/
    // Reserve name for object.
    private StatAttributes s;

    // Saves a dataset.
    private double[] dataset;

    /*****************************************************************************************************************/
    // Constructor.

    // No param.
    public StatPlotter(){
        this.s = new StatAttributes();

    }
    // One param.
    // Takes in an array of numeric data.
    public StatPlotter(ArrayList<Double> dataset){
        this.s = new StatAttributes(dataset);
        this.dataset = s.processArray(dataset);
    }
    public StatPlotter(double[] dataset){
        this.s = new StatAttributes(dataset);
        this.dataset = s.processArray(dataset);
    }
    public StatPlotter(float[] dataset){
        this.s = new StatAttributes(dataset);
        this.dataset = s.processArray(dataset);
    }
    public StatPlotter(long[] dataset){
        this.s = new StatAttributes(dataset);
        this.dataset = s.processArray(dataset);
    }
    public StatPlotter(int[] dataset){
        this.s = new StatAttributes(dataset);
        this.dataset = s.processArray(dataset);
    }

    /*****************************************************************************************************************/
    // Dot Plot Methods.

    // Prints a dot plot to the system log.
    public void printDotPlot(){
        // Get start and stop for for loop.
        int start = (int)this.s.getMinimum();
        int end = (int)this.s.getMaximum() + 1;

        int borderSize = this.getProperSize(this.dataset);

        // Loop through data.
        try {
            int index = 0;
            for (int current = start; current < end; current++) {
                System.out.print(this.getSizedString(borderSize, current) + " | ");
                // Print dots.
                int consecutive = 1;
                while (current == (int) this.dataset[index]) {
                    System.out.print(consecutive + " ");
                    consecutive++;
                    index++;
                }

                // Move to next line.
                System.out.println();
            }
        }catch (ArrayIndexOutOfBoundsException e){
            // Crisis adverted excellent work.
            System.out.println();
        }

    }

    /*****************************************************************************************************************/
    // Leaf Plot Methods.

    // Prints a leaf plot to system log.
    public void printLeafPlot(double stemDigit, double leafDigit){
        // Save max String size.
        int borderSize = Math.max(this.getProperSize(this.dataset), 4);
        // Print border.
        this.printLeafBorder(borderSize);
        // Print body.
        this.printLeafBody(borderSize, this.dataset, stemDigit, leafDigit);
        // Print key.
        this.printLeafKey(stemDigit, leafDigit);
    }

    private void printLeafBorder(int borderSize){
        System.out.print(this.getSizedString(borderSize, "Stem"));
        System.out.println(" | Leaf");

        System.out.print("--" + this.getSizedString(borderSize, "+", "-"));
        System.out.println("---------------------------------------------------------");
    }
    private void printLeafBody(int borderSize, double[] dataset, double stemDigit, double leafDigit){
        // Save min and max.
        double min = s.getMinimum();
        double max = s.getMaximum();

        // Save start and end variables.
        int start = this.getDigit(stemDigit, min);
        int end   = this.getDigit(stemDigit, max) + 1;

        // Loop through dataset and build plot as you go.
        try {
            int currentIndex = 0;
            double leaf = dataset[0];

            for (int stem = start; stem < end; stem++) {
                // Print all leaves of one stem.
                String stemString = this.getSizedString(borderSize, stem);
                System.out.print(stemString + " | ");
                while (this.getDigit(stemDigit, leaf) == stem) {
                    // Add leaf to the plot.
                    System.out.print(Math.abs(this.getDigit(leafDigit, leaf)) + " ");

                    currentIndex++;
                    leaf = dataset[currentIndex];
                }
                System.out.println();
            }
        }catch (ArrayIndexOutOfBoundsException e){
            // Crisis adverted excellent work.
            System.out.println();
        }
    }
    private void printLeafKey(double stemDigit, double leafDigit){
        int stemEx = (int)(Math.random() * 10);
        int leafEx = (int)(Math.random() * 10);
        System.out.println(
                "Key: " + stemDigit + "|" + leafDigit + ", " +
                        "Ex: " + stemEx + "|" + leafEx + " = " + (stemDigit * stemEx + leafDigit * leafEx));
    }

    // Prints a leaf plot to system log.
    public void printModLeafPlot(){
        int stemDigit = 10;
        int leafDigit = 1;
        // Save max String size.
        int borderSize = Math.max(this.getProperSize(this.dataset), 4);
        // Print border.
        this.printLeafBorder(borderSize);
        // Print body.
        this.printLeafBody(borderSize, this.dataset, stemDigit, leafDigit);
        // Print key.
        this.printLeafKey(stemDigit, leafDigit);
    }
    private void printModLeafBody(int borderSize, double[] dataset, double stemDigit, double leafDigit){
        // Save min and max.
        double min = s.getMinimum();
        double max = s.getMaximum();

        // Save start and end variables.
        int start = this.getDigit(stemDigit, min);
        int end   = this.getDigit(stemDigit, max) + 1;

        // Loop through dataset and build plot as you go.
        try {
            int currentIndex = 0;
            double leaf = dataset[0];
            for (int stem = start; stem < end; stem++) {
                // Print all leaves of one stem.
                String stemString = this.getSizedString(borderSize, stem);
                System.out.print(stemString + " | ");
                while (this.getDigit(stemDigit, leaf) == stem) {
                    // Add leaf to the plot.
                    System.out.print(Math.abs(this.getDigit(leafDigit, leaf)) + " ");

                    currentIndex++;
                    leaf = dataset[currentIndex];
                }
                System.out.println();
            }
        }catch (ArrayIndexOutOfBoundsException e){
            // Crisis adverted excellent work.
            System.out.println();
        }
    }

    /*****************************************************************************************************************/
    // Methods for StatAttributes object.

    // Loads in a new set of data and overrides previous values.
    public void loadData(ArrayList<Double> newDataset){
        // Normalize data and apply changes to instance variables.
        this.s.loadData(newDataset);
        this.dataset = s.processArray(newDataset);
    }
    public void loadData(double[] newDataset){
        this.s.loadData(newDataset);
        this.dataset = s.processArray(newDataset);
    }
    public void loadData(float[] newDataset){
        this.s.loadData(newDataset);
        this.dataset = s.processArray(newDataset);
    }
    public void loadData(long[] newDataset){
        this.s.loadData(newDataset);
        this.dataset = s.processArray(newDataset);
    }
    public void loadData(int[] newDataset){
        this.s.loadData(newDataset);
        this.dataset = s.processArray(newDataset);
    }

    // Prints all attributes.
    public void printAttributes(){
        this.s.print();

    }
    public void printCenter(){
        this.s.printCenter();

    }
    public void printSpread(){
        this.s.printSpread();

    }

    // Shape methods.
    public String getShape(){
        return this.s.getShape();

    }

    // Center methods.
    public double getMedian(){
        return this.s.getMedian();

    }
    public double getMean(){
        return this.s.getMean();

    }
    public double getMode(){
        return this.s.getMode();

    }

    // Spread Methods
    public double getQuart1(){
        return this.s.getQuart1();

    }
    public double getQuart3(){
        return this.s.getQuart3();

    }
    public double getRange(){
        return this.s.getRange();

    }
    public double getIQR(){
        return this.s.getIQR();

    }

    public double getOutlierMin(){
        return this.s.getOutlierMin();

    }
    public double getOutlierMax(){
        return this.s.getOutlierMax();

    }
    public boolean isOutlier(double num){
        return this.s.isOutlier(num);

    }
    public double[] getOutliers(){
        return this.s.getOutliers();

    }

    /*****************************************************************************************************************/
    // Private Methods.

    private String getSizedString(int size, String toEdit, String filler){
        String s = toEdit + "";
        while(s.length() < size){
            s = filler + s;
        }
        return s;
    }
    private String getSizedString(int size, String toEdit){
        return this.getSizedString(size, toEdit, " ");

    }
    private String getSizedString(int size, double toEdit){
        return this.getSizedString(size, toEdit + "");

    }
    private String getSizedString(int size, float toEdit){
        return this.getSizedString(size, toEdit + "");

    }
    private String getSizedString(int size, long toEdit){
        return this.getSizedString(size, toEdit + "");

    }
    private String getSizedString(int size, int toEdit){
        return this.getSizedString(size, toEdit + "");

    }
    private int getProperSize(double[] dataset){
        // Loop through all terms and find the max.
        int maxSize = 0;
        for(double num : dataset){
            int contender = (num + "").length();
            if(contender > maxSize){
                maxSize = contender;
            }
        }

        // Return max.
        return maxSize;
    }

    public int getDigit(double digit, double num){
        double mod = (num % (digit * 10)) / digit;
        return (int) mod;
    }

}
