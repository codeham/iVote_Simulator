import java.lang.reflect.Array;
import java.util.*;

public class IVoteService {
    /**
     * question being configured for iService
     */
    private String givenQuestion;
    /**
     * answer(s) being configured for iService
     */
    private List<String> givenAnswer;
    /**
     * options for question conf. for iService
     */
    private List<String> givenChoices;
    /**
     * table that stores results after simulation
     */
    public HashMap<String, List<String>> resultsTable;
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

    /**
     * submits student's answer(s), increments student's submission count,
     * also checks for duplicate submissions & overrides the duplicate
     * if needed, once that edge case is checked submission & ID is placed in table
     * @param student student submitting answer
     * @param answers student's answers in a form of a list
     */
    public void submit(Student student, List<String> answers){
        // check for duplicate submissions
        student.submissionCount();
        int submissions = student.getSubmissions();

        if(!checkDuplicate(submissions)){
            //override submission
            resultsTable.replace(student.getStudentID(), answers);
        }
        resultsTable.put(student.getStudentID(), answers);
    }

    /**
     * helper method that checks the Student's submission count
     * to determine duplication
     * @param submissionCount Student's current submission count
     * @return a boolean depending on duplication
     */
    public boolean checkDuplicate(int submissionCount){
        if(submissionCount > 1){
            System.out.println("Only one submission allowed, most recent submission will override");
            return false;
        }
        return true;
    }

    /**
     * getter to return HashMap table containing results
     * @return
     */
    public HashMap<String, List<String>> getResultsTable() {
        return resultsTable;
    }

    /**
     * this method prints resulting stats of the program
     * includes: number count of each answer choice used &
     * resulting total of correct answers by Student's
     */
    public void printStats(){
        System.out.println();
        System.out.println("** Submission Results **");
        System.out.println();

        for(String x: givenChoices){
            int keepCount = 0;
            for(String studentID: resultsTable.keySet()){
                for(String eachAnswer: resultsTable.get(studentID)){
                    if(eachAnswer.equals(x)){
                        //if each answer in answersList is in one of those stored lists
                        keepCount++;
                    }
                }
            }
            System.out.println(x + ": " + keepCount);
        }
        System.out.println();
        System.out.println("Total Correct Students: " + correctResults());
        System.out.println("*************************************************************************");
    }

    /**
     * helper method to determine correct answer results
     * @return correct answer of the simulation
     */
    public int correctResults(){
        int correctAns = 0;
        List<String> tempAnswers = new ArrayList<String>(givenAnswer);
        Collections.sort(tempAnswers);

        for(List<String> x: resultsTable.values()){
            List<String> tempResults = new ArrayList<String>(x);
            Collections.sort(tempResults);
            if(tempResults.equals(tempAnswers)){
                correctAns++;
            }
        }

        return correctAns;
    }

}
