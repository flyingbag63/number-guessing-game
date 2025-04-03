import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private static final String WELCOME_MESSAGE = "Welcome to the Number Guessing Game!\n" +
            "I'm thinking of a number between 1 and 100.";

    private static final String DIFFICULTY_LEVEL_MESSAGE = "Please select the difficulty level:\n" +
            "1. Easy (10 chances)\n" +
            "2. Medium (5 chances)\n" +
            "3. Hard (3 chances)";

    private static final String ENTER_NUMBER_MESSAGE = "Please Enter a number";
    private static final String YOU_WON_MESSAGE = "You Won";
    private static final String NO_CHANCES_LEFT = "You Lost, No chances left";

    public static void main(String[] args) throws IOException {

        NumberGuessingService numberGuessingService = new NumberGuessingService();
        Scanner scanner = new Scanner(System.in);
        String selectedDifficultyLevel = "";

        System.out.println(WELCOME_MESSAGE);
        System.out.println(DIFFICULTY_LEVEL_MESSAGE);
        selectedDifficultyLevel = scanner.nextLine();
        Integer chances = numberGuessingService.getChanges(selectedDifficultyLevel);
        Integer originalNumber = ThreadLocalRandom.current().nextInt(0, 100 + 1);
        while (chances > 0) {
            System.out.println(ENTER_NUMBER_MESSAGE);
            Integer number = scanner.nextInt();
            if (Objects.equals(number, originalNumber)) {
                System.out.println(YOU_WON_MESSAGE);
                System.exit(0);
            }
            chances -= 1;
        }

        System.out.println("Original Number: " + originalNumber);
        System.out.println(NO_CHANCES_LEFT);
    }
}