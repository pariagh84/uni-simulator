package uni;

import java.util.ArrayList;

public class PresentedCourse {
    public int id;

    // List of presented courses
    public static ArrayList<PresentedCourse> presentedCourseList = new ArrayList<>();

    // ID of the presented course
    public int courseID;

    // ID of the professor presenting a specific course
    public int professorID;

    // Maximum capacity of a specific course
    public int capacity;

    // IDs of students enrolled in a specific course
    public ArrayList<Integer> studentIds;

    // Constructor for initializing each object
    public PresentedCourse(int courseID, int professorID, int maxCapacity) {
        this.courseID = courseID;
        this.professorID = professorID;
        this.capacity = maxCapacity;
        this.studentIds = new ArrayList<>();

        // Assign ID before adding to the list
        this.id = presentedCourseList.size() + 1;
        presentedCourseList.add(this);
    }

    // Finding presented courses via their ID
    public static PresentedCourse findById(int ID) {
        for (PresentedCourse presentedCourse : presentedCourseList) {
            if (presentedCourse.id == ID) {
                return presentedCourse;
            }
        }
        return null;
    }

    // Adding students
    public void addStudent(int studentID) {
        if (studentIds.size() >= capacity) {
            System.out.println("Maximum capacity reached, cannot add student.");
            return;
        }
        studentIds.add(studentID);
        System.out.println("Student ID " + studentID + " successfully enrolled.");
    }
}
