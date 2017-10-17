import java.util.List;

public class Student {
/*
    Students will be identified with a numeric ID of 5 digits
    represented as a string. No duplicates will be allowed
    ex. 10299, 82736...
 */
    private String studentID;
    private int submissions;
    private List<String> studentAnswers;

    /**
     * constructor for Student
     */
    public Student(){
        submissions = 0;
    }

    /**
     * getter for student ID
     * @return student ID
     */
    public String getStudentID() {
        return studentID;
    }

    /**
     * setter for student ID
     * @param studentID
     */
    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    /**
     * helper method to
     * @param studentAnswers
     */
    public void addStudentAnswers(List<String> studentAnswers){
        this.studentAnswers = studentAnswers;
    }

    /**
     * helper method for submission counter , increments when called
     * represents number of submissions by student
     */
    public void submissionCount(){
        submissions++;
    }

    /**
     * getter for number of submissions
     * @return
     */
    public int getSubmissions(){
        return submissions;
    }

}
