import base.Person;
import uni.*;

public class Main {
    public static void main(String[] args) {
        // Creating five persons
        Person p1 = new Person("Alice Johnson", "1001");
        Person p2 = new Person("Bob Smith", "1002");
        Person p3 = new Person("Charlie Davis", "1003");
        Person p4 = new Person("David Evans", "1004");
        Person p5 = new Person("Emma Wilson", "1005");

        // Creating two majors
        Major cs = new Major("Computer Science", 50);
        Major math = new Major("Mathematics", 50);

        // Creating three students
        Student s1 = new Student(p1.id, 403, cs.id);
        Student s2 = new Student(p2.id, 403, cs.id);
        Student s3 = new Student(p3.id, 403, math.id);

        // Printing student names and IDs
        System.out.println("Students:");
        System.out.println(s1.studentID + " - " + p1.name);
        System.out.println(s2.studentID + " - " + p2.name);
        System.out.println(s3.studentID + " - " + p3.name);

        // Creating two professors
        Professor prof1 = new Professor(p4.id, cs.id);
        Professor prof2 = new Professor(p5.id, math.id);

        // Printing professor details
        System.out.println("Professors:");
        System.out.println(prof1.id + " - " + p4.name);
        System.out.println(prof2.id + " - " + p5.name);

        // Creating three courses
        Course c1 = new Course("Foundation of Mathematics", 3);
        Course c2 = new Course("Advanced Programming", 4);
        Course c3 = new Course("Foundation of Combinatorics", 3);

        // Creating three presented courses
        PresentedCourse pc1 = new PresentedCourse(c1.id, prof1.id, 30);
        PresentedCourse pc2 = new PresentedCourse(c2.id, prof1.id, 30);
        PresentedCourse pc3 = new PresentedCourse(c3.id, prof2.id, 30);

        // Enrolling students in courses
        pc1.addStudent(s1.id);
        pc1.addStudent(s2.id);
        pc2.addStudent(s1.id);
        pc3.addStudent(s3.id);

        // Creating transcripts
        Transcript t1 = new Transcript(s1.id);
        Transcript t2 = new Transcript(s2.id);
        Transcript t3 = new Transcript(s3.id);

        // Assigning grades
        t1.setGrade(pc1.id, 18.5);
        t1.setGrade(pc2.id, 17.0);
        t2.setGrade(pc1.id, 16.0);
        t3.setGrade(pc3.id, 19.0);

        // Printing transcripts
        System.out.println("\nTranscripts:");
        t1.printTranscript();
        System.out.println("GPA: " + t1.getGPA());
        t2.printTranscript();
        System.out.println("GPA: " + t2.getGPA());
        t3.printTranscript();
        System.out.println("GPA: " + t3.getGPA());
    }
}