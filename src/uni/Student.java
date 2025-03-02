package uni;

import java.util.ArrayList;
import java.util.HashMap;

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

    //To make difference between different majors and entry year
    public static HashMap<String, Integer> studentCountPerYearMajor = new HashMap<>();



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
        Major major = Major.findByID(majorID);
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
        studentList.add(this);
        this.id = studentList.size();

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


    //Setting student code for each object
    public void setStudentCode() {
        Major major = Major.findByID(majorID);

        // Use a composite key of (entranceYear, majorID) to track student order uniquely per year & major
        String key = entranceYear + "-" + majorID;

        // Initialize counter if it's a new combination of entranceYear and majorID
        if (!Student.studentCountPerYearMajor.containsKey(key)) {
            Student.studentCountPerYearMajor.put(key, 1);
        }

        int studentOrder = Student.studentCountPerYearMajor.get(key);

        if (major != null) {
            studentID = String.format("%d%02d%03d", entranceYear, majorID, studentOrder);
        } else {
            System.out.println("Error: Major not found.");
            studentID = String.format("%d%02d%03d", entranceYear, 0, studentOrder);
        }

        // Increment count for the next student in the same entranceYear and major
        Student.studentCountPerYearMajor.put(key, studentOrder + 1);
    }
}
