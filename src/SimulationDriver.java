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

        // TEST QUESTION
        List<String> answer = new ArrayList<>();
        answer.add("c");
        List<String> answerOptions = new ArrayList<>();
        answerOptions.add("a. cat");
        answerOptions.add("b. chicken");
        answerOptions.add("c. hog");
        answerOptions.add("d. shark");

        SingleChoice newChoice = new SingleChoice("Which of these rhymes with dog ?",answer, answerOptions);



        Student studentOne = new Student("009529299");
        System.out.println("Student ID is : " + studentOne.getStudentID());
        System.out.println("Question:\n");
        // question
        System.out.println(newChoice.getQuestion());
        //choices
        newChoice.printList();
        System.out.println("Answer: " + newChoice.getAnswer());



    }
}
