import java.util.Iterator;
import java.util.List;
public abstract class Question {
    /**
     * holds the main question created by the simulationDriver
     */
    private String question;

    /**
     * list that holds the answer(s) to both Multiple & Single type Questions
     */
    private List<String> answer;

    /**
     * list holds possible answer candidates for the created question
     */
    private List<String> answerChoices;

    /**
     * Default constructor (Question abstract class)
     * @param question  :main question created
     * @param answer    :answer-key for question asked (Multiple/Single Question)
     * @param answerChoices :possible answer choices for user to pick from
     */
    public Question(String question, List<String> answer, List<String> answerChoices){
        this.question = question;
        this.answer = answer;
        this.answerChoices = answerChoices;
    }

    /**
     * getter returns main question
     * @return
     */
    public String getQuestion(){
        return question;
    }

    /**
     * getter returns answer(s)
     * @return
     */
    public List<String> getAnswer() {
        return answer;
    }

    /**
     * getter returns possible answer choices to pick from
     * @return
     */
    public List<String> getAnswerChoices() {
        return answerChoices;
    }

    /**
     * helper method to print out content in answerChoices list
     */
    public void printChoicelist(){
        Iterator iter = answerChoices.iterator();
        while(iter.hasNext()){
            System.out.println(iter.next());
        }
    }
}
