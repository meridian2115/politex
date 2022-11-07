package org.politex.models.utils;

public class BaseUtils {
    public static void printArray(double[][] numbers){
        System.out.println();
        if (numbers.length > 0) {
            for (int i = 0; i < numbers.length; i++) {
                for (int j = 0; j < numbers[0].length; j++) {
                    System.out.print(numbers[i][j] + "\t");
                }
                System.out.println();
            }
        }
    }
}
