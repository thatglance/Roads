package main.java.com.epam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;

import main.java.com.epam.api.Path;
import main.java.com.epam.api.GpsNavigator;
import main.java.com.epam.graph.entity.Edge;
import main.java.com.epam.graph.entity.Vertex;
import main.java.com.epam.impl.GpsNavigatorImpl;

/**
 * This class app demonstrates how your implementation of {@link GpsNavigator} is intended to be used.
 */
public class ExampleApp {

    public static void main(String[] args) {

        List<Edge> persons = new ArrayList<Edge>();
//        Collections.sort
        /*Collections.sort(persons, new Comparator<Person>() {
            public int compare(Person person, Person person1) {
                int name = person.getName().compareTo(person1.getName());
                if(name == 0){
                    return name;
                }
                return person.getAge() > person1.getAge() ? 1 : person.getAge() < person1.getAge() ? -1 : 0;
            }
        });*/

        final GpsNavigator navigator = new GpsNavigatorImpl();
        navigator.readData("input.txt");

        final Path path = navigator.findPath("F", "B");

        if (path != null){
            System.out.println(path);
        }
    }

}