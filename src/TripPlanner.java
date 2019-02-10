import java.util.Scanner;
import java.text.DecimalFormat;

public class TripPlanner {
    public static void main(String[] args){
        greeting();
        calculateTimeAndBudget();
        calculateTimeDifference();
        calculateCountryArea();

    }
    public static void greeting(){
        System.out.println("Welcome to Vacation Planner!");
        Scanner input = new Scanner(System.in);
        System.out.println("What is your name? ");
        String name = input.nextLine();
        System.out.println("Nice to meet you " + name + ", where are you traveling to? ");
        String destination = input.nextLine();
        System.out.println("Great! " + destination + " sounds like a great trip!");
        System.out.println("*****");
    }

    public static void calculateTimeAndBudget(){
        DecimalFormat numberFormat = new DecimalFormat("#.00");
        Scanner input = new Scanner(System.in);
        System.out.println("How many days are you going to spend traveling? ");
        int days = input.nextInt();
        System.out.println("What is their total budget for the trip in USD? ");
        double budget = input.nextDouble();
        System.out.println("What is the currency symbol for their destination? ");
        String currency = input.next();
        System.out.println("How many " + currency + " are there in 1 USD? ");
        double conversionRate = input.nextDouble();

        int hours = days*24;
        int minutes = hours*60;
        double budgetPerDay = budget/days;
        double convertedBudget = budget*conversionRate;
        double covertedBudgetPerDay = convertedBudget/days;

        System.out.println("If you are traveling for " + days + " days, that is the same as " +
                            hours + " hours or " + minutes + " minutes.");
        System.out.println("If you are going to send $" + budget +
                            " USD that means per day you can spend up to $" + numberFormat.format(budgetPerDay) + " USD.");
        System.out.println("Your total budget in " + currency + " is " + numberFormat.format(convertedBudget) +
                            " " + currency + ", which per day is " + numberFormat.format(covertedBudgetPerDay) + " " + currency);
        System.out.println("*****");
    }

    public static void calculateTimeDifference(){
        Scanner input = new Scanner(System.in);
        System.out.println("What is the time difference, in hours, between your home and your destination?");
        int timeDiff = input.nextInt() % 24;
        int midnightConversion = timeDiff + 24;
        int noonConversion = timeDiff + 12;
        System.out.println("That means that when it is midnight at home, it will be " + midnightConversion +
                ":00 in your travel destination and when it is noon at home it will be " + noonConversion + ":00");
        System.out.println("*****");
    }

    public static void calculateCountryArea(){
        DecimalFormat numberFormat = new DecimalFormat("#.00");
        Scanner input = new Scanner(System.in);
        System.out.println("What is the square area of your destination country in km2? ");
        double squareArea = input.nextDouble();
        double convertedSquareArea = squareArea*0.386102;
        System.out.println("In miles2 that is " + numberFormat.format(convertedSquareArea));
        System.out.println("*****");
    }

}
