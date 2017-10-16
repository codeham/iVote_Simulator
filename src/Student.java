import java.util.List;
import java.util.Random;

public class Student {
/*
    Students will be identified with a numeric ID of 9 digits
    represented as a string. No duplicates will be allowed
    ex. 009529299, 82736735...
 */
    private String studentID;
    private int submissions;
    private List<String> studentAnswers;

    public Student(){

    }

    public String createId(){
        //create randomized ID for student ranging from 00000-99999
        Random rand = new Random();
        int idMaker = rand.nextInt(90000) + 10000;
        String createId = String.valueOf(idMaker);

        return  createId;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public void addStudentAnswers(List<String> studentAnswers){
        this.studentAnswers = studentAnswers;
    }

    public void submissionCount(){
        submissions++;
    }

    public int getSubmissions(){
        return submissions;
    }

}
