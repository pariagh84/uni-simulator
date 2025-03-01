package uni;

import base.Person;

import java.util.HashMap;

public class Transcript {
    public int studentID;

    // Integer indicates the ID of the presented course, and Double indicates the achieved grade in that course
    public HashMap<Integer, Double> transcript;


    // Constructor for initializing each object
    public Transcript(int studentID) {
        this.studentID = studentID;
        this.transcript = new HashMap<>();
    }


    // Setting grade for a student in a presented course
    public void setGrade(int presentedCourseID, double grade) {
        PresentedCourse presentedCourse = PresentedCourse.findById(presentedCourseID);
        if (presentedCourse == null || !presentedCourse.studentIds.contains(studentID)) {
            System.out.println("Student ID " + studentID + " is not enrolled in the course.");
            return;
        }
        if (grade < 0.0 || grade > 20.0) {
            System.out.println("Invalid grade. Please enter a grade between 0.0 and 20.0.");
            return;
        }
        transcript.put(presentedCourseID, grade);
        System.out.println("Grade set to " + grade + " for course ID " + presentedCourseID);
    }


    // Printing the transcript of the student
    public void printTranscript() {
        Student student = Student.findByID(studentID);
        if (student == null) {
            System.out.println("Student not found.");
            return;
        }
        Person person = Person.findByID(student.personID);
        if (person == null) {
            System.out.println("Student personal details not found.");
            return;
        }
        System.out.println("Student Name: " + person.name + " (ID: " + studentID + ")");
        System.out.println("Transcript:");
        for (Integer presentedCourseID : transcript.keySet()) {
            PresentedCourse presentedCourse = PresentedCourse.findById(presentedCourseID);
            if (presentedCourse != null) {
                Course course = Course.findById(presentedCourse.courseID);
                if (course != null) {
                    System.out.println("Course ID: " + presentedCourseID + " - " + course.title + ", Grade: " + transcript.get(presentedCourseID));
                }
            }
        }
    }


    // Calculating GPA based on courses and grades
    public double getGPA() {
        double totalGradePoints = 0;
        int totalUnits = 0;
        for (Integer presentedCourseID : transcript.keySet()) {
            PresentedCourse presentedCourse = PresentedCourse.findById(presentedCourseID);
            if (presentedCourse != null) {
                Course course = Course.findById(presentedCourse.courseID);
                if (course != null) {
                    totalGradePoints += transcript.get(presentedCourseID) * course.units;
                    totalUnits += course.units;
                }
            }
        }
        return totalUnits == 0 ? 0.0 : totalGradePoints / totalUnits;
    }
}
