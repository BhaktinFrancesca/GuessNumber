import java.util.Random;
import java.util.Scanner;

public class GuessNumber {
    public static void main(String args[]) {
        int userTry = 0;
        Random rand = new Random();
        int upperbound = 11;
        int counter = 0;

        //random number 0>x>10
        int int_rand = rand.nextInt(upperbound);
        //System.out.println(int_rand);
        Scanner userNumber = new Scanner(System.in);

        //do/while - user number is > or < to int_rand?
        do {

            System.out.println("Enter your number: ");
            //userTry = userNumber.nextInt();
            String userStr = userNumber.nextLine();
            boolean verificaInputUtente = GuessNumber.isNumeric(userStr);
            counter++;

            if (!verificaInputUtente) {
                System.out.println("Please, input a number (0-" + (upperbound - 1) + ").");
            } else {

                userTry = Integer.parseInt(userStr);

                if (userTry > upperbound) {
                    System.out.println("Please, input a number (0-" + (upperbound - 1) + ").");
                } else {
                    if (int_rand > userTry) {
                        System.out.println("Your number is way TOO small.");
                    } else if (int_rand < userTry) {
                        System.out.println("Your number is too BIG.");
                    }
                }

            }

        } while (int_rand != userTry);

        System.out.println("Congratulations! You've guess in " + counter + " tries. Have a nice day :)");

    }

    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            int i = Integer.parseInt(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}
