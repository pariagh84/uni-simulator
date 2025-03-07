package uni;

import java.util.ArrayList;

public class Course {
    public int id;

    // List of available courses
    public static ArrayList<Course> courseList = new ArrayList<>();

    // Name of the course
    public String title;

    // Number of units of each course
    public int units;

    // Constructor for initializing each object
    public Course(String title, int units) {
        this.title = title;
        this.units = units;

        // Assign ID before adding to the list
        courseList.add(this);
        this.id = courseList.size();

    }

    // Finding courses via their ID
    public static Course findByID(int ID) {
        for (Course course : courseList) {
            if (course.id == ID) {
                return course;
            }
        }
        return null;
    }
}
