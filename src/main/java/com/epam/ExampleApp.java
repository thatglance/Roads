package main.java.com.epam;

import main.java.com.epam.api.Path;
import main.java.com.epam.api.GpsNavigator;
import main.java.com.epam.impl.GpsNavigatorImpl;

/**
 * This class app demonstrates how your implementation of {@link GpsNavigator} is intended to be used.
 */
public class ExampleApp {

    public static void main(String[] args) {
        final GpsNavigator navigator = new GpsNavigatorImpl();
        navigator.readData("input.txt");

        final Path path = navigator.findPath("A", "blaB");

        if (path != null){
            System.out.println(path);
        }
    }

}