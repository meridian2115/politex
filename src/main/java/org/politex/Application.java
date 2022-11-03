package org.politex;

import org.politex.models.logic.Kramer;

import java.io.File;
import java.io.FileNotFoundException;

public class Application {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("D:\\projects\\tests\\kramer\\test1.txt");
        Kramer kramer = new Kramer(file);
    }
}
