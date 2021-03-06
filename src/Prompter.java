import java.util.*;

public class Prompter{

    private Game game;


    public Prompter(Game game){
        this.game = game;
    }


    public boolean promptForGuess(){
        boolean isHit = false;
        boolean isAcceptable = false;

        do {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please enter a letter: ");
            String guessInput = scanner.nextLine();

            try {
                isHit = game.applyGuess(guessInput);
                isAcceptable = true;
            } catch(IllegalArgumentException iae) {
                System.out.printf("%s. Please try again. %n",
                        iae.getMessage());
            }
        } while(! isAcceptable);

        return isHit;
    }


    public void displayProgress(){
        System.out.printf("You have %d tries left to solve: %s%n",
                game.getRemainingTries(),
                game.getCurrentProgress());
    }

    public void displayOutcome(){
        if (game.isWon()){
            System.out.printf("You won! Finished with %d tries remaining.",
                    game.getRemainingTries());
        }
        else
            System.out.printf("Sorry, Game Over. The word was %s.",
                    game.getAnswer());
    }

}