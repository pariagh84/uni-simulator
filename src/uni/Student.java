package uni;

import java.util.ArrayList;

public class Student {
    public int id;

    //List of all the students in the university
    public static ArrayList<Student> studentList;

    public int personID;

    //Year each student got it
    public final int entranceYear;

    //The major in which the student is enrolled
    public int majorID;

    public String studentID;

    //Constructor for initializing each object
    public Student(int personID, int entranceYear, int majorID) {
        this.personID = personID;
        this.entranceYear = entranceYear;
        studentList = new ArrayList<>();
        studentList.add(new Student(personID, entranceYear, majorID));
        id = studentList.size();
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
        studentID = String.valueOf(entranceYear) + String.valueOf(majorID) + String.valueOf(personID);
    }

}
