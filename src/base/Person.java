package base;

import java.util.ArrayList;

public class Person {
    public int id;

    // List of all the people in the university
    public static ArrayList<Person> personList = new ArrayList<>();

    // Name of the person
    public String name;

    // National code of each person
    public String nationalID;

    // Constructor for initializing each object
    public Person(String name, String nationalID) {
        this.name = name;
        this.nationalID = nationalID;

        // Assign ID before adding to the list
        personList.add(this);
        this.id = personList.size();

    }

    // Finding persons via their ID
    public static Person findByID(int id) {
        for (Person person : personList) {
            if (person.id == id) {
                return person;
            }
        }
        return null;
    }
}
