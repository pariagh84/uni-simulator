package uni;

import java.util.ArrayList;

public class Student {
    public int id;

    //List of all the students in the university
    public static ArrayList<Student> studentList;

    public int personID;

    //The year each student got it
    public final int entranceYear;

    //The major in which the student is enrolled
    public int majorID;

    public String studentID;

    //Constructor for initializing each object
    public Student(int personID, int entranceYear, int majorID) {
        this.personID = personID;
        this.entranceYear = entranceYear;
        this.majorID = majorID;

        // Ensure studentList is initialized
        if (studentList == null) {
            studentList = new ArrayList<>();
        }

        // Find the corresponding major
        Major major = Major.findById(majorID);
        if (major != null) {
            if (major.numberOfStudents >= major.capacity) {
                System.out.println("Error: Cannot add student. Major " + major.name + " is full.");
                return;
            }
            major.numberOfStudents++;
        } else {
            System.out.println("Warning: Major not found for student.");
        }

        // Assign ID before adding to the list
        this.id = studentList.size() + 1;
        studentList.add(this);

        // Generate student ID
        setStudentCode();
    }



    //Finding students via their ID
    public static Student findByID(int id) {
        for (Student student : studentList) {
            if  (student.id == id) {
                return student;
            }
        }
        return null;
    }


    //Setting student ID for each object
    public void setStudentCode() {
        Major major = Major.findById(majorID);
        if (major != null) {
            int studentOrder = major.numberOfStudents;
            studentID = String.format("%d%02d%03d", entranceYear, majorID, studentOrder);
        } else {
            System.out.println("Error: Major not found.");
            studentID = String.format("%d%02d%03d", entranceYear, 0, 0);
        }
    }
}
