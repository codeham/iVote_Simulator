import java.util.List;

/**
 * Single choice question type extends Question abstract type
 */
public class SingleChoice extends Question {
    public SingleChoice(String question, List<String> answer, List<String> answerChoices){
        super(question, answer, answerChoices);
    }
}