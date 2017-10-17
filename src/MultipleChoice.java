import java.util.List;

/**
 * Multiple choice question type extends Question abstract type
 */
public class MultipleChoice extends Question {
    public MultipleChoice(String question, List<String> answer, List<String> answerChoices){
        super(question, answer, answerChoices);
    }
}