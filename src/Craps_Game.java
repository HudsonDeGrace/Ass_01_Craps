import java.util.Scanner;
import java.util.Random;
public class Craps_Game {
    public static void main(String[] args) {
        Random gen = new Random();
        Scanner in = new Scanner(System.in);

        boolean terminate = false; // Ends program
        boolean done = false; // Ends the continue while loop
        boolean gameEnd = false; // Ends the loop in the game
        int point = 0;

        do {
            gameEnd = false;
            int die1 = gen.nextInt(6) + 1;
            int die2 = gen.nextInt(6) + 1;
            int sum = die1 + die2;
            if (sum == 2 || sum == 3 || sum == 12) {
                System.out.println("You rolled a " + die1 + " " + die2 + "!");
                System.out.println("You crapped out! You lose!");
                gameEnd = true;
            } else if (sum == 7 || sum == 11) {
                System.out.println("You rolled a " + die1 + " " + die2 + "!");
                System.out.println("You got a natural! You win!");
                gameEnd = true;
            } else {
                System.out.println("You rolled a " + die1 + " " + die2 + "!");
                do{
                    System.out.println(sum + " is the new point!");
                    point = sum;
                    die1 = gen.nextInt(6) + 1;
                    die2 = gen.nextInt(6) + 1;
                    sum = die1 + die2;

                    if(sum == 7){
                        System.out.println("You rolled a " + die1 + " " + die2 + "!");
                        System.out.println("You rolled a 7 and lost!");
                        gameEnd = true;
                    } else if(sum == point){
                        System.out.println("You rolled a " + die1 + " " + die2 + "!");
                        System.out.println("You rolled the point! You win!");
                        gameEnd = true;
                    } else{
                        System.out.println("You rolled a " + die1 + " " + die2 + "!");
                        System.out.println("Try for the point again!");
                    }
                }while(!gameEnd);
            }
            do {
                System.out.print("Do you want to continue? [y or n] ");
                String ifContinue = in.nextLine();
                if (ifContinue.equals("n")) {
                    done = true;
                    terminate = true;
                } else if (ifContinue.equals("y")) {
                    done = true;
                } else {
                    System.out.println("You said " + ifContinue + "! Please input y for yes or n for no.");
                    done = false;
                }
            } while (!done);
        } while (!terminate);
    }
}