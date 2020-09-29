package com.blucyn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

// Class is dedicated to gathering data from an array / Arraylist.
/* Data may include:
    - Median        - Range
    - Mean          - Quartiles
    - Mode          - IQR
    - Standard Deviation
 */
public class StatAttributes {
    /******************************************************************************************************************/
    // Reserve names for attributes.

    private double[] dataset;

    private double stdDeviation;
    private double median;
    private double quart1;
    private double quart3;
    private double range;
    private double mean;
    private double mode;
    private double IQR;

    /*****************************************************************************************************************/
    // Constructor.

    // No param.
    public StatAttributes(){
        // Set all values to a default of 0.
        this.setAllTo(0);
    }
    // One param.
    // Takes in an array of numeric data.
    public StatAttributes(ArrayList<Double> dataset){
        // Normalize data and then initialize attributes.
        this.initAll(this.processArray(dataset));
    }
    public StatAttributes(double[] dataset){
        // Normalize data and then initialize attributes.
        this.initAll(this.processArray(dataset));
    }
    public StatAttributes(float[] dataset){
        // Normalize data and then initialize attributes.
        this.initAll(this.processArray(dataset));
    }
    public StatAttributes(long[] dataset){
        // Normalize data and then initialize attributes.
        this.initAll(this.processArray(dataset));
    }
    public StatAttributes(int[] dataset){
        // Normalize data and then initialize attributes.
        this.initAll(this.processArray(dataset));
    }

    /*****************************************************************************************************************/
    // Public Methods.

    // Loads in a new set of data and overrides previous values.
    public void loadData(ArrayList<Double> newDataset){
        // Normalize data and apply changes to instance variables.
        this.initAll(this.processArray(newDataset));
    }
    public void loadData(double[] newDataset){
        // Normalize data and apply changes to instance variables.
        this.initAll(this.processArray(newDataset));
    }
    public void loadData(float[] newDataset){
        // Normalize data and apply changes to instance variables.
        this.initAll(this.processArray(newDataset));
    }
    public void loadData(long[] newDataset){
        // Normalize data and apply changes to instance variables.
        this.initAll(this.processArray(newDataset));
    }
    public void loadData(int[] newDataset){
        // Normalize data and apply changes to instance variables.
        this.initAll(this.processArray(newDataset));
    }

    // Normalizes arrays into properly usable double arrays.
    public double[] processArray(ArrayList<Double> inputArray){
        // Sort data.
        Collections.sort(inputArray);

        // Create return listData.
        double[] dataset = new double[inputArray.size()];
        for(int i = 0; i < inputArray.size(); i ++){
            dataset[i] = inputArray.get(i);
        }

        // Return end product.
        return dataset;
    }
    public double[] processArray(double[] inputArray){
        // Add elements of array to an ArrayList.
        ArrayList<Double> listData = new ArrayList<>();
        for(double num : inputArray){
            listData.add(num);
        }

        // Sort data.
        Collections.sort(listData);

        // Create return listData.
        double[] dataset = new double[listData.size()];
        for(int i = 0; i < listData.size(); i ++){
            dataset[i] = listData.get(i);
        }

        // Return end product.
        return dataset;
    }
    public double[] processArray(float[] inputArray){
        // Add elements of array to an ArrayList.
        ArrayList<Double> listData = new ArrayList<>();
        for(double num : inputArray){
            listData.add(num);
        }

        // Sort data.
        Collections.sort(listData);

        // Create return listData.
        double[] dataset = new double[listData.size()];
        for(int i = 0; i < listData.size(); i ++){
            dataset[i] = listData.get(i);
        }

        // Return end product.
        return dataset;
    }
    public double[] processArray(long[] inputArray){
        // Add elements of array to an ArrayList.
        ArrayList<Double> listData = new ArrayList<>();
        for(double num : inputArray){
            listData.add(num);
        }

        // Sort data.
        Collections.sort(listData);

        // Create return listData.
        double[] dataset = new double[listData.size()];
        for(int i = 0; i < listData.size(); i ++){
            dataset[i] = listData.get(i);
        }

        // Return end product.
        return dataset;
    }
    public double[] processArray(int[] inputArray){
        // Add elements of array to an ArrayList.
        ArrayList<Double> listData = new ArrayList<>();
        for(double num : inputArray){
            listData.add(num);
        }

        // Sort data.
        Collections.sort(listData);

        // Create return listData.
        double[] dataset = new double[listData.size()];
        for(int i = 0; i < listData.size(); i ++){
            dataset[i] = listData.get(i);
        }

        // Return end product.
        return dataset;
    }

