package org.politex.models.logic;

import org.politex.models.utils.BaseUtils;
import org.politex.models.utils.FileUtils;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

public class Gauss {
    double[][] numbers;
    Set<Integer> ignoredIndexes = new HashSet<>();

    public Gauss(File file) {
        this.numbers = FileUtils.parseFile(file);
        BaseUtils.printArray(this.numbers);

        for (int i = 0; i < numbers.length -1; i++) {
            int index0, prevIndex = -1;
            do {
                index0 = findMinLineIndexValue(i, this.numbers);
                if (index0 != -1) {
                    addMinToLine(index0, i);
                    prevIndex = index0;
                }
                if(checkArray(i)){
                    break;
                }
            } while (index0 != -1);
            ignoredIndexes.add(prevIndex);
            BaseUtils.printArray(this.numbers);
        }
        System.out.println("На основании полученной матрицы проведите ручной расчет");
    }

    private int findMinLineIndexValue(int column, double[][] numbers) {
        int index = 0;
        int countOfZero = 0;
        Double minValue = null;
        for (int i = 0; i < numbers.length; i++) {
            if (ignoredIndexes.contains(i)) {
                continue;
            }
            if (minValue == null) {
                index = i;
                minValue = numbers[i][column];
            }
            if (numbers[i][column] == 0) {
                countOfZero++;
                continue;
            }
            if (Math.abs(numbers[i][column]) == 1) {
                minValue = numbers[i][column];
                System.out.println("Колонка " + column + " MinValue = " + minValue);
                return i;
            }
            if (Math.abs(numbers[i][column]) < Math.abs(minValue)) {
                minValue = numbers[i][column];
                index = i;
            }
        }
        if (countOfZero == numbers.length - 1) {
            return -1;
        }
        System.out.println("Колонка " + column + " MinValue = " + minValue);
        return index;
    }

    private void addMinToLine(int line, int column) {
        for (int i = 0; i < numbers.length; i++) {
            if (ignoredIndexes.contains(i)) {
                continue;
            }
            if (i == line) {
                continue;
            }
            if (numbers[i][column] == 0) {
                continue;
            }
            boolean plus = true;
            //Если оба числа отрицательные, то вычитаем x = -1 - (-2);
            if (numbers[i][column] < 0 && numbers[line][column] < 0) {
                plus = false;
            }
            //Если оба числа положительные, то вычитаем x = 1 - 2;
            if (numbers[i][column] > 0 && numbers[line][column] > 0) {
                plus = false;
            }
            for (int j = 0; j < numbers[i].length; j++) {
                if (plus) {
                    numbers[i][j] = numbers[i][j] + numbers[line][j];
                } else {
                    numbers[i][j] = numbers[i][j] - numbers[line][j];
                }
            }
        }
    }

    private boolean checkArray(int column){
        int zeroCount = 0;
        for (double[] number : numbers) {
            if (number[column] == 0) {
                zeroCount++;
            }
        }
        return zeroCount == numbers.length - (column + 1);
    }
}
