import java.util.Scanner;

public class Main{
    public static int calcFibonacci(int n) {
        // F(n) = F(n-1) + F(n-2)
        return (n <= 1) ? n : calcFibonacci(n - 1) + calcFibonacci(n - 2);
    }

    public static void main(String[] args) {
        // Input
        Scanner userInput = new Scanner(System.in);

        System.out.print("User input: ");
        int index = userInput.nextInt();

        // Output
        System.out.println("Output: F(" + index + ") = " + calcFibonacci(index));
    }
}
