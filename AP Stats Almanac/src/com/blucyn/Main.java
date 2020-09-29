package com.blucyn;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        int[] dataset = {
                3,13,15,19,21,
                22,25,31,33,35,
                35,35,37,37,38,
                43,43,45,46,48,
                49,50,50,53,56,
                57,59,63,65,66,
                70,70,74,80,82,
                92,98,157
        };

        double[] d2 = {
                10,   28 ,  30 ,  36  , 48
        };

        printAnalysis(d2);
    }

    /*****************************************************************************************************************/
    // Helper Methods.

    public static  void printAnalysis(ArrayList<Double> dataset){
        System.out.println(dataset.size() + " elements in dataset.\n");
        StatPlotter s = new StatPlotter(dataset);

        printArray(dataset);

        s.printDotPlot();
        s.printAttributes();
    }
    public static  void printAnalysis(double[] dataset){
        System.out.println(dataset.length + " elements in dataset.\n");
        StatPlotter s = new StatPlotter(dataset);

        printArray(dataset);

        s.printDotPlot();
        s.printAttributes();
    }
    public static  void printAnalysis(int[] dataset){
        System.out.println(dataset.length + " elements in dataset.\n");
        StatPlotter s = new StatPlotter(dataset);

        printArray(dataset);

        s.printDotPlot();
        s.printAttributes();
    }

    public static void printArray(ArrayList<Double> array){
        System.out.print("Dataset: ");
        for(int i = 0; i < array.size(); i++){
            System.out.print("[" + array.get(i) + "] ");
            if(i % 5 == 4){
                System.out.print("\n         ");
            }
        }
        System.out.println();
    }
    public static void printArray(double[] array){
        System.out.print("Dataset: ");
        for(int i = 0; i < array.length; i++){
            System.out.print("[" + array[i] + "] ");
            if(i % 5 == 4){
                System.out.print("\n         ");
            }
        }
        System.out.println();
    }
    public static void printArray(float[] array){
        System.out.print("Dataset: ");
        for(int i = 0; i < array.length; i++){
            System.out.print("[" + array[i] + "] ");
            if(i % 5 == 4){
                System.out.print("\n         ");
            }
        }
        System.out.println();
    }
    public static void printArray(long[] array){
        System.out.print("Dataset: ");
        for(int i = 0; i < array.length; i++){
            System.out.print("[" + array[i] + "] ");
            if(i % 5 == 4){
                System.out.print("\n         ");
            }
        }
        System.out.println();
    }
    public static void printArray(int[] array){
        System.out.print("Dataset: ");
        for(int i = 0; i < array.length; i++){
            System.out.print("[" + array[i] + "] ");
            if(i % 5 == 4){
                System.out.print("\n         ");
            }
        }
        System.out.println();
    }
}
