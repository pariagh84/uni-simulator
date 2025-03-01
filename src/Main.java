import base.Person;
import uni.*;

public class Main {
    public static void main(String[] args) {
        // Creating five people
        Person person1 = new Person("Paria Gharakhani", "1001");
        Person person2 = new Person("Rozhin Jahanbakhsh", "1002");
        Person person3 = new Person("Helia Khosravi", "1003");
        Person person4 = new Person("Mehdi Ghatei", "1004");
        Person person5 = new Person("Behzad Najafi", "1005");

        // Creating two majors
        Major cs = new Major("Computer Science", 50);
        Major math = new Major("Mathematics", 50);

        // Creating three students
        Student student1 = new Student(person1.id, 403, cs.id);
        Student student2 = new Student(person2.id, 403, cs.id);
        Student student3 = new Student(person3.id, 403, math.id);

        // Printing student names and IDs
        System.out.println("Students:");
        System.out.println(student1.studentID + " - " + person1.name);
        System.out.println(student2.studentID + " - " + person2.name);
        System.out.println(student3.studentID + " - " + person3.name);

        // Creating two professors
        Professor professor1 = new Professor(person4.id, cs.id);
        Professor professor2 = new Professor(person5.id, math.id);

        // Printing professor details
        System.out.println("\nProfessors:");
        System.out.println(professor1.id + " - " + person4.name);
        System.out.println(professor2.id + " - " + person5.name);

        // Creating three courses
        Course course1 = new Course("Foundation of Mathematics", 3);
        Course course2 = new Course("Advanced Programming", 4);
        Course course3 = new Course("Foundation of Combinatorics", 3);

        // Creating three presented courses
        PresentedCourse presentedCourse1 = new PresentedCourse(course1.id, professor1.id, 30);
        PresentedCourse presentedCourse2 = new PresentedCourse(course2.id, professor1.id, 30);
        PresentedCourse presentedCourse3 = new PresentedCourse(course3.id, professor2.id, 30);

        // Enrolling students in courses
        PresentedCourse foundPc1 = PresentedCourse.findById(presentedCourse1.id);
        if (foundPc1 != null) {
            foundPc1.addStudent(student1.id);
            foundPc1.addStudent(student2.id);
        } else {
            System.out.println("Error: Presented Course 1 not found.");
        }

        PresentedCourse foundPc2 = PresentedCourse.findById(presentedCourse2.id);
        if (foundPc2 != null) {
            foundPc2.addStudent(student1.id);
        } else {
            System.out.println("Error: Presented Course 2 not found.");
        }

        PresentedCourse foundPc3 = PresentedCourse.findById(presentedCourse3.id);
        if (foundPc3 != null) {
            foundPc3.addStudent(student3.id);
        } else {
            System.out.println("Error: Presented Course 3 not found.");
        }

        // Creating transcripts
        Transcript transcript1 = new Transcript(student1.id);
        Transcript transcript2 = new Transcript(student2.id);
        Transcript transcript3 = new Transcript(student3.id);

        // Assigning grades
        transcript1.setGrade(presentedCourse1.id, 18.5);
        transcript1.setGrade(presentedCourse2.id, 17.0);
        transcript2.setGrade(presentedCourse1.id, 16.0);
        transcript3.setGrade(presentedCourse3.id, 19.0);

        // Printing transcripts
        System.out.println("\nTranscripts:");

        transcript1.printTranscript();
        System.out.println("GPA: " + transcript1.getGPA());

        transcript2.printTranscript();
        System.out.println("GPA: " + transcript2.getGPA());

        transcript3.printTranscript();
        System.out.println("GPA: " + transcript3.getGPA());
    }
}
