package org.politex.models.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileUtils {
    public static double[][] parseFile(File file) {
        try {
            Scanner scanner = new Scanner(file);
            List<String> lines = new ArrayList<>();
            while (scanner.hasNext()){
                String line = scanner.nextLine();
                lines.add(line);
            }
            int rows = lines.size();
            int columns = lines.get(0).split(" ").length;
            double[][] numbers = new double[rows][columns];
            for (int i = 0; i < rows; i++) {
                String[] values = lines.get(i).split(" ");
                for(int j = 0; j < columns; j++){
                    numbers[i][j] = Double.parseDouble(values[j]);
                }
            }
            return numbers;
        } catch (FileNotFoundException ex) {
            System.out.println("Отсутствует файл для подсчета");
        }
        return null;
    }
}