    // Prints all attributes.
    public void print(){
        this.printShape();
        System.out.println();
        this.printCenter();
        System.out.println();
        this.printSpread();
        System.out.println();
        this.printOutliers();
    }
    public void printShape(){
        System.out.println("Shape: " + this.getShape());

    }
    public void printCenter(){
        System.out.println("Mean: " + this.mean);
        System.out.println("Mode: " + this.mode);
        System.out.println("Median: " + this.median);
        System.out.println("IQR: " + this.IQR);
        System.out.println("Standard Deviation: " + this.stdDeviation);
    }
    public void printSpread(){
        System.out.println("Range: " + this.range);
        System.out.println("Q1: " + this.quart1);
        System.out.println("Q3: " + this.quart3);
        System.out.println("Minimum: " + this.getMinimum());
        System.out.println("Maximum: " + this.getMaximum());
    }
    public void printOutliers(){
        System.out.println("Outlier Minimum: " + this.getOutlierMin());
        System.out.println("Outlier Maximum: " + this.getOutlierMax());

        double[] outliers = this.getOutliers();
        if(outliers.length > 0){
            System.out.print("Outliers: ");
            for(double outlier : outliers){
                System.out.print(outlier + ", ");
            }
            System.out.println("\b\b");
        }
    }

    /*****************************************************************************************************************/
    // Accessor Methods.

    // Shape methods.
    public String getShape(){
        // Get the percent difference of the median and mean.
        double diff = Math.min(this.median, this.mean) / Math.max(this.median, this.mean);

        // If they're above 95% the same, its symmetric.
        if(diff > .95){
            // Find out what kind of symmetric.
            if(diff == 1){
                return "Perfect Symmetric";
            }else{
                return "Slight Symmetric";
            }

        // If mean is greater than the median, its right skewed.
        }else if(this.mean > this.median){
            // Figure out how accurate it is.
            if(diff > .90){
                return "Slight Right-Skewed";
            }else if(diff < .15){
                return "Strong Right-Skewed";
            }else{
                return "Right-Skewed";
            }

        // If mean is less than the median, its left skewed.
        }else{
            // Figure out how accurate it is.
            if(diff > .90){
                return "Slight Left-Skewed";
            }else if(diff < .15){
                return "Strong Left-Skewed";
            }else{
                return "Left-Skewed";
            }
        }
    }

    // Center methods.
    public double getMedian(){
        return this.median;

    }
    public double getMean(){
        return this.mean;

    }
    public double getMode(){
        return this.mode;

    }

    // Spread Methods
    public double getQuart1(){
        return this.quart1;

    }
    public double getQuart3(){
        return this.quart3;

    }
    public double getRange(){
        return this.range;

    }
    public double getIQR(){
        return this.quart3 - this.quart1;

    }
    public double getStdDeviation(){
        return this.stdDeviation;

    }

    // Other methods.
    public double getMinimum(){
        // Return first index.
        return this.dataset[0];
    }
    public double getMaximum(){
        // Return last index.
        return this.dataset[dataset.length - 1];
    }

    // Methods to determine whether somethings an outlier or not.
    public double getOutlierMin(){
        return this.quart1 - (this.IQR * 1.5);

    }
    public double getOutlierMax(){
        return this.quart3 + (this.IQR * 1.5);

    }
    public boolean isOutlier(double num){
        return (num < this.getOutlierMin() || num > this.getOutlierMax());

    }
    public double[] getOutliers(){
        // ArrayList to later add outliers as you find them.
        ArrayList<Double> outliers = new ArrayList<>();

        // Add outliers to the ArrayList.
        for(double num : this.dataset){
            if(this.isOutlier(num)){
                outliers.add(num);
            }
        }

        // Transform ArrayList into a normal array.
        double[] returnList = new double[outliers.size()];
        for(int i = 0; i < outliers.size(); i++){
            returnList[i] = outliers.get(i);
        }

        // Return end product.
        return returnList;
    }

    /*****************************************************************************************************************/
    // Higher Level Private Methods.

    // Sets all attributes to a given double.
    private void setAllTo(double val){
        this.median = val;
        this.mean = val;
        this.mode = val;

        this.range = val;
        this.quart1 = val;
        this.quart3 = val;
    }

    // Initialize all attributes to reflect the given array.
    private void initAll(double[] dataset){
        this.initCenter(dataset);
        this.initSpread(dataset);
        this.dataset = dataset;
    }
    // Initialize all center attributes to reflect the given array.
    private void initCenter(double[] dataset){
        this.initMedian(dataset);
        this.initMean(dataset);
        this.initMode(dataset);
    }
    // Initialize all spread attributes to reflect the given array.
    private void initSpread(double[] dataset){
        this.initRange(dataset);
        this.initIQR(dataset);
        this.initStdDeviation(dataset);
    }
    // Initialize IQR attribute to reflect the given array.
    private void initIQR(double[] dataset){
        this.initQuart1(dataset);
        this.initQuart3(dataset);
        this.IQR = this.getIQR();
    }

