package org.politex.models.logic;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Решение системы уравнений 3х3 методом Крамера
 * */
public class Kramer {
    double[][] numbers;
    private double x1, x2, x3, d;

    public double getX1() {
        return x1;
    }

    public void setX1(double x1) {
        this.x1 = x1;
    }

    public double getX2() {
        return x2;
    }

    public void setX2(double x2) {
        this.x2 = x2;
    }

    public double getX3() {
        return x3;
    }

    public void setX3(double x3) {
        this.x3 = x3;
    }

    public double getD() {
        return d;
    }

    public void setD(double d) {
        this.d = d;
    }

    /**
     * Пример файла:
     * 2 -3 4 6
     * -4 5 -1 7
     * 2 -6 4 0
    * */
    public Kramer(File file) {
        double[][] numbers = parseFile(file);
        this.d = calculate(numbers);
        if (this.d == 0) {
            System.out.println("Нет решения");
            return;
        }
        this.x1 = calculate(numbers, 4, 2, 3)/d;
        this.x2 = calculate(numbers, 1, 4, 3)/d;
        this.x3 = calculate(numbers, 1, 2, 4)/d;
        System.out.println(String.format("x1 = %s, x2 = %s, x3 = %s", x1, x2, x3));
    }

    private double[][] parseFile(File file) {
        try {
            double[][] numbers = new double[3][4];
            Scanner scanner = new Scanner(file);
            for (int i=0; i < 3; i++) {
                String line = scanner.nextLine();
                String[] values = line.split(" ");
                for (int j = 0; j < 4; j++) {
                    try {
                        numbers[i][j] = Double.parseDouble(values[j]);
                    } catch (Exception ex) {
                        System.out.println("Ошибка в данных");
                        ex.printStackTrace();
                    }
                }
            }
            return numbers;
        } catch (FileNotFoundException ex) {
            System.out.println("Отсутствует файл для подсчета");
        }
        return null;
    }

    public double calculate(double[][] numbers, int... varArgs){
        if (varArgs.length == 0) {
            this.numbers = numbers;
        } else {
            this.numbers = new double[3][3];
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (j == varArgs[j]-1) {
                        this.numbers[i][j] = numbers[i][j];
                    } else {
                        this.numbers[i][j] = numbers[i][varArgs[j]-1];
                    }
                }
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(this.numbers[i][j] + " ");
            }
            System.out.println();
        }
        double d = get(1,1) * get(2,2) * get(3,3) +
                get(2,1) * get(1,3) * get(3,2) +
                get(3,1) * get(1,2) * get(2,3) -
                get(3,1) * get(2,2) * get(1,3) -
                get(1,1) * get(2,3) * get(3,2) -
                get(1,2) * get(3,3) * get(2,1);
        System.out.println("D = " + d);
        System.out.println();
        return d;
    }

    private double get(int a, int b) {
        return numbers[a - 1][b - 1];
    }
}
