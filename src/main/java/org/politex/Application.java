package org.politex;

import org.politex.models.logic.Kramer;

import java.io.File;
import java.io.FileNotFoundException;

public class Application {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/test/resources/kramer_test1.txt");
        Kramer kramer = new Kramer(file);
    }
}
