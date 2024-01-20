import java.util.Scanner;
public class GuessingNumberGame1 {
    public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);
        int minRange =1;
        int maxRange = 100;
        int totalRound = 3;
        int currentRound = 1;
        int score =0;
        System.out.println("Welcome to Guess the number Game!");
        System.out.println("You have to guess a number between 1 to 100");
        while(currentRound<=totalRound){
            int targetNumber =getRandomNumber(minRange,maxRange);
            int attempts = 0;
            int maxAttempts = 10;
            System.out.println("\nRound"+currentRound+" of "+totalRound);
            System.out.println("Round Score: "+score);
            while(true){
                System.out.print("Enter your guess: ");
                int guess = scanner.nextInt();
                attempts++;
                if(guess==targetNumber){
                    System.out.println("Congratulations! You guessed correct number in"+attempts+"attempts.");
                    int RoundScore = CalculateRoundScore(attempts);
                    score+=RoundScore;
                    System.out.println("RoundScore: "+RoundScore);
                    break;
                }
                else if(guess<targetNumber){
                    System.out.println("Your guess is lower than than targetNumber");
                }
                else {
                    System.out.println("Your guess is higher than the targetNumber");
                }
                if(attempts>=maxAttempts){
                    System.out.println("Sorry,you have reached the maximum number of attempts.The correct number was:"+targetNumber);
                    break;
                }
            }
            currentRound++;
        }
        System.out.println("\nGame over!");
        System.out.println("Total Score :"+score);
        scanner.close();
    }
    private static int getRandomNumber(int min, int max){
        return (int)(Math.random()*(max-min+1))+min;
    }
    private static int CalculateRoundScore(int attempts){
        if(attempts<=3){
            return 10;
        }
        else if(attempts<=6){
            return 5;
        }
        else{
            return 1;
        }
    }
}

