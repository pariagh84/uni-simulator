package uni;

import java.util.ArrayList;

public class Major {
    public int id;

    // List of available majors
    public static ArrayList<Major> majorList = new ArrayList<>();

    // Name of the major
    public String name;

    // Maximum capacity of a major
    public final int capacity;

    // Students enrolled in a specific major
    public int numberOfStudents = 0;

    // Constructor for initializing each object
    public Major(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;

        // Assign ID before adding to the list
        this.id = majorList.size() + 1;
        majorList.add(this);
    }

    // Finding a major via its ID
    public static Major findById(int id) {
        for (Major major : majorList) {
            if (major.id == id) {
                return major;
            }
        }
        return null;
    }

    // Adding students to a specific major
    public void addStudent() {
        if (numberOfStudents >= capacity) {
            System.out.println("Maximum number of students reached, cannot add student to " + name);
            return;
        }
        numberOfStudents++;
        System.out.println("Student successfully added to " + name + ". Current count: " + numberOfStudents);
    }
}
