package uni;

import java.util.ArrayList;

public class Professor {
    public int id;

    // List of all the professors in the university
    public static ArrayList<Professor> professorList = new ArrayList<>();

    public int personID;

    // The major in which each professor teaches
    public int majorID;

    // Constructor for initializing each object
    public Professor(int personID, int majorID) {
        this.personID = personID;
        this.majorID = majorID;

        // Assign ID before adding to the list
        professorList.add(this);
        this.id = professorList.size();

    }

    // Finding professors via their ID
    public static Professor findByID(int ID) {
        for (Professor professor : professorList) {
            if (professor.id == ID) {
                return professor;
            }
        }
        return null;
    }
}
