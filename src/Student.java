public class Student {
/*
    Students will be identified with a numeric ID of 9 digits
    represented as a string. No duplicates will be allowed
    ex. 009529299, 82736735...
 */
    private String studentID;
    private int submissions;

    Student(String id){
        submissions = 0;
        if(id.length() == 9){
            this.studentID = id;
            System.out.println("ID added !");
        }else{
            System.out.println("Error: not a valid student ID");
        }
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public void submissionCount(){
        submissions++;
    }

    public int getSubmissions(){
        return submissions;
    }
}
