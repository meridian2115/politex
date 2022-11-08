package org.politex;

import org.politex.models.logic.Gauss;
import org.politex.models.logic.Kramer;

import java.io.File;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Введите методику для решения уравнения ");
            System.out.println("1. Метод Крамера с тремя неизвестными");
            System.out.println("2. Метод Гаусса ");
            System.out.println("0. Выход ");
            String taskNum = scanner.nextLine();
            if (taskNum.equals("0")) {
                break;
            }

            System.out.println("Введите имя txt файла для расчета ");
            String fileName = scanner.nextLine();
            File file = new File(String.format("src/test/resources/%s.txt", fileName));

            switch (taskNum){
                case "1":
                    Kramer kramer = new Kramer(file);
                    break;
                case "2":
                    Gauss gauss = new Gauss(file);
                    break;
                default:
                    System.out.println("Введено неверное значение");
            }
            break;
        }
    }
}
