import java.util.Scanner;

public class MazeRunner {
    public static Scanner input = new Scanner(System.in);
    public static Maze myMap = new Maze();
    public static int countMoves = 0;
    public static boolean lost = false;

    public static void main(String[] args){
        intro();
        mazeGame();
    }

    public static void intro(){
        System.out.println("Welcome to Maze Runner!");
        System.out.println("Here is your current position:");
        myMap.printMap();
    }

    public static void mazeGame(){
        String direction;
        while(!myMap.didIWin()){
            lost = movesMessage();
            if(lost){
                System.out.println("Sorry, but you didn't escape in time- you lose!");
                break;
            }
            direction = userMove();
            countMoves = move(direction);
        }

        if (!lost){
            System.out.println("Congratulations, you made it out alive!");
            System.out.println("and you did it in " + countMoves + " moves");
        }
    }

    public static String userMove(){
        System.out.println("Where would you like to move? (R, L, U, D)?");
        String direction = input.next();
        while(!direction.equals("R") && !direction.equals("L") && !direction.equals("U") && !direction.equals("D")){
            direction = input.next();
        }
        return direction;
    }

    public static int move(String direction){
        countMoves++;
        if(direction.equals("R")){
            if(!myMap.canIMoveRight()){
                System.out.println("Sorry, you’ve hit a wall.");
            } else if(myMap.isThereAPit("R")){
                navigatePit(direction);
            } else {
                myMap.moveRight();
                myMap.printMap();
            }
        } else if(direction.equals("L")){
            if(!myMap.canIMoveLeft()){
                System.out.println("Sorry, you’ve hit a wall.");
            } else if(myMap.isThereAPit("L")){
                navigatePit(direction);
            } else {
                myMap.moveLeft();
                myMap.printMap();
            }
        } else if(direction.equals("U")){
            if(!myMap.canIMoveUp()){
                System.out.println("Sorry, you’ve hit a wall.");
            } else if(myMap.isThereAPit("U")){
                navigatePit(direction);
            } else {
                myMap.moveUp();
                myMap.printMap();
            }
        } else if(direction.equals("D")){
            if(!myMap.canIMoveDown()){
                System.out.println("Sorry, you’ve hit a wall.");
            } else if(myMap.isThereAPit("D")){
                navigatePit(direction);
            } else {
                myMap.moveDown();
                myMap.printMap();
            }
        } else {
            // Do nothing
        }
        return countMoves;
    }

    public static boolean movesMessage(){
        if(countMoves == 50){
            System.out.println("Warning: You have made 50 moves, you have 50 remaining before the maze exit closes");
            return false;
        } else if (countMoves == 75){
            System.out.println("Alert! You have made 75 moves, you only have 25 moves left to escape.");
            return false;
        } else if (countMoves == 90){
            System.out.println("DANGER! You have made 90 moves, you only have 10 moves left to escape!!");
            return false;
        } else if (countMoves == 100){
            System.out.println("Oh no! You took too long to escape, and now the maze exit is closed FOREVER >:[");
            return true;
        } else {
            return false;
        }
    }

    public static void navigatePit(String direction){
        System.out.println("Watch out! There's a pit ahead, jump it?");
        String jump = input.nextLine();
        jump = Character.toString(jump.charAt(0));
        if(jump.equals("y")){
            myMap.jumpOverPit(direction);
        }
    }
}
