import java.util.Scanner;
import java.util.Random;
/**
 * We use 2 classes (Scanner and Random) from java.util package.
 * Scanner class - gives us an opportunity to use some methods which accept different data types of entered inputs.
 * Random class - gives us an opportunity to use some methods for random number generations.
 */

public class CatchMeIfYouCan {
    public static void main(String[] args) {
        // Random().nextInt(100) generates number from 0 to 99
        // with + 1 we complete it to 100
        int randomlyChosenNum = new Random().nextInt(100) + 1; 
        System.out.println("<<< Choose a random number between 1 and 100 >>>");
        
        Scanner scanner = new Scanner(System.in);
        // user's entered number 
        int enteredNum = scanner.nextInt();

        // Check if user number and random number matches or not
        System.out.println(enteredNum == randomlyChosenNum ? 
            "Yayyyyyyyyy, you got it!" : 
            "Upps, a wrong guess, it was: " + randomlyChosenNum);
        
        scanner.close();
    }
}
