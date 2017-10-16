import java.util.HashMap;
import java.util.List;

public class IVoteService {
    /**
     *
     */
    private String givenQuestion;
    /**
     *
     */
    private List<String> givenAnswer;
    /**
     *
     */
    private List<String> givenChoices;
    /**
     *
     */
    private HashMap<String, List<String>> resultsTable;
    /**
     * default constructor for ivote service
     *
     * @param question :Question object to create new ivote instance
     */
    public IVoteService(Question question){
        this.givenQuestion = question.getQuestion();
        this.givenAnswer = question.getAnswer();
        this.givenChoices = question.getAnswerChoices();
        this.resultsTable = new HashMap<String, List<String>>();
    }

    public void submit(Student student, List<String> answers){
        // check for duplicate submissions
        student.submissionCount();
        int submissions = student.getSubmissions();

        if(!checkDuplicate(submissions)){
            //override submission
            resultsTable.replace(student.getStudentID(), answers);
        }

        resultsTable.put(student.getStudentID(), answers);
        // check for correct answers
    }

    public boolean checkDuplicate(int submissionCount){
        if(submissionCount > 1){
            System.out.println("Only one submission allowed, most recent submission will override");
            return false;
        }
        System.out.println("Submission success !");
        return true;
    }
}
