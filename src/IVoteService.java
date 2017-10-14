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
     * default constructor for ivote service
     *
     * @param question :Question object to create new ivote instance
     */
    public IVoteService(Question question){
        this.givenQuestion = question.getQuestion();
        this.givenAnswer = question.getAnswer();
        this.givenChoices = question.getAnswerChoices();
    }

    public void submit(Student student){
        // check for duplicate submissions
        student.submissionCount();
        int submissions = student.getSubmissions();
        checkDuplicate(submissions);
        // check for correct answers
    }

    public boolean checkDuplicate(int submissionCount){
        if(submissionCount > 1){
            System.out.println("ONLY ONE SUBMISSION ALLOWED PER USER !!!!");
            return false;
        }
        System.out.println("Submission success !");
        return true;
    }
}
