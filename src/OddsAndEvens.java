import java.util.*;

public class OddsAndEvens {

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int userChoice = pickOddsOrEvens(input);
        playGame(input, userChoice);
    }

    public static int pickOddsOrEvens(Scanner input) {
        System.out.println("Let’s play a game called \"Odds and Evens\"");
        System.out.print("What is your name? ");
        String name = input.nextLine();
        System.out.print("Hi " + name + ", which do you choose? (O)dds or (E)vens? ");
        String userChoice = input.next();
        if(userChoice.equals("O")){
            System.out.println(name + " has picked odds! The computer will be evens.");
            System.out.println("-----------------");
            return 0;
        } else {
            System.out.println(name + " has picked evens! The computer will be odds.");
            System.out.println("-----------------");
            return 1;
        }
    }

    public static void playGame(Scanner input, int userChoice) {
        System.out.print("How many \"fingers\" do you want to put out? ");
        int userFingers = input.nextInt();
        Random rand = new Random();
        int computerFingers = rand.nextInt(6);
        System.out.println("The computer plays " + computerFingers + " fingers.");
        System.out.println("-----------------");
        int sum = userFingers + computerFingers;
        System.out.println(userFingers + " + " + computerFingers + " = " + sum);
        boolean oddOrEven = sum % 2 == 0;

        if(oddOrEven) {
            System.out.println(sum + " is ...even!");
            if(userChoice == 1) {
                System.out.println("That means the user wins");
            } else {
                System.out.println("That means the computer wins");
            }
        } else {
            System.out.println(sum + " is ...odd!");
            if(userChoice == 0) {
                System.out.println("That means the user wins");
            } else {
                System.out.println("That means the computer wins");
            }
        }
        System.out.println("-----------------");
    }
}