    /*****************************************************************************************************************/
    // Low Level Private Methods.

    // Returns a value.
    // Assigns values to center variables using the dataset provided.
    private double getNewMedian(double[] dataset){
        // Save length related variables.
        int length = dataset.length;
        int halfLength = length / 2;

        // Special case for when size is 1 or 2.
        if(length == 1){
            return dataset[0];
        }else if(length == 2){
            return (dataset[0] + dataset[1]) / 2;
        }

        // First check for whether the data is even or odd.
        if(length % 2 == 0){
            // Its even.
            // Figure out and assign the average of the middle two indices.
            double sum = dataset[halfLength] + dataset[halfLength + 1];
            return sum / 2.0;
        }else{
            // Its odd.
            // just assign the middle term.
            return dataset[halfLength];
        }
    }
    private void initMedian(double[] dataset){
        // Update attribute with method.
        this.median = getNewMedian(dataset);
    }

    private double getNewMean(double[] dataset){
        // Important variables.
        int length = dataset.length;
        double total = 0;

        // Loop through all indices of dataset and add to a total.
        for(double num : dataset){
            total += num;
        }

        // Assign mean to the total / the length.
        double mean =  total / length;

        // Get rid of rounding errors.
        mean = Math.round(mean * 100000000000.0) / 100000000000.0;

        // Return mean.
        return mean;
    }
    private void initMean(double[] dataset){
        // Update attribute with method.
        this.mean = this.getNewMean(dataset);
    }

    private double getNewMode(double[] dataset){
        // Create two ArrayLists.
        // One to store names, and another for counts.
        ArrayList<Double> names = new ArrayList<>();
        ArrayList<Integer> counts = new ArrayList<>();
        // Variable to keep track of the index of the maximum value.
        int maxCount = 0;
        int maxIndex = 0;

        // Loop through all indices of dataset.
        for(double num : dataset){
            int index = names.indexOf(num);
            // If number is NOT in names, then create a new spot for it.
            if(index == -1){
                names.add(num);
                counts.add(1);
            }else{
                // Since it is, increment count.
                int newVal = counts.get(index) + 1;
                counts.set(index, newVal);

                // If newVal is larger than maxCount, then update maxCount and save current index.
                if(newVal > maxCount){
                    maxCount = newVal;
                    maxIndex = index;
                }
            }
        }

        // Assign mode to the name with the highest count.
        return names.get(maxIndex);
    }
    private void initMode(double[] dataset){
        // Update attribute with method.
        this.mode = this.getNewMode(dataset);
    }

    private double getNewStdDeviation(double[] dataset){
        double total = 0;

        // Add to total the minus mean-ed square of dataset[i].
        for(int i = 0; i < dataset.length; i++){
            total += Math.pow(dataset[i] - this.mean, 2);
        }

        // Return that divided by the amount of terms - 1.
        return Math.sqrt(total / (dataset.length - 1));
    }
    private void initStdDeviation(double[] dataset){
        // Update attribute with method.
        this.stdDeviation = this.getNewStdDeviation(dataset);
    }


    // Assigns values to spread attributes.
    private double getNewRange(double[] dataset){
        // Assumes that the array is sorted.
        return dataset[dataset.length - 1] - dataset[0];
    }
    private void initRange(double[] dataset){
        // Update attribute with method.
        this.range = this.getNewRange(dataset);
    }

    private double getNewQuart1(double[] dataset){
        // Save important variables.
        int length = dataset.length;
        int half = length / 2;

        // If theres only one number in the list, return that one.
        if(length == 1){
            return dataset[0];
        }
        double[] firstHalf = Arrays.copyOfRange(dataset, 0, half);

        return this.getNewMedian(firstHalf);
    }
    private void initQuart1(double[] dataset){
        // Update attribute with method.
        this.quart1 = this.getNewQuart1(dataset);
    }

    private double getNewQuart3(double[] dataset){
        // Save important variables.
        int length = dataset.length;
        int half = length / 2;
        boolean isOdd = length % 2 != 0;

        // Special casing for when size is 1, and another for if size is odd.
        if(length == 1){
            return dataset[0];
        }else if(isOdd){
            half++;
        }

        // Create second half array and return the median of that list.
        double[] secondHalf = Arrays.copyOfRange(dataset, half, dataset.length);
        return this.getNewMedian(secondHalf);
    }
    private void initQuart3(double[] dataset){
        // Update attribute with method.
        this.quart3 = this.getNewQuart3(dataset);
    }

}
