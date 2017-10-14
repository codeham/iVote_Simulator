import java.util.ArrayList;
import java.util.List;

public class SimulationDriver {
    public static void main(String[] args){
        /**
         *  General simulation for Single/Multiple choice questions
         */
//        randomly generate the IDs and answers for a group of students to simulate the
//        submission process & check results

        System.out.println("***iVote Simulation***");

        // Question Simulation
        String questionSingle = "Which of these choices rhymes with dog?";

        List<String> singleAnswer = new ArrayList<>();
        List<String> singleOptions = new ArrayList<>();

        singleAnswer.add("c");

        singleOptions.add("a. cat");
        singleOptions.add("b. chicken");
        singleOptions.add("c. hog");
        singleOptions.add("d. shark");

        Question singleQuestiontype = new SingleChoice(questionSingle,singleAnswer,singleOptions);

        // multiple choice question
        String questionMulti = "Which of these choices represents a Java primitive type? (pick more than one)";

        List<String> multiAnswers = new ArrayList<String>();
        List<String> multiOptions = new ArrayList<String>();

        multiAnswers.add("a");
        multiAnswers.add("b");
        multiAnswers.add("c");

        multiOptions.add("a. int");
        multiOptions.add("b. String");
        multiOptions.add("c. char");
        multiOptions.add("d. Array");
        multiOptions.add("e. HashMap");

        Question multiQuestiontype = new MultipleChoice(questionMulti,multiAnswers,multiOptions);

        // single question
        System.out.println("Single Question: " + singleQuestiontype.getQuestion());
        singleQuestiontype.printChoicelist();
        System.out.println("Single Answer: " + singleQuestiontype.getAnswer());

        System.out.println("");

        //multi question
        System.out.println("Multi Question: " + multiQuestiontype.getQuestion());
        multiQuestiontype.printChoicelist();
        System.out.println("Multi Answer: " + multiQuestiontype.getAnswer());

        simulateVoting(singleQuestiontype, multiQuestiontype);
    }

    public static void simulateVoting(Question singleType, Question mutliType){
        Student pedro = new Student("009529299");
        System.out.println("Student ID is : " + pedro.getStudentID());
        System.out.println("Question(s):\n");

        IVoteService serviceThread = new IVoteService(singleType);
        serviceThread.submit(pedro);
        serviceThread.submit(pedro);
    }
}
